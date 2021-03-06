package com.server.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.server.entities.Form;
import com.server.entities.enums.FormStatus;

public interface FormRepository extends JpaRepository<Form, Long>{
	
	//busca por Id
	Form findByid(Long Id);	
	
	@Query("SELECT f.travelDate FROM Form f where f.id = :id") 
	Date findtravelDatebyId(Long id);
	
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
	
	List<Form> findAllByStatus(FormStatus status);
	
	
	
	List<Form> findAllByrequestDateBetween(Date before,Date after);
	
	List<Form> findAllBytravelDateBetween(Date before,Date after);
	
	List<Form> findAllBydepartureHourBetween(Date before,Date after);
	
	List<Form> findAllByreturnDateBetween(Date before,Date after);
	
	List<Form> findAllByreturnHourBetween(Date before,Date after);
	
	List<Form> findAllByarrivalTimeBetween(Date before,Date after);
	
	@Transactional
    void deleteById(Long id);
}
