package com.qcloud.component.publicdata.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ClassifyUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/classify/list.do");
        list.add("/admin/classify/toAdd.do");
        list.add("/admin/classify/toEdit.do");
        list.add("/admin/classify/add.do");
        list.add("/admin/classify/edit.do");
        list.add("/admin/classify/listByType.do");
        list.add("/admin/classify/listByTypes.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/classify/list.do");
        list.add("/admin/classify/listByType.do");
        list.add("/admin/classify/listByTypes.do");
        return list;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/classify/listByType.do");
        list.add("/classify/listTopByType.do");
        list.add("/classify/listByParentAndType.do");
        list.add("/classify/listToTopAncestor.do");
        return list;
    }
}
