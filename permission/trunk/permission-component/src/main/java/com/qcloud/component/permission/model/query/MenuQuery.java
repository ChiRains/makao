package com.qcloud.component.permission.model.query;

public class MenuQuery {

    private long   catalogId;

    private String name;

    public long getCatalogId() {

        return catalogId;
    }

    public void setCatalogId(long catalogId) {

        this.catalogId = catalogId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
