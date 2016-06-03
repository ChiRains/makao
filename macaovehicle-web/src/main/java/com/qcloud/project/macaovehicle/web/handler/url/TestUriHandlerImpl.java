package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class TestUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/test/applyVehicleNumber.do");
        list.add("/test/bookingOnSuccessKeepOnRecord.do");
        list.add("/test/noticeOnFailureKeepOnRecord.do");
        list.add("/test/downloadFile.do");
        list.add("/test/test.do");
        list.add("/test/borderPost.do");
        list.add("/test/ciqPost.do");
        list.add("/test/customsPost.do");
        list.add("/test/sendDriverCard.do");
        list.add("/test/sendCarCard.do");
        return list;
    }
}
