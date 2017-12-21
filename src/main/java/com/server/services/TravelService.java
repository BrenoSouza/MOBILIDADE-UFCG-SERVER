package com.server.services;

import java.util.Date;
import java.util.List;

import org.springframework.validation.BindingResult;

import com.server.entities.Travel;
import com.server.entities.enums.TravelStatus;

public interface TravelService {

	Travel addTravelVehicle(Long idForm,Long idVehicle,Long id_Driver,BindingResult result);
	
	List<Travel> getAllTravel();
	
	Travel getTravel(Long id);
	
	void deleteTravel(Long id);
	
	Travel setStatus(Long id, TravelStatus Status);
	
	Boolean checkVehicleAvailable(Long id,Date after,Date before);
	
	Boolean checkDriverAvailable(Long id,Date after,Date before);
}
