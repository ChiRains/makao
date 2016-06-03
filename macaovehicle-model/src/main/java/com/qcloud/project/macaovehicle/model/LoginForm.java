package com.qcloud.project.macaovehicle.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;

public class LoginForm {

    private CarOwnerEnterprisers enterprisers;

    private CarOwnerWorkers      workers;

    private CarOwnerHousers      housers;

    private CarOwnerPurchase     purchase;

    private CarOwnerTalent       talent;

    private CarOwnerAcquisition  acquisition;

    // 姓名
    private String               name;

    //
    private String               password;

    // 性别
    private int                  sex;

    // 验证码
    private String               verificationCode;

    // 手机号
    private String               mobile;

    // 邮箱
    private String               email;

    private String               birthday;

    private String               code;

    private int                  type;

    private int                  clerkType;

    // 身份证号码
    private String               idcardNumber;

    // 居住地址
    private String               address;

    // 户口所在地
    private String               residence;

    // 身份证反面
    private String               idcardBack;

    // 身份证正面
    private String               idcardFace;

    // 证件类型（1护照 2：回乡证）
    private int                  certificateType;

    // 证件号码
    private String               certificateNo;

    // 其他证件有效期
    private Date                 certificateDate;

    // 证件图片
    private String               certificateUrl;

    // 身份证有效期
    private String               idCardValidTime;

    private List<String>         certificateUrls = new ArrayList<String>();

    public int getCertificateType() {

        return certificateType;
    }

    public void setCertificateType(int certificateType) {

        this.certificateType = certificateType;
    }

    public String getCertificateNo() {

        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {

        this.certificateNo = certificateNo;
    }

    public Date getCertificateDate() {

        return certificateDate;
    }

    public void setCertificateDate(Date certificateDate) {

        this.certificateDate = certificateDate;
    }

    public String getCertificateUrl() {

        return certificateUrl;
    }

    public void setCertificateUrl(String certificateUrl) {

        this.certificateUrl = certificateUrl;
    }

    public String getIdCardValidTime() {

        return idCardValidTime;
    }

    public void setIdCardValidTime(String idCardValidTime) {

        this.idCardValidTime = idCardValidTime;
    }

    public CarOwnerAcquisition getAcquisition() {

        return acquisition;
    }

    public void setAcquisition(CarOwnerAcquisition acquisition) {

        this.acquisition = acquisition;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public int getSex() {

        return sex;
    }

    public void setSex(int sex) {

        this.sex = sex;
    }

    public String getVerificationCode() {

        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {

        this.verificationCode = verificationCode;
    }

    public String getMobile() {

        return mobile;
    }

    public void setMobile(String mobile) {

        this.mobile = mobile;
    }

    public String getIdcardNumber() {

        return idcardNumber;
    }

    public void setIdcardNumber(String idcardNumber) {

        this.idcardNumber = idcardNumber;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getResidence() {

        return residence;
    }

    public void setResidence(String residence) {

        this.residence = residence;
    }

    public String getIdcardBack() {

        return idcardBack;
    }

    public void setIdcardBack(String idcardBack) {

        this.idcardBack = idcardBack;
    }

    public String getIdcardFace() {

        return idcardFace;
    }

    public void setIdcardFace(String idcardFace) {

        this.idcardFace = idcardFace;
    }

    public CarOwnerEnterprisers getEnterprisers() {

        return enterprisers;
    }

    public void setEnterprisers(CarOwnerEnterprisers enterprisers) {

        this.enterprisers = enterprisers;
    }

    public CarOwnerWorkers getWorkers() {

        return workers;
    }

    public void setWorkers(CarOwnerWorkers workers) {

        this.workers = workers;
    }

    public CarOwnerHousers getHousers() {

        return housers;
    }

    public void setHousers(CarOwnerHousers housers) {

        this.housers = housers;
    }

    public int getType() {

        return type;
    }

    public void setType(int type) {

        this.type = type;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public String getBirthday() {

        return birthday;
    }

    public void setBirthday(String birthday) {

        this.birthday = birthday;
    }

    public int getClerkType() {

        return clerkType;
    }

    public void setClerkType(int clerkType) {

        this.clerkType = clerkType;
    }

    public CarOwnerPurchase getPurchase() {

        return purchase;
    }

    public void setPurchase(CarOwnerPurchase purchase) {

        this.purchase = purchase;
    }

    public CarOwnerTalent getTalent() {

        return talent;
    }

    public void setTalent(CarOwnerTalent talent) {

        this.talent = talent;
    }

    public List<String> getCertificateUrls() {

        return certificateUrls;
    }

    public void setCertificateUrls(List<String> certificateUrls) {

        this.certificateUrls = certificateUrls;
    }
}
