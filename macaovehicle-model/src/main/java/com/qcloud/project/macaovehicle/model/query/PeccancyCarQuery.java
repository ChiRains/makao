package com.qcloud.project.macaovehicle.model.query;

public class PeccancyCarQuery {
	
	private long  carOwnerId;
	
	private String outsidePlate;
	
	private String temporaryPlate;
	
	private String code;

	public String getOutsidePlate() {
		return outsidePlate;
	}

	public void setOutsidePlate(String outsidePlate) {
		this.outsidePlate = outsidePlate;
	}

	public String getTemporaryPlate() {
		return temporaryPlate;
	}

	public void setTemporaryPlate(String temporaryPlate) {
		this.temporaryPlate = temporaryPlate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public long getCarOwnerId() {
		return carOwnerId;
	}

	public void setCarOwnerId(long carOwnerId) {
		this.carOwnerId = carOwnerId;
	}
	
	public PeccancyCarQuery(){
	
	}
}
