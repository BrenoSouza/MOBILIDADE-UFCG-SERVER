package com.server.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.entities.Form;
import com.server.repositories.FormRepository;
import com.server.services.FormService;

@Service
public class FormServiceImpl implements FormService {
	
	@Autowired
	private FormRepository formRepository;

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
	public List<Form> searchBystatus(String status) {
		return formRepository.findAllBystatusIgnoreCaseContaining(status);
	}

	@Override
	public List<Form> searchAllByRequestDate(Date requestDate) {
		return formRepository.findAllByrequestDate(requestDate);
	}

	@Override
	public List<Form> searchAllBytravelDate(Date travelDate) {
		return formRepository.findAllBytravelDate(travelDate);
	}
	
	@Override
	public List<Form> searchAllBydepartureHour(Date departureHour) {
		return formRepository.findAllBydepartureHour(departureHour);
	}

	@Override
	public List<Form> searchAllByreturnDate(Date returnDate) {
		return formRepository.findAllByreturnDate(returnDate);
	}

	@Override
	public List<Form> searchAllByreturnHour(Date returnHour) {
		return formRepository.findAllByreturnHour(returnHour);
	}

	@Override
	public List<Form> searchAllByarrivalTime(Date arrivalTime) {
		return formRepository.findAllByarrivalTime(arrivalTime);
	}

}
