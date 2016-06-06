package com.qcloud.component.publicservice.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class WeiXinUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/weixinConfig/setWeiXinConfig.do");
        list.add("/admin/weixinConfig/getWeiXinConfig.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/weixinConfig/setWeiXinConfig.do");
        list.add("/admin/weixinConfig/getWeiXinConfig.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/weixinConfig/getWeiXinConfig.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/weixinConfig/setWeiXinConfig.do", list);
        return map;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/weixinConfig/getAuthorizeUrl.do");
        list.add("/weixinConfig/getJSSDKConfig.do");
        list.add("/weixinConfig/addWeixinImage.do");
        list.add("/weixinConfig/isSubscribe.do");
        list.add("/weixinConfig/getCodeUrl.do");
        list.add("/weixinConfig/loadOpenId.do");
        return list;
    }
}
