package com.server.services;

import java.util.List;

import com.server.entities.Form;

public interface FormService {
	
	/**
	 * Return Form by Id
	 * 
	 * @param Id
	 * @return Form
	 */
	Form findByid(Long Id);
	
	/**
	 * Return all Form
	 * 
	 * @param Id
	 * @return List<Form>
	 */
	List<Form> findAll();
	
	/**
	 * Save new Form in database
	 * 
	 * @param Id
	 * @return List<Form>
	 */
	Form persistir(Form formulario);
}
