package com.qcloud.component.snakerext.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class TaskFormAccessUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/taskFormAccess/list.do");
        list.add("/admin/taskFormAccess/toAdd.do");
        list.add("/admin/taskFormAccess/toEdit.do");
        list.add("/admin/taskFormAccess/add.do");
        list.add("/admin/taskFormAccess/edit.do");
        list.add("/admin/taskFormAccess/selectElement.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/taskFormAccess/list.do");
        list.add("/admin/taskFormAccess/selectElement.do");
        list.add("/admin/taskFormAccess/edit.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/process/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/taskFormAccess/list.do", list);
        map.put("/admin/taskFormAccess/selectElement.do", list);
        map.put("/admin/taskFormAccess/edit.do", list);
        return map;
    }
}
