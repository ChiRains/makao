package com.qcloud.component.piratesship.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class UrlUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/url/list.do");
        list.add("/url/index.do");
        list.add("/url/notconfiguredIndex.do");
        list.add("/url/query.do");
        return list;
    }
}
