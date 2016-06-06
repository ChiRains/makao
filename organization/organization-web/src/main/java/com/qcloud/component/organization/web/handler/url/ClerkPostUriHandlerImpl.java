package com.qcloud.component.organization.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ClerkPostUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        // list.add("/admin/clerkPost/list.do");
        // list.add("/admin/clerkPost/toAdd.do");
        // list.add("/admin/clerkPost/toEdit.do");
        // list.add("/admin/clerkPost/add.do");
        list.add("/admin/clerkPost/edit.do");
        list.add("/admin/clerkPost/selectMember.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        // list.add("/admin/clerkPost/list.do");
        // list.add("/admin/clerkPost/toAdd.do");
        // list.add("/admin/clerkPost/toEdit.do");
        // list.add("/admin/clerkPost/add.do");
        list.add("/admin/clerkPost/edit.do");
        list.add("/admin/clerkPost/selectMember.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return map;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/clerkPost/salesmanPostKeyValue.do");
        list.add("/clerkPost/dispatcherPostKeyValue.do");
        return list;
    }

    @Override
    public List<String> userUris() {

        List<String> list = new ArrayList<String>();
        list.add("/app/clerkPost/salesmanPostKeyValue.do");
        list.add("/app/clerkPost/dispatcherPostKeyValue.do");
        list.add("/app/clerkPost/clerkKeyValue.do");
        return list;
    }

    @Override
    public List<String> appUris() {

        List<String> list = new ArrayList<String>();
        list.add("/app/clerkPost/salesmanPostKeyValue.do");
        list.add("/app/clerkPost/dispatcherPostKeyValue.do");
        list.add("/app/clerkPost/clerkKeyValue.do");
        return list;
    }
}
