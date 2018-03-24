package com.server.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.entities.RegisterGenerator;
import com.server.repositories.GeneratorRepository;
import com.server.services.GeneratorService;

@Service
public class GenertorServiceImpl implements GeneratorService{

	@Autowired
	private GeneratorRepository generatorRepository;
	
	@Override
	public Long getRegisterForm() {
		RegisterGenerator register = generatorRepository.findTopByOrderByRegisterForm();
		if(register == null) {
			RegisterGenerator register2 = new RegisterGenerator();
			register2.setRegisterForm(0l);
			register2.setRegisterTravel(0l);
			this.generatorRepository.save(register2);
			register = generatorRepository.findTopByOrderByRegisterForm();
		}
		register.setRegisterForm(register.getRegisterForm() + 1);
		generatorRepository.save(register);
		return register.getRegisterForm();
	}

	@Override
	public Long getRegisterTravel() {
		RegisterGenerator register = generatorRepository.findTopByOrderByRegisterForm();
		if(register == null) {
			RegisterGenerator register2 = new RegisterGenerator();
			register2.setRegisterForm(0l);
			register2.setRegisterTravel(0l);
			this.generatorRepository.save(register2);
			register = generatorRepository.findTopByOrderByRegisterForm();
		}
		register.setRegisterTravel(register.getRegisterTravel() + 1);
		generatorRepository.save(register);
		return register.getRegisterTravel();
	}

}
