package com.server.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.entities.Vehicle;
import com.server.repositories.VehicleRepository;
import com.server.services.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehiclerepository;
	
	@Override
	public Vehicle findById(Long id) {
		return vehiclerepository.findById(id);
	}

	@Override
	public List<Vehicle> findAll() {
		return vehiclerepository.findAll();
	}

	@Override
	public Vehicle save(Vehicle vehicle) {
		return vehiclerepository.save(vehicle);
	}

	@Override
	public void delete(Long id) {
		vehiclerepository.delete(id);

	}

}
