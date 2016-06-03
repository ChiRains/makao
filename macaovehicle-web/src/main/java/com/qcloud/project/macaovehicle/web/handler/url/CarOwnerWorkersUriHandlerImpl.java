package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class CarOwnerWorkersUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
//        list.add("/carOwnerWorkers/add.do");
//        list.add("/carOwnerWorkers/edit.do");
//        list.add("/carOwnerWorkers/get.do");
        return list;
    }

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/carOwnerWorkers/add.do");
        list.add("/carOwnerWorkers/edit.do");
        list.add("/carOwnerWorkers/get.do");
        return list;
    }
    
    
}
