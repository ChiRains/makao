package com.qcloud.component.piratesship.web.vo.admin;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.core.urlXml.UrlField;

public class UrlDescVO {

    private String         name;
    
    private String         url;

//    private List<UrlField> requestList = new ArrayList<UrlField>();

    private String         requestStr;

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    
    public String getRequestStr() {
    
        return requestStr;
    }

    
    public void setRequestStr(String requestStr) {
    
        this.requestStr = requestStr;
    }
}
