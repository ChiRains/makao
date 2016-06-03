package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class AbnormalUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
//        list.add("/abnormal/list.do");
        list.add("/abnormal/realTime.do");
        list.add("/abnormal/statisticRecord.do");
        list.add("/abnormal/statisticInRecord.do");
//        //
        list.add("/abnormal/imitate.do");
        list.add("/abnormal/ifReal.do");
        list.add("/abnormal/statisticToday.do");
        list.add("/abnormal/list4Deal.do");
        return list;
    }

    @Override
    public List<String> userUris() {

        List<String> list = new ArrayList<String>();
//        list.add("/abnormal/list.do");
//        list.add("/abnormal/realTime.do");
//        list.add("/abnormal/statisticRecord.do");
//        list.add("/abnormal/statisticInRecord.do");
//        //
//        list.add("/abnormal/imitate.do");
//        list.add("/abnormal/ifReal.do");
//        list.add("/abnormal/statisticToday.do");
        return list;
    }

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/abnormal/list.do");
        list.add("/abnormal/crossBorderRecord.do");
        list.add("/abnormal/realTimeWarning.do");
        list.add("/abnormal/crossBorderToday.do");
//        list.add("/abnormal/realTime.do");
//        list.add("/abnormal/statisticRecord.do");
//        list.add("/abnormal/statisticInRecord.do");
        //
//        list.add("/abnormal/imitate.do");
//        list.add("/abnormal/ifReal.do");
//        list.add("/abnormal/statisticToday.do");
        return list;
    }
    
    
    
    
    
    
}
