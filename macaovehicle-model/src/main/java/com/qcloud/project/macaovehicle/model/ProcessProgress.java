package com.qcloud.project.macaovehicle.model;

public class ProcessProgress {

    // ID
    private long   id;

    // 表单编码
    private String formInstCode;

    // ID
    private long   carOwnerId;

    // 流程活动名称
    private String activity;

    // 1 通过 2 不通过
    private int    state;

    // 处理时间
    private String dateStr;

    // 1, "申请" 2, "管委会预审通过" 3, "验车通过",4, "管委会核实原件", 5, "交警核实原件" 6, "备案" 7, "排期装卡" 8, "通知装卡" 9, "完成"
    private int    progressState;

    // 入境申请
    private int    type;

    private long   formInstanceId;

    public ProcessProgress() {

    }

    public ProcessProgress(long id, String formInstCode, long carOwnerId, String activity, int state, String dateStr, int progressState, int type, long formInstanceId) {

        this.id = id;
        this.formInstCode = formInstCode;
        this.carOwnerId = carOwnerId;
        this.activity = activity;
        this.state = state;
        this.dateStr = dateStr;
        this.progressState = progressState;
        this.type = type;
        this.formInstanceId = formInstanceId;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

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

    public void setProgressState(int progressState) {

        this.progressState = progressState;
    }

    public int getProgressState() {

        return progressState;
    }

    public int getType() {

        return type;
    }

    public void setType(int type) {

        this.type = type;
    }

    public long getCarOwnerId() {

        return carOwnerId;
    }

    public void setCarOwnerId(long carOwnerId) {

        this.carOwnerId = carOwnerId;
    }

    public long getFormInstanceId() {

        return formInstanceId;
    }

    public void setFormInstanceId(long formInstanceId) {

        this.formInstanceId = formInstanceId;
    }
}
