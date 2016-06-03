package com.qcloud.project.macaovehicle.web.view;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeServiceResponse {

    private Integer errcode;

    private String  errmsg;

    public EmployeeServiceResponse() {

    }

    public EmployeeServiceResponse(Integer errcode, String errmsg) {

        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public Integer getErrcode() {

        return errcode;
    }

    public void setErrcode(Integer errcode) {

        this.errcode = errcode;
    }

    public String getErrmsg() {

        return errmsg;
    }

    public void setErrmsg(String errmsg) {

        this.errmsg = errmsg;
    }
}
