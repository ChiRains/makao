package com.qcloud.component.organization.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ContactsUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

         List<String> list = new ArrayList<String>();
        // list.add("/contacts/list.do");
        // list.add("/contacts/export.do");
        // list.add("/contacts/departmentKeyValue.do");
        // list.add("/app/contacts/departmentKeyValue.do");
        // list.add("/app/contacts/list.do");
         return list;
    }

    @Override
    public Map<String, List<String>> permissionRelaMap() {

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return map;
    }

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/contacts/list.do");
        list.add("/contacts/export.do");
        list.add("/contacts/departmentKeyValue.do");
        return list;
    }

    @Override
    public List<String> appUris() {

        List<String> list = new ArrayList<String>();
        list.add("/app/contacts/list.do");
        list.add("/app/contacts/departmentKeyValue.do");
        return list;
    }

    @Override
    public List<String> userUris() {

        List<String> list = new ArrayList<String>();
        list.add("/app/contacts/list.do");
        list.add("/app/contacts/departmentKeyValue.do");
        return list;
    }
}
