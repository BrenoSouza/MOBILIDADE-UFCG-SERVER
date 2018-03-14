package com.server.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.entities.Form;
import com.server.entities.Travel;
import com.server.entities.Vehicle;
import com.server.entities.enums.FormStatus;
import com.server.repositories.TravelRepository;
import com.server.response.Response;
import com.server.services.TravelService;
import com.server.services.VehicleService;

@RestController
@RequestMapping("public")
@CrossOrigin("*")
public class PublicController {

	@Autowired
	private TravelService travelService;
	
	@Autowired
	private VehicleService vehicleService;
		
	@GetMapping("travel")
	public ResponseEntity<Response<Travel>> getAllTravel(){
	
	Response<Travel> response = new Response<Travel>();
	
	response.addList(travelService.getAllPublicTravel());
	
	return ResponseEntity.ok().body(response);
	
	}
	
	@GetMapping("Travel")
	public ResponseEntity<Response<Vehicle>> getAllVehicle(){
	
	Response<Vehicle> response = new Response<Vehicle>();
	
	response.addList(vehicleService.findAll());
	
	return ResponseEntity.ok().body(response);
	
	}
	
}
