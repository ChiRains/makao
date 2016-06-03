package com.qcloud.component.organization.entity;

import com.qcloud.component.organization.QPost;

public class PostEntity implements QPost {

    private Long   id;

    private String name;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
