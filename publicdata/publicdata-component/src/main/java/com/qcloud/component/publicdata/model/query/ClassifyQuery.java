package com.qcloud.component.publicdata.model.query;
public class ClassifyQuery {
    private long   type;
    private String name;

    public ClassifyQuery() {
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
