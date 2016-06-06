package com.qcloud.component.form.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class FormTableMappingUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        // list.add("/admin/formTableMapping/list.do");
        // list.add("/admin/formTableMapping/toAdd.do");
        list.add("/admin/formTableMapping/toEdit.do");
        // list.add("/admin/formTableMapping/add.do");
        list.add("/admin/formTableMapping/edit.do");
        list.add("/admin/formTableMapping/toChildrenEdit.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        // list.add("/admin/formTableMapping/list.do");
        // list.add("/admin/formTableMapping/toAdd.do");
        list.add("/admin/formTableMapping/toEdit.do");
        // list.add("/admin/formTableMapping/add.do");
        list.add("/admin/formTableMapping/edit.do");
        list.add("/admin/formTableMapping/toChildrenEdit.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/formDef/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/formTableMapping/toEdit.do", list);
        map.put("/admin/formTableMapping/edit.do", list);
        map.put("/admin/formTableMapping/toChildrenEdit.do", list);
        return map;
    }
}
