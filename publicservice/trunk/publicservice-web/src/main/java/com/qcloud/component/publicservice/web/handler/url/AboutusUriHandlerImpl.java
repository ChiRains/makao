package com.qcloud.component.publicservice.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class AboutusUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/aboutusConfig/getAboutusConfig.do");
        list.add("/admin/aboutusConfig/setAboutusConfig.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/aboutusConfig/getAboutusConfig.do");
        list.add("/admin/aboutusConfig/setAboutusConfig.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/aboutusConfig/setAboutusConfig.do", stringToList("/admin/aboutusConfig/getAboutusConfig.do"));
        return map;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/aboutusConfig/getAboutus.do");
        list.add("/aboutusConfig/getHtmlAboutus.do");
        return list;
    }
}
