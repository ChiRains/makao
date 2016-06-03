package com.qcloud.component.snakerext.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ProcessExecutorUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        // list.add("/admin/processExecutor/list.do");
        // list.add("/admin/processExecutor/toAdd.do");
        // list.add("/admin/processExecutor/toEdit.do");
        // list.add("/admin/processExecutor/add.do");
        list.add("/admin/processExecutor/edit.do");
        list.add("/admin/processExecutor/selectMember.do");
        //
        list.add("/processExecutor/listNextExecutors.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        // list.add("/admin/processExecutor/list.do");
        list.add("/admin/processExecutor/selectMember.do");
        list.add("/admin/processExecutor/edit.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/process/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/processExecutor/selectMember.do", list);
        map.put("/admin/processExecutor/edit.do", list);
        return map;
    }

    @Override
    public List<String> appUris() {

        List<String> list = new ArrayList<String>();
        list.add("/app/processExecutor/listNextExecutors.do");
        return list;
    }

    @Override
    public List<String> userUris() {

        List<String> list = new ArrayList<String>();
        list.add("/app/processExecutor/listNextExecutors.do");
        return list;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/processExecutor/listNextExecutors4Token.do");
        return list;
    }
}
