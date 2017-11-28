package com.server.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.server.entities.Form;

public interface FormRepository extends JpaRepository<Form, Long>{
	
	//busca por Id
	Form findByid(Long Id);	
	
	List<Form> findAllByRequesterSectorIgnoreCaseContaining(String requesterSector);
	
	List<Form> findAllByDestinationIgnoreCaseContaining(String destination);
	
	List<Form> findAllByPurposeIgnoreCaseContaining(String purpose);
	
	List<Form> findAllByNameIgnoreCaseContaining(String name);
	
	List<Form> findAllByphoneIgnoreCaseContaining(String phone);
	
	List<Form> findAllBydeparturePointIgnoreCaseContaining(String departurePoint);
	
	List<Form> findAllByaddressIgnoreCaseContaining(String address);
	
	List<Form> findAllByflightNumberIgnoreCaseContaining(String flightNumber);
	
	List<Form> findAllByairCompanyIgnoreCaseContaining(String airCompany);
	
	List<Form> findAllBytravelOriginIgnoreCaseContaining(String travelOrigin);
	
	List<Form> findAllBydriverSectorResponsibilityIgnoreCaseContaining(String driverSectorResponsibility);
	
	List<Form> findAllByrequestJustificationIgnoreCaseContaining(String requestJustification);
	
	List<Form> findAllBystatusIgnoreCaseContaining(String status);
	
	
	
	List<Form> findAllByrequestDate(Date requestDate);
	
	List<Form> findAllBytravelDate(Date travelDate);
	
	List<Form> findAllBydepartureHour(Date departureHour);
	
	List<Form> findAllByreturnDate(Date returnDate);
	
	List<Form> findAllByreturnHour(Date returnHour);
	
	List<Form> findAllByarrivalTime(Date arrivalTime);
	
	@Transactional
    void deleteById(Long id);
}
