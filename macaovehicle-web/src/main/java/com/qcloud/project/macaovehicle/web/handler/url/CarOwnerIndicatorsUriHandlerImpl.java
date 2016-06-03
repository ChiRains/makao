package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class CarOwnerIndicatorsUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/carOwnerIndicators/list.do");
        list.add("/admin/carOwnerIndicators/toAdd.do");
        list.add("/admin/carOwnerIndicators/toEdit.do");
        list.add("/admin/carOwnerIndicators/add.do");
        list.add("/admin/carOwnerIndicators/edit.do");
        list.add("/carOwnerIndicators/add.do");
        list.add("/carOwnerIndicators/get.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/carOwnerIndicators/list.do");
        return list;
    }
}
