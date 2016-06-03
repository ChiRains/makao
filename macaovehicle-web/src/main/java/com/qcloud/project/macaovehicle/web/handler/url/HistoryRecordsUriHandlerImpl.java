package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class HistoryRecordsUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/historyRecords/list.do");
        list.add("/admin/historyRecords/toAdd.do");
        list.add("/admin/historyRecords/toEdit.do");
        list.add("/admin/historyRecords/add.do");
        list.add("/admin/historyRecords/edit.do");
        list.add("/historyRecords/add.do");
        list.add("/historyRecords/list.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/historyRecords/list.do");
        return list;
    }
}
