package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class MacaoUserUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/macaoUser/login.do");
        list.add("/macaoUser/register.do");
        list.add("/macaoMail/sendMail.do");
        list.add("/macaoMail/sendMail4Reset.do");
        //
        list.add("/macaoUser/reset.do");
        list.add("/macaoUser/logout.do");
        return list;
    }

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/macaoUser/edit.do");
        list.add("/macaoUser/uploadHeadImage.do");
        list.add("/macaoUser/listDepartment.do");
        return list;
    }
}
