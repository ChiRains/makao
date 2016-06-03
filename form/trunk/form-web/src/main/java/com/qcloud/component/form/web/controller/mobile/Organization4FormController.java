package com.qcloud.component.form.web.controller.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.web.controller.ClerkController;
import com.qcloud.component.organization.web.controller.DepartmentController;
import com.qcloud.component.organization.web.controller.PostController;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.Base64;

@Controller
@RequestMapping(value = Organization4FormController.DIR)
public class Organization4FormController {

    public static final String   DIR = "/org4form";

    @Autowired
    private ClerkController      clerkController;

    @Autowired
    private PostController       postController;

    @Autowired
    private DepartmentController departmentController;

    @Autowired
    private ClerkHelper          clerkHelper;

    @RequestMapping
    public FrontAjaxView getClerk(String userToken) {

        AssertUtil.assertNotEmpty(userToken, "用户token不能为空.");
        String appToken = Base64.decode(userToken);
        return clerkController.getClerk(appToken);
    }

    @RequestMapping
    public FrontAjaxView clerkKeyValue(String userToken) {

        AssertUtil.assertNotEmpty(userToken, "用户token不能为空.");
        String appToken = Base64.decode(userToken);
        Clerk clerk = clerkHelper.getClerk(appToken);
        AssertUtil.assertNotNull(clerk, "用户不存在");
        return clerkController.clerkKeyValue();
    }

    @RequestMapping
    public FrontAjaxView listPost(String userToken) {

        AssertUtil.assertNotEmpty(userToken, "用户token不能为空.");
        String appToken = Base64.decode(userToken);
        Clerk clerk = clerkHelper.getClerk(appToken);
        AssertUtil.assertNotNull(clerk, "用户不存在");
        return postController.list();
    }

    @RequestMapping
    public FrontAjaxView listDepartment(String userToken) {

        AssertUtil.assertNotEmpty(userToken, "用户token不能为空.");
        String appToken = Base64.decode(userToken);
        Clerk clerk = clerkHelper.getClerk(appToken);
        AssertUtil.assertNotNull(clerk, "用户不存在");
        return departmentController.list();
    }
}
