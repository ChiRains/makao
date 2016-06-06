package com.qcloud.component.snaker.web.vo.admin;

public class ProcessVO {

    private String id;

    private String name;

    private String displayName;

    private Long   formId;

    private int    version = -1;

    private String pcApplyUrl;

    private String mobileApplyUrl;

    public int getVersion() {

        return version;
    }

    public void setVersion(int version) {

        this.version = version;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDisplayName() {

        return displayName;
    }

    public void setDisplayName(String displayName) {

        this.displayName = displayName;
    }

    public Long getFormId() {

        return formId;
    }

    public void setFormId(Long formId) {

        this.formId = formId;
    }

    public String getPcApplyUrl() {

        return pcApplyUrl;
    }

    public void setPcApplyUrl(String pcApplyUrl) {

        this.pcApplyUrl = pcApplyUrl;
    }

    public String getMobileApplyUrl() {

        return mobileApplyUrl;
    }

    public void setMobileApplyUrl(String mobileApplyUrl) {

        this.mobileApplyUrl = mobileApplyUrl;
    }
}
