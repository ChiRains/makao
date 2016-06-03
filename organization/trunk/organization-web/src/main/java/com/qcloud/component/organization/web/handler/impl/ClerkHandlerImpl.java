package com.qcloud.component.organization.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.model.ClerkPost;
import com.qcloud.component.organization.model.Department;
import com.qcloud.component.organization.model.DepartmentClerk;
import com.qcloud.component.organization.model.Post;
import com.qcloud.component.organization.model.Superior;
import com.qcloud.component.organization.model.key.TypeEnum.SexType;
import com.qcloud.component.organization.service.ClerkPostService;
import com.qcloud.component.organization.service.ClerkService;
import com.qcloud.component.organization.service.DepartmentClerkService;
import com.qcloud.component.organization.service.DepartmentService;
import com.qcloud.component.organization.service.PostService;
import com.qcloud.component.organization.service.SuperiorService;
import com.qcloud.component.organization.web.handler.ClerkHandler;
import com.qcloud.component.organization.web.vo.ClerkVO;
import com.qcloud.component.organization.web.vo.admin.AdminClerkVO;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class ClerkHandlerImpl implements ClerkHandler {

    @Autowired
    ClerkPostService       clerkPostService;

    @Autowired
    PostService            postService;

    @Autowired
    DepartmentClerkService departmentClerkService;

    @Autowired
    DepartmentService      departmentService;

    @Autowired
    SuperiorService        superiorService;

    @Autowired
    ClerkService           clerkService;

    @Autowired
    private FileSDKClient  fileSDKClient;

    @Override
    public List<ClerkVO> toVOList(List<Clerk> list) {

        List<ClerkVO> voList = new ArrayList<ClerkVO>();
        for (Clerk clerk : list) {
            voList.add(toVO(clerk));
        }
        return voList;
    }

    @Override
    public ClerkVO toVO(Clerk clerk) {

        String json = Json.toJson(clerk);
        ClerkVO vo = Json.toObject(json, ClerkVO.class, true);
        if (!StringUtils.isEmpty(vo.getHeadImage())) {
            vo.setHeadImageUid(fileSDKClient.urlToUid(vo.getHeadImage()));
            vo.setHeadImage(fileSDKClient.getFileServerUrl() + vo.getHeadImage());
        }
        if (vo.getSex() == SexType.MAN.getKey()) {
            vo.setSexStr(SexType.MAN.getName());
        }
        if (vo.getSex() == SexType.WOMEN.getKey()) {
            vo.setSexStr(SexType.WOMEN.getName());
        }
        List<ClerkPost> cpList = clerkPostService.listByClerk(clerk.getId());
        if (cpList != null && cpList.size() > 0) {
            ClerkPost cp = cpList.get(0);
            Post post = postService.get(cp.getPostId());
            AssertUtil.assertNotNull(post, "岗位不存在." + cp.getPostId());
            vo.setPostId(post.getId());
            vo.setPostName(post.getName());
        } else {
            vo.setPostId(-1L);
            vo.setPostName("");
        }
        DepartmentClerk departmentClerk = departmentClerkService.getBelongsDepartment(clerk.getId());
        if (departmentClerk == null) {
            vo.setDepartmentId(-1L);
            vo.setDepartmentName("");
        } else {
            Department department = departmentService.get(departmentClerk.getDepartmentId());
            AssertUtil.assertNotNull(department, "部门不存在." + departmentClerk.getDepartmentId());
            vo.setDepartmentId(department.getId());
            vo.setDepartmentName(department.getName());
        }
        Superior superior = superiorService.getByClerk(clerk.getId());
        if (superior == null) {
            vo.setLeader(-1L);
            vo.setLeaderName("");
        } else {
            vo.setLeader(superior.getLeaderId());
            Clerk leader = clerkService.get(superior.getLeaderId());
            AssertUtil.assertNotNull(leader, "你的上级领导不存在!");
            vo.setLeaderName(leader.getName());
        }
        return vo;
    }

    @Override
    public List<AdminClerkVO> toVOList4Admin(List<Clerk> list) {

        List<AdminClerkVO> voList = new ArrayList<AdminClerkVO>();
        for (Clerk adminClerk : list) {
            voList.add(toVO4Admin(adminClerk));
        }
        return voList;
    }

    @Override
    public AdminClerkVO toVO4Admin(Clerk clerk) {

        String json = Json.toJson(clerk);
        AdminClerkVO vo = Json.toObject(json, AdminClerkVO.class, true);
        DepartmentClerk departmentClerk = departmentClerkService.getBelongsDepartment(clerk.getId());
        if (departmentClerk == null) {
            vo.setDepartmentId(-1L);
            vo.setDepartmentName("暂无分配");
        } else {
            Department department = departmentService.get(departmentClerk.getDepartmentId());
            AssertUtil.assertNotNull(department, "部门不存在." + departmentClerk.getDepartmentId());
            vo.setDepartmentId(department.getId());
            vo.setDepartmentName(department.getName());
        }
        return vo;
    }
}
