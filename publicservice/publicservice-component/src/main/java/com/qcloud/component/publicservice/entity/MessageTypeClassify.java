package com.qcloud.component.publicservice.entity;

import com.qcloud.component.publicdata.IntKeyValue;

public class MessageTypeClassify implements IntKeyValue {

    private int    classify;

    private String name;

    public int getClassify() {

        return classify;
    }

    public void setClassify(int classify) {

        this.classify = classify;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public long getKey() {

        return classify;
    }

    @Override
    public String getValue() {

        return name;
    }
}
