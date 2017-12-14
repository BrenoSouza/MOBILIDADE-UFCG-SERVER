package com.server.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.server.entities.Driver;
import com.server.entities.Form;
import com.server.entities.Travel;
import com.server.entities.Vehicle;
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
	
	@Override
	public Travel addTravel(Long idForm,Long idVehicle,BindingResult result) {
		Form form = this.formRepository.findOne(idForm);
		Vehicle vehicle = this.vehicleRepository.findOne(idVehicle);
		//Driver driver = this.driverRepository.findOne(travel.getDriver().getId());
		Travel travel = new Travel();
		
		
		if(form == null) {
			result.addError(new ObjectError("Viagem", "Formulário não encontrado"));
			return null;
		}
		
		if(vehicle == null) {
			result.addError(new ObjectError("Veiculo", "Veículo não encontrado"));
			return null;
		}
		
		if(! checkVehicleAvailable(idVehicle, form.getTravelDate(), form.getReturnDate())) {
			result.addError(new ObjectError("Veiculo", "Veículo não disponível na data requisitada"));
			return null;
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		travel.setForm(form);
		travel.setVehicle(vehicle);
		travel.setTravelDate(form.getTravelDate());
		travel.setReturnDate(form.getReturnDate());
		return this.travelRepository.save(travel);
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
	public Travel setStatus(Long id, String Status) {
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
		
		System.out.println("data after:" + after.toString());
		System.out.println("data before:" + before.toString());
		//Vehicle vehicle = this.vehicleRepository.findById(id);
		//List<Travel> list = this.travelRepository.findAllByVehicleAndTravelDateAfterAndReturnDateBefore(vehicle,after,before);
		
		//List<Travel> setList = new ArrayList<Travel>(this.travelRepository.findAllByVehicle(vehicle));
		//System.out.println("setlist pelo veiculo: " + setList.size());
		
		List<Travel> listAfter = new ArrayList<Travel>(this.travelRepository.findAllByTravelDateAfter(after));
		System.out.println("viagens iniciadas apos: " + listAfter.size());
		
		List<Travel> listBefore = new ArrayList<Travel>(this.travelRepository.findAllByReturnDateAfter(after));
		System.out.println("viajens terminadas apos: " + listBefore.size());
		
		List<Travel> list =  new ArrayList<>();
		for (int i = 0; i < listAfter.size() ; i++) {
			if((listAfter.get(i).getVehicle().getId() == id)) {
				list.add(listAfter.get(i));
			}
		}
		
		for (int i = 0; i < listBefore.size() ; i++) {
			if((listBefore.get(i).getVehicle().getId() == id)&&(!list.contains(listBefore.get(i)))) {
				list.add(listBefore.get(i));
			}
		}
		
		System.out.println("list: " + list.size());
		
		List<Interval> listInterval = new ArrayList<Interval>();
		
		for (int i = 0; i < list.size(); i++) {
            Date inicio=list.get(i).getTravelDate();
            Date fim= list.get(i).getReturnDate();
            Interval intervalo=new Interval(inicio.getTime(),fim.getTime());
            listInterval.add(intervalo);
		}
		
		for (int i = 0; i < listInterval.size(); i++) {
			if(listInterval.get(i).contains(after.getTime()) ||listInterval.get(i).contains(before.getTime())) {
				return false;
			}
		}
		
		return true;
		
	}
	
	

}
