package com.qcloud.component.publicdata.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ExpressUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/express/list.do");
        list.add("/admin/express/toAdd.do");
        list.add("/admin/express/toEdit.do");
        list.add("/admin/express/add.do");
        list.add("/admin/express/edit.do");
        list.add("/admin/express/provinceList.do");
        list.add("/admin/express/cityList.do");
        list.add("/admin/express/toList.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/express/list.do");
        list.add("/admin/express/toAdd.do");
        list.add("/admin/express/toEdit.do");
        list.add("/admin/express/add.do");
        list.add("/admin/express/edit.do");
        list.add("/admin/express/provinceList.do");
        list.add("/admin/express/cityList.do");
        list.add("/admin/express/toList.do");
        return list;
    }
    
    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/express/list.do");
        //
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/express/toAdd.do", list);
        map.put("/admin/express/toEdit.do", list);
        map.put("/admin/express/add.do", list);
        map.put("/admin/express/edit.do", list);
        //
        return map;
    }
}
