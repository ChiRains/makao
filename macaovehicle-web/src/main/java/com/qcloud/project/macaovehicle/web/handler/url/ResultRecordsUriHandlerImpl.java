package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ResultRecordsUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/record/add/");
        return list;
    }

    @Override
    public List<String> restfulUris() {

        List<String> list = new ArrayList<String>();
        list.add("/record/add/");
        return list;
    }
}
