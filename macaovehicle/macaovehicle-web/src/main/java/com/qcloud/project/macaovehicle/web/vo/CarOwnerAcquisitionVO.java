package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

public class CarOwnerAcquisitionVO {

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

    private String       contractUrlUid;

    private List<String> contractUrls;

    private List<String> contractUrlUids;

    public String getContractUrlUid() {

        return contractUrlUid;
    }

    public void setContractUrlUid(String contractUrlUid) {

        this.contractUrlUid = contractUrlUid;
    }

    private String buyTimeFormat;

    public CarOwnerAcquisitionVO() {

    }

    public CarOwnerAcquisitionVO(long id, long carOwnerId, String application, int deadline, String buyTime, String contractUrl) {

        this.id = id;
        this.carOwnerId = carOwnerId;
        this.application = application;
        this.deadline = deadline;
        this.buyTime = buyTime;
        this.contractUrl = contractUrl;
    }

    public String getBuyTimeFormat() {

        return buyTimeFormat;
    }

    public void setBuyTimeFormat(String buyTimeFormat) {

        this.buyTimeFormat = buyTimeFormat;
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

    public List<String> getContractUrlUids() {

        return contractUrlUids;
    }

    public void setContractUrlUids(List<String> contractUrlUids) {

        this.contractUrlUids = contractUrlUids;
    }
}
