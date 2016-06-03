package com.qcloud.component.admin.web.helper;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.admin.AdminClient;
import com.qcloud.component.admin.QAdmin;
import com.qcloud.component.token.TokenClient;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.web.filter.admin.AdminFilterService;
import com.qcloud.pirates.web.page.PageParameter;

@Component
public class AdminParameter implements PageParameter {

    @Autowired
    private AdminFilterService adminFilterService;

    @Autowired
    private TokenClient        tokenClient;

    @Autowired
    private AdminClient        adminClient;

    @Override
    public String getKey() {

        return AdminClient.ADMIN_LOGIN_PARAMETER_KEY;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getValue(HttpServletRequest request) {

        String tokenId = adminFilterService.getTokenId(request);
        AssertUtil.assertNotEmpty(tokenId, "获取用户登录信息失败.");
        String idStr = tokenClient.get(tokenId);
        AssertUtil.assertNotEmpty(idStr, "获取用户标识失败.");
        long adminId = Long.parseLong(idStr);
        QAdmin admin = adminClient.getAdminById(adminId);
        AssertUtil.assertNotNull(admin, "管理员不存在." + adminId);
        return (T) admin;
    }
}
