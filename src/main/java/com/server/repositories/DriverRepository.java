package com.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.Driver;

public interface DriverRepository  extends JpaRepository<Driver,Long>{

	//search by id
	Driver findById(Long id);
}
