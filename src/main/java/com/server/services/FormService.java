package com.server.services;

import java.util.Date;
import java.util.List;

import com.server.entities.Form;
import com.server.entities.enums.FormStatus;

public interface FormService {
	
	/**
	 * Return Form by Id.
	 * 
	 * @param Id
	 * @return Form
	 */
	Form findByid(Long Id);
	
	List<Form> searchByRequesterSector(String requesterSector);
	
	List<Form> searchByDestination(String destination);
	
	List<Form> searchByPurpose(String purpose);
	
	List<Form> searchByName(String name);
	
	List<Form> searchByphone(String phone);
	
	List<Form> searchBydeparturePoint(String departurePoint);
	
	List<Form> searchByaddress(String address);
	
	List<Form> searchByflightNumber(String flightNumber);
	
	List<Form> searchByairCompany(String airCompany);
	
	List<Form> searchBytravelOrigin(String travelOrigin);
	
	List<Form> searchBydriverSectorResponsibility(String driverSectorResponsibility);
	
	List<Form> searchByrequestJustification(String requestJustification);
	
	List<Form> searchBystatus(FormStatus status);
	
	
	
	List<Form> searchAllByRequestDate(Date requestDate);
	
	List<Form> searchAllBytravelDate(Date travelDate);
	
	List<Form> searchAllBydepartureHour(Date departureHour);
	
	List<Form> searchAllByreturnDate(Date returnDate);
	
	List<Form> searchAllByreturnHour(Date returnHour);
	
	List<Form> searchAllByarrivalTime(Date arrivalTime);
	
	/**
	 * Return all Form.
	 * 
	 * @param Id
	 * @return List<Form>
	 */
	List<Form> findAll();
	
	/**
	 * Save new Form in database.
	 * 
	 * @param Id
	 * @return List<Form>
	 */
	Form save(Form form);
	
	/**
	 * Delete form by id.
	 * 
	 * @param id
	 * @return
	 */
	void deleteById(Long id);
	
	
	
}
