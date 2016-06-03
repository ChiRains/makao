package com.qcloud.project.macaovehicle.model.query;

import java.util.Date;

public class DriverLossQuery {

    // 表单编码(不涉及流程)
    private String formInstCode;

    // 新电子司机卡号
    private String newDriverIc;

    // 搜索申请时间
    private Date   applyTimeFront;

    // 搜索申请时间
    private Date   applyTimeBack;

    public DriverLossQuery() {

    }

    public String getFormInstCode() {

        return formInstCode;
    }

    public String getNewDriverIc() {

        return newDriverIc;
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

    public void setNewDriverIc(String newDriverIc) {

        this.newDriverIc = newDriverIc;
    }

    public void setApplyTimeFront(Date applyTimeFront) {

        this.applyTimeFront = applyTimeFront;
    }

    public void setApplyTimeBack(Date applyTimeBack) {

        this.applyTimeBack = applyTimeBack;
    }
}
