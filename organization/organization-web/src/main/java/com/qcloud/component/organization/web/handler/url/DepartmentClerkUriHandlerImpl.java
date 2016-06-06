package com.qcloud.component.organization.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class DepartmentClerkUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        // list.add("/admin/departmentClerk/list.do");
        // list.add("/admin/departmentClerk/toAdd.do");
        // list.add("/admin/departmentClerk/toEdit.do");
        // list.add("/admin/departmentClerk/add.do");
        list.add("/admin/departmentClerk/edit.do");
        list.add("/admin/departmentClerk/selectMember.do");
        list.add("/admin/departmentClerk/selectManager.do");
        list.add("/admin/departmentClerk/editManager.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
//        list.add("/admin/departmentClerk/list.do");
//        list.add("/admin/departmentClerk/toAdd.do");
//        list.add("/admin/departmentClerk/toEdit.do");
//        list.add("/admin/departmentClerk/add.do");
        list.add("/admin/departmentClerk/edit.do");
        list.add("/admin/departmentClerk/selectMember.do");
        list.add("/admin/departmentClerk/selectManager.do");
        list.add("/admin/departmentClerk/editManager.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return map;
    }
}
