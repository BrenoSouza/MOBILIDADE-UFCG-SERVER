package com.server.services;

import java.util.List;

import com.server.entities.Vehicle;

public interface VehicleService {

	/**
	 * Find vehicle by id.
	 * @param id
	 * @return
	 */
	Vehicle findById(Long id);
	
	/**
	 * Find all vehicle.
	 * @return All vehicle in the database;
	 */
	List<Vehicle> findAll();
	
	/**
	 * Save vehicle in to database.
	 * @param vehicle
	 * @return
	 */
	Vehicle save(Vehicle vehicle);
	
	/**
	 * Delete vehicle by id.
	 * @param id
	 */
	void delete(Long id);
	
	
}
