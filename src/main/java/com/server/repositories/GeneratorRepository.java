package com.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.RegisterGenerator;

public interface GeneratorRepository extends JpaRepository<RegisterGenerator, Long>{

	RegisterGenerator findTopByOrderByRegisterForm();
	
}
