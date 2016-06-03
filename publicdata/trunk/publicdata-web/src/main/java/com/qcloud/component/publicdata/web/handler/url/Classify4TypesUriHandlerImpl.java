package com.qcloud.component.publicdata.web.handler.url;
import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;
public class Classify4TypesUriHandlerImpl extends AbstractUriHandler {
    @Override
    public List<String> adminUris() {
        List<String> list = new ArrayList<String>();
        list.add("/admin/classify4Types/list.do");
        list.add("/admin/classify4Types/listForMerchant.do");
        list.add("/admin/classify4Types/toAdd.do");
        list.add("/admin/classify4Types/toEdit.do");
        list.add("/admin/classify4Types/add.do");
        list.add("/admin/classify4Types/edit.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {
        List<String> list = new ArrayList<String>();
//        list.add("/admin/classify4Types/list.do");
//        list.add("/admin/classify4Types/listForMerchant.do");
        return list;
    }
}
