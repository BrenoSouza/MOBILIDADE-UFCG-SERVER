package com.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.server.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Long>{
	
	//find by id
	Vehicle findById(Long id);
	
}
