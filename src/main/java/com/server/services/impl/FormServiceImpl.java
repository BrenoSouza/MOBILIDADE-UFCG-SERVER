package com.server.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.entities.Form;
import com.server.repositories.FormRepository;
import com.server.services.FormService;

@Service
public class FormServiceImpl implements FormService {
	
	@Autowired
	private FormRepository formRepository;

	@Override
	public Form findByid(Long Id) {
		return formRepository.findByid(Id);
	}

	@Override
	public List<Form> findAll() {
		return formRepository.findAll();
	}

	@Override
	public Form persistir(Form formulario) {
		return formRepository.save(formulario);
	}

	

}
