package com.qcloud.component.processtask.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class TaskingUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/tasking/list.do");
        list.add("/tasking/listMyApplying.do");
        list.add("/tasking/listMyApproving.do");
        list.add("/tasking/delete.do");
        list.add("/tasking/getNextExecutor.do");
        return list;
    }

    @Override
    public List<String> appUris() {

        List<String> list = new ArrayList<String>();
        list.add("/app/tasking/list.do");
        list.add("/app/tasking/listMyApplying.do");
        list.add("/app/tasking/listMyApproving.do");
        return list;
    }

    @Override
    public List<String> userUris() {

        List<String> list = new ArrayList<String>();
        list.add("/app/tasking/list.do");
        list.add("/app/tasking/listMyApplying.do");
        list.add("/app/tasking/listMyApproving.do");
        return list;
    }
}
