package com.qcloud.component.organization.web.helper;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.pirates.web.page.PageParameter;

@Component
public class ClerkParameter implements PageParameter {

    @Autowired
    ClerkHelper clerkHelper;

    @Override
    public String getKey() {

        return OrganizationClient.CLERK_LOGIN_PARAMETER_KEY;
    }

    @Override
    public <T> T getValue(HttpServletRequest request) {

        return (T) clerkHelper.getClerkModel(request);
    }
}
