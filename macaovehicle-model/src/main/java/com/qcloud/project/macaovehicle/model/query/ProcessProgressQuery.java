package com.qcloud.project.macaovehicle.model.query;

public class ProcessProgressQuery {

    private int  type;

    private int  state;

    private long carOwnerId;

    public int getState() {

        return state;
    }

    public void setState(int state) {

        this.state = state;
    }

    public ProcessProgressQuery() {

    }

    public long getCarOwnerId() {

        return carOwnerId;
    }

    public void setCarOwnerId(long carOwnerId) {

        this.carOwnerId = carOwnerId;
    }

    public int getType() {

        return type;
    }

    public void setType(int type) {

        this.type = type;
    }
}
