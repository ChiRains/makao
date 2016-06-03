package com.qcloud.project.macaovehicle.model;

import java.util.ArrayList;
import java.util.List;

public class CarOwnerAcquisition {

    private long         id;

    private long         carOwnerId;

    // 购地用途
    private String       application;

    // 购地用地年限
    private int          deadline;

    // 购买日期
    private String       buyTime;

    // 用地出让权使用合同图片
    private String       contractUrl;

    private List<String> contractUrls = new ArrayList<String>();

    public CarOwnerAcquisition() {

    }

    public CarOwnerAcquisition(long id, long carOwnerId, String application, int deadline, String buyTime, String contractUrl) {

        this.id = id;
        this.carOwnerId = carOwnerId;
        this.application = application;
        this.deadline = deadline;
        this.buyTime = buyTime;
        this.contractUrl = contractUrl;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setCarOwnerId(long carOwnerId) {

        this.carOwnerId = carOwnerId;
    }

    public long getCarOwnerId() {

        return carOwnerId;
    }

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

    public void setContractUrl(String contractUrl) {

        this.contractUrl = contractUrl;
    }

    public String getContractUrl() {

        return contractUrl;
    }

    public String getBuyTime() {

        return buyTime;
    }

    public void setBuyTime(String buyTime) {

        this.buyTime = buyTime;
    }

    public List<String> getContractUrls() {

        return contractUrls;
    }

    public void setContractUrls(List<String> contractUrls) {

        this.contractUrls = contractUrls;
    }
}
