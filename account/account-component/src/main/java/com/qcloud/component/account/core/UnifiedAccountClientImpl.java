package com.qcloud.component.account.core;

import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.qcloud.component.account.QAccount;
import com.qcloud.component.account.UnifiedAccountClient;
import com.qcloud.component.account.exception.AccountException;
import com.qcloud.component.account.model.CertificateType;
import com.qcloud.component.account.model.EntryCertificate;
import com.qcloud.component.account.model.key.TypeEnum.EntryCertificateStateType;
import com.qcloud.component.account.service.CertificateTypeService;
import com.qcloud.component.account.service.EntryCertificateService;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.Base64;
import com.qcloud.pirates.util.EncryptUtil;
import com.qcloud.pirates.util.StringUtil;

@Service
public class UnifiedAccountClientImpl implements UnifiedAccountClient {

    @Value("${pirates.password.key}")
    private String                  additionalPwd;

    private Log                     logger = LogFactory.getLog(getClass());

    @Autowired
    private EntryCertificateService entryCertificateService;

    @Autowired
    private CertificateTypeService  certificateTypeService;

    public String getAdditionalPwd() {

        return additionalPwd;
    }

    public void setAdditionalPwd(String additionalPwd) {

        this.additionalPwd = additionalPwd;
    }

    @PostConstruct
    public void init() {

        if (StringUtils.isEmpty(additionalPwd) || "${pirates.password.key}".equals(additionalPwd)) {
            additionalPwd = "";
        }
        logger.info("additional p w d " + additionalPwd);
        if (StringUtils.isNotEmpty(additionalPwd)) {
            additionalPwd = Base64.decode(additionalPwd);
        }
        logger.info("additional p w d " + additionalPwd);
    }

    @Override
    public String encodePwd(String pwd) {

        if (StringUtils.isNotEmpty(additionalPwd) && !"${pirates.password.key}".equals(additionalPwd)) {
            return EncryptUtil.md5(additionalPwd + pwd + "@qcloud.com");
        }
        return EncryptUtil.md5(pwd);
    }

    @Override
    public boolean exist(String account) {

        AssertUtil.assertNotEmpty(account, "账号不能为空");
        return entryCertificateService.getByAccount(account) != null;
    }

    @Override
    public boolean updatePwd(String account, String pwd) {

        AssertUtil.assertNotEmpty(account, "账号不能为空");
        AssertUtil.assertNotNull(pwd, "密码不能为空");
        EntryCertificate entryCertificate = entryCertificateService.getByAccount(account);
        AssertUtil.assertNotNull(entryCertificate, "账号不存在." + account);
        List<EntryCertificate> list = entryCertificateService.listByGroup(entryCertificate.getGroup());
        String password = encodePwd(pwd);
        for (EntryCertificate ec : list) {
            ec.setPassword(password);
            entryCertificateService.update(ec);
        }
        return true;
    }

    @Override
    public boolean updateName(String account, String name) {

        EntryCertificate entryCertificate = entryCertificateService.getByAccount(account);
        AssertUtil.assertNotNull(entryCertificate, "账号不存在." + account);
        List<EntryCertificate> list = entryCertificateService.listByGroup(entryCertificate.getGroup());
        for (EntryCertificate ec : list) {
            ec.setName(name);
            entryCertificateService.update(ec);
        }
        return true;
    }

    @Override
    public boolean canEntrySystem(String code, String account, String group, String pwd) {

        EntryCertificate entryCertificate = entryCertificateService.getByAccount(account);
        AssertUtil.assertNotNull(entryCertificate, "账号不存在." + account);
        if (entryCertificate.getState() == EntryCertificateStateType.DISABLE.getKey()) {
            throw new AccountException("账号已经被禁用." + account);
        }
        if (entryCertificate.getState() == EntryCertificateStateType.FROZEN.getKey()) {
            throw new AccountException("账号已经被冻结." + account);
        }
        if (entryCertificate.getCode().equals(code) && entryCertificate.getGroup().equals(group)) {
            AssertUtil.assertTrue(entryCertificate.getPassword().equals(encodePwd(pwd)), "密码不正确.");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public QAccount getByAccount(String account) {

        return entryCertificateService.getByAccount(account);
    }

    @Override
    public String reg(String code, String account, String name, String pwd) {

        AssertUtil.assertNotEmpty(account, "账号不能为空");
        AssertUtil.assertNotNull(pwd, "密码不能为空");
        AssertUtil.assertTrue(checkTypeCode(code), "账号类型尚未定义." + code);
        if (exist(account)) {
            throw new AccountException("账号已存在." + account);
        }
        synchronized (account) {
            EntryCertificate entryCertificate = new EntryCertificate();
            entryCertificate.setCode(code);
            entryCertificate.setAccount(account);
            entryCertificate.setGroup(StringUtil.uuid());
            entryCertificate.setName(name);
            entryCertificate.setPassword(encodePwd(pwd));
            entryCertificateService.add(entryCertificate);
            return entryCertificate.getGroup();
        }
    }

    @Override
    public boolean regByOtherAccount(String code, String account, String otherAccount, String group) {

        AssertUtil.assertNotEmpty(account, "账号不能为空");
        AssertUtil.assertNotEmpty(otherAccount, "其他账号不能为空");
        AssertUtil.assertTrue(checkTypeCode(code), "账号类型尚未定义." + code);
        AssertUtil.assertTrue(!exist(account), "账号已存在." + account);
        EntryCertificate otherEntryCertificate = entryCertificateService.getByAccount(otherAccount);
        AssertUtil.assertNotNull(otherEntryCertificate, "其他账号不存在." + account);
        AssertUtil.assertTrue(otherEntryCertificate.getGroup().equals(group), "账号组别不正确,注册失败." + account);
        synchronized (account) {
            EntryCertificate entryCertificate = new EntryCertificate();
            entryCertificate.setCode(code);
            entryCertificate.setAccount(account);
            entryCertificate.setGroup(otherEntryCertificate.getGroup());
            entryCertificate.setName(otherEntryCertificate.getName());
            entryCertificate.setPassword(otherEntryCertificate.getPassword());
            return entryCertificateService.add(entryCertificate);
        }
    }

    private boolean checkTypeCode(String code) {

        CertificateType certificateType = certificateTypeService.getByCode(code);
        return certificateType != null;
    }

    @Override
    public boolean updateAccount(String account, String newAccount) {

        if (exist(newAccount)) {
            throw new AccountException("账号已存在." + account);
        }
        EntryCertificate entryCertificate = entryCertificateService.getByAccount(account);
        AssertUtil.assertNotNull(entryCertificate, "账号不存在." + account);
        entryCertificate.setAccount(newAccount);
        return entryCertificateService.update(entryCertificate);
    }

    @Override
    public boolean disableAccount(String account) {

        EntryCertificate entryCertificate = entryCertificateService.getByAccount(account);
        AssertUtil.assertNotNull(entryCertificate, "账号不存在." + account);
        entryCertificate.setState(EntryCertificateStateType.DISABLE.getKey());
        return entryCertificateService.update(entryCertificate);
    }

    @Override
    public boolean enableAccount(String account) {

        EntryCertificate entryCertificate = entryCertificateService.getByAccount(account);
        AssertUtil.assertNotNull(entryCertificate, "账号不存在." + account);
        entryCertificate.setState(EntryCertificateStateType.ENABLE.getKey());
        return entryCertificateService.update(entryCertificate);
    }
}