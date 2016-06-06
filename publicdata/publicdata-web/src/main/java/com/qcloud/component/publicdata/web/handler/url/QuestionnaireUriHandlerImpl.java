package com.qcloud.component.publicdata.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class QuestionnaireUriHandlerImpl extends AbstractUriHandler {

     @Override
     public List<String> adminUris() {
    
     List<String> list = new ArrayList<String>();
     list.add("/admin/questionnaire/list.do");
     list.add("/admin/questionnaire/toAdd.do");
     list.add("/admin/questionnaire/toEdit.do");
     list.add("/admin/questionnaire/add.do");
     list.add("/admin/questionnaire/edit.do");
     return list;
     }
    //
    // @Override
    // public List<String> permissionUris() {
    //
    // List<String> list = new ArrayList<String>();
    // list.add("/admin/questionnaire/list.do");
    // return list;
    // }
    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/questionnaire/get.do");
        list.add("/questionnaire/getFeedback.do");
        return list;
    }
}
