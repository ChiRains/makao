package com.qcloud.project.macaovehicle.model.query;

import java.util.Date;

public class DriverCancelQuery {

    // 表单编码(不涉及流程)
    private String formInstCode;

    // 证件号码
    private String certificateNo;

    // 搜索申请时间
    private Date   applyTimeFront;

    // 搜索申请时间
    private Date   applyTimeBack;

    public DriverCancelQuery() {

    }

    public String getFormInstCode() {

        return formInstCode;
    }

    public String getCertificateNo() {

        return certificateNo;
    }

    public Date getApplyTimeFront() {

        return applyTimeFront;
    }

    public Date getApplyTimeBack() {

        return applyTimeBack;
    }

    public void setFormInstCode(String formInstCode) {

        this.formInstCode = formInstCode;
    }

    public void setCertificateNo(String certificateNo) {

        this.certificateNo = certificateNo;
    }

    public void setApplyTimeFront(Date applyTimeFront) {

        this.applyTimeFront = applyTimeFront;
    }

    public void setApplyTimeBack(Date applyTimeBack) {

        this.applyTimeBack = applyTimeBack;
    }
}
