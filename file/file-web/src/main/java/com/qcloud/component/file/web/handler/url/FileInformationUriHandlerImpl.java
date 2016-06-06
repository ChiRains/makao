package com.qcloud.component.file.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class FileInformationUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/fileInformation/list.do");
        list.add("/admin/fileInformation/toEdit.do");
        list.add("/admin/fileInformation/edit.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/fileInformation/list.do");
        list.add("/admin/fileInformation/toEdit.do");
        list.add("/admin/fileInformation/edit.do");
        return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        List<String> list = stringToList("/admin/fileInformation/list.do");
        //
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("/admin/fileInformation/toEdit.do", list);
        map.put("/admin/fileInformation/edit.do", list);
        //
        return map;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/fileInformation/get.do");
        return list;
    }
}
