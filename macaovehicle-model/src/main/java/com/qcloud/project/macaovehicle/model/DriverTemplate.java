package com.qcloud.project.macaovehicle.model;

import java.util.Date;
import java.math.BigDecimal;

public class DriverTemplate {
	
	//ID
	private long id;		
	
	private long carOwnerId;		
	
	//驾驶证号码
	private String licenseNumber;		
	
	//駕駛證初次領證日期
	private String licenseStartTime;		
	
	//驾驶证图片
	private String licenseImage;		
	
	//驾驶员姓名
	private String driverName;		
	
	//第二姓名
	private String seconddrivername;		
	
	//驾驶员联系电话
	private String driverPhone;		
	
	//驾驶员身份证
	private String driverIdCard;		
	
	//驾驶员地址
	private String driverAddress;		
	
	//身份证有效期
	private String idcardValidTime;		
	
	//驾驶证有效期
	private String licenseValidTime;		
	
	//准驾车型
	private String quasi;		
	
	//身份证前
	private String idcardFace;		
	
	//身份证后
	private String idcardBack;		
	
	//证件类型（1护照  2：回乡证）
	private int certificateType;		
	
	//证件号码
	private String certificateNo;		
	
	//其他证件有效期
	private String certificateDate;		
	
	//证件图片
	private String certificateUrl;		
	
	//一寸免冠红底照片
	private String inchImage;		
	
	//出生日期
	private String birthday;		
	
	//第二生日
	private String secondbirthday;		
	
	//性别
	private int sex;		
	
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
	
	//健康证号码
	private String healthCard;		
	
	//健康证明
	private String healthCardImg;		
	
	//工作单位
	private String driverworkplace;		
	
	//司机IC识别卡号（唯一）
	private String driverIc;		
	
	//卡id是否可用
	private int driverIcState;		

	public DriverTemplate(){
	
	}

