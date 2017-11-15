package com.server.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.entities.Driver;
import com.server.repositories.DriverRepository;
import com.server.services.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Override
	public Driver findById(Long id) {
		return driverRepository.findById(id);
	}

	@Override
	public List<Driver> findAll() {
		return driverRepository.findAll();
	}

	@Override
	public Driver save(Driver driver) {
		return driverRepository.save(driver);
	}

	@Override
	public void delete(Long id) {
		driverRepository.delete(id);

	}

}
