package com.qcloud.component.organization.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.organization.QContacts;
import com.qcloud.component.organization.model.Department;
import com.qcloud.component.organization.model.Post;
import com.qcloud.component.organization.model.key.TypeEnum.SexType;
import com.qcloud.component.organization.service.DepartmentService;
import com.qcloud.component.organization.service.PostService;
import com.qcloud.component.organization.web.handler.ContactsHandler;
import com.qcloud.component.organization.web.vo.ContactsVO;
import com.qcloud.component.organization.web.vo.ExportContactsVO;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class ContactsHandlerImpl implements ContactsHandler {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    PostService       postService;

    @Override
    public List<ContactsVO> toVOList(List<QContacts> data) {

        List<ContactsVO> list = new ArrayList<ContactsVO>();
        for (QContacts contacts : data) {
            ContactsVO cvo = new ContactsVO();
            cvo.setClerkName(contacts.getClerkName());
            Department department = departmentService.get(contacts.getDepartmentId());
            AssertUtil.assertNotNull(department, "部门不存在." + contacts.getDepartmentId());
            cvo.setDepartment(department.getName());
            cvo.setJovEmail(contacts.getJovEmail());
            cvo.setMobile(contacts.getMobile());
            Post post = postService.get(contacts.getPostId());
            AssertUtil.assertNotNull(post, "部门不存在." + contacts.getPostId());
            cvo.setPost(post.getName());
            cvo.setSex(contacts.getSex());
            cvo.setHeadImage(contacts.getHeadImage());
            list.add(cvo);
        }
        return list;
    }

    @Override
    public List<ExportContactsVO> toVOList4Export(List<QContacts> data) {

        List<ExportContactsVO> list = new ArrayList<ExportContactsVO>();
        for (QContacts contacts : data) {
            ExportContactsVO cvo = new ExportContactsVO();
            cvo.setClerkName(contacts.getClerkName());
            Department department = departmentService.get(contacts.getDepartmentId());
            AssertUtil.assertNotNull(department, "部门不存在." + contacts.getDepartmentId());
            cvo.setDepartment(department.getName());
            cvo.setJovEmail(contacts.getJovEmail());
            cvo.setMobile(contacts.getMobile());
            Post post = postService.get(contacts.getPostId());
            AssertUtil.assertNotNull(post, "部门不存在." + contacts.getPostId());
            cvo.setPost(post.getName());
            SexType sex = null;
            String sexStr = sex.getValue(contacts.getSex());
            cvo.setSexStr(sexStr);
            list.add(cvo);
        }
        return list;
    }
}
