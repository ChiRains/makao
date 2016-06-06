package com.qcloud.component.form.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class Organization4FormUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/org4form/getClerk.do");
        list.add("/org4form/clerkKeyValue.do");
        list.add("/org4form/listPost.do");
        list.add("/org4form/listDepartment.do");
        //
        return list;
    }
}
