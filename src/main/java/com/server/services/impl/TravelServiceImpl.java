package com.server.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.server.entities.Driver;
import com.server.entities.Form;
import com.server.entities.Travel;
import com.server.entities.Vehicle;
import com.server.entities.enums.FormStatus;
import com.server.entities.enums.TravelStatus;
import com.server.repositories.DriverRepository;
import com.server.repositories.FormRepository;
import com.server.repositories.TravelRepository;
import com.server.repositories.VehicleRepository;
import com.server.services.TravelService;

@Service
public class TravelServiceImpl implements TravelService{

	@Autowired
	private DriverRepository driverRepository;

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private FormRepository formRepository;
	
	@Autowired
	private TravelRepository travelRepository;
	
	private List<Travel> list =  new ArrayList<Travel>();
	
	
	@Override
	public Travel addTravelVehicle(Long idForm,Long idVehicle,Long idDriver,BindingResult result) {
		Form form = this.formRepository.findOne(idForm);
		Vehicle vehicle = this.vehicleRepository.findOne(idVehicle);
		Driver driver = this.driverRepository.findOne(idDriver);
		
		if(form == null) {
			result.addError(new ObjectError("Formulário", "Formulário não encontrado"));
			return null;
		}
		
		if(form.getTravelDate().after(form.getReturnDate())) {
			result.addError(new ObjectError("Data", "Data de volta anterior a data de ida"));
			return null;
		}
		
		if(form.getTravelDate().equals(form.getReturnDate())) {
			result.addError(new ObjectError("Data", "Data de ida e volta são as mesmas"));
			return null;
		}
		
		if(vehicle == null) {
			result.addError(new ObjectError("Veiculo", "Veículo não encontrado"));
			return null;
		}
		
		if(driver == null) {
			result.addError(new ObjectError("Motorista", "Motorista não encontrado"));
			return null;
		}
		
		if(! checkVehicleAvailable(idVehicle, form.getTravelDate(), form.getReturnDate())) {
			result.addError(new ObjectError("Veiculo", "Veículo não disponível na data requisitada"));
			form.setStatus(FormStatus.DENIED);
			return null;
		}
		
		if(! checkDriverAvailable(idDriver, form.getTravelDate(), form.getReturnDate())) {
			result.addError(new ObjectError("Motorista", "Motorista não disponível na data requisitada"));
			form.setStatus(FormStatus.DENIED);
			return null;
		}
			
		
		if(result.hasErrors()) {
			return null;
		}
		
		Travel travel = new Travel();
		travel.setForm(form);
		travel.setVehicle(vehicle);
		travel.setTravelDate(form.getTravelDate());
		travel.setReturnDate(form.getReturnDate());
		travel.setStatus(TravelStatus.PLANNED);
		this.travelRepository.save(travel);
		
		form.setStatus(FormStatus.COMPLETED);
		this.formRepository.save(form);
		return travel;
	}

	@Override
	public List<Travel> getAllTravel() {
		return this.travelRepository.findAll();
	}

	@Override
	public void deleteTravel(Long id) {
		 this.travelRepository.delete(id);
		
	}

	@Override
	public Travel setStatus(Long id, TravelStatus Status) {
		Travel travel = this.travelRepository.findOne(id);
		travel.setStatus(Status);
		return this.travelRepository.save(travel);
	}

	@Override
	public Travel getTravel(Long id) {
		return this.travelRepository.findOne(id);
	}

	@Override
	public Boolean checkVehicleAvailable(Long id, Date after, Date before) {
		
		if(after.equals(before)) {
			return false;
		}
		
		if(after.after(before)){
			return false;
		}
		
		
		Vehicle vehicle = this.vehicleRepository.findOne(id);
		
		List<Travel> listTravel = new ArrayList<Travel>(this.travelRepository.findAllByStatusAndVehicle(TravelStatus.HAPPENING,vehicle));
		
		listTravel.addAll(this.travelRepository.findAllByStatusAndVehicle(TravelStatus.PLANNED,vehicle));
				
		Interval interval = new Interval(after.getTime(),before.getTime());
		
		List<Interval> listInterval = new ArrayList<Interval>();
		
		for (int i = 0; i < listTravel.size(); i++) {
            Date start=listTravel.get(i).getTravelDate();
            Date end= new Date(listTravel.get(i).getReturnDate().getTime() + 1000l);
            if((interval.contains(start.getTime())) || (interval.contains(end.getTime()))) {
            	list.add(listTravel.get(i));
            	return false;
            }            
            listInterval.add(new Interval(start.getTime(),end.getTime()));
		}
		
		//before = new Date(before.getTime() +1000l);
		 
		for (int i = 0; i < listInterval.size(); i++) {
			if(listInterval.get(i).contains(after.getTime()) || listInterval.get(i).contains(before.getTime())) {
				return false;
			}
		}
				
		return true;
		
	}
	
	@Override
	public Boolean checkDriverAvailable(Long id, Date after, Date before) {
		
		if(after.equals(before)) {
			return false;
		}
		
		if(after.after(before)){
			return false;
		}
		
		Driver driver = this.driverRepository.findOne(id);
		
		List<Travel> listTravel = new ArrayList<Travel>(this.travelRepository.findAllByStatusAndDriver(TravelStatus.HAPPENING,driver));
		
		listTravel.addAll(this.travelRepository.findAllByStatusAndDriver(TravelStatus.PLANNED,driver));
				
		Interval interval = new Interval(after.getTime(),before.getTime());
		
		List<Interval> listInterval = new ArrayList<Interval>();
		
		for (int i = 0; i < listTravel.size(); i++) {
            Date start=listTravel.get(i).getTravelDate();
            Date end= new Date(listTravel.get(i).getReturnDate().getTime() + 1000l);
            if((interval.contains(start.getTime())) || (interval.contains(end.getTime()))) {
            	return false;
            }            
            listInterval.add(new Interval(start.getTime(),end.getTime()));
		}
		
		//before = new Date(before.getTime() +1000l);
		 
		for (int i = 0; i < listInterval.size(); i++) {
			if(listInterval.get(i).contains(after.getTime()) || listInterval.get(i).contains(before.getTime())) {
				return false;
			}
		}
				
		return true;
	}

}
