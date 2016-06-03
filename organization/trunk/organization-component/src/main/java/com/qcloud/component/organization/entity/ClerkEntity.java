package com.qcloud.component.organization.entity;

import com.qcloud.component.organization.QClerk;

public class ClerkEntity implements QClerk {

    Long   id;

    Long   departmentId;

    Long   postId;

    String name;

    String mobile;

    int    sex;

    String headImage;

    String jobEmail;

    String inside;

    String departmentName;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Long getDepartmentId() {

        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {

        this.departmentId = departmentId;
    }

    public Long getPostId() {

        return postId;
    }

    public void setPostId(Long postId) {

        this.postId = postId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getMobile() {

        return mobile;
    }

    public void setMobile(String mobile) {

        this.mobile = mobile;
    }

    public String getHeadImage() {

        return headImage;
    }

    public int getSex() {

        return sex;
    }

    public void setSex(int sex) {

        this.sex = sex;
    }

    public void setHeadImage(String headImage) {

        this.headImage = headImage;
    }

    public String getJobEmail() {

        return jobEmail;
    }

    public void setJobEmail(String jobEmail) {

        this.jobEmail = jobEmail;
    }

    public String getInside() {

        return inside;
    }

    public void setInside(String inside) {

        this.inside = inside;
    }

    public String getDepartmentName() {

        return departmentName;
    }

    public void setDepartmentName(String departmentName) {

        this.departmentName = departmentName;
    }
}
