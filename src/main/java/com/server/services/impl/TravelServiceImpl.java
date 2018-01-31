package com.server.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.server.response.Response;
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
	
	private List<Travel> listTravelBusy;
	
	private static final Long MARGIN = 1000l;
	
	
	@Override
	public Response<List<Travel>> addTravelVehicle(Long idForm,Long idVehicle,Long idDriver) {
		Response<List<Travel>> response =  new Response<List<Travel>>();
		
		Form form = this.formRepository.findOne(idForm);
		Vehicle vehicle = this.vehicleRepository.findOne(idVehicle);
		Driver driver = this.driverRepository.findOne(idDriver);
		
		response = this.checkVehicleAvailable(idVehicle, idForm);
				
		if(! response.getErrors().isEmpty()) {
			return response;
		}
		
		response = this.checkDriverAvailable(idDriver, idForm);
		
		if(! response.getErrors().isEmpty()) {
			return response;
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

		return response;
	}

	@Override
	public List<Travel> getAllTravel() {
		List<Travel> listTravel = new ArrayList<Travel>(this.travelRepository.findAllByStatus(TravelStatus.HAPPENING));
		
		listTravel.addAll(this.travelRepository.findAllByStatus(TravelStatus.PLANNED));
		
		Date today = new Date();
		
		for (int i = 0; i < listTravel.size(); i++) {
			if((today.before(listTravel.get(i).getReturnDate())) && (today.after(listTravel.get(i).getTravelDate()))) {
				this.travelRepository.save(listTravel.get(i));
			}else {
				listTravel.get(i).setStatus(TravelStatus.COMPLETED);
			}
			this.travelRepository.save(listTravel.get(i));
		}		
		return listTravel;
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
	public Response<List<Travel>> checkVehicleAvailable(Long idVehicle,Long idForm) {
		
		Response<List<Travel>> response =  new Response<List<Travel>>();
		
		listTravelBusy = new ArrayList<Travel>();
		
		Vehicle vehicle = this.vehicleRepository.findOne(idVehicle);
		
		if(vehicle == null) {
			response.addErrorMessage("Veiculo - Veículo não encontrado, tente novamente");
			return response;
		}
		
		
		Form form = this.formRepository.findByid(idForm);
		
		if(form == null) {
			response.addErrorMessage("Formulário - Formulário não encontrado, tente novamente");
			return response;
		}		
		
		Date after = form.getTravelDate();
		Date before = form.getReturnDate();
		
		
		if(after.equals(before)) {
			response.addErrorMessage("Data - Datas de ida e volta iguais, tente novamente");
			return response;
		}
		
		if(after.after(before)){
			response.addErrorMessage("Data - Datas de ida é anterior a data de volta, tente novamente");
			return response;
		}
		
		
		
		
		List<Travel> listTravel = new ArrayList<Travel>(this.travelRepository.findAllByStatusAndVehicle(TravelStatus.HAPPENING,vehicle));
		
		listTravel.addAll(this.travelRepository.findAllByStatusAndVehicle(TravelStatus.PLANNED,vehicle));
				
		Interval interval = new Interval(after.getTime(),before.getTime());
		
		List<Interval> listInterval = new ArrayList<Interval>();
		
		for (int i = 0; i < listTravel.size(); i++) {
			
            Date start=listTravel.get(i).getTravelDate();
            Date end= new Date(listTravel.get(i).getReturnDate().getTime() + MARGIN);
            
            if((interval.contains(start.getTime())) || (interval.contains(end.getTime()))) {
            	listTravelBusy.add(listTravel.get(i));
            }            
            listInterval.add(new Interval(start.getTime(),end.getTime()));
		}
		
		//before = new Date(before.getTime() +1000l);
		 
		for (int i = 0; i < listInterval.size(); i++) {
			if(listInterval.get(i).contains(after.getTime()) || listInterval.get(i).contains(before.getTime())) {
				if(! listTravelBusy.contains(listTravel.get(i))) {
					listTravelBusy.add(listTravel.get(i));
				}
			}
		}
		
		if(! listTravelBusy.isEmpty()) {
			response.setData(listTravelBusy);
			response.addErrorMessage("Veículo ja ocupado");
			form.setStatus(FormStatus.DENIED);
			this.formRepository.save(form);
		}
		
		return response;
		
	}
	
	@Override
	public Response<List<Travel>> checkDriverAvailable(Long idDriver, Long idForm) {
		
		Response<List<Travel>> response =  new Response<List<Travel>>();
		
		listTravelBusy = new ArrayList<Travel>();
		
		Driver driver = this.driverRepository.findOne(idDriver);
		
		if(driver == null) {
			response.addErrorMessage("Motorista não encontrado, tente novamente");
			return response;
		}
		
		Form form = this.formRepository.findByid(idForm);
		
		if(form == null) {
			response.addErrorMessage("Formulário não encontrado, tente novamente");
		}
		
		Date after = form.getTravelDate();
		Date before = form.getReturnDate();
		
		
		if(after.equals(before)) {
			response.addErrorMessage("Data - Datas de ida e volta iguais, tente novamente");
			return response;
		}
		
		if(after.after(before)){
			response.addErrorMessage("Data - Datas de ida é anterior a data de volta, tente novamente");
			return response;
		}
		
		
		
		List<Travel> listTravel = new ArrayList<Travel>(this.travelRepository.findAllByStatusAndDriver(TravelStatus.HAPPENING,driver));
		
		listTravel.addAll(this.travelRepository.findAllByStatusAndDriver(TravelStatus.PLANNED,driver));
				
		Interval interval = new Interval(after.getTime(),before.getTime());
		
		List<Interval> listInterval = new ArrayList<Interval>();
		
		for (int i = 0; i < listTravel.size(); i++) {
            Date start=listTravel.get(i).getTravelDate();
            Date end= new Date(listTravel.get(i).getReturnDate().getTime() + MARGIN);
            if((interval.contains(start.getTime())) || (interval.contains(end.getTime()))) {
            	listTravelBusy.add(listTravel.get(i));
            }            
            listInterval.add(new Interval(start.getTime(),end.getTime()));
		}
		
		//before = new Date(before.getTime() +1000l);
		 
		for (int i = 0; i < listInterval.size(); i++) {
			if(listInterval.get(i).contains(after.getTime()) || listInterval.get(i).contains(before.getTime())) {
				if(! listTravelBusy.contains(listTravel.get(i))) {
					listTravelBusy.add(listTravel.get(i));
				}
				
			}
		}
		
		if(! listTravelBusy.isEmpty()) {
			response.addErrorMessage("Motorista ocupado");
			response.setData(listTravelBusy);
			form.setStatus(FormStatus.DENIED);
			this.formRepository.save(form);
		}
				
		return response;
	}

	@Override
	public Boolean checkVehicleIsAvailable(Long id, Date after, Date before) {
		//checkVehicleAvailable(id, after,before);
		return listTravelBusy.isEmpty();
	}

	@Override
	public Boolean checkDriverIsAvailable(Long id, Date after, Date before) {
		//checkDriverAvailable(id, after, before);
		return listTravelBusy.isEmpty();
	}

	
}
