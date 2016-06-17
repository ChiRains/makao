package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class HistoryUserRecordsUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/historyUserRecords/list.do");
        list.add("/admin/historyUserRecords/toAdd.do");
        list.add("/admin/historyUserRecords/toEdit.do");
        list.add("/admin/historyUserRecords/add.do");
        list.add("/admin/historyUserRecords/edit.do");
        list.add("/historyUserRecords/list.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/historyUserRecords/list.do");
        return list;
    }
}
