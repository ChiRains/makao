package com.qcloud.project.macaovehicle.web.vo;

public class ProcessProgressItemVO {

    private int    orderNO;

    // 表单编码
    private String formInstCode;

    // 流程活动名称
    private String activity;

    // 1 通过 2 不通过
    private int    state;

    // 处理时间
    private String dateStr;

    public void setFormInstCode(String formInstCode) {

        this.formInstCode = formInstCode;
    }

    public String getFormInstCode() {

        return formInstCode;
    }

    public void setActivity(String activity) {

        this.activity = activity;
    }

    public String getActivity() {

        return activity;
    }

    public void setState(int state) {

        this.state = state;
    }

    public int getState() {

        return state;
    }

    public void setDateStr(String dateStr) {

        this.dateStr = dateStr;
    }

    public String getDateStr() {

        return dateStr;
    }

    public int getOrderNO() {

        return orderNO;
    }

    public void setOrderNO(int orderNO) {

        this.orderNO = orderNO;
    }
}
