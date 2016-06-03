package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class CarOwnerEnterprisersUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
//        list.add("/carOwnerEnterprisers/add.do");
//        list.add("/carOwnerEnterprisers/edit.do");
//        list.add("/carOwnerEnterprisers/get.do");
        return list;
    }

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/carOwnerEnterprisers/add.do");
        list.add("/carOwnerEnterprisers/edit.do");
        list.add("/carOwnerEnterprisers/get.do");
        return list;
    }
}
