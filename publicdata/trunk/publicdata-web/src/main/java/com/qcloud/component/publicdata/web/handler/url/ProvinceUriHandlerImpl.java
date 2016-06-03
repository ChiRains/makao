package com.qcloud.component.publicdata.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ProvinceUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/province/list.do");
        list.add("/admin/province/toAdd.do");
        list.add("/admin/province/toEdit.do");
        list.add("/admin/province/add.do");
        list.add("/admin/province/edit.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/province/list.do");
        list.add("/admin/province/toAdd.do");
        list.add("/admin/province/toEdit.do");
        list.add("/admin/province/add.do");
        list.add("/admin/province/edit.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/province/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/province/toAdd.do", list);
        map.put("/admin/province/toEdit.do", list);
        map.put("/admin/province/add.do", list);
        map.put("/admin/province/edit.do", list);
        return map;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/province/list.do");
        list.add("/province/listProvince.do");
        list.add("/province/listAddress3grade.do");
        return list;
    }
}
