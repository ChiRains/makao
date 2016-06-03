package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminDriverVO {

    // ID
    private long   id;

    private long   carOwnerId;
    
    private String driverworkplace;

	// 驾驶证号码
    private String licenseNumber;

    // 行驶证图片
    private String licenseImage;

    private String driverName;

    private String driverPhone;

    private String driverIdCard;

    private String driverAddress;

    // 驾驶证有效期
    private String licenseValidTime;

    // 准驾车型
    private String quasi;

    // 正面
    private String idcardFace;

    // 反面
    private String idcardBack;

    // 回乡证
    private String hvps;

    // 回乡证拍照
    private String hvpsImage;

    // 护照
    private String passport;

    // 护照拍照
    private String passportImage;

    // 一寸照片
    private String inchImage;

    private String birthday;

    private int    sex;
    
  //国籍(1,境内；2，境外)
  	private int nation;		
  	
  	//签注类别
  	private int endorsementType;		
  	
  	//所持证件发证机关代码
  	private String endorsementOrgCode;		
  	
  	//签证签注有效期
  	private String endorsementValidtime;		
  	
  	//停留期（月）
  	private int endorsementStay;		
  	
  	//去往国
  	private String gotoCountry;		
  	
  	//来自国
  	private String comefromCountry;		
  	
  	//民族代码
  	private String nationCode;		
  	
  	//签证号
  	private String endorsementCode;		
  	
  	//健康证明
  	private String healthCardImg;	
  	
	//回乡证有效期
	private String hvpsValidTime;		

	//护照有效期
	private String passportValidTime;	

    
    public String getHvpsValidTime() {
		return hvpsValidTime;
	}

	public void setHvpsValidTime(String hvpsValidTime) {
		this.hvpsValidTime = hvpsValidTime;
	}

	public String getPassportValidTime() {
		return passportValidTime;
	}

	public void setPassportValidTime(String passportValidTime) {
		this.passportValidTime = passportValidTime;
	}

	public AdminDriverVO(long id, long carOwnerId, String licenseNumber, String licenseImage, String driverName, String driverPhone, String driverIdCard, String driverAddress) {

        this.id = id;
        this.carOwnerId = carOwnerId;
        this.licenseNumber = licenseNumber;
        this.licenseImage = licenseImage;
        this.driverName = driverName;
        this.driverPhone = driverPhone;
        this.driverIdCard = driverIdCard;
        this.driverAddress = driverAddress;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setCarOwnerId(long carOwnerId) {

        this.carOwnerId = carOwnerId;
    }

    public long getCarOwnerId() {

        return carOwnerId;
    }

    public void setLicenseNumber(String licenseNumber) {

        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() {

        return licenseNumber;
    }

    public void setLicenseImage(String licenseImage) {

        this.licenseImage = licenseImage;
    }

    public String getLicenseImage() {

        return licenseImage;
    }

    public void setDriverName(String driverName) {

        this.driverName = driverName;
    }

    public String getDriverName() {

        return driverName;
    }

    public void setDriverPhone(String driverPhone) {

        this.driverPhone = driverPhone;
    }

    public String getDriverPhone() {

        return driverPhone;
    }

    public void setDriverIdCard(String driverIdCard) {

        this.driverIdCard = driverIdCard;
    }

    public String getDriverIdCard() {

        return driverIdCard;
    }

    public void setDriverAddress(String driverAddress) {

        this.driverAddress = driverAddress;
    }

    public String getDriverAddress() {

        return driverAddress;
    }

    public String getQuasi() {

        return quasi;
    }

    public void setQuasi(String quasi) {

        this.quasi = quasi;
    }

    public String getIdcardFace() {

        return idcardFace;
    }

    public void setIdcardFace(String idcardFace) {

        this.idcardFace = idcardFace;
    }

    public String getIdcardBack() {

        return idcardBack;
    }

    public void setIdcardBack(String idcardBack) {

        this.idcardBack = idcardBack;
    }

    public String getHvps() {

        return hvps;
    }

    public void setHvps(String hvps) {

        this.hvps = hvps;
    }

    public String getHvpsImage() {

        return hvpsImage;
    }

    public void setHvpsImage(String hvpsImage) {

        this.hvpsImage = hvpsImage;
    }

    public String getPassport() {

        return passport;
    }

    public void setPassport(String passport) {

        this.passport = passport;
    }

    public String getPassportImage() {

        return passportImage;
    }

    public void setPassportImage(String passportImage) {

        this.passportImage = passportImage;
    }

    public String getInchImage() {

        return inchImage;
    }

    public void setInchImage(String inchImage) {

        this.inchImage = inchImage;
    }

    public int getSex() {

        return sex;
    }

    public void setSex(int sex) {

        this.sex = sex;
    }

    public String getLicenseValidTime() {

        return licenseValidTime;
    }

    public void setLicenseValidTime(String licenseValidTime) {

        this.licenseValidTime = licenseValidTime;
    }

    public String getBirthday() {

        return birthday;
    }

    public void setBirthday(String birthday) {

        this.birthday = birthday;
    }
    
    public int getNation() {
		return nation;
	}

	public void setNation(int nation) {
		this.nation = nation;
	}

	public int getEndorsementType() {
		return endorsementType;
	}

	public void setEndorsementType(int endorsementType) {
		this.endorsementType = endorsementType;
	}

	public String getEndorsementOrgCode() {
		return endorsementOrgCode;
	}

	public void setEndorsementOrgCode(String endorsementOrgCode) {
		this.endorsementOrgCode = endorsementOrgCode;
	}

	public String getEndorsementValidtime() {
		return endorsementValidtime;
	}

	public void setEndorsementValidtime(String endorsementValidtime) {
		this.endorsementValidtime = endorsementValidtime;
	}

	public int getEndorsementStay() {
		return endorsementStay;
	}

	public void setEndorsementStay(int endorsementStay) {
		this.endorsementStay = endorsementStay;
	}

	public String getGotoCountry() {
		return gotoCountry;
	}

	public void setGotoCountry(String gotoCountry) {
		this.gotoCountry = gotoCountry;
	}

	public String getComefromCountry() {
		return comefromCountry;
	}

	public void setComefromCountry(String comefromCountry) {
		this.comefromCountry = comefromCountry;
	}

	public String getNationCode() {
		return nationCode;
	}

	public void setNationCode(String nationCode) {
		this.nationCode = nationCode;
	}

	public String getEndorsementCode() {
		return endorsementCode;
	}

	public void setEndorsementCode(String endorsementCode) {
		this.endorsementCode = endorsementCode;
	}

	public String getHealthCardImg() {
		return healthCardImg;
	}

	public void setHealthCardImg(String healthCardImg) {
		this.healthCardImg = healthCardImg;
	}

	public AdminDriverVO() {

    }
	
    public String getDriverworkplace() {
		return driverworkplace;
	}

	public void setDriverworkplace(String driverworkplace) {
		this.driverworkplace = driverworkplace;
	}


}
