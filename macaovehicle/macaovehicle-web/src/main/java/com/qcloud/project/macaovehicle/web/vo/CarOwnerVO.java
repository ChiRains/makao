package com.qcloud.project.macaovehicle.web.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarOwnerVO {

    // ID
    private long                   id;

    private long                   userId;

    private String                 name;

    private String                 mobile;

    private int                    sex;

    private String                 headImage;

    private String                 email;

    // private long userId;
    // 身份证号码
    private String                 idcardNumber;

    // 居住地址
    private String                 address;

    // 户口所在地
    private String                 residence;

    // 身份证反面
    private String                 idcardBack;

    // 身份证正面
    private String                 idcardFace;

    private String                 birthday;

    // 1务工2在住3企业4人才5购地
    private int                    type;

    // 1务工2在住3企业4人才5购地
    private String                 typeStr;

    private int                    clerkType;

    private String                 clerkTypeStr;

    private CarOwnerWorkersVO      workersVO;

    private CarOwnerHousersVO      housersVO;

    private CarOwnerEnterprisersVO enterprisersVO;

    private CarOwnerPurchaseVO     purchaseVO;

    private int                    certificateType;

    private CarOwnerAcquisitionVO  acquisitionVO;

    private String                 certificateNo;

    private Date                   certificateDate;

    private String                 certificateUrl;

    private String                 sexFormat;

    private String                 idCardValidTime;

    private String                 headImageUid;

    private String                 idcardBackUid;

    private String                 idcardFaceUid;

    private String                 certificateUrlUid;

    private CarOwnerTalentVO       talentVO;

    private String                 certificateDateFormat;

    private List<String>           certificateUrls    = new ArrayList<String>();

    private List<String>           certificateUrlUids = new ArrayList<String>();

    public CarOwnerVO() {

    }

    public String getHeadImageUid() {

        return headImageUid;
    }

    public void setHeadImageUid(String headImageUid) {

        this.headImageUid = headImageUid;
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

    public void setType(int type) {

        this.type = type;
    }

    public int getType() {

        return type;
    }

    public CarOwnerWorkersVO getWorkersVO() {

        return workersVO;
    }

    public void setWorkersVO(CarOwnerWorkersVO workersVO) {

        this.workersVO = workersVO;
    }

    public CarOwnerHousersVO getHousersVO() {

        return housersVO;
    }

    public void setHousersVO(CarOwnerHousersVO housersVO) {

        this.housersVO = housersVO;
    }

    public CarOwnerEnterprisersVO getEnterprisersVO() {

        return enterprisersVO;
    }

    public void setEnterprisersVO(CarOwnerEnterprisersVO enterprisersVO) {

        this.enterprisersVO = enterprisersVO;
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

    public void setHeadImage(String headImage) {

        this.headImage = headImage;
    }

    public String getTypeStr() {

        return typeStr;
    }

    public void setTypeStr(String typeStr) {

        this.typeStr = typeStr;
    }

    public String getBirthday() {

        return birthday;
    }

    public void setBirthday(String birthday) {

        this.birthday = birthday;
    }

    public String getIdcardFaceUid() {

        return idcardFaceUid;
    }

    public void setIdcardFaceUid(String idcardFaceUid) {

        this.idcardFaceUid = idcardFaceUid;
    }

    public String getIdcardBackUid() {

        return idcardBackUid;
    }

    public void setIdcardBackUid(String idcardBackUid) {

        this.idcardBackUid = idcardBackUid;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public CarOwnerPurchaseVO getPurchaseVO() {

        return purchaseVO;
    }

    public void setPurchaseVO(CarOwnerPurchaseVO purchaseVO) {

        this.purchaseVO = purchaseVO;
    }

    public CarOwnerTalentVO getTalentVO() {

        return talentVO;
    }

    public void setTalentVO(CarOwnerTalentVO talentVO) {

        this.talentVO = talentVO;
    }

    public int getClerkType() {

        return clerkType;
    }

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

    public String getSexFormat() {

        return sexFormat;
    }

    public void setSexFormat(String sexFormat) {

        this.sexFormat = sexFormat;
    }

    public String getIdCardValidTime() {

        return idCardValidTime;
    }

    public void setIdCardValidTime(String idCardValidTime) {

        this.idCardValidTime = idCardValidTime;
    }

    public void setClerkType(int clerkType) {

        this.clerkType = clerkType;
    }

    public void setClerkTypeStr(String clerkTypeStr) {

        this.clerkTypeStr = clerkTypeStr;
    }

    public CarOwnerAcquisitionVO getAcquisitionVO() {

        return acquisitionVO;
    }

    public void setAcquisitionVO(CarOwnerAcquisitionVO acquisitionVO) {

        this.acquisitionVO = acquisitionVO;
    }

    public String getClerkTypeStr() {

        return clerkTypeStr;
    }

    public String getCertificateUrlUid() {

        return certificateUrlUid;
    }

    public void setCertificateUrlUid(String certificateUrlUid) {

        this.certificateUrlUid = certificateUrlUid;
    }

    public String getCertificateDateFormat() {

        return certificateDateFormat;
    }

    public void setCertificateDateFormat(String certificateDateFormat) {

        this.certificateDateFormat = certificateDateFormat;
    }

    public int getSex() {

        return sex;
    }

    public void setSex(int sex) {

        this.sex = sex;
    }

    public List<String> getCertificateUrlUids() {

        return certificateUrlUids;
    }

    public void setCertificateUrlUids(List<String> certificateUrlUids) {

        this.certificateUrlUids = certificateUrlUids;
    }

    public List<String> getCertificateUrls() {

        return certificateUrls;
    }

    public void setCertificateUrls(List<String> certificateUrls) {

        this.certificateUrls = certificateUrls;
    }
}
