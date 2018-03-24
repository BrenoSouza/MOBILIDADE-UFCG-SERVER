package com.server.services;

import java.util.Date;
import java.util.List;

import com.server.entities.Travel;
import com.server.entities.Vehicle;
import com.server.response.Response;

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
	
	Response<Travel> getAllTravelOfVehicleInDay(Long vehicleId,Date travelDate);
	
	Response<Vehicle> getAllVehicleAvailableInInterval(Long formId);
	
	Response<Vehicle> getAllVehicleUnavailableInDate(Date travelDate);
	
	
}
