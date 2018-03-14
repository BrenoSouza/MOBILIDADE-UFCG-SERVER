package com.server.controllers;



import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.dtos.JustificationDenielDto;
import com.server.entities.Form;
import com.server.entities.enums.FormStatus;
import com.server.services.FormService;
import com.server.response.Response;

@RestController
@RequestMapping("form")
@CrossOrigin(origins = "*")
public class FormController {

	@Autowired
	private FormService formService;
	
	
	@PostMapping
	public ResponseEntity<Response<Form>> register(@RequestBody Form form,
		BindingResult result){
		
		// Response object.
		Response<Form> response = new Response<Form>();
		
		form.setStatus(FormStatus.WAITING);//set waiting status
		form.setRide(false);
		
		// Save form in the database.
		response.addData(this.formService.save(form));
		
		return ResponseEntity.ok(response);

	}
	
	@GetMapping
	public ResponseEntity<Response<Form>> getAllForm(){
		
		// Response object.
		Response<Form> response =  new Response<Form>();
		
		// Getting all form in database and push in response object.
		response.setData(formService.findAll());
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<Form>> getFormById(@PathVariable("id") Long id){
		
		// Response object.
		Response<Form> response =  new Response<Form>();
		
		// Getting form id in the database.
		Form form = formService.findByid(id);
		
		// Add form to the object response.
		response.addData(form);
		
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response<Form>> updateForm(@PathVariable("id") Long id, @RequestBody Form updateForm){
		
		// Update id form.
		updateForm.setId(id);
		
		// Response object.
		Response<Form> response = new Response<Form>();
				
		// Update form in database.
		formService.save(updateForm);	
		
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("denied/{id}")
	public ResponseEntity<Response<Form>> updateFormStatus(@PathVariable("id") Long id, @RequestBody JustificationDenielDto message){
		
		//sdffsdf
		Form updateForm = formService.findByid(id);
		if(updateForm.getStatus() == FormStatus.DENIED) {
			updateForm.setStatus(FormStatus.WAITING);
			updateForm.setJustificationDeniel(null);
		}else {
			updateForm.setStatus(FormStatus.DENIED);
			updateForm.setJustificationDeniel(message.getJustificationDeniel());
		}
		
		
		// Response object.
		Response<Form> response = new Response<Form>();
				
		// Update form in database.
		formService.save(updateForm);	
		
		
		return ResponseEntity.ok(response);
	}
			
			
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<Form>> deleteForm(@PathVariable("id") Long id){
		
		// Response object.
		Response<Form> response = new Response<Form>();
		
		// Delete form object to the database.
		formService.deleteById(id);
		
		
		return ResponseEntity.ok(response);
	}
	
	//-------------------------SEARCH-CONTROLLERS---------------------------------
	
	
	
	@GetMapping("/search")
	public ResponseEntity<Response<Form>> searchByAttribute(
		@RequestParam(value = "name",             required = false) String name,
		@RequestParam(value = "sector",			  required = false) String sector,
		@RequestParam(value = "destination",      required = false) String destination,
		@RequestParam(value = "purpose",          required = false) String purpose,
		@RequestParam(value = "phone",            required = false) String phone,
		@RequestParam(value = "departurePoint",   required = false) String departurePoint,
		@RequestParam(value = "address",          required = false) String address,
		@RequestParam(value = "flightNumber",     required = false) String flightNumber,
		@RequestParam(value = "airCompany", 	  required = false) String airCompany,
		@RequestParam(value = "travelOrigin", 	  required = false) String travelOrigin,
		@RequestParam(value = "driverResponsible",required = false) String driverResponsible,
		@RequestParam(value = "justification",    required = false) String justification,
		@RequestParam(value = "status",           required = false) FormStatus status,
		@RequestParam(value = "requesterSector",  required = false) String requesterSector,
		@RequestParam(value = "requestDate",      required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date requestDate,
		@RequestParam(value = "travelDate",       required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date travelDate,
		@RequestParam(value = "departureHour",    required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date departureHour,
		@RequestParam(value = "returnDate",       required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date returnDate,
		@RequestParam(value = "returnHour",       required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date returnHour,
		@RequestParam(value = "arrivalTime",      required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date arrivalTime){
	
		
		Response<Form> response;
		
		response = search(name, sector, destination, purpose, phone, departurePoint, address, flightNumber, airCompany,
				travelOrigin, driverResponsible, justification, status, requestDate, travelDate, departureHour,
				returnDate, returnHour, arrivalTime,requesterSector);
				
		return ResponseEntity.ok(response);
	}

	private Response<Form> search(String name, String sector, String destination, String purpose, String phone,
			String departurePoint, String address, String flightNumber, String airCompany, String travelOrigin,
			String driverResponsible, String justification, FormStatus status, Date requestDate, Date travelDate,
			Date departureHour, Date returnDate, Date returnHour, Date arrivalTime,String requesterSector) {
		Response<Form> response = new Response<Form>();
		
		if(name != null) {
			response.setData(this.formService.searchByName(name));
		}		
		if(sector != null) {
			response.setData(this.formService.searchByRequesterSector(sector));
		}		
		if(destination != null) {
			response.setData(this.formService.searchByDestination(destination));
		}
		if(purpose != null) {
			response.setData(this.formService.searchByPurpose(purpose));
		}
		if(phone != null) {
			response.setData(this.formService.searchByphone(phone));
		}
		if(departurePoint != null) {
			response.setData(this.formService.searchBydeparturePoint(departurePoint));
		}
		if(address != null) {
			response.setData(this.formService.searchByaddress(address));
		}
		if(flightNumber != null) {
			response.setData(this.formService.searchByflightNumber(flightNumber));
		}
		if(airCompany != null) {
			response.setData(this.formService.searchByairCompany(airCompany));
		}
		if(travelOrigin != null) {
			response.setData(this.formService.searchBytravelOrigin(travelOrigin));
		}
		if(driverResponsible != null) {
			response.setData(this.formService.searchBydriverSectorResponsibility(driverResponsible));
		}
		if(justification != null) {
			response.setData(this.formService.searchByrequestJustification(justification));
		}
		if(status != null) {
			response.setData(this.formService.searchBystatus(status));
		}
		if(requestDate != null) {
			response.setData(this.formService.searchAllByRequestDate(requestDate));
		}
		if(travelDate != null) {
			response.setData(this.formService.searchAllBytravelDate(travelDate));
		}
		if(departureHour != null) {
			//response.setData(this.formService.searchAllBydepartureHour(departureHour));
		}
		if(returnDate != null) {
			response.setData(this.formService.searchAllByreturnDate(returnDate));
		}
		if(returnHour != null) {
			//response.setData(this.formService.searchAllByreturnHour(returnHour));
		}
		if(arrivalTime != null) {
			response.setData(this.formService.searchAllByarrivalTime(arrivalTime));
		}
		if(requesterSector != null) {
			response.setData(this.formService.searchByRequesterSector(requesterSector));
		}
		return response;
	}
	
	
	/*@InitBinder
	public void initBinder(WebDataBinder binder) throws Exception {
	    final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    final CustomDateEditor dateEditor = new CustomDateEditor(formatter, true) {
	        @Override
	        public void setAsText(String text) throws IllegalArgumentException {
	            if ("date".equals(text)) {
	                try {
						setValue(formatter.parse("000-00-00"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            } else {
	                super.setAsText(text);
	            }
	        }
	    };
	    binder.registerCustomEditor(Date.class, dateEditor);
	}*/
	
}
