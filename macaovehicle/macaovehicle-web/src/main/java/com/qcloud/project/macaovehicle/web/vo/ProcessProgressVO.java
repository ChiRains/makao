package com.qcloud.project.macaovehicle.web.vo;

import java.util.HashMap;
import java.util.Map;

public class ProcessProgressVO {

    // ID
    private long                id;

    // 表单编码
    private String              formInstCode;

    // 表单id
    private String              formInstanceId;

    // ID
    private long                carOwnerId;

    // 流程活动名称
    private String              activity;

    // 1 通过 2 不通过
    private int                 state;

    // 处理时间
    private String              dateStr;

    // 1, "申请" 2, "管委会预审通过" 3, "验车通过",4, "管委会核实原件", 5, "交警核实原件" 6, "备案" 7, "排期装卡" 8, "通知装卡" 9, "完成"
    private int                 progressState;

    private int                 type;

    private Map<String, Object> returnMap = new HashMap<String, Object>();

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

    public Map<String, Object> getReturnMap() {

        return returnMap;
    }

    public void setReturnMap(Map<String, Object> returnMap) {

        this.returnMap = returnMap;
    }

    public long getCarOwnerId() {

        return carOwnerId;
    }

    public void setCarOwnerId(long carOwnerId) {

        this.carOwnerId = carOwnerId;
    }

    public String getFormInstanceId() {

        return formInstanceId;
    }

    public void setFormInstanceId(String formInstanceId) {

        this.formInstanceId = formInstanceId;
    }
}
