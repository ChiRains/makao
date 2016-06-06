package com.qcloud.component.metadata.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class TableUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/table/list.do");
        list.add("/admin/table/toAdd.do");
        list.add("/admin/table/toEdit.do");
        list.add("/admin/table/add.do");
        list.add("/admin/table/edit.do");
        list.add("/admin/table/delete.do");
        list.add("/admin/table/initBackup.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/table/list.do");
        list.add("/admin/table/toAdd.do");
        list.add("/admin/table/toEdit.do");
        list.add("/admin/table/add.do");
        list.add("/admin/table/edit.do");
        list.add("/admin/table/delete.do");
        list.add("/admin/table/initBackup.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/table/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/table/toAdd.do", list);
        map.put("/admin/table/toEdit.do", list);
        map.put("/admin/table/add.do", list);
        map.put("/admin/table/edit.do", list);
        map.put("/admin/table/delete.do", list);
        map.put("/admin/table/initBackup.do", list);
        return map;
    }
}
