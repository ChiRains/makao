package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class CarOwnerPurchaseUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
//        list.add("/carOwnerPurchase/add.do");
//        list.add("/carOwnerPurchase/edit.do");
//        list.add("/carOwnerPurchase/get.do");
        return list;
    }

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/carOwnerPurchase/add.do");
        list.add("/carOwnerPurchase/edit.do");
        list.add("/carOwnerPurchase/get.do");
        return list;
    }
    
    
}
