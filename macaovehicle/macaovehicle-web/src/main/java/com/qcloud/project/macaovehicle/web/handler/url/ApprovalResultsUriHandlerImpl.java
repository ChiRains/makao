package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ApprovalResultsUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
//        list.add("/approvalResults/list.do");
//        list.add("/approvalResults/addResults.do");
//        //
//        list.add("/approvalResults/countryRecord.do");
//        list.add("/approvalResults/borderRecord.do");
//        list.add("/approvalResults/haikwanRecord.do");
//        list.add("/approvalResults/notThrough.do");
//        list.add("/approvalResults/bothThrough.do");
        return list;
    }

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/approvalResults/list.do");
        list.add("/approvalResults/list.do");
        list.add("/approvalResults/addResults.do");
        //
        list.add("/approvalResults/countryRecord.do");
        list.add("/approvalResults/borderRecord.do");
        list.add("/approvalResults/haikwanRecord.do");
        list.add("/approvalResults/notThrough.do");
        list.add("/approvalResults/bothThrough.do");
        return list;
    }
}
