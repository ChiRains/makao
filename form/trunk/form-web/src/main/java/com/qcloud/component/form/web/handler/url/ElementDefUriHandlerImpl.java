package com.qcloud.component.form.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ElementDefUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/elementDef/list.do");
        list.add("/admin/elementDef/toAdd.do");
        list.add("/admin/elementDef/toEdit.do");
        list.add("/admin/elementDef/add.do");
        list.add("/admin/elementDef/edit.do");
        list.add("/admin/elementDef/delete.do");
        list.add("/admin/elementDef/childrenList.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/elementDef/list.do");
        list.add("/admin/elementDef/toAdd.do");
        list.add("/admin/elementDef/toEdit.do");
        list.add("/admin/elementDef/add.do");
        list.add("/admin/elementDef/edit.do");
        list.add("/admin/elementDef/delete.do");
        list.add("/admin/elementDef/childrenList.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/formDef/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/elementDef/list.do", list);
        map.put("/admin/elementDef/toAdd.do", list);
        map.put("/admin/elementDef/add.do", list);
        map.put("/admin/elementDef/toEdit.do", list);
        map.put("/admin/elementDef/edit.do", list);
        //
        map.put("/admin/elementDef/childrenList.do", list);
        return map;
    }
}
