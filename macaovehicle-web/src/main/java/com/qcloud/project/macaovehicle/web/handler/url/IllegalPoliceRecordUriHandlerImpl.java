package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class IllegalPoliceRecordUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/illegalPoliceRecord/list.do");
        list.add("/admin/illegalPoliceRecord/toAdd.do");
        list.add("/admin/illegalPoliceRecord/toEdit.do");
        list.add("/admin/illegalPoliceRecord/add.do");
        list.add("/admin/illegalPoliceRecord/edit.do");
        list.add("/illegalPoliceRecord/add.do");
        list.add("/illegalPoliceRecord/list.do");
        list.add("/illegalPoliceRecord/listCarOwner.do");
        list.add("/illegalPoliceRecord/get.do");
        list.add("/illegalPoliceRecord/update.do");
        list.add("/illegalPoliceRecord/delete.do");
        
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/illegalPoliceRecord/list.do");
        return list;
    }
}
