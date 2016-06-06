package com.qcloud.component.publicdata.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ImageInformationUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/imageInformation/list.do");
        list.add("/admin/imageInformation/toEdit.do");
        list.add("/admin/imageInformation/edit.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/imageInformation/list.do");
        //
        list.add("/admin/imageInformation/toEdit.do");
        list.add("/admin/imageInformation/edit.do");
        return list;
    }
    
    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/imageInformation/list.do");
        //
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/imageInformation/toEdit.do", list);
        map.put("/admin/imageInformation/edit.do", list);
        //
        return map;
    }
}
