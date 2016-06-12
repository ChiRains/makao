package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class DepartmentRoleUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/departmentRole/add.do");
        list.add("/departmentRole/list.do");
        list.add("/departmentRole/get.do");
        list.add("/departmentRole/update.do");
        list.add("/departmentRole/roleList.do");
        list.add("/departmentRole/changeRole.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/departmentRole/list.do");
        return list;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        // list.add("/departmentRole/add.do");
        return list;
    }
}
