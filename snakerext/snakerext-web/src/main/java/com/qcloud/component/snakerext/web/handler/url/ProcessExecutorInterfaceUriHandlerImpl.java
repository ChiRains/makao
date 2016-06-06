package com.qcloud.component.snakerext.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ProcessExecutorInterfaceUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/processExecutorInterface/list.do");
        list.add("/admin/processExecutorInterface/toAdd.do");
        list.add("/admin/processExecutorInterface/toEdit.do");
        list.add("/admin/processExecutorInterface/add.do");
        list.add("/admin/processExecutorInterface/edit.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/processExecutorInterface/list.do");
        list.add("/admin/processExecutorInterface/toAdd.do");
        list.add("/admin/processExecutorInterface/toEdit.do");
        list.add("/admin/processExecutorInterface/add.do");
        list.add("/admin/processExecutorInterface/edit.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/processExecutorInterface/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/processExecutorInterface/toAdd.do", list);
        map.put("/admin/processExecutorInterface/add.do", list);
        map.put("/admin/processExecutorInterface/toEdit.do", list);
        map.put("/admin/processExecutorInterface/edit.do", list);
        return map;
    }
}
