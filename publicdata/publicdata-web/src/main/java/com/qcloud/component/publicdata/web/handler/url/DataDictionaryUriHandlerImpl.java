package com.qcloud.component.publicdata.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class DataDictionaryUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/dataDictionary/list.do");
        list.add("/admin/dataDictionary/toAdd.do");
        list.add("/admin/dataDictionary/toEdit.do");
        list.add("/admin/dataDictionary/add.do");
        list.add("/admin/dataDictionary/edit.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/dataDictionary/list.do");
        //
        list.add("/admin/dataDictionary/toAdd.do");
        list.add("/admin/dataDictionary/toEdit.do");
        list.add("/admin/dataDictionary/add.do");
        list.add("/admin/dataDictionary/edit.do");
        //
        return list;
    }
    
    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/dataDictionary/list.do");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/dataDictionary/toAdd.do", list);
        map.put("/admin/dataDictionary/toEdit.do", list);
        map.put("/admin/dataDictionary/add.do", list);
        map.put("/admin/dataDictionary/edit.do", list);
        return map;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/dataDictionary/listByType.do");
        return list;
    }
}
