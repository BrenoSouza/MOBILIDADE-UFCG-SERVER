package com.server.services;

import java.util.List;

import com.server.entities.Driver;

public interface DriverService {
	
	/**
	 * Find Driver by id.
	 * @param id
	 * @return
	 */
	Driver findById(Long id);
	
	/**
	 * Find all Driver.
	 * @return All Driver in the database;
	 */
	List<Driver> findAll();
	
	/**
	 * Save Driver in to database.
	 * @param Driver
	 * @return
	 */
	Driver save(Driver driver);
	
	/**
	 * Delete vehicle by id.
	 * @param id
	 */
	void delete(Long id);
}
