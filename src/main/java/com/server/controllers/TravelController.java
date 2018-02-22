package com.server.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.dtos.RideDto;
import com.server.dtos.Traveldto;
import com.server.entities.Travel;
import com.server.response.Response;
import com.server.services.TravelService;

@RestController
@RequestMapping("/travel")
@CrossOrigin(origins = "*")
public class TravelController {
	
	@Autowired
	private TravelService travelService;


	@PostMapping
	public ResponseEntity<Response<Travel>> addTravel( @RequestBody Traveldto travel){
		Response<Travel> response = this.travelService.addTravelVehicle(travel.getFormId(),travel.getVehicle(),travel.getDriver());
		
		if(response.getErrors().isEmpty()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
							
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@GetMapping("/check_vehicle")
	public ResponseEntity<Response<Travel>> checkVehicleAvailable(
			@RequestParam(value = "vehcile_id",required = true) Long vehicleId,
			@RequestParam(value = "form_id",required = true) Long formId){
		
		Response<Travel> response = this.travelService.checkVehicleAvailable(vehicleId,formId,false);
		
		if(response.getErrors().isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
							
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@GetMapping("/check_driver")
	public ResponseEntity<Response<Travel>> checkDriverAvailable(
			@RequestParam(value = "driver_id",    required = true) Long driverId,
			@RequestParam(value = "form_id",      required = true) Long formId){
		
		Response<Travel> response = this.travelService.checkDriverAvailable(driverId,formId);
		
		if(response.getErrors().isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@GetMapping
	public ResponseEntity<Response<Travel>> getAllTravel(){
		Response<Travel> response = new Response<Travel>();
		
		response.setData(travelService.getAllTravel());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<Travel>> getTravel(@PathVariable Long id){
		Response<Travel> response = new Response<Travel>();
		
		response.addData(this.travelService.getTravel(id));		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<Travel>> deleteTravel(@PathVariable Long id){
		Response<Travel> response = new Response<Travel>();
		
		this.travelService.deleteTravel(id);		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PostMapping("/ride")
	public ResponseEntity<Response<Travel>> addRide( @RequestBody RideDto ride){
		Response<Travel> response = this.travelService.addRide(ride.getTarvelId() , ride.getFormId());
		
		if(response.getErrors().isEmpty()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
							
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	
}
