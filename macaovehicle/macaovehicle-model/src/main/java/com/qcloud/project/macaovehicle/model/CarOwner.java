package com.qcloud.project.macaovehicle.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

public class CarOwner {

    // ID
    private long   id;

    private long   userId;

    // 身份证号码
    private String idcardNumber;

    // 居住地址
    private String address;

    // 户口所在地
    private String residence;

    // 身份证反面
    private String idcardBack;

    // 身份证正面
    private String idcardFace;

    private String birthday;

    // 1务工2在住3企业4人才5购地
    private int    type;

    // 1个人2企业
    private int    clerkType;

    // 电话
    private String mobile;

    // 邮箱
    private String email;

    // 名称
    private String name;

    // 证件类型（1护照 2：回乡证）
    private int    certificateType;

    // 证件号码
    private String certificateNo;

    // 其他证件有效期
    private Date   certificateDate;

    // 证件图片
    private String certificateUrl;

    // 性别(1，男 2女)
    private int    sex;

    // 身份证有效期
    private String idCardValidTime;

    public CarOwner() {

    }

    public CarOwner(long id, long userId, String idcardNumber, String address, String residence, String idcardBack, String idcardFace, String birthday, int type, int clerkType, String mobile, String email, String name, int certificateType, String certificateNo, Date certificateDate, String certificateUrl, int sex, String idCardValidTime) {

        this.id = id;
        this.userId = userId;
        this.idcardNumber = idcardNumber;
        this.address = address;
        this.residence = residence;
        this.idcardBack = idcardBack;
        this.idcardFace = idcardFace;
        this.birthday = birthday;
        this.type = type;
        this.clerkType = clerkType;
        this.mobile = mobile;
        this.email = email;
        this.name = name;
        this.certificateType = certificateType;
        this.certificateNo = certificateNo;
        this.certificateDate = certificateDate;
        this.certificateUrl = certificateUrl;
        this.sex = sex;
        this.idCardValidTime = idCardValidTime;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setUserId(long userId) {

        this.userId = userId;
    }

    public long getUserId() {

        return userId;
    }

    public void setIdcardNumber(String idcardNumber) {

        this.idcardNumber = idcardNumber;
    }

    public String getIdcardNumber() {

        return idcardNumber;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getAddress() {

        return address;
    }

    public void setResidence(String residence) {

        this.residence = residence;
    }

    public String getResidence() {

        return residence;
    }

    public void setIdcardBack(String idcardBack) {

        this.idcardBack = idcardBack;
    }

    public String getIdcardBack() {

        return idcardBack;
    }

    public void setIdcardFace(String idcardFace) {

        this.idcardFace = idcardFace;
    }

    public String getIdcardFace() {

        return idcardFace;
    }

    public void setBirthday(String birthday) {

        this.birthday = birthday;
    }

    public String getBirthday() {

        return birthday;
    }

    public void setType(int type) {

        this.type = type;
    }

    public int getType() {

        return type;
    }

    public void setClerkType(int clerkType) {

        this.clerkType = clerkType;
    }

    public int getClerkType() {

        return clerkType;
    }

    public void setMobile(String mobile) {

        this.mobile = mobile;
    }

    public String getMobile() {

        return mobile;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getEmail() {

        return email;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setCertificateType(int certificateType) {

        this.certificateType = certificateType;
    }

    public int getCertificateType() {

        return certificateType;
    }

    public void setCertificateNo(String certificateNo) {

        this.certificateNo = certificateNo;
    }

    public String getCertificateNo() {

        return certificateNo;
    }

    public void setCertificateDate(Date certificateDate) {

        this.certificateDate = certificateDate;
    }

    public Date getCertificateDate() {

        return certificateDate;
    }

    public void setCertificateUrl(String certificateUrl) {

        this.certificateUrl = certificateUrl;
    }

    public String getCertificateUrl() {

        return certificateUrl;
    }

    public void setSex(int sex) {

        this.sex = sex;
    }

    public int getSex() {

        return sex;
    }

    public void setIdCardValidTime(String idCardValidTime) {

        this.idCardValidTime = idCardValidTime;
    }

    public String getIdCardValidTime() {

        return idCardValidTime;
    }
}
