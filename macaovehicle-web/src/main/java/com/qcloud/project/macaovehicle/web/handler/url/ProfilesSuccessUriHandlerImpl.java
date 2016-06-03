package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ProfilesSuccessUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/profilesSuccess/list.do");
        list.add("/admin/profilesSuccess/toAdd.do");
        list.add("/admin/profilesSuccess/toEdit.do");
        list.add("/admin/profilesSuccess/add.do");
        list.add("/admin/profilesSuccess/edit.do");
        list.add("/profilesSuccess/listDriver.do");
        list.add("/profilesSuccess/getDriver.do");
        list.add("/profilesSuccess/listVehicle.do");
        list.add("/profilesSuccess/listCarOwner.do");
        list.add("/profilesSuccess/getAvailCar.do");
        list.add("/profilesSuccess/listEntryVehicle.do");
        list.add("/profilesSuccess/getEntryVehicle.do");
        list.add("/profilesSuccess/listEntryDriver.do");
        list.add("/profilesSuccess/getEntryDriver.do");
        list.add("/profilesSuccess/listEntry4CarOwner.do");
        list.add("/profilesSuccess/unbindDriver.do");
        return list;
    }
}
