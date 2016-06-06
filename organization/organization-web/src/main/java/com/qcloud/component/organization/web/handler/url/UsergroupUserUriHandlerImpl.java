package com.qcloud.component.organization.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class UsergroupUserUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/usergroupUser/list.do");
        list.add("/admin/usergroupUser/toAdd.do");
        list.add("/admin/usergroupUser/toEdit.do");
        list.add("/admin/usergroupUser/add.do");
        list.add("/admin/usergroupUser/edit.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/usergroupUser/list.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return map;
    }
}
