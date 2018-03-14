package com.server.controllers;




import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.server.entities.Form;
import com.server.entities.Travel;
import com.server.entities.enums.FormStatus;
import com.server.entities.enums.TravelStatus;
import com.server.repositories.TravelRepository;
import com.server.response.Response;
import com.server.services.TravelService;

@RestController
@RequestMapping("/travel")
@CrossOrigin(origins = "*")
public class TravelController {
	
	@Autowired
	private TravelService travelService;

	@Autowired
	private TravelRepository travelRepository;
	
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
		
		Response<Travel> response = this.travelService.checkVehicleAvailable(vehicleId,formId);
		
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
		Response<Travel> response = this.travelService.addRide(ride.getTravelId() , ride.getFormId());
		
		if(response.getErrors().isEmpty()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
							
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@GetMapping("/search")
	public ResponseEntity<Response<Travel>> searchByAttribute(
		@RequestParam(value = "name",             required = false) String name,
		@RequestParam(value = "sector",			  required = false) String sector,
		@RequestParam(value = "status",           required = false) TravelStatus status,
		@RequestParam(value = "requesterSector",  required = false) String requesterSector,
		@RequestParam(value = "vehicle",		  required = false) String vehicle,
		@RequestParam(value = "plate", 			  required = false) String plate,
		@RequestParam(value = "driverName", 	  required = false) String driverName,
		@RequestParam(value = "driverCnh",  	  required = false) String driverCnh,
		@RequestParam(value = "travelDate",       required = false) @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") Date travelDate,
		@RequestParam(value = "returnDate",       required = false) @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") Date returnDate){
	
		
		Response<Travel> response;
		
		response = search(name, sector, status, requesterSector, vehicle, plate, driverName, driverCnh, travelDate,
				returnDate);
				
		return ResponseEntity.ok(response);
	}

	private Response<Travel> search(String name, String sector, TravelStatus status, String requesterSector,
			String vehicle, String plate, String driverName, String driverCnh, Date travelDate, Date returnDate) {
		Response<Travel> response = new Response<Travel>();
		
		if(name != null) {
			response.addList(this.travelRepository.findAllByFormName(name));
		}
		
		if(sector != null) {
			//response.addList(this.travelRepository.findAllByFormSector(sector));
		}
		
		if(status != null) {
			response.addList(this.travelRepository.findAllByStatus(status));
		}
		
		if(requesterSector != null) {
			response.addList(this.travelRepository.findAllByFormRequesterSector(requesterSector));
		}
		
		if(vehicle != null) {
			response.addList(this.travelRepository.findAllByVehicleVehicle(vehicle));
		}
		
		if(plate != null) {
			response.addList(this.travelRepository.findAllByVehiclePlate(plate));
		}
		
		if(driverName != null) {
			response.addList(this.travelRepository.findAllByDriverName(driverName));
		}
		
		if(driverCnh != null) {
			response.addList(this.travelRepository.findAllByDriverCnh(driverCnh));
		}
		
		if(travelDate != null) {
			Date travelDate2 = new Date();
			travelDate2.setTime(travelDate.getTime());
			travelDate.setHours(0);
			travelDate.setMinutes(0);
			travelDate.setSeconds(0);
			travelDate2.setHours(23);
			travelDate2.setMinutes(59);
			travelDate2.setSeconds(59);
			response.addList(this.travelRepository.findAllByTravelDateBetween(travelDate,travelDate2));
		}
		
		if(returnDate != null) {
			Date returnDate2 = new Date();
			returnDate2.setTime(returnDate.getTime());
			returnDate.setHours(0);
			returnDate.setMinutes(0);
			returnDate.setSeconds(0);
			returnDate2.setHours(23);
			returnDate2.setMinutes(59);
			returnDate2.setSeconds(59);
			response.addList(this.travelRepository.findAllByReturnDateBetween(returnDate,returnDate2));
		}
		
		return response;
	}

	
	
	
}
