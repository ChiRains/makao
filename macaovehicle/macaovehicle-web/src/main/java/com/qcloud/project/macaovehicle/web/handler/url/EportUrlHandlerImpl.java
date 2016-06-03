package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class EportUrlHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/eport/eportTest/");
        list.add("/eport/borderPost.do");
        list.add("/eport/ciqPost.do");
        list.add("/eport/checkXmlReceive.do");
        list.add("/eport/cipXmlReceive.do");
        list.add("/eport/customsXmlReceive.do");
        return list;
    }

    @Override
    public List<String> restfulUris() {

        List<String> list = new ArrayList<String>();
        list.add("/eport/eportTest/");
        list.add("/eport/checkXmlReceive.do");
        list.add("/eport/cipXmlReceive.do");
        list.add("/eport/customsXmlReceive.do");
        return list;
    }
}
