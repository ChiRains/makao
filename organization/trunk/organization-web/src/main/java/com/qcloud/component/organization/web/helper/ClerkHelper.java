package com.qcloud.component.organization.web.helper;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.service.ClerkService;
import com.qcloud.component.token.TokenClient;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.web.filter.admin.AdminFilterService;
import com.qcloud.pirates.web.filter.user.UserFilterService;

@Component
public class ClerkHelper {

    @Autowired
    private AdminFilterService adminFilterService;

    @Autowired
    private UserFilterService  userFilterService;

    @Autowired
    private TokenClient        tokenClient;

    @Autowired
    private ClerkService       clerkService;

    @Autowired
    private OrganizationClient organizationClient;

    public Clerk getClerk(HttpServletRequest request) {

        String token = adminFilterService.getTokenId(request);
        if (StringUtils.isEmpty(token)) {
            token = userFilterService.getTokenId(request);
        }
        AssertUtil.assertNotEmpty(token, "获取用户登录信息失败.");
        String idStr = tokenClient.get(token);
        AssertUtil.assertNotEmpty(idStr, "获取用户标识失败.");
        Clerk clerk = clerkService.get(Long.parseLong(idStr));
        AssertUtil.assertNotNull(clerk, "用户不存在.");
        return clerk;
    }

    public Clerk getClerk(String token) {

        AssertUtil.assertNotEmpty(token, "获取用户登录信息失败.");
        String idStr = tokenClient.get(token);
        AssertUtil.assertNotEmpty(idStr, "获取用户标识失败.");
        Clerk clerk = clerkService.get(Long.parseLong(idStr));
        AssertUtil.assertNotNull(clerk, "用户不存在.");
        return clerk;
    }

    public QClerk getClerkModel(HttpServletRequest request) {

        String token = adminFilterService.getTokenId(request);
        if (StringUtils.isEmpty(token)) {
            token = userFilterService.getTokenId(request);
        }
        AssertUtil.assertNotEmpty(token, "获取用户登录信息失败.");
        String idStr = tokenClient.get(token);
        AssertUtil.assertNotEmpty(idStr, "获取用户标识失败.");
        QClerk clerk = organizationClient.getClerk(Long.parseLong(idStr));
        AssertUtil.assertNotNull(clerk, "用户不存在.");
        return clerk;
    }

    public QClerk getClerkModel(String token) {

        AssertUtil.assertNotEmpty(token, "获取用户登录信息失败.");
        String idStr = tokenClient.get(token);
        AssertUtil.assertNotEmpty(idStr, "获取用户标识失败.");
        QClerk clerk = organizationClient.getClerk(Long.parseLong(idStr));
        AssertUtil.assertNotNull(clerk, "用户不存在.");
        return clerk;
    }
    
}
