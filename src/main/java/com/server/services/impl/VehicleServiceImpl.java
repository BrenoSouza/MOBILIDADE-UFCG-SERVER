package com.server.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.entities.Form;
import com.server.entities.Travel;
import com.server.entities.Vehicle;
import com.server.repositories.FormRepository;
import com.server.repositories.TravelRepository;
import com.server.repositories.VehicleRepository;
import com.server.response.Response;
import com.server.services.TravelService;
import com.server.services.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private TravelRepository travelRepository;
	
	@Autowired
	private TravelService travelService;
	
	@Override
	public Vehicle findById(Long id) {
		return vehicleRepository.findById(id);
	}

	@Override
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	@Override
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public void delete(Long id) {
		vehicleRepository.delete(id);

	}

	@Override
	public Response<Travel> getAllTravelOfVehicleInDay(Long vehicleId, Date travelDate) {
		Vehicle vehicle= this.vehicleRepository.getOne(vehicleId);
		
		Date travelDate2 = new Date();
		travelDate2.setTime(travelDate.getTime());
		travelDate.setHours(0);
		travelDate.setMinutes(0);
		travelDate.setSeconds(0);
		travelDate2.setHours(23);
		travelDate2.setMinutes(59);
		travelDate2.setSeconds(59);
		
		
		Response<Travel> response =  new Response<Travel>();
		List<Travel> list = this.travelRepository.findAllByVehicleAndTravelDateBetween(vehicle, travelDate, travelDate2);
		response.setData(list);
		return response; 
	}

	@Override
	public Response<Vehicle> getAllVehicleAvailableInInterval(Long formId) {
		List<Vehicle> vehicleList = this.vehicleRepository.findAll();
		List<Vehicle> vehicleAvailable = new ArrayList<Vehicle>();
		
		for (int i = 0; i < vehicleList.size(); i++) {
			if(this.travelService.checkVehicleAvailable(vehicleList.get(i).getId(), formId, false).getData().isEmpty()) {
				vehicleAvailable.add(vehicleList.get(i));
			}
		}
		
		Response<Vehicle> response =  new Response<Vehicle>();
		response.addList(vehicleAvailable);
		
		return response;
	}

	@Override
	public Response<Vehicle> getAllVehicleUnavailableInDate(Date travelDate) {
		
		Date travelDate2 = new Date();
		travelDate2.setTime(travelDate.getTime());
		travelDate.setHours(0);
		travelDate.setMinutes(0);
		travelDate.setSeconds(0);
		travelDate2.setHours(23);
		travelDate2.setMinutes(59);
		travelDate2.setSeconds(59);
		
		Response<Vehicle> response = new Response<Vehicle>();
		
		List<Travel> list = this.travelRepository.findAllByTravelDateBetween(travelDate, travelDate2);
		
		for (int i = 0; i < list.size(); i++) {
			response.addData(list.get(i).getVehicle());
		}
		 return response;
	}
	
	
}
