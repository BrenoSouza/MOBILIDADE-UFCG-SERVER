package com.server.dtos;

public class Traveldto {

	private Long formId;
	
	private Long vehicle;
	
	private Long driver;

	public Traveldto() {}
	
	public Long getFormId() {
		return formId;
	}

	public void setFormId(Long formId) {
		this.formId = formId;
	}

	public Long getVehicle() {
		return vehicle;
	}

	public void setVehicle(Long vehicle) {
		this.vehicle = vehicle;
	}

	public Long getDriver() {
		return driver;
	}

	public void setDriver(Long driver) {
		this.driver = driver;
	}
	
	
}
