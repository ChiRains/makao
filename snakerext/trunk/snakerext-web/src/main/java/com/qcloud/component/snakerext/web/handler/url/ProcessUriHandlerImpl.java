package com.qcloud.component.snakerext.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ProcessUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/process/list.do");
        list.add("/admin/process/toAdd.do");
        list.add("/admin/process/toEdit.do");
        list.add("/admin/process/add.do");
        list.add("/admin/process/edit.do");
        list.add("/admin/process/delete.do");
        list.add("/admin/process/enable.do");
        list.add("/admin/process/start.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/process/list.do");
        list.add("/admin/process/toAdd.do");
        list.add("/admin/process/toEdit.do");
        list.add("/admin/process/add.do");
        list.add("/admin/process/edit.do");
        list.add("/admin/process/delete.do");
        list.add("/admin/process/enable.do");
        list.add("/admin/process/start.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/process/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/process/toAdd.do", list);
        map.put("/admin/process/add.do", list);
        return map;
    }
}
