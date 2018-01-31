package com.server.services;

import java.util.Date;
import java.util.List;

import org.springframework.validation.BindingResult;

import com.server.entities.Travel;
import com.server.entities.enums.TravelStatus;
import com.server.response.Response;

public interface TravelService {

	Response<List<Travel>> addTravelVehicle(Long idForm,Long idVehicle,Long id_Driver);
	
	List<Travel> getAllTravel();
	
	Travel getTravel(Long id);
	
	void deleteTravel(Long id);
	
	Travel setStatus(Long id, TravelStatus Status);
	
	Boolean checkVehicleIsAvailable(Long id, Date after, Date before);
	
	Boolean checkDriverIsAvailable(Long id, Date after, Date before);
	
	Response<List<Travel>> checkVehicleAvailable(Long vehicleId,Long formId);

	Response<List<Travel>> checkDriverAvailable(Long id,Long formId);
}
