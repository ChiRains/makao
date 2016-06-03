package com.qcloud.component.publicservice.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class DistanceUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/distanceConfig/getDistanceConfig.do");
        list.add("/admin/distanceConfig/setDistanceConfig.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/distanceConfig/getDistanceConfig.do");
        list.add("/admin/distanceConfig/setDistanceConfig.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/distanceConfig/getDistanceConfig.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/distanceConfig/setDistanceConfig.do", list);
        return map;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/distanceConfig/list.do");
        return list;
    }
}
