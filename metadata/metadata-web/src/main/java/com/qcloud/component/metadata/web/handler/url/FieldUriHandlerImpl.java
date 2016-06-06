package com.qcloud.component.metadata.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class FieldUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/field/list.do");
        list.add("/admin/field/toAdd.do");
        list.add("/admin/field/toEdit.do");
        list.add("/admin/field/add.do");
        list.add("/admin/field/edit.do");
        list.add("/admin/field/delete.do");
        list.add("/admin/field/downloadFile.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/field/list.do");
        list.add("/admin/field/toAdd.do");
        list.add("/admin/field/toEdit.do");
        list.add("/admin/field/add.do");
        list.add("/admin/field/edit.do");
        list.add("/admin/field/delete.do");
        list.add("/admin/field/downloadFile.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/table/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/field/list.do", list);
        map.put("/admin/field/toAdd.do", list);
        map.put("/admin/field/toEdit.do", list);
        map.put("/admin/field/add.do", list);
        map.put("/admin/field/edit.do", list);
        map.put("/admin/field/delete.do", list);
        map.put("/admin/field/downloadFile.do", list);
        return map;
    }
}
