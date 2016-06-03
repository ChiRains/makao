package com.qcloud.project.macaovehicle.model;

public class VehicleNetResult {

    private String errorCode;

    private String errorMsg;

    public String getErrorCode() {

        return errorCode;
    }

    public void setErrorCode(String errorCode) {

        this.errorCode = errorCode;
    }

    public String getErrorMsg() {

        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {

        this.errorMsg = errorMsg;
    }

    public boolean isSuccess() {

        return "0".equals(errorCode);
    }
}
