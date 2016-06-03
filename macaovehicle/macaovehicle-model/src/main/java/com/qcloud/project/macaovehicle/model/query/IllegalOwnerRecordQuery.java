package com.qcloud.project.macaovehicle.model.query;

public class IllegalOwnerRecordQuery {

    private String certificatesNo;

    private Long   departmentId;

    private String name;

    public IllegalOwnerRecordQuery() {

    }

    public Long getDepartmentId() {

        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {

        this.departmentId = departmentId;
    }

    public String getCertificatesNo() {

        return certificatesNo;
    }

    public void setCertificatesNo(String certificatesNo) {

        this.certificatesNo = certificatesNo;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
