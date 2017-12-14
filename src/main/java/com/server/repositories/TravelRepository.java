package com.server.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.Travel;
import com.server.entities.Vehicle;

public interface TravelRepository extends JpaRepository<Travel, Long> {
	
	List<Travel> findAllByTravelDateAfter(Date after);	
	
	List<Travel> findAllByReturnDateAfter(Date after);	
	
	//List<Travel> findAllByVehicle(Vehicle vehicle);
	
	//List<Travel> findAllByVehicleAndTravelDateAfterAndReturnDateBefore(Vehicle vehicle,Date after,Date before);	

}
