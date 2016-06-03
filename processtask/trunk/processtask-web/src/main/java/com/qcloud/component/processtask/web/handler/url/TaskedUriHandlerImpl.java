package com.qcloud.component.processtask.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class TaskedUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/tasked/list.do");
        list.add("/tasked/listMyApplyedApproving.do");
        list.add("/tasked/listMyApplyedApproved.do");
        list.add("/tasked/listMyApproved.do");
        return list;
    }

    @Override
    public List<String> appUris() {

        List<String> list = new ArrayList<String>();
        list.add("/app/tasked/list.do");
        list.add("/app/tasked/listMyApplyedApproving.do");
        list.add("/app/tasked/listMyApplyedApproved.do");
        list.add("/app/tasked/listMyApproved.do");
        return list;
    }

    @Override
    public List<String> userUris() {

        List<String> list = new ArrayList<String>();
        list.add("/app/tasked/list.do");
        list.add("/app/tasked/listMyApplyedApproving.do");
        list.add("/app/tasked/listMyApplyedApproved.do");
        list.add("/app/tasked/listMyApproved.do");
        return list;
    }
}
