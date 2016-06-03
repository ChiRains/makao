package com.qcloud.component.admin.web.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class AdminUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/");
        list.add("/admin");
        list.add("/admin/");
        list.add("/admin/toLogin.do");
        list.add("/admin/toLoginAgain.do");
        list.add("/admin/login.do");
        list.add("/admin/loginAgain.do");
        list.add("/admin/logout.do");
        return list;
    }

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/index.do");
        list.add("/admin/list.do");
        list.add("/admin/toAdd.do");
        list.add("/admin/toEdit.do");
        list.add("/admin/add.do");
        list.add("/admin/edit.do");
        list.add("/admin/delete.do");
        list.add("/admin/resetPsw.do");
        list.add("/admin/enable.do");
        list.add("/admin/toAdminPersonalInfo.do");
        list.add("/admin/modify.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> list = stringToList("/admin/list.do");
        //
        map.put("/admin/toAdd.do", list);
        map.put("/admin/add.do", list);
        map.put("/admin/toEdit.do", list);
        map.put("/admin/edit.do", list);
        map.put("/admin/enable.do", list);
        map.put("/admin/resetPsw.do", list);
        //
        map.put("/admin/modify.do", stringToList("/admin/toAdminPersonalInfo.do"));
        return map;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/list.do");
        list.add("/admin/toAdd.do");
        list.add("/admin/toEdit.do");
        list.add("/admin/add.do");
        list.add("/admin/edit.do");
        list.add("/admin/delete.do");
        list.add("/admin/resetPsw.do");
        list.add("/admin/enable.do");
        list.add("/admin/toAdminPersonalInfo.do");
        list.add("/admin/modify.do");
        return list;
    }
}
