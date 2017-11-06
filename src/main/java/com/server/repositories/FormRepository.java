package com.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.Form;

public interface FormRepository extends JpaRepository<Form, Long>{
	
	//busca por Id
	Form findByid(Long Id);	

}
