package com.qcloud.component.publicdata.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class CityUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/city/list.do");
        list.add("/admin/city/toAdd.do");
        list.add("/admin/city/toEdit.do");
        list.add("/admin/city/add.do");
        list.add("/admin/city/edit.do");
        list.add("/admin/city/queryByProvince.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/city/list.do");
        list.add("/admin/city/toAdd.do");
        list.add("/admin/city/toEdit.do");
        list.add("/admin/city/add.do");
        list.add("/admin/city/edit.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/city/list.do");
        //
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/city/toAdd.do", list);
        map.put("/admin/city/toEdit.do", list);
        map.put("/admin/city/add.do", list);
        map.put("/admin/city/edit.do", list);
        //
        return map;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/city/queryByProvince.do");
        list.add("/city/listByProvince.do");
        list.add("/city/listCityByProvince.do");
        return list;
    }
}
