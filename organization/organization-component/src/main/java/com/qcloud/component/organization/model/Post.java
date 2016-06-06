package com.qcloud.component.organization.model;

import com.qcloud.component.publicdata.IntKeyValue;

public class Post implements IntKeyValue {

    // ID
    private long   id;

    // 名称
    private String name;

    public Post() {

    }

    public Post(long id, String name) {

        this.id = id;
        this.name = name;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    @Override
    public long getKey() {

        return id;
    }

    @Override
    public String getValue() {

        return name;
    }
}