	public DriverTemplate(long id,long carOwnerId,String licenseNumber,String licenseStartTime,String licenseImage,String driverName,String seconddrivername,String driverPhone,String driverIdCard,String driverAddress,String idcardValidTime,String licenseValidTime,String quasi,String idcardFace,String idcardBack,int certificateType,String certificateNo,String certificateDate,String certificateUrl,String inchImage,String birthday,String secondbirthday,int sex,int nation,int endorsementType,String endorsementOrgCode,String endorsementValidtime,int endorsementStay,String gotoCountry,String comefromCountry,String nationCode,String endorsementCode,String healthCard,String healthCardImg,String driverworkplace,String driverIc,int driverIcState){
		this.id = id;		
		this.carOwnerId = carOwnerId;		
		this.licenseNumber = licenseNumber;		
		this.licenseStartTime = licenseStartTime;		
		this.licenseImage = licenseImage;		
		this.driverName = driverName;		
		this.seconddrivername = seconddrivername;		
		this.driverPhone = driverPhone;		
		this.driverIdCard = driverIdCard;		
		this.driverAddress = driverAddress;		
		this.idcardValidTime = idcardValidTime;		
		this.licenseValidTime = licenseValidTime;		
		this.quasi = quasi;		
		this.idcardFace = idcardFace;		
		this.idcardBack = idcardBack;		
		this.certificateType = certificateType;		
		this.certificateNo = certificateNo;		
		this.certificateDate = certificateDate;		
		this.certificateUrl = certificateUrl;		
		this.inchImage = inchImage;		
		this.birthday = birthday;		
		this.secondbirthday = secondbirthday;		
		this.sex = sex;		
		this.nation = nation;		
		this.endorsementType = endorsementType;		
		this.endorsementOrgCode = endorsementOrgCode;		
		this.endorsementValidtime = endorsementValidtime;		
		this.endorsementStay = endorsementStay;		
		this.gotoCountry = gotoCountry;		
		this.comefromCountry = comefromCountry;		
		this.nationCode = nationCode;		
		this.endorsementCode = endorsementCode;		
		this.healthCard = healthCard;		
		this.healthCardImg = healthCardImg;		
		this.driverworkplace = driverworkplace;		
		this.driverIc = driverIc;		
		this.driverIcState = driverIcState;		
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
		
	public void setLicenseStartTime(String licenseStartTime) {
		this.licenseStartTime = licenseStartTime;
	}

	public String getLicenseStartTime() {
		return licenseStartTime;
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
		
	public void setSeconddrivername(String seconddrivername) {
		this.seconddrivername = seconddrivername;
	}

	public String getSeconddrivername() {
		return seconddrivername;
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
		
	public void setIdcardValidTime(String idcardValidTime) {
		this.idcardValidTime = idcardValidTime;
	}

	public String getIdcardValidTime() {
		return idcardValidTime;
	}	
		
	public void setLicenseValidTime(String licenseValidTime) {
		this.licenseValidTime = licenseValidTime;
	}

	public String getLicenseValidTime() {
		return licenseValidTime;
	}	
		
	public void setQuasi(String quasi) {
		this.quasi = quasi;
	}

	public String getQuasi() {
		return quasi;
	}	
		
	public void setIdcardFace(String idcardFace) {
		this.idcardFace = idcardFace;
	}

	public String getIdcardFace() {
		return idcardFace;
	}	
		
	public void setIdcardBack(String idcardBack) {
		this.idcardBack = idcardBack;
	}

	public String getIdcardBack() {
		return idcardBack;
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
		
	public void setCertificateDate(String certificateDate) {
		this.certificateDate = certificateDate;
	}

	public String getCertificateDate() {
		return certificateDate;
	}	
		
	public void setCertificateUrl(String certificateUrl) {
		this.certificateUrl = certificateUrl;
	}

	public String getCertificateUrl() {
		return certificateUrl;
	}	
		
	public void setInchImage(String inchImage) {
		this.inchImage = inchImage;
	}

	public String getInchImage() {
		return inchImage;
	}	
		
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBirthday() {
		return birthday;
	}	
		
	public void setSecondbirthday(String secondbirthday) {
		this.secondbirthday = secondbirthday;
	}

	public String getSecondbirthday() {
		return secondbirthday;
	}	
		
	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getSex() {
		return sex;
	}	
		
	public void setNation(int nation) {
		this.nation = nation;
	}

	public int getNation() {
		return nation;
	}	
		
	public void setEndorsementType(int endorsementType) {
		this.endorsementType = endorsementType;
	}

	public int getEndorsementType() {
		return endorsementType;
	}	
		
	public void setEndorsementOrgCode(String endorsementOrgCode) {
		this.endorsementOrgCode = endorsementOrgCode;
	}

	public String getEndorsementOrgCode() {
		return endorsementOrgCode;
	}	
		
	public void setEndorsementValidtime(String endorsementValidtime) {
		this.endorsementValidtime = endorsementValidtime;
	}

	public String getEndorsementValidtime() {
		return endorsementValidtime;
	}	
		
	public void setEndorsementStay(int endorsementStay) {
		this.endorsementStay = endorsementStay;
	}

	public int getEndorsementStay() {
		return endorsementStay;
	}	
		
	public void setGotoCountry(String gotoCountry) {
		this.gotoCountry = gotoCountry;
	}

	public String getGotoCountry() {
		return gotoCountry;
	}	
		
	public void setComefromCountry(String comefromCountry) {
		this.comefromCountry = comefromCountry;
	}

	public String getComefromCountry() {
		return comefromCountry;
	}	
		
	public void setNationCode(String nationCode) {
		this.nationCode = nationCode;
	}

	public String getNationCode() {
		return nationCode;
	}	
		
	public void setEndorsementCode(String endorsementCode) {
		this.endorsementCode = endorsementCode;
	}

	public String getEndorsementCode() {
		return endorsementCode;
	}	
		
	public void setHealthCard(String healthCard) {
		this.healthCard = healthCard;
	}

	public String getHealthCard() {
		return healthCard;
	}	
		
	public void setHealthCardImg(String healthCardImg) {
		this.healthCardImg = healthCardImg;
	}

	public String getHealthCardImg() {
		return healthCardImg;
	}	
		
	public void setDriverworkplace(String driverworkplace) {
		this.driverworkplace = driverworkplace;
	}

	public String getDriverworkplace() {
		return driverworkplace;
	}	
		
	public void setDriverIc(String driverIc) {
		this.driverIc = driverIc;
	}

	public String getDriverIc() {
		return driverIc;
	}	
		
	public void setDriverIcState(int driverIcState) {
		this.driverIcState = driverIcState;
	}

	public int getDriverIcState() {
		return driverIcState;
	}	
		
}
