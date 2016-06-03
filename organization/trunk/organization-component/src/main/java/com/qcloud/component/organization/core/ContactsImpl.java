package com.qcloud.component.organization.core;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.organization.Contacts;
import com.qcloud.component.organization.QContacts;
import com.qcloud.component.organization.entity.ContactsEntity;
import com.qcloud.component.organization.exception.OrganizationException;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.model.ClerkPost;
import com.qcloud.component.organization.model.Department;
import com.qcloud.component.organization.model.DepartmentClerk;
import com.qcloud.component.organization.service.ClerkPostService;
import com.qcloud.component.organization.service.ClerkService;
import com.qcloud.component.organization.service.DepartmentClerkService;
import com.qcloud.component.organization.service.DepartmentService;
import com.qcloud.component.organization.service.PostService;
import com.qcloud.pirates.data.Page;

@Component
public class ContactsImpl implements Contacts {

    @Autowired
    private ClerkService   clerkService;

    @Autowired
    DepartmentService      departmentService;

    @Autowired
    DepartmentClerkService departmentClerkService;

    @Autowired
    ClerkPostService       clerkPostService;

    @Autowired
    PostService            postService;

    @Override
    public Page<QContacts> query(String name, Long departmentId0, int start, int count) {

        Long departmentId = departmentId0 == null ? 0L : departmentId0;
        Department department = departmentService.get(departmentId);
        Page<QContacts> page = new Page<QContacts>();
        if (StringUtils.isNotEmpty(name) || department == null) {
            List<Clerk> clerkList = clerkService.listByName(name);
            List<Clerk> dcList = new ArrayList<Clerk>();
            if (department != null) {
                List<DepartmentClerk> list = departmentClerkService.listByDepartment(departmentId);
                for (Clerk clerk : clerkList) {
                    for (DepartmentClerk departmentClerk : list) {
                        if (clerk.getId() == departmentClerk.getClerkId()) {
                            dcList.add(clerk);
                            break;
                        }
                    }
                }
            } else {
                dcList = clerkList;
            }
            List<QContacts> result = new ArrayList<QContacts>();
            for (int index = start; index < dcList.size() && index < start + count; index++) {
                Clerk clerk = dcList.get(index);
                ContactsEntity ce = new ContactsEntity();
                ce.setClerkName(clerk.getName());
                ce.setSex(clerk.getSex());
                ce.setMobile(clerk.getMobile());
                ce.setJovEmail(clerk.getJobEmail());
                ce.setHeadImage(clerk.getHeadImage());
                DepartmentClerk departmentClerk = departmentClerkService.getBelongsDepartment(clerk.getId());
                ce.setDepartmentId(departmentClerk.getDepartmentId());
                List<ClerkPost> clerkPostList = clerkPostService.listByClerk(clerk.getId());
                if (CollectionUtils.isEmpty(clerkPostList) || clerkPostList.size() > 1) {
                    throw new OrganizationException("用户有多个岗位." + clerk.getName());
                }
                ce.setPostId(clerkPostList.get(0).getPostId());
                result.add(ce);
            }
            page.setData(result);
            page.setCount(dcList.size());
        } else {
            List<DepartmentClerk> list = departmentClerkService.listByDepartment(departmentId);
            List<QContacts> result = new ArrayList<QContacts>();
            for (int index = start; index < list.size() && index < start + count; index++) {
                Clerk clerk = clerkService.get(list.get(index).getClerkId());
                if (clerk != null) {
                    ContactsEntity ce = new ContactsEntity();
                    ce.setClerkName(clerk.getName());
                    ce.setSex(clerk.getSex());
                    ce.setMobile(clerk.getMobile());
                    ce.setJovEmail(clerk.getJobEmail());
                    DepartmentClerk departmentClerk = departmentClerkService.getBelongsDepartment(clerk.getId());
                    ce.setDepartmentId(departmentClerk.getDepartmentId());
                    List<ClerkPost> clerkPostList = clerkPostService.listByClerk(clerk.getId());
                    if (CollectionUtils.isEmpty(clerkPostList) || clerkPostList.size() > 1) {
                        throw new OrganizationException("用户有多个岗位." + clerk.getName());
                    }
                    ce.setPostId(clerkPostList.get(0).getPostId());
                    result.add(ce);
                }
            }
            page.setData(result);
            page.setCount(result.size());
        }
        return page;
    }
}
