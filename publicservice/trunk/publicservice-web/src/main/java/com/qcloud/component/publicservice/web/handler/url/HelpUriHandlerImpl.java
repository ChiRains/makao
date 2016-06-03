package com.qcloud.component.publicservice.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class HelpUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/helpConfig/getHelpConfig.do");
        list.add("/admin/helpConfig/setHelpConfig.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/helpConfig/getHelpConfig.do");
        list.add("/admin/helpConfig/setHelpConfig.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/helpConfig/setHelpConfig.do", stringToList("/admin/helpConfig/getHelpConfig.do"));
        return map;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/helpConfig/getHtmlHelp.do");
        list.add("/helpConfig/getHelp.do");
        return list;
    }
}
