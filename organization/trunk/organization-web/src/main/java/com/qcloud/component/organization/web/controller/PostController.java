package com.qcloud.component.organization.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.model.Department;
import com.qcloud.component.organization.model.Post;
import com.qcloud.component.organization.service.PostService;
import com.qcloud.component.organization.web.handler.PostHandler;
import com.qcloud.component.publicdata.IntKeyValue;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.publicdata.PublicdataClient;
import com.qcloud.pirates.mvc.FrontAjaxView;

@Controller
@RequestMapping(value = PostController.DIR)
public class PostController {

    public static final String DIR = "/post";

    @Autowired
    private PostService        postService;

    @Autowired
    private PublicdataClient   publicdataClient;

    @RequestMapping
    public FrontAjaxView list() {

        List<Post> list = postService.listAll();
        List<IntKeyValue> ikList = new ArrayList<IntKeyValue>();
        for (IntKeyValue intKeyValue : list) {
            ikList.add(intKeyValue);
        }
        List<KeyValueVO> voList = publicdataClient.exchageObj(ikList, -1L, "");
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("获取岗位列表成功");
        view.addObject("list", voList);
        return view;
    }
    
    
}
