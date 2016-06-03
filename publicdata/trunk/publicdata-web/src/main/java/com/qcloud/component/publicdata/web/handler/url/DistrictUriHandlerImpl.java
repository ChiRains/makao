package com.qcloud.component.publicdata.web.handler.url;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;
public class DistrictUriHandlerImpl extends AbstractUriHandler {
    @Override
    public List<String> adminUris() {
        List<String> list = new ArrayList<String>();
        list.add("/admin/district/list.do");
        list.add("/admin/district/toAdd.do");
        list.add("/admin/district/toEdit.do");
        list.add("/admin/district/add.do");
        list.add("/admin/district/edit.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {
        List<String> list = new ArrayList<String>();
        list.add("/admin/district/list.do");
        list.add("/admin/district/toAdd.do");
        list.add("/admin/district/toEdit.do");
        list.add("/admin/district/add.do");
        list.add("/admin/district/edit.do");
        return list;
    }
    
    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/district/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/district/toAdd.do", list);
        map.put("/admin/district/toEdit.do", list);
        map.put("/admin/district/add.do", list);
        map.put("/admin/district/edit.do", list);
        return map;
    }

    @Override
    public List<String> whiteNameUris() {
        List<String> list = new ArrayList<String>();
        list.add("/district/queryByCity.do");
        list.add("/district/listByCity.do");
        list.add("/district/listDistrictByCity.do");
        return list;
    }
}
