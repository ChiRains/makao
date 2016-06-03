package com.qcloud.component.publicdata.web.vo.admin;


public class AdminDataDictionaryVO {

    private long   id;

    // 类型
    private String type;

    // 存储键值
    private long   key;

    // 显示名称
    private String value;

    private String displayName;

    public AdminDataDictionaryVO() {

    }

    public AdminDataDictionaryVO(long id, String type, long key, String value, String displayName) {

        this.id = id;
        this.type = type;
        this.key = key;
        this.value = value;
        this.displayName = displayName;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getType() {

        return type;
    }

    public void setKey(long key) {

        this.key = key;
    }

    public long getKey() {

        return key;
    }

    public void setValue(String value) {

        this.value = value;
    }

    public String getValue() {

        return value;
    }

    public String getDisplayName() {

        return displayName;
    }

    public void setDisplayName(String displayName) {

        this.displayName = displayName;
    }
}
