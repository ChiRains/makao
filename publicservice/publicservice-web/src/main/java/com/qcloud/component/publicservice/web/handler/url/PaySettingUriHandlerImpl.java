package com.qcloud.component.publicservice.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class PaySettingUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/paySetting/list.do");
        list.add("/admin/paySetting/wxEnable.do");
        list.add("/admin/paySetting/wxDisable.do");
        list.add("/admin/paySetting/alipayEnable.do");
        list.add("/admin/paySetting/alipayDisable.do");
        list.add("/admin/paySetting/unionEnable.do");
        list.add("/admin/paySetting/unionDisable.do");
        list.add("/admin/paySetting/update.do");
        list.add("/admin/paySetting/settingTime.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/paySetting/list.do");
        list.add("/admin/paySetting/wxEnable.do");
        list.add("/admin/paySetting/wxDisable.do");
        list.add("/admin/paySetting/alipayEnable.do");
        list.add("/admin/paySetting/alipayDisable.do");
        list.add("/admin/paySetting/unionEnable.do");
        list.add("/admin/paySetting/unionDisable.do");
        list.add("/admin/paySetting/update.do");
        list.add("/admin/paySetting/settingTime.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/paySetting/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/paySetting/wxDisable.do", list);
        map.put("/admin/paySetting/wxEnable.do", list);
        map.put("/admin/paySetting/alipayEnable.do", list);
        map.put("/admin/paySetting/alipayDisable.do", list);
        map.put("/admin/paySetting/unionEnable.do", list);
        map.put("/admin/paySetting/unionDisable.do", list);
        //
        map.put("/admin/paySetting/update.do", stringToList("/admin/paySetting/settingTime.do"));
        return map;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        return list;
    }
}
