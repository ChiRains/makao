package com.qcloud.component.snakerext.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ProcessFormUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/processForm/selectForm.do");
        list.add("/admin/processForm/editForm.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/processForm/selectForm.do");
        list.add("/admin/processForm/editForm.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/process/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/processForm/selectForm.do", list);
        map.put("/admin/processForm/editForm.do", list);
        return map;
    }
}
