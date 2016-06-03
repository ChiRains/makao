package com.qcloud.project.macaovehicle.web.form;

import java.util.Date;

public class HistoryAcquisitionForm {

    // 购地用途
    private String application;

    // 购地用地年限
    private int    deadline;

    // 购买日期
    private Date   buyTime;

    // 用地出让权使用合同图片
    private String contractUrl;

    public void setApplication(String application) {

        this.application = application;
    }

    public String getApplication() {

        return application;
    }

    public void setDeadline(int deadline) {

        this.deadline = deadline;
    }

    public int getDeadline() {

        return deadline;
    }

    public void setBuyTime(Date buyTime) {

        this.buyTime = buyTime;
    }

    public Date getBuyTime() {

        return buyTime;
    }

    public void setContractUrl(String contractUrl) {

        this.contractUrl = contractUrl;
    }

    public String getContractUrl() {

        return contractUrl;
    }
}
