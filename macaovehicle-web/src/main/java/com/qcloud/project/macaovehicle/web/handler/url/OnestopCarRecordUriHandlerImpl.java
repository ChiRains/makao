package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class OnestopCarRecordUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/onestopCarRecord/list.do");
        list.add("/admin/onestopCarRecord/toAdd.do");
        list.add("/admin/onestopCarRecord/toEdit.do");
        list.add("/admin/onestopCarRecord/add.do");
        list.add("/admin/onestopCarRecord/edit.do");
        list.add("/onestopCarRecord/list.do");
        list.add("/onestopCarRecord/listEntry.do");
        list.add("/onestopCarRecord/countAll.do");
        list.add("/onestopCarRecord/realList.do");
        list.add("/onestopCarRecord/listRecord.do");
        return list;
    }
}
