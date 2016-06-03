package com.qcloud.component.publicservice.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ProtocolUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/protocolConfig/getProtocolConfig.do");
        list.add("/admin/protocolConfig/setProtocolConfig.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/protocolConfig/getProtocolConfig.do");
        list.add("/admin/protocolConfig/setProtocolConfig.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/protocolConfig/setProtocolConfig.do", stringToList("/admin/protocolConfig/getProtocolConfig.do"));
        return map;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/protocolConfig/getHtmlProtocol.do");
        list.add("/protocolConfig/getProtocol.do");
        return list;
    }
}
