package com.qcloud.component.admin.service.impl;

import javax.annotation.PostConstruct;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.qcloud.component.account.UnifiedAccountClient;
import com.qcloud.component.admin.LoginVerification;
import com.qcloud.component.admin.dao.AdminDao;
import com.qcloud.component.admin.exception.AdminException;
import com.qcloud.component.admin.model.Admin;
import com.qcloud.component.admin.model.key.TypeEnum.AdminEnableType;
import com.qcloud.component.admin.service.AdminService;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.parameter.ParamType;
import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.component.permission.AccountClient;
import com.qcloud.component.permission.PermissionClient;
import com.qcloud.component.permission.model.Account;
import com.qcloud.pirates.data.Page;

public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao             adminDao;

    @Autowired
    private AutoIdGenerator      autoIdGenerator;

    @Autowired
    private ParameterClient      parameterClient;

    @Autowired
    private UnifiedAccountClient unifiedAccountClient;

    @Autowired
    private PermissionClient     permissionClient;

    @Autowired
    private AccountClient        accountClient;

    @Autowired(required = false)
    private LoginVerification    loginVerification;

    private static final String  ID_KEY             = "pirates_admin";

    private String               supermanPrefixCode = "super-";

    private long                 supermanRoleId     = -1;

    private String               account;

    private String               password;

    private String               adminPrefixCode    = "admin-";

    private long                 adminRoleId        = -1;

    private final String         adminDefaultPsw    = "123456";

    public void setAccount(String account) {

        this.account = account;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public void setSupermanRoleId(long supermanRoleId) {

        this.supermanRoleId = supermanRoleId;
    }

    public void setAdminRoleId(long adminRoleId) {

        this.adminRoleId = adminRoleId;
    }

    @PostConstruct
    public void init() {

        if (StringUtils.isEmpty(account) || "${pirates.superman.account}".equals(account)) {
            throw new AdminException("请设置超级管理员账号.");
        }
        if (StringUtils.isEmpty(password) || "${pirates.superman.password}".equals(password)) {
            throw new AdminException("请设置超级管理员密码.");
        }
        if (supermanRoleId == -1) {
            throw new AdminException("请设置超级管理员角色标识.");
        }
        if (adminRoleId == -1) {
            throw new AdminException("请设置普通管理员角色标识.");
        }
        String perAccountCode = supermanPrefixCode + account;
        Account account = accountClient.getAccount(perAccountCode);
        boolean roleExist = permissionClient.isRoleExist(supermanRoleId);
        if (!roleExist) {
            throw new AdminException("请初始化超级管理员角色.标识:" + supermanRoleId);
        }
        if (account == null) {
            account = new Account();
            account.setCode(perAccountCode);
            account.setName("superman");
            accountClient.addAccount(account);
            account = accountClient.getAccount(perAccountCode);
            permissionClient.grant(account.getId(), supermanRoleId);
        }
        boolean adminRoleExist = permissionClient.isRoleExist(adminRoleId);
        if (!adminRoleExist) {
            throw new AdminException("请初始化普通管理员角色.标识:" + adminRoleId);
        }
        String str = parameterClient.get(PermissionClient.NO_GRANT_ACCOUNT_CODES_KEY);
        if (str == null || str.indexOf(perAccountCode) == -1) {
            String value = str == null ? perAccountCode : str + PermissionClient.NO_GRANT_ACCOUNT_CODES_KEY_SPLIT + perAccountCode;
            parameterClient.reg(PermissionClient.NO_GRANT_ACCOUNT_CODES_KEY, value, ParamType.STRING);
        }
    }

    @Override
    public boolean add(final Admin bean) {

        Admin admin = adminDao.getByAccount(bean.getAccount());
        if (admin != null) {
            throw new AdminException("账号已经存在 " + bean.getAccount());
        }
        bean.setPassword(getEncodeDefaultPsw());
        long id = autoIdGenerator.get(ID_KEY);
        bean.setId(id);
        boolean result = adminDao.add(bean);
        if (result) {
            String perAccountCode = getAdminPermissionAccountCode(bean);
            Account account = accountClient.getAccount(perAccountCode);
            if (account == null) {
                account = new Account();
                account.setCode(perAccountCode);
                account.setName(bean.getName());
                accountClient.addAccount(account);
                account = accountClient.getAccount(perAccountCode);
                permissionClient.grant(account.getId(), adminRoleId);
            }
        }
        return result;
    }

    @Override
    public Page<Admin> list(int start, int count) {

        return adminDao.list(start, count);
    }

    @Override
    public boolean delete(long key) {

        return adminDao.delete(key);
    }

    @Override
    public boolean update(Admin bean) {

        Admin admin = get(bean.getId());
        // 账号不允许改
        bean.setAccount(admin.getAccount());
        // 密码如果不为空,则是修改密码
        if (StringUtils.isEmpty(bean.getPassword())) {
            bean.setPassword(admin.getPassword());
        }
        return adminDao.update(bean);
    }

    @Override
    public Admin get(long key) {

        return adminDao.get(key);
    }

    @Override
    public boolean isSuperman(String account, String password) {

        return this.account.equals(account) && this.password.equals(getEncodePsw(password));
    }

    @Override
    public boolean isAdmin(String account, String password) {

        Admin admin = adminDao.getByAccount(account);
        if (admin != null && admin.getEnable() == AdminEnableType.DISABLE.getKey()) {
            throw new AdminException("管理员已被禁用." + admin.getAccount());
        }
        return admin != null && getEncodePsw(password).equals(admin.getPassword());
    }

    @Override
    public boolean isBussnessAdmin(String account, String password) {

        // 密码由业务方加密，同时由业务方验证,这里传入密码明文
        if (loginVerification != null) {
            return loginVerification.allow(account, password);
        }
        return false;
    }

    @Override
    public String[] getBusinessAdminAccountCode(String username) {

        if (loginVerification != null) {
            return loginVerification.getAccountCodes(username);
        }
        return new String[0];
    }

    @Override
    public String getBusinessIdentificationKey(String username) {

        if (loginVerification != null) {
            return loginVerification.getIdentificationKey(username);
        }
        return null;
    }

    @Override
    public String getEncodeDefaultPsw() {

        return getEncodePsw(adminDefaultPsw);
    }

    @Override
    public String getAdminPermissionAccountCode(Admin admin) {

        return adminPrefixCode + admin.getAccount();
    }

    @Override
    public String getAdminPermissionAccountCode(String username) {

        return adminPrefixCode + username;
    }

    @Override
    public String getSupermanPermissionAccountCode() {

        return supermanPrefixCode + account;
    }

    @Override
    public Admin getByAccount(String code) {

        return adminDao.getByAccount(code);
    }

    @Override
    public String getEncodePsw(String pwd) {

        return unifiedAccountClient.encodePwd(pwd);
    }
}
