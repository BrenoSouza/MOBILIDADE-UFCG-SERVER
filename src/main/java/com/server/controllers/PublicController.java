package com.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.entities.Travel;
import com.server.response.Response;
import com.server.services.TravelService;

@RestController
@RequestMapping("public")
@CrossOrigin("*")
public class PublicController {

	@Autowired
	private TravelService travelService;
	
	
	@GetMapping
	public ResponseEntity<Response<Travel>> getAllTravel(){
	
	Response<Travel> response = new Response<Travel>();
	
	response.addList(travelService.getAllPublicTravel());
	
	return ResponseEntity.ok().body(response);
	
	}
	
	
	
}
