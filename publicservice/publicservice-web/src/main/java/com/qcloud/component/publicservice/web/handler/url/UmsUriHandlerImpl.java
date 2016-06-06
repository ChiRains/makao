package com.qcloud.component.publicservice.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class UmsUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/umsConfig/getUmsConfig.do");
        list.add("/admin/umsConfig/setUmsConfig.do");
        list.add("/admin/umsConfig/testUmsConfig.do");
        list.add("/admin/umsConfig/toTest.do");
        list.add("/admin/umsConfig/list.do");
        list.add("/admin/umsConfig/save.do");
        list.add("/admin/umsConfig/test.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/umsConfig/getUmsConfig.do");
        list.add("/admin/umsConfig/setUmsConfig.do");
        list.add("/admin/umsConfig/testUmsConfig.do");
        list.add("/admin/umsConfig/toTest.do");
        list.add("/admin/umsConfig/list.do");
        list.add("/admin/umsConfig/save.do");
        list.add("/admin/umsConfig/test.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/umsConfig/getUmsConfig.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/umsConfig/setUmsConfig.do", list);
        map.put("/admin/umsConfig/testUmsConfig.do", list);
        map.put("/admin/umsConfig/toTest.do", list);
        map.put("/admin/umsConfig/list.do", list);
        map.put("/admin/umsConfig/save.do", list);
        map.put("/admin/umsConfig/test.do", list);
        return map;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        return list;
    }
}
