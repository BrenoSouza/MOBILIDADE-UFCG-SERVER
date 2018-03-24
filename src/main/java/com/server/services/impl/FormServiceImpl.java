package com.server.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.entities.Form;
import com.server.entities.enums.FormStatus;
import com.server.repositories.FormRepository;
import com.server.services.FormService;
import com.server.services.GeneratorService;

@Service
public class FormServiceImpl implements FormService {
	
	@Autowired
	private FormRepository formRepository;
	
	@Autowired
	private GeneratorService generatorService;

	@Override
	public Form findByid(Long id) {
		return formRepository.findByid(id);
	}

	@Override
	public List<Form> findAll() {
		return formRepository.findAll();
	}

	@Override
	public Form save(Form formulario) {
		formulario.setRegister(this.generatorService.getRegisterForm());
		return formRepository.save(formulario);
	}

	@Override
	public void deleteById(Long id) {
		formRepository.deleteById(id);
	}

	@Override
	public List<Form> searchByRequesterSector(String requesterSector) {
		return formRepository.findAllByRequesterSectorIgnoreCaseContaining(requesterSector); 
	}

	@Override
	public List<Form> searchByDestination(String destination) {
		return formRepository.findAllByDestinationIgnoreCaseContaining(destination);
	}

	@Override
	public List<Form> searchByPurpose(String purpose) {
		return formRepository.findAllByPurposeIgnoreCaseContaining(purpose);
	}

	@Override
	public List<Form> searchByName(String name) {
		return formRepository.findAllByNameIgnoreCaseContaining(name);
	}

	@Override
	public List<Form> searchByphone(String phone) {
		return formRepository.findAllByphoneIgnoreCaseContaining(phone);
	}

	@Override
	public List<Form> searchBydeparturePoint(String departurePoint) {
		return formRepository.findAllBydeparturePointIgnoreCaseContaining(departurePoint);
	}

	@Override
	public List<Form> searchByaddress(String address) {
		return formRepository.findAllByaddressIgnoreCaseContaining(address);
	}

	@Override
	public List<Form> searchByflightNumber(String flightNumber) {
		return formRepository.findAllByflightNumberIgnoreCaseContaining(flightNumber);
	}

	@Override
	public List<Form> searchByairCompany(String airCompany) {
		return formRepository.findAllByairCompanyIgnoreCaseContaining(airCompany);
	}

	@Override
	public List<Form> searchBytravelOrigin(String travelOrigin) {
		return formRepository.findAllBytravelOriginIgnoreCaseContaining(travelOrigin);
	}

	@Override
	public List<Form> searchBydriverSectorResponsibility(String driverSectorResponsibility) {
		return formRepository.findAllBydriverSectorResponsibilityIgnoreCaseContaining(driverSectorResponsibility);
	}

	@Override
	public List<Form> searchByrequestJustification(String requestJustification) {
		return formRepository.findAllByrequestJustificationIgnoreCaseContaining(requestJustification);
	}

	@Override
	public List<Form> searchBystatus(FormStatus status) {
		return formRepository.findAllByStatus(status);
	}

	@Override
	public List<Form> searchAllByRequestDate(Date requestDate) {
		Date requestDate2 = new Date();
		requestDate2.setTime(requestDate.getTime());
		requestDate.setHours(0);
		requestDate.setMinutes(0);
		requestDate.setSeconds(0);
		requestDate2.setHours(23);
		requestDate2.setMinutes(59);
		requestDate2.setSeconds(59);
		return formRepository.findAllByrequestDateBetween(requestDate,requestDate2);
	}

	@Override
	public List<Form> searchAllBytravelDate(Date travelDate) {
		Date travelDate2 = new Date();
		travelDate2.setTime(travelDate.getTime());
		travelDate.setHours(0);
		travelDate.setMinutes(0);
		travelDate.setSeconds(0);
		travelDate2.setHours(23);
		travelDate2.setMinutes(59);
		travelDate2.setSeconds(59);
		return formRepository.findAllBytravelDateBetween(travelDate,travelDate2);
	}
	
	@Override
	public List<Form> searchAllBydepartureHour(Date departureHour) {
		Date departureHour2 = new Date();
		departureHour2.setTime(departureHour.getTime());
		departureHour.setHours(0);
		departureHour.setMinutes(0);
		departureHour.setSeconds(0);
		departureHour2.setHours(23);
		departureHour2.setMinutes(59);
		departureHour2.setSeconds(59);
		return formRepository.findAllBydepartureHourBetween(departureHour,departureHour2);
	}

	@Override
	public List<Form> searchAllByreturnDate(Date returnDate) {
		Date returnDate2 = new Date();
		returnDate2.setTime(returnDate.getTime());
		returnDate.setHours(0);
		returnDate.setMinutes(0);
		returnDate.setSeconds(0);
		returnDate2.setHours(23);
		returnDate2.setMinutes(59);
		returnDate2.setSeconds(59);
		return formRepository.findAllByreturnDateBetween(returnDate,returnDate2);
	}

	@Override
	public List<Form> searchAllByreturnHour(Date returnHour) {
		Date returnHour2 = new Date();
		returnHour2.setTime(returnHour.getTime());
		returnHour.setHours(0);
		returnHour.setMinutes(0);
		returnHour.setSeconds(0);
		returnHour2.setHours(23);
		returnHour2.setMinutes(59);
		returnHour2.setSeconds(59);
		return formRepository.findAllByreturnHourBetween(returnHour,returnHour2);
	}

	@Override
	public List<Form> searchAllByarrivalTime(Date arrivalTime) {
		Date arrivalTime2 = new Date();
		arrivalTime2.setTime(arrivalTime.getTime());
		arrivalTime.setHours(0);
		arrivalTime.setMinutes(0);
		arrivalTime.setSeconds(0);
		arrivalTime2.setHours(23);
		arrivalTime2.setMinutes(59);
		arrivalTime2.setSeconds(59);
		return formRepository.findAllByarrivalTimeBetween(arrivalTime,arrivalTime2);
	}

}
