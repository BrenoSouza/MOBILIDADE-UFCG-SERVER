package com.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.server.entities.Form;

public interface FormRepository extends JpaRepository<Form, Long>{
	
	//busca por Id
	Form findByid(Long Id);	
	
	@Transactional
    void deleteById(Long id);
}
