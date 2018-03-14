package com.server.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.Driver;
import com.server.entities.Travel;
import com.server.entities.Vehicle;
import com.server.entities.enums.TravelStatus;

public interface TravelRepository extends JpaRepository<Travel, Long> {
	
	List<Travel> findAllByTravelDateAfter(Date after);	
	
	List<Travel> findAllByReturnDateAfter(Date after);	
	
	List<Travel> findAllByStatusAndVehicle(TravelStatus status,Vehicle vehicle);
	
	List<Travel> findAllByStatusAndDriver(TravelStatus status,Driver driver);
	
	List<Travel> findAllByStatus(TravelStatus status);
	
	List<Travel> findAllByVehicleAndTravelDateBetween(Vehicle vehicle, Date before,Date after);
	
	List<Travel> findAllByTravelDateBetween(Date before,Date after);
	
	List<Travel> findAllByReturnDateBetween(Date before,Date after);
	
	// search vehicle
	List<Travel> findAllByVehicleVehicle(String vehicle);
	List<Travel> findAllByVehiclePlate(String plate);
	
	// search drive
	List<Travel> findAllByDriverName(String name);
	List<Travel> findAllByDriverCnh(String cnh);
	
	//seach form
	List<Travel> findAllByFormName(String name);
	//List<Travel> findAllByFormSector(String sector);
	List<Travel> findAllByFormRequesterSector(String requesterSector);
	
}
