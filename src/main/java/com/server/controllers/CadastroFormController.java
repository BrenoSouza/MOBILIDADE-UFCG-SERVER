package com.server.controllers;



import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.dtos.FormDto;
import com.server.entities.Form;
import com.server.services.FormService;
import com.server.services.impl.FormServiceImpl;
import com.server.response.Response;



@RestController
@RequestMapping("form")
@CrossOrigin(origins = "*")
public class CadastroFormController {

	@Autowired
	private FormService formService;
	
	@PostMapping
	public ResponseEntity<Response<Form>> cadastrar(@RequestBody Form formulario,
		BindingResult result)throws NoSuchAlgorithmException {
		
		Response<Form> response = new Response<Form>();		
		System.out.println(formulario.getDataRequisição() + formulario.getNome());

		this.formService.persistir(formulario);
		
		return ResponseEntity.ok(response);

	}
	


	
}
