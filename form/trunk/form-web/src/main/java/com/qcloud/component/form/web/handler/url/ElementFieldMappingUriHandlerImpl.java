package com.qcloud.component.form.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ElementFieldMappingUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/elementFieldMapping/list.do");
        list.add("/admin/elementFieldMapping/toAdd.do");
        list.add("/admin/elementFieldMapping/toEdit.do");
        list.add("/admin/elementFieldMapping/add.do");
        list.add("/admin/elementFieldMapping/edit.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/elementFieldMapping/list.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return map;
    }
}
