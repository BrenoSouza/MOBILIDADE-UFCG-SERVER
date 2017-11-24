package com.server.controllers;


import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.dtos.FormDto;
import com.server.entities.Form;
import com.server.services.FormService;
import com.server.response.Response;

@RestController
@RequestMapping("form")
@CrossOrigin(origins = "*")
public class FormController {

	@Autowired
	private FormService formService;
	
	
	
	@PostMapping
	public ResponseEntity<Response<Form>> register(@RequestBody Form form,
		BindingResult result)throws NoSuchAlgorithmException, ParseException {
		
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		//Date date = formatter.parse("2000-11-11");
		Date date = new Date();
		form.setRequestDate(date);
		// Response object.
		Response<Form> response = new Response<Form>();	
		
		// Save form in the database.
		this.formService.save(form);
		
		// Add success message to response object.
		response.addSuccessMessage("Cadastro realizado com sucesso.");
		
		return ResponseEntity.ok(response);

	}
	
	@GetMapping
	public ResponseEntity<Response<Form>> getAllForm(){
		
		// Response object.
		Response<Form> response =  new Response<Form>();
		
		// Getting all form in database and push in response object.
		response.setData(formService.findAll());
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<Form>> getFormById(@PathVariable("id") Long id){
		
		// Response object.
		Response<Form> response =  new Response<Form>();
		
		// Getting form id in the database.
		Form form = formService.findByid(id);
		
		// Add form to the object response.
		response.setData(form);
		
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response<Form>> updateForm(@PathVariable("id") Long id, @RequestBody Form updateForm){
		
		// Update id form.
		updateForm.setId(id);
		
		// Response object.
		Response<Form> response = new Response<Form>();
				
		// Update form in database.
		formService.save(updateForm);	
		
		// Add success message to response object.
		response.addSuccessMessage("atualização realizada com sucesso");
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<Form>> deleteForm(@PathVariable("id") Long id){
		
		// Response object.
		Response<Form> response = new Response<Form>();
		
		// Delete form object to the database.
		formService.deleteById(id);
		
		
		return ResponseEntity.ok(response);
	}
	
}
