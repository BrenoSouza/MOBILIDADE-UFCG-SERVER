package com.server.services;

import java.util.Date;
import java.util.List;

import com.server.entities.Travel;
import com.server.entities.enums.TravelStatus;
import com.server.response.Response;

public interface TravelService {

	Response<List<Travel>> addTravelVehicle(Long idForm,Long idVehicle,Long id_Driver);
	
	List<Travel> getAllTravel();
	
	Travel getTravel(Long id);
	
	void deleteTravel(Long id);
	
	Travel setStatus(Long id, TravelStatus Status);
	
	Response<List<Travel>> checkVehicleAvailable(Long vehicleId,Long formId);

	Response<List<Travel>> checkDriverAvailable(Long id,Long formId);
	
	Response<List<Travel>> getAllTravelVehicle(Long vehicleId,Date date);
}
