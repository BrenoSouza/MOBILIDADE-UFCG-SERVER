package com.server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.entities.Driver;
import com.server.response.Response;
import com.server.services.DriverService;


@RestController
@RequestMapping("/driver")
@CrossOrigin(origins = "*")
public class DriverController {

	@Autowired
	private DriverService driverService;
	
	@PostMapping
	public ResponseEntity<Response<Driver>> registerDriver(@RequestBody Driver driver){
		
		// Response Object.
		Response<Driver> response =  new Response<Driver>();
		
		// Save vehicle in the database.
		this.driverService.save(driver);
		
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<Response<Driver>> getAllDriver(){
		
		// Response Object.
		Response<Driver> response =  new Response<Driver>();
		
		List<Driver> driver = this.driverService.findAll();
		
		response.setData(driver);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<Driver>> getDriver(@PathVariable Long id){
		
		// Response Object.
		Response<Driver> response =  new Response<Driver>();
		
		Driver driver = this.driverService.findById(id);
		
		response.setData(driver);
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<Response<Driver>> updateDriver(@PathVariable Long id,@RequestBody Driver driver){
		
		driver.setId(id);
		
		this.driverService.save(driver);
		
		// Response Object.
		Response<Driver> response =  new Response<Driver>();
		
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Response<Driver>> deleteVehicle(@PathVariable Long id){
		
		this.driverService.delete(id);
		
		// Response Object.
		Response<Driver> response =  new Response<Driver>();
		
		
		return ResponseEntity.ok(response);
	}
	
}
