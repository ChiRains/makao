package com.qcloud.component.organization.model.query;

public class ClerkQuery {

    private String name;

    private int    type;

    private String laborNumber;

    public ClerkQuery() {

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getType() {

        return type;
    }

    public void setType(int type) {

        this.type = type;
    }

    public String getLaborNumber() {

        return laborNumber;
    }

    public void setLaborNumber(String laborNumber) {

        this.laborNumber = laborNumber;
    }
}
