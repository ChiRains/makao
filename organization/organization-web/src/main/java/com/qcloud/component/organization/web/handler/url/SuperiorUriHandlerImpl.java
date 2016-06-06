package com.qcloud.component.organization.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class SuperiorUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/superior/list.do");
        list.add("/admin/superior/toAdd.do");
        list.add("/admin/superior/toEdit.do");
        list.add("/admin/superior/add.do");
        list.add("/admin/superior/edit.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/superior/list.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return map;
    }
}
