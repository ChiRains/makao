package com.qcloud.component.organization.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.model.ClerkPost;
import com.qcloud.component.organization.model.Post;
import com.qcloud.component.organization.model.key.TypeEnum.EnableType;
import com.qcloud.component.organization.service.ClerkPostService;
import com.qcloud.component.organization.service.ClerkService;
import com.qcloud.component.organization.service.PostService;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.web.mvc.annotation.PiratesApp;

@Controller
@RequestMapping(value = ClerkPostController.DIR)
public class ClerkPostController {

    public static final String DIR = "/clerkPost";

    @Autowired
    private ClerkPostService   clerkPostService;

    @Autowired
    private PostService        postService;

    @Autowired
    private ClerkService       clerkService;

    @PiratesApp
    @RequestMapping
    public FrontAjaxView salesmanPostKeyValue() {// 获取员工岗位是业务员的Id，name

        Xml xml = XmlFactory.get("jingjian-bussiness-post");
        AssertUtil.assertNotNull(xml, "请初始化业务员岗位设置: jingjian-bussiness-post");
        List<XmlItem> itemList = xml.getItemList();
        Long postId = 0L;
        for (XmlItem xmlItem : itemList) {
            postId = Long.parseLong(xmlItem.getAttrMap().get("postId"));
            break;
        }
        List<KeyValueVO> list = new ArrayList<KeyValueVO>();
        for (Post post : postService.listAll()) {
            if (post.getId() == postId) {
                for (ClerkPost cp : clerkPostService.listByPost(post.getId())) {
                    Clerk clerk = clerkService.get(cp.getClerkId());
                    if (clerk != null && clerk.getEnable() == EnableType.ENABLE.getKey()) {
                        KeyValueVO vo = new KeyValueVO();
                        vo.setKey(String.valueOf(clerk.getId()));
                        vo.setValue(clerk.getName());
                        list.add(vo);
                    }
                }
            }
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("salesmanPostKeyValue", list);
        return view;
    }

    @PiratesApp
    @RequestMapping
    public FrontAjaxView dispatcherPostKeyValue() {// 获取员工岗位是业务员的Id，name

        Xml xml = XmlFactory.get("jingjian-dispatch-post");
        AssertUtil.assertNotNull(xml, "请初始化调度员岗位设置: jingjian-dispatch-post");
        List<XmlItem> itemList = xml.getItemList();
        Long postId = 0L;
        for (XmlItem xmlItem : itemList) {
            postId = Long.parseLong(xmlItem.getAttrMap().get("postId"));
            break;
        }
        List<KeyValueVO> list = new ArrayList<KeyValueVO>();
        for (Post post : postService.listAll()) {
            if (post.getId() == postId) {
                for (ClerkPost cp : clerkPostService.listByPost(post.getId())) {
                    Clerk clerk = clerkService.get(cp.getClerkId());
                    if (clerk != null && clerk.getEnable() == EnableType.ENABLE.getKey()) {
                        KeyValueVO vo = new KeyValueVO();
                        vo.setKey(String.valueOf(clerk.getId()));
                        vo.setValue(clerk.getName());
                        list.add(vo);
                    }
                }
            }
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("dispatcherPostKeyValue", list);
        return view;
    }

    @PiratesApp
    @RequestMapping
    public FrontAjaxView clerkKeyValue() {// clerk的id为key，name为value

        List<Clerk> clerkList = clerkService.listAll();
        List<KeyValueVO> list = new ArrayList<KeyValueVO>();
        for (Clerk clerk : clerkList) {
            if (!list.contains(clerk.getName()) && clerk.getEnable() == 1) {
                KeyValueVO vo = new KeyValueVO();
                vo.setKey(String.valueOf(clerk.getId()));
                vo.setValue(clerk.getName());
                list.add(vo);
            }
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("clerkKeyValue", list);
        return view;
    }
}
