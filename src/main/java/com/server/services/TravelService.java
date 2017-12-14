package com.server.services;

import java.util.Date;
import java.util.List;

import org.springframework.validation.BindingResult;

import com.server.entities.Travel;

public interface TravelService {

	Travel addTravel(Long idForm,Long idVehicle,BindingResult result);
	
	List<Travel> getAllTravel();
	
	Travel getTravel(Long id);
	
	void deleteTravel(Long id);
	
	Travel setStatus(Long id, String Status);
	
	Boolean checkVehicleAvailable(Long id,Date after,Date before);
}
