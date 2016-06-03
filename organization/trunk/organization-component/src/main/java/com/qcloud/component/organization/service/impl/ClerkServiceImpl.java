package com.qcloud.component.organization.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qcloud.component.account.QAccount;
import com.qcloud.component.account.UnifiedAccountClient;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.organization.common.ClerkConstant;
import com.qcloud.component.organization.dao.ClerkDao;
import com.qcloud.component.organization.exception.OrganizationException;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.model.key.TypeEnum;
import com.qcloud.component.organization.model.key.TypeEnum.EnableType;
import com.qcloud.component.organization.model.query.ClerkQuery;
import com.qcloud.component.organization.service.ClerkService;
import com.qcloud.component.permission.AccountClient;
import com.qcloud.component.permission.model.Account;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.StringUtil;

@Service
public class ClerkServiceImpl implements ClerkService {

    @Autowired
    private ClerkDao             clerkDao;

    @Autowired
    private AutoIdGenerator      autoIdGenerator;

    @Autowired
    private AccountClient        accountClient;

    @Autowired
    private FileSDKClient        fileSDKClient;

    @Autowired
    private UnifiedAccountClient unifiedAccountClient;

    private static final String  ID_KEY             = "organization_clerk";

    private static final String  ACCOUNT_TYPE_CODE  = "clerk_account_type";

    private static final String  MOBILE_TYPE_CODE   = "mobile";

    private static final String  EMAIL_TYPE_CODE    = "email";

    private static final String  IDCARD_TYPE_CODE   = "idCard";

    public static final String   CLERK_PASSWORD_KEY = "clerk-default-password";

    @PostConstruct
    public void init() {

        boolean mobile = enableAccountType(MOBILE_TYPE_CODE);
        boolean email = enableAccountType(EMAIL_TYPE_CODE);
        boolean idCard = enableAccountType(IDCARD_TYPE_CODE);
        AssertUtil.assertTrue(mobile || email || idCard, "请在app.xml文件配置组织职员账号支持类型:手机或者Email或者会员卡,支持组合");
    }

