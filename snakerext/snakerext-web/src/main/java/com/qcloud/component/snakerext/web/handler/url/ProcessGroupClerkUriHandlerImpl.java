package com.qcloud.component.snakerext.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ProcessGroupClerkUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/processGroupClerk/list.do");
        list.add("/admin/processGroupClerk/toAdd.do");
        list.add("/admin/processGroupClerk/toEdit.do");
        list.add("/admin/processGroupClerk/add.do");
        list.add("/admin/processGroupClerk/edit.do");
        list.add("/admin/processGroupClerk/selectClerk.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        // list.add("/admin/processGroupClerk/list.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/process/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/process/toAdd.do", list);
        return map;
    }
}
