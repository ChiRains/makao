package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class TaskingBorderUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/taskingBorder/list.do");
        list.add("/admin/taskingBorder/toAdd.do");
        list.add("/admin/taskingBorder/toEdit.do");
        list.add("/admin/taskingBorder/add.do");
        list.add("/admin/taskingBorder/edit.do");
        list.add("/taskingBorder/list.do");
        list.add("/taskingBorder/listed.do");
        list.add("/taskingBorder/doTasking.do");
        list.add("/taskingBorder/get.do");
        list.add("/taskingBorder/markTasking.do");
        list.add("/taskingBorder/exportVehicle.do");
        list.add("/taskingBorder/exportDriver.do");
        list.add("/taskingBorder/exportEnterprise.do");
        list.add("/taskingBorder/exportDriverVehicle.do");
        list.add("/taskingBorder/exportFile.do");
        list.add("/taskingBorder/downloadImage.do");
        return list;
    }
}
