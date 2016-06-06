package com.qcloud.component.form.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class FormUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> userUris() {

        List<String> list = new ArrayList<String>();
        list.add("/app/form/save.do");
        list.add("/app/form/submit.do");
        list.add("/app/form/get.do");
        list.add("/app/form/getInFlat.do");
        list.add("/app/form/getHist.do");
        list.add("/app/form/getHistInFlat.do");
        list.add("/app/form/getHtmlSaveToken.do");
        return list;
    }

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/form/save.do");
        list.add("/form/submit.do");
        list.add("/form/get.do");
        list.add("/form/getInFlat.do");
        list.add("/form/getHist.do");
        list.add("/form/getHistInFlat.do");
        return list;
    }

    @Override
    public List<String> appUris() {

        List<String> list = new ArrayList<String>();
        list.add("/app/form/save.do");
        list.add("/app/form/submit.do");
        list.add("/app/form/get.do");
        list.add("/app/form/getInFlat.do");
        list.add("/app/form/getHist.do");
        list.add("/app/form/getHistInFlat.do");
        list.add("/app/form/getHtmlSaveToken.do");
        return list;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/form/save4Token.do");
        list.add("/form/submit4Token.do");
        //
        list.add("/form/get4Token.do");
        list.add("/form/getInFlat4Token.do");
        list.add("/form/getHist4Token.do");
        list.add("/form/getHistInFlat4Token.do");
        //
        return list;
    }
}
