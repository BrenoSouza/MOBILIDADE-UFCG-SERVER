package com.server.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RegisterGenerator {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Long id;

	private Long registerForm;
	
	private Long registerTravel;

	public Long getRegisterForm() {
		return registerForm;
	}

	public void setRegisterForm(Long refisterForm) {
		this.registerForm = refisterForm;
	}

	public Long getRegisterTravel() {
		return registerTravel;
	}

	public void setRegisterTravel(Long registerTravel) {
		this.registerTravel = registerTravel;
	}
	
	
}
