package com.qcloud.component.organization.web.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.service.PostService;

@Controller
@RequestMapping(value = AppPostController.DIR)
public class AppPostController {

    public static final String DIR = "/app/post";

    @Autowired
    private PostService        postService;
}