    private boolean enableAccountType(String accountName) {

        Xml xml = XmlFactory.get(ACCOUNT_TYPE_CODE);
        AssertUtil.assertNotNull(xml, "xml尚未配置账号支持类型");
        List<XmlItem> list = xml.getItemList();
        for (XmlItem xmlItem : list) {
            if (accountName.equals(xmlItem.getAttrMap().get("key")) && Boolean.valueOf(xmlItem.getAttrMap().get("enable"))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(Clerk clerk) {

        if (StringUtils.isNotEmpty(clerk.getMobile())) {
            Clerk c = clerkDao.getByMobile(clerk.getMobile());
            AssertUtil.assertTrue(c == null, "手机号已经使用." + clerk.getMobile());
            if (enableAccountType(MOBILE_TYPE_CODE)) {
                AssertUtil.assertTrue(!unifiedAccountClient.exist(clerk.getMobile()), "账号已经使用." + clerk.getMobile());
            }
        }
        if (StringUtils.isNotEmpty(clerk.getJobEmail())) {
            Clerk c = clerkDao.getByJobEmail(clerk.getJobEmail());
            AssertUtil.assertTrue(c == null, "Email已经使用." + clerk.getJobEmail());
            if (enableAccountType(EMAIL_TYPE_CODE)) {
                AssertUtil.assertTrue(!unifiedAccountClient.exist(clerk.getJobEmail()), "账号已经使用." + clerk.getJobEmail());
            }
        }
        if (StringUtils.isNotEmpty(clerk.getIdCard())) {
            Clerk c = clerkDao.getByIdCard(clerk.getIdCard());
            AssertUtil.assertTrue(c == null, "身份证已经使用." + clerk.getIdCard());
            if (enableAccountType(IDCARD_TYPE_CODE)) {
                AssertUtil.assertTrue(!unifiedAccountClient.exist(clerk.getIdCard()), "账号已经使用." + clerk.getIdCard());
            }
        }
        final String pwd = getDefaultPwd();
        String group = null;
        String ac = null;
        if (StringUtils.isNotEmpty(clerk.getMobile()) && enableAccountType(MOBILE_TYPE_CODE)) {
            group = regAccount(clerk.getMobile(), clerk.getName(), pwd, ac, group);
            ac = clerk.getMobile();
        }
        if (StringUtils.isNotEmpty(clerk.getJobEmail()) && enableAccountType(EMAIL_TYPE_CODE)) {
            group = regAccount(clerk.getJobEmail(), clerk.getName(), pwd, ac, group);
            ac = clerk.getJobEmail();
        }
        if (StringUtils.isNotEmpty(clerk.getIdCard()) && enableAccountType(IDCARD_TYPE_CODE)) {
            group = regAccount(clerk.getIdCard(), clerk.getName(), pwd, ac, group);
            ac = clerk.getIdCard();
        }
        clerk.setAccountGroup(group);
        clerk.setEnable(EnableType.ENABLE.getKey());
        long id = autoIdGenerator.get(ID_KEY);
        clerk.setId(id);
        boolean result = clerkDao.add(clerk);
        if (result) {
            if (StringUtils.isNotEmpty(clerk.getMobile()) && enableAccountType(MOBILE_TYPE_CODE)) {
                addPermissionAccount(clerk.getMobile(), clerk.getName());
            }
        }
        return result;
    }

    private void addPermissionAccount(String perAccountCode, String name) {

        perAccountCode = getClerkPermissionAccountCode(perAccountCode);
        Account account = accountClient.getAccount(perAccountCode);
        if (account == null) {
            account = new Account();
            account.setCode(perAccountCode);
            account.setName(name);
            accountClient.addAccount(account);
        }
    }

    private String regAccount(String account, String nickname, String pwd, String otherAccount, String group) {

        String resultGroup = group;
        if (StringUtils.isEmpty(otherAccount)) {
            resultGroup = unifiedAccountClient.reg(TypeEnum.CLERK_ACCOUNT_CODE, account, nickname, pwd);
        } else {
            unifiedAccountClient.regByOtherAccount(TypeEnum.CLERK_ACCOUNT_CODE, account, otherAccount, group);
        }
        return resultGroup;
    }

    @Override
    public Clerk get(Long id) {

        return clerkDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return clerkDao.delete(id);
    }

    @Override
    public boolean update(Clerk clerk) {

        return clerkDao.update(clerk);
    }

    @Override
    public Page<Clerk> page(ClerkQuery query, int start, int count) {

        return clerkDao.page(query, start, count);
    }

    public List<Clerk> listAll() {

        return clerkDao.listAll();
    }

    // @Override
    // public String getEncodeDefaultPwd() {
    //
    // return getEncodePsw(ClerkConstant.CLERK_PASSWORD_KEY);
    // }
    private String getDefaultPwd() {

        Xml xml = XmlFactory.get(CLERK_PASSWORD_KEY);
        AssertUtil.assertNotNull(xml, "xml尚未配置账号默认密码");
        List<XmlItem> list = xml.getItemList();
        for (XmlItem xmlItem : list) {
            if ("pwd".equals(xmlItem.getAttrMap().get("key")) && Boolean.valueOf(xmlItem.getAttrMap().get("enable"))) {
                return StringUtil.nullToEmpty(xmlItem.getText()).trim();
            }
        }
        return "123456";
    }

    // @Override
    // public String getEncodePsw(String psw) {
    //
    // return EncryptUtil.md5(psw);
    // }
    public boolean changePwd(Long id, String pwd) {

        AssertUtil.assertNotEmpty(pwd, "用户密码不能为空.");
        AssertUtil.assertNotNull(id, "用户ID不能为空.");
        Clerk clerk = get(id);
        AssertUtil.assertNotNull(id, "用户不存在." + id);
        String account = null;
        QAccount qAccount = unifiedAccountClient.getByAccount(clerk.getMobile());
        account = clerk.getMobile();
        if (qAccount == null) {
            qAccount = unifiedAccountClient.getByAccount(clerk.getJobEmail());
            account = clerk.getJobEmail();
        }
        if (qAccount == null) {
            qAccount = unifiedAccountClient.getByAccount(clerk.getIdCard());
            account = clerk.getIdCard();
        }
        AssertUtil.assertNotNull(account, "找不到用户账号:" + clerk.getName());
        unifiedAccountClient.updatePwd(account, pwd);
        return true;
    }

    @Override
    public Clerk getByAccount(String account) {

        Clerk clerk = clerkDao.getByMobile(account);
        if (clerk == null) {
            clerk = clerkDao.getByJobEmail(account);
        }
        if (clerk == null) {
            clerk = clerkDao.getByIdCard(account);
        }
        return clerk;
    }

    @Override
    public String getClerkPermissionAccountCode(String account) {

        Clerk clerk = getByAccount(account);
        AssertUtil.assertNotNull(clerk, "职员不存在" + account);
        return ClerkConstant.CLERKPREFIXCODE + clerk.getMobile();
    }

    @Override
    public List<Clerk> listAll(Map<String, Object> map) {

        return clerkDao.listAll(map);
    }

    @Override
    public boolean isClerk(String account, String password) {

        Clerk clerk = getByAccount(account);
        if (clerk != null && clerk.getEnable() == EnableType.DISABLE.getKey()) {
            throw new OrganizationException("职工已离职." + clerk.getName());
        }
        return clerk != null && unifiedAccountClient.canEntrySystem(TypeEnum.CLERK_ACCOUNT_CODE, account, clerk.getAccountGroup(), password);
    }

    @Override
    public List<Clerk> listByName(String name) {

        return clerkDao.listByName(name);
    }

    @Override
    public boolean editEnable(Long id) {

        return clerkDao.editEnable(id);
    }

    @Override
    public String isClerk(Long id, String password) {

        AssertUtil.assertNotNull(id, "用户ID不能为空.");
        Clerk clerk = get(id);
        AssertUtil.assertNotNull(id, "用户不存在." + id);
        if (isClerk(clerk.getMobile(), password)) {
            return clerk.getMobile();
        }
        if (isClerk(clerk.getJobEmail(), password)) {
            return clerk.getJobEmail();
        }
        if (isClerk(clerk.getIdCard(), password)) {
            return clerk.getIdCard();
        }
        return null;
    }

    @Override
    public Clerk getByMobile(String mobile) {

        return clerkDao.getByMobile(mobile);
    }

    @Override
    public Clerk getByIdCard(String idCard) {

        return clerkDao.getByIdCard(idCard);
    }

    @Override
    public Clerk getByJobEmail(String email) {

        return clerkDao.getByJobEmail(email);
    }

    @Transactional
    @Override
    public boolean updateClerkInfo(Clerk oldClerk, Clerk clerk) {

        if (!oldClerk.getMobile().equals(clerk.getMobile())) {
            unifiedAccountClient.updateAccount(oldClerk.getMobile(), clerk.getMobile());
        }
        if (!oldClerk.getName().equals(clerk.getName())) {
            unifiedAccountClient.updateName(clerk.getMobile(), clerk.getName());
        }
        oldClerk.setMobile(clerk.getMobile());
        oldClerk.setName(clerk.getName());
        oldClerk.setHeadImage(fileSDKClient.uidToUrl(clerk.getHeadImage()));
        oldClerk.setSex(clerk.getSex());
        oldClerk.setInside(clerk.getInside());
        return update(oldClerk);
    }

    @Override
    public boolean updateJobEmail(Clerk oldClerk, String jobEmail) {

        if (unifiedAccountClient.updateAccount(oldClerk.getJobEmail(), jobEmail)) {
            oldClerk.setJobEmail(jobEmail);
            return update(oldClerk);
        }
        return false;
    }
}
