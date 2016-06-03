package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class AbnormalRecordUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/abnormalRecord/list4Deal.do");
        return list;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/abnormalRecord/add/");
        return list;
    }

    @Override
    public List<String> restfulUris() {

        List<String> list = new ArrayList<String>();
        list.add("/abnormalRecord/add/");
        return list;
    }
}
