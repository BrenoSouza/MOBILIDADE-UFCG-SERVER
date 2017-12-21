package com.server.controllers;


import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.dtos.Traveldto;
import com.server.entities.Travel;
import com.server.response.Response;
import com.server.services.TravelService;

@RestController
@RequestMapping("/travel")
@CrossOrigin(origins = "*")
public class TravelController {
	
	@Autowired
	private TravelService travelSerive;


	@PostMapping
	public ResponseEntity<Response<Travel>> addTravel(@Valid @RequestBody Traveldto travel , BindingResult result){
		Response<Travel> response = new Response<Travel>();
		
		response.setData(this.travelSerive.addTravelVehicle(travel.getFormId(),travel.getVehicle(),travel.getDriver(), result));
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.addErrorMessage(error.getDefaultMessage()));
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/check_vehicle")
	public Response<Boolean> checkVehicleAvailable(
			@RequestParam(value = "vehcile_id",      required = false) Long vehicleId,
			@RequestParam(value = "after",      required = false) @DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss") Date after,
			@RequestParam(value = "before",      required = false) @DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss") Date before){
		Response<Boolean> response = new Response<Boolean>();
		
		response.setData(this.travelSerive.checkVehicleAvailable(vehicleId, after, before));
		return response;
	}
	
	@GetMapping("/check_driver")
	public Response<Boolean> checkDriverAvailable(
			@RequestParam(value = "driver_id",      required = false) Long driverId,
			@RequestParam(value = "after",      required = false) @DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss") Date after,
			@RequestParam(value = "before",      required = false) @DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss") Date before){
		Response<Boolean> response = new Response<Boolean>();
		
		response.setData(this.travelSerive.checkDriverAvailable(driverId, after, before));
		return response;
	}
	
	@GetMapping
	public ResponseEntity<Response<Travel>> getAllTravel(){
		Response<Travel> response = new Response<Travel>();
		
		response.setData(travelSerive.getAllTravel());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<Travel>> getTravel(@PathVariable Long id){
		Response<Travel> response = new Response<Travel>();
		
		response.setData(this.travelSerive.getTravel(id));		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<Travel>> deleteTravel(@PathVariable Long id){
		Response<Travel> response = new Response<Travel>();
		
		this.travelSerive.deleteTravel(id);		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
