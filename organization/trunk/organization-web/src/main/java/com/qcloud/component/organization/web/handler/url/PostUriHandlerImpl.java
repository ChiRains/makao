package com.qcloud.component.organization.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class PostUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/post/list.do");
        list.add("/admin/post/toAdd.do");
        list.add("/admin/post/toEdit.do");
        list.add("/admin/post/add.do");
        list.add("/admin/post/edit.do");
        list.add("/post/list.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/post/list.do");
        list.add("/admin/post/toAdd.do");
        list.add("/admin/post/toEdit.do");
        list.add("/admin/post/add.do");
        list.add("/admin/post/edit.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/post/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/post/toAdd.do", list);
        map.put("/admin/post/toEdit.do", list);
        map.put("/admin/post/add.do", list);
        map.put("/admin/post/edit.do", list);
        //
        map.put("/admin/clerkPost/selectMember.do", list);
        map.put("/admin/clerkPost/edit.do", list);
        return map;
    }
}
