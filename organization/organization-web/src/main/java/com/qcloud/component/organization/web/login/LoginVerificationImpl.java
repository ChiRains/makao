package com.qcloud.component.organization.web.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.admin.LoginVerification;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.service.ClerkService;

// 京建用户不允许登录后台,仅允许系统管理员登录后台
@Component
public class LoginVerificationImpl implements LoginVerification {

    @Autowired
    private ClerkService clerkService;

    @Override
    public boolean allow(String account, String password) {

        return clerkService.isClerk(account, password);
    }

    @Override
    public String[] getAccountCodes(String account) {

        return new String[] { clerkService.getClerkPermissionAccountCode(account)};
    }

    @Override
    public String getIdentificationKey(String account) {

        Clerk clerk = clerkService.getByAccount(account);
        if (clerk == null) {
            return null;
        }
        return String.valueOf(clerk.getId());
    }
}
