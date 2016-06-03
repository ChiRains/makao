package com.qcloud.component.organization.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ClerkMessageUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/clerkMessage/toSend.do");
        list.add("/admin/clerkMessage/send.do");
        list.add("/admin/clerkMessage/toSelectClerk.do");
        //
        list.add("/clerkMessage/list.do");
        list.add("/clerkMessage/listContent.do");
        list.add("/clerkMessage/get.do");
        list.add("/clerkMessage/read.do");
        list.add("/clerkMessage/delete.do");
        list.add("/clerkMessage/deleteList.do");
        list.add("/clerkMessage/countAll.do");
        list.add("/clerkMessage/countUnread.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/clerkMessage/toSend.do");
        list.add("/admin/clerkMessage/send.do");
        list.add("/admin/clerkMessage/toSelectClerk.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/clerk/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/clerkMessage/toSend.do", list);
        map.put("/admin/clerkMessage/send.do", list);
        map.put("/admin/clerkMessage/toSelectClerk.do", list);
        return map;
    }

    @Override
    public List<String> userUris() {

        List<String> list = new ArrayList<String>();
        // ##############################################
        list.add("/app/clerkMessage/list.do");
        list.add("/app/clerkMessage/get.do");
        list.add("/app/clerkMessage/read.do");
        list.add("/app/clerkMessage/delete.do");
        //
        list.add("/app/clerkMessage/countAll.do");
        list.add("/app/clerkMessage/countUnread.do");
        list.add("/app/clerkMessage/deleteList.do");
        return list;
    }

    @Override
    public List<String> appUris() {

        List<String> list = new ArrayList<String>();
        list.add("/app/clerkMessage/list.do");
        list.add("/app/clerkMessage/get.do");
        list.add("/app/clerkMessage/read.do");
        list.add("/app/clerkMessage/delete.do");
        list.add("/app/clerkMessage/deleteList.do");
        //
        list.add("/app/clerkMessage/countAll.do");
        list.add("/app/clerkMessage/countUnread.do");
        return list;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
//        list.add("/admin/clerkMessage/send.do");
        return list;
    }
}
