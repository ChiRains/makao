package com.qcloud.component.permission.web.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class PermissionUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/grant/toGrant.do");
        list.add("/grant/grant.do");
        list.add("/grant/list.do");
        //
        list.add("/catalog/list.do");
        //
        list.add("/menu/list.do");
        list.add("/menu/toAdd.do");
        list.add("/menu/add.do");
        list.add("/menu/toEdit.do");
        list.add("/menu/edit.do");
        //
        list.add("/permission/toGrant.do");
        list.add("/permission/menuGrant.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/grant/toGrant.do");
        list.add("/grant/grant.do");
        list.add("/grant/list.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> list = stringToList("/grant/list.do");
        //
        map.put("/grant/toGrant.do", list);
        map.put("/grant/grant.do", list);
        return map;
    }
}
