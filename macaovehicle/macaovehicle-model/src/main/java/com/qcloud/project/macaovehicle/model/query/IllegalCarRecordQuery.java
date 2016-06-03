package com.qcloud.project.macaovehicle.model.query;

public class IllegalCarRecordQuery {

    private String plateNumber;

    private Long   departmentId;

    public IllegalCarRecordQuery() {

    }

    public String getPlateNumber() {

        return plateNumber;
    }

    public Long getDepartmentId() {

        return departmentId;
    }

    public void setPlateNumber(String plateNumber) {

        this.plateNumber = plateNumber;
    }

    public void setDepartmentId(Long departmentId) {

        this.departmentId = departmentId;
    }
}
