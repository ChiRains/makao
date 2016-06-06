package com.qcloud.component.form.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class FormDefUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/formDef/list.do");
        list.add("/admin/formDef/toAdd.do");
        list.add("/admin/formDef/toEdit.do");
        list.add("/admin/formDef/add.do");
        list.add("/admin/formDef/edit.do");
        list.add("/admin/formDef/delete.do");
        list.add("/admin/formDef/childrenList.do");
        list.add("/admin/formDef/childrenAdd.do");
        list.add("/admin/formDef/toChildrenAdd.do");
        list.add("/admin/formDef/childrenEdit.do");
        list.add("/admin/formDef/childrenToEdit.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/formDef/list.do");
        list.add("/admin/formDef/toAdd.do");
        list.add("/admin/formDef/toEdit.do");
        list.add("/admin/formDef/add.do");
        list.add("/admin/formDef/edit.do");
        list.add("/admin/formDef/delete.do");
        list.add("/admin/formDef/childrenList.do");
        list.add("/admin/formDef/childrenAdd.do");
        list.add("/admin/formDef/toChildrenAdd.do");
        list.add("/admin/formDef/childrenEdit.do");
        list.add("/admin/formDef/childrenToEdit.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/formDef/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/formDef/toAdd.do", list);
        map.put("/admin/formDef/add.do", list);
        map.put("/admin/formDef/toEdit.do", list);
        map.put("/admin/formDef/edit.do", list);
        map.put("/admin/formDef/childrenList.do", list);
        map.put("/admin/formDef/toChildrenAdd.do", list);
        map.put("/admin/formDef/childrenAdd.do", list);
        map.put("/admin/formDef/childrenToEdit.do", list);
        map.put("/admin/formDef/childrenEdit.do", list);
        return map;
    }
}
