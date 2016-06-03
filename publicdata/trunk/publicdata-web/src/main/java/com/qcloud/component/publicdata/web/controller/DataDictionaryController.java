package com.qcloud.component.publicdata.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.publicdata.PublicdataClient;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = DataDictionaryController.DIR)
public class DataDictionaryController {

    public static final String DIR = "/dataDictionary";

    @Autowired
    private PublicdataClient   publicdataClient;

    @RequestMapping
    @NoReferer
    public FrontAjaxView listByType(String type) {

        List<KeyValueVO> list = publicdataClient.listDataDictionaryByType(type);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("dictionaryList", list);
        return view;
    }
    
}
