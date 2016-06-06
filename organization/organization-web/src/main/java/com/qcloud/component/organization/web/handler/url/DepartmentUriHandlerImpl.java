package com.qcloud.component.organization.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class DepartmentUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/department/list.do");
        list.add("/admin/department/toAdd.do");
        list.add("/admin/department/toEdit.do");
        list.add("/admin/department/add.do");
        list.add("/admin/department/edit.do");
        list.add("/department/list.do");
        list.add("/admin/department/delete.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/department/list.do");
        list.add("/admin/department/toAdd.do");
        list.add("/admin/department/toEdit.do");
        list.add("/admin/department/add.do");
        list.add("/admin/department/edit.do");
        list.add("/admin/department/delete.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/department/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/department/toAdd.do", list);
        map.put("/admin/department/add.do", list);
        map.put("/admin/department/toEdit.do", list);
        map.put("/admin/department/edit.do", list);
        map.put("/admin/department/delete.do", list);
        //
        map.put("/admin/departmentClerk/selectMember.do", list);
        map.put("/admin/departmentClerk/selectManager.do", list);
        map.put("/admin/departmentClerk/editManager.do", list);
        map.put("/admin/departmentClerk/edit.do", list);
        return map;
    }

    @Override
    public List<String> userUris() {

        List<String> list = new ArrayList<String>();
        list.add("/app/department/list.do");
        return list;
    }

    @Override
    public List<String> appUris() {

        List<String> list = new ArrayList<String>();
        list.add("/app/department/list.do");
        return list;
    }
}
