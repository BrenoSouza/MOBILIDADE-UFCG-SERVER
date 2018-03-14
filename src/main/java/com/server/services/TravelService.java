package com.server.services;

import java.util.Date;
import java.util.List;

import com.server.entities.Travel;
import com.server.entities.enums.TravelStatus;
import com.server.response.Response;

public interface TravelService {

	Response<Travel> addTravelVehicle(Long idForm,Long idVehicle,Long id_Driver);
	
	List<Travel> getAllTravel();
	
	List<Travel> getAllPublicTravel();
	
	Travel getTravel(Long id);
	
	void deleteTravel(Long id);
	
	Travel setStatus(Long id, TravelStatus Status);
	
	Response<Travel> checkVehicleAvailable(Long vehicleId,Long formId);

	Response<Travel> checkDriverAvailable(Long id,Long formId);
	
	Response<Travel> addRide(Long travelId,Long formId);
	
	
}
