package com.server.controllers;


import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.entities.Form;
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
		BindingResult result)throws NoSuchAlgorithmException, ParseException {
		
		// Response object.
		Response<Form> response = new Response<Form>();
		
		// Save form in the database.
		this.formService.save(form);
		
		// Add success message to response object.
		response.addSuccessMessage("Cadastro realizado com sucesso.");
		
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
		response.setData(form);
		
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
		
		// Add success message to response object.
		response.addSuccessMessage("atualização realizada com sucesso");
		
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
		@RequestParam(value = "name",             required = false,defaultValue = "¨") String name,
		@RequestParam(value = "sector",			  required = false,defaultValue = "¨") String sector,
		@RequestParam(value = "destination",      required = false,defaultValue = "¨") String destination,
		@RequestParam(value = "purpose",          required = false,defaultValue = "¨") String purpose,
		@RequestParam(value = "phone",            required = false,defaultValue = "¨") String phone,
		@RequestParam(value = "departurePoint",   required = false,defaultValue = "¨") String departurePoint,
		@RequestParam(value = "address",          required = false,defaultValue = "¨") String address,
		@RequestParam(value = "flightNumber",     required = false,defaultValue = "¨") String flightNumber,
		@RequestParam(value = "airCompany", 	  required = false,defaultValue = "¨") String airCompany,
		@RequestParam(value = "travelOrigin", 	  required = false,defaultValue = "¨") String travelOrigin,
		@RequestParam(value = "driverResponsible",required = false,defaultValue = "¨") String driverResponsible,
		@RequestParam(value = "justification",    required = false,defaultValue = "¨") String justification,
		@RequestParam(value = "status",           required = false,defaultValue = "¨") String status,
		@RequestParam(value = "requestDate",      required = false,defaultValue = "date") @DateTimeFormat(pattern="yyyy-MM-dd") Date requestDate,
		@RequestParam(value = "travelDate",       required = false,defaultValue = "date") @DateTimeFormat(pattern="yyyy-MM-dd") Date travelDate,
		@RequestParam(value = "departureHour",    required = false,defaultValue = "date") @DateTimeFormat(pattern="yyyy-MM-dd") Date departureHour,
		@RequestParam(value = "returnDate",       required = false,defaultValue = "date") @DateTimeFormat(pattern="yyyy-MM-dd") Date returnDate,
		@RequestParam(value = "returnHour",       required = false,defaultValue = "date") @DateTimeFormat(pattern="yyyy-MM-dd") Date returnHour,
		@RequestParam(value = "arrivalTime",      required = false,defaultValue = "date") @DateTimeFormat(pattern="yyyy-MM-dd") Date arrivalTime){
		Response<Form> response = new Response<Form>();
		
		response.setData(this.formService.searchByName(name));
		response.setData(this.formService.searchByRequesterSector(sector));
		response.setData(this.formService.searchByDestination(destination));
		response.setData(this.formService.searchByPurpose(purpose));
		response.setData(this.formService.searchByphone(phone));
		response.setData(this.formService.searchBydeparturePoint(departurePoint));
		response.setData(this.formService.searchByaddress(address));
		response.setData(this.formService.searchByflightNumber(flightNumber));
		response.setData(this.formService.searchByairCompany(airCompany));
		response.setData(this.formService.searchBytravelOrigin(travelOrigin));
		response.setData(this.formService.searchBydriverSectorResponsibility(driverResponsible));
		response.setData(this.formService.searchByrequestJustification(justification));
		response.setData(this.formService.searchBystatus(status));
		response.setData(this.formService.searchAllByRequestDate(requestDate));
		response.setData(this.formService.searchAllBytravelDate(travelDate));
		response.setData(this.formService.searchAllBydepartureHour(departureHour));
		response.setData(this.formService.searchAllByreturnDate(returnDate));
		response.setData(this.formService.searchAllByreturnHour(returnHour));
		response.setData(this.formService.searchAllByarrivalTime(arrivalTime));
				
		
		return ResponseEntity.ok(response);
	}
	
	
	@InitBinder
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
	}
	
}
