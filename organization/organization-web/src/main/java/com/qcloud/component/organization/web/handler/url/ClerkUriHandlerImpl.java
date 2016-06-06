package com.qcloud.component.organization.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ClerkUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/clerk/list.do");
        list.add("/admin/clerk/toAdd.do");
        list.add("/admin/clerk/toEdit.do");
        list.add("/admin/clerk/add.do");
        list.add("/admin/clerk/edit.do");
        list.add("/admin/clerk/resetPwd.do");
        list.add("/admin/clerk/enable.do");
        list.add("/admin/clerk/selectAllClerk.do");
        //
        list.add("/clerk/getClerk.do");
        list.add("/clerk/logout.do");
        //
        list.add("/clerk/updatePwd.do");
        list.add("/clerk/getClerk.do");
        list.add("/clerk/resetPwd.do");
        list.add("/clerk/updateClerk.do");
        list.add("/clerk/updateClerkInfo.do");
        //
        list.add("/clerk/listLoginLog.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/clerk/list.do");
        list.add("/admin/clerk/toAdd.do");
        list.add("/admin/clerk/toEdit.do");
        list.add("/admin/clerk/add.do");
        list.add("/admin/clerk/edit.do");
        list.add("/admin/clerk/resetPwd.do");
        list.add("/admin/clerk/enable.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/clerk/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/clerk/toAdd.do", list);
        map.put("/admin/clerk/add.do", list);
        map.put("/admin/clerk/toEdit.do", list);
        map.put("/admin/clerk/edit.do", list);
        map.put("/admin/clerk/enable.do", list);
        map.put("/admin/clerk/resetPwd.do", list);
        return map;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/clerk/login.do");
        list.add("/clerk/clerkKeyValue.do");
        list.add("/clerk/sendMsgForCode.do");
        list.add("/clerk/validateCode.do");
        //
        list.add("/app/clerk/login.do");
        return list;
    }

    @Override
    public List<String> userUris() {

        List<String> list = new ArrayList<String>();
        //
        list.add("/app/clerk/sendMsgForCode.do");
        list.add("/app/clerk/validateCode.do");
        //
        list.add("/app/clerk/updatePwd.do");
        list.add("/app/clerk/getClerk.do");
        list.add("/app/clerk/resetPwd.do");
        list.add("/app/clerk/updateClerk.do");
        list.add("/app/clerk/logout.do");
        //
        list.add("/app/clerk/updateClerkInfo.do");
        return list;
    }

    @Override
    public List<String> appUris() {

        List<String> list = new ArrayList<String>();
        list.add("/app/clerk/login.do");
        list.add("/app/clerk/sendMsgForCode.do");
        list.add("/app/clerk/validateCode.do");
        list.add("/app/clerk/updatePwd.do");
        list.add("/app/clerk/getClerk.do");
        list.add("/app/clerk/resetPwd.do");
        list.add("/app/clerk/updateClerk.do");
        list.add("/app/clerk/logout.do");
        list.add("/app/clerk/updateClerkInfo.do");
        return list;
    }
}
