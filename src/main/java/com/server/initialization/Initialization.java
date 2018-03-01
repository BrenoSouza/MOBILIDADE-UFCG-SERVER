package com.server.initialization;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
 
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
 
@Component
public class Initialization implements ApplicationListener<ContextRefreshedEvent> {
 
    @Autowired
    private DriverRepository driverRepository;
 
    @Autowired
    private VehicleRepository vehicleRepository;
 
    @Autowired
    private FormRepository formRepository;
   
    @Autowired
    private TravelRepository travelRepository;
   
    //dd-MM-yyyy HH:mm:ss
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");//yyyy'-'MM'-'dd'T'HH':'mm':'ss
   
   
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
 
       
        Driver driver01 = new Driver();
        Driver driver02 = new Driver();
       
        Vehicle vehicle01 = new Vehicle();
        Vehicle vehicle02 = new Vehicle();
        Vehicle vehicle03 = new Vehicle();
        Vehicle vehicle04 = new Vehicle();
        Vehicle vehicle05 = new Vehicle();
                       
        Form form01 =  new Form();
        Form form02 =  new Form();
        Form form03 =  new Form();
        Form form04 =  new Form();
        Form form05 =  new Form();
       
        Travel travel01 = new Travel();
        Travel travel02 = new Travel();
        Travel travel03 = new Travel();
        Travel travel04 = new Travel();
        Travel travel05 = new Travel();
       
       
        try {
        	
            form1(form01);
            form2(form02);
            form3(form03);
            form4(form04);
            form5(form05);
            
            driver01(driver01);
            driver02(driver02);
           
            vehicle01(vehicle01);
            vehicle02(vehicle02);
            vehicle03(vehicle03);
            vehicle04(vehicle04);
            vehicle05(vehicle05);
            
            travel01(travel01,form01,driver01,vehicle01);
            travel02(travel02,form02,driver02,vehicle02);
            travel03(travel03,form03,driver01,vehicle01);
            travel04(travel04,form04,driver02,vehicle02);
            travel05(travel05,form05,driver01,vehicle01);
           
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
       
        driverRepository.save(driver01);
        driverRepository.save(driver02);
       
        vehicleRepository.save(vehicle01);
        vehicleRepository.save(vehicle02);
        vehicleRepository.save(vehicle03);
        vehicleRepository.save(vehicle04);
        vehicleRepository.save(vehicle05);
       
        formRepository.save(form01);
        formRepository.save(form02);
        formRepository.save(form03);
        formRepository.save(form04);
        formRepository.save(form05);
       
        travelRepository.save(travel01);
        travelRepository.save(travel02);
        travelRepository.save(travel03);
        travelRepository.save(travel04);
        travelRepository.save(travel05);
 
    }
   
    private void travel01(Travel travel,Form form, Driver driver, Vehicle vehicle) throws ParseException {
        travel.setDriver(driver);
        travel.addform(form);
        travel.setVehicle(vehicle);
        travel.setStatus(TravelStatus.PLANNED);
        travel.setTravelDate(formatter.parse("22-02-2018 08:00:00"));
        travel.setReturnDate(formatter.parse("22-02-2018 10:00:00"));
    }
   
    private void travel02(Travel travel,Form form, Driver driver, Vehicle vehicle) throws ParseException {
        travel.setDriver(driver);
        travel.addform(form);
        travel.setVehicle(vehicle);
        travel.setStatus(TravelStatus.PLANNED);
        travel.setTravelDate(formatter.parse("22-02-2018 08:00:00"));
        travel.setReturnDate(formatter.parse("22-02-2018 11:00:00"));
    }
   
    private void travel03(Travel travel,Form form, Driver driver, Vehicle vehicle) throws ParseException {
        travel.setDriver(driver);
        travel.addform(form);
        travel.setVehicle(vehicle);
        travel.setStatus(TravelStatus.PLANNED);
        travel.setTravelDate(formatter.parse("22-02-2018 11:00:00"));
        travel.setReturnDate(formatter.parse("22-02-2018 14:00:00"));
    }
 
    private void travel04(Travel travel,Form form, Driver driver, Vehicle vehicle) throws ParseException {
        travel.setDriver(driver);
        travel.addform(form);
        travel.setVehicle(vehicle);
        travel.setStatus(TravelStatus.PLANNED);
        travel.setTravelDate(formatter.parse("22-02-2018 11:01:00"));
        travel.setReturnDate(formatter.parse("22-02-2018 14:00:00"));
    }
 
    private void travel05(Travel travel,Form form, Driver driver, Vehicle vehicle) throws ParseException {
        travel.setDriver(driver);
        travel.addform(form);
        travel.setVehicle(vehicle);
        travel.setStatus(TravelStatus.PLANNED);
        travel.setTravelDate(formatter.parse("22-02-2018 14:01:00"));
        travel.setReturnDate(formatter.parse("22-02-2018 16:00:00"));
    }
 
 
   
    private void vehicle01(Vehicle vehicle) throws ParseException{
        vehicle.setBrand("fiat");
        vehicle.setCapacity(10);
        vehicle.setColor("prata");
        vehicle.setConservationState("ruim");
        vehicle.setFuel("gasolina");
        vehicle.setPlate("AAA1111");
        vehicle.setVehicle("carro");
        vehicle.setYear(2000);
    }
   
    private void vehicle02(Vehicle vehicle) throws ParseException{
        vehicle.setBrand("Honda");
        vehicle.setCapacity(15);
        vehicle.setColor("branco");
        vehicle.setConservationState("bom");
        vehicle.setFuel("disel");
        vehicle.setPlate("AAA2222");
        vehicle.setVehicle("onibus");
        vehicle.setYear(2010);
    }
   
    private void vehicle03(Vehicle vehicle) throws ParseException{
        vehicle.setBrand("ford");
        vehicle.setCapacity(15);
        vehicle.setColor("preto");
        vehicle.setConservationState("bom");
        vehicle.setFuel("disel");
        vehicle.setPlate("AAA3333");
        vehicle.setVehicle("carro");
        vehicle.setYear(2010);
    }
   
    private void vehicle04(Vehicle vehicle) throws ParseException{
        vehicle.setBrand("toyota");
        vehicle.setCapacity(15);
        vehicle.setColor("vermelho");
        vehicle.setConservationState("ruim");
        vehicle.setFuel("gasolina");
        vehicle.setPlate("AAA4444");
        vehicle.setVehicle("onibus");
        vehicle.setYear(2010);
    }
   
    private void vehicle05(Vehicle vehicle) throws ParseException{
        vehicle.setBrand("gm");
        vehicle.setCapacity(15);
        vehicle.setColor("azul");
        vehicle.setConservationState("bom");
        vehicle.setFuel("disel");
        vehicle.setPlate("AAA5555");
        vehicle.setVehicle("carro");
        vehicle.setYear(2010);
    }
   
    private void driver01(Driver driver) throws ParseException{
        driver.setAddress("catole");
        driver.setCnh("321654");
        driver.setCpf("4465465");
        driver.setName("Antonio");
        driver.setPhone("321654");
        driver.setRegistration(0);
    }
   
    private void driver02(Driver driver) throws ParseException{
        driver.setAddress("bodocongo");
        driver.setCnh("321654");
        driver.setCpf("4465465");
        driver.setName("Paulo");
        driver.setPhone("321654");
        driver.setRegistration(1);
    }
   
    private void form1(Form form) throws ParseException {
        //dados da viagem
        form.setRequesterSector("DME");
        form.setDestination("UFPB");
        form.setPurpose("Apresentação de tcc");
        form.setRequestDate(formatter.parse("05-12-2017 00:00:00"));
 
        //dados do solicitante
        form.setName("Jose Lucas");
        form.setPhone("999551232");
 
        //datas de horas da viagem
        form.setTravelDate(formatter.parse("22-02-2018 08:00:00"));
        form.setDepartureHour(new Date());
        form.setReturnDate(formatter.parse("22-02-2018 10:00:00"));
        form.setReturnHour(new Date());
        form.setDeparturePoint("UFCG");
        form.setAddress("Avenida Floriano Peixoto");
 
        //passageiros no aeroporto
        //form.setArrivalTime(new Date());
        //form.setFlightNumber("98645");
        //form.setAirCompany(null);
        //form.setTravelOrigin("São Paulo");
 
        ///Setor responsável pelas diárias dos motoristas, justifacao e startus
        form.setDriverSectorResponsibility("setor de Matemática");
        form.setRequestJustification(null);    
        form.setStatus(FormStatus.WAITING);
        form.setTravel(null);
    }
   
    private void form2(Form form) throws ParseException {
        //dados da viagem
        form.setRequesterSector("DF");
        form.setDestination("João Pessoa");
        form.setPurpose("Apresentação de tcc");
        form.setRequestDate(formatter.parse("05-12-2017 00:00:00"));
       
        //dados do solicitante
        form.setName("jose Carlos");
        form.setPhone("999663355");
       
        //datas de horas da viagem
        form.setTravelDate(formatter.parse("22-02-2018 08:00:00"));
        form.setDepartureHour(new Date());
        form.setReturnDate(formatter.parse("22-02-2018 11:00:00"));
        form.setReturnHour(new Date());
        form.setDeparturePoint("Reitoria");
        form.setAddress("Avenida João Pessoa");
       
        //passageiros no aeroporto
        //form.setArrivalTime(new Date());
        //form.setFlightNumber("98645");
        //form.setAirCompany(null);
        //form.setTravelOrigin("São Paulo");
       
        ///Setor responsável pelas diárias dos motoristas, justifacao e startus
        form.setDriverSectorResponsibility("setor de Fisica");
        form.setRequestJustification(null);    
        form.setStatus(FormStatus.WAITING);
        form.setTravel(null);
    }
 
    private void form3(Form form) throws ParseException {
        //dados da viagem
        form.setRequesterSector("UEA");
        form.setDestination("UFRN");
        form.setPurpose("Seminário");
        form.setRequestDate(formatter.parse("05-12-2017 00:00:00"));
 
        //dados do solicitante
        form.setName("Lucas Ronaldo");
        form.setPhone("998633575");
 
        //datas de horas da viagem
        form.setTravelDate(formatter.parse("22-02-2018 11:00:00"));
        form.setDepartureHour(new Date());
        form.setReturnDate(formatter.parse("22-02-2018 14:00:00"));
        form.setReturnHour(new Date());
        form.setDeparturePoint("Reitoria");
        form.setAddress("Avenida Brasil");
 
        //passageiros no aeroporto
        //form.setArrivalTime(new Date());
        //form.setFlightNumber("98645");
        //form.setAirCompany(null);
        //form.setTravelOrigin("São Paulo");
 
        ///Setor responsável pelas diárias dos motoristas, justifacao e startus
        form.setDriverSectorResponsibility("setor de estatistica");
        form.setRequestJustification(null);    
        form.setStatus(FormStatus.WAITING);
        form.setTravel(null);
    }
   
    private void form4(Form form) throws ParseException {
        //dados da viagem
        form.setRequesterSector("UAL");
        form.setDestination("João Pessoa");
        form.setPurpose("Congresso");
        form.setRequestDate(formatter.parse("05-12-2017 00:00:00"));
 
        //dados do solicitante
        form.setName("Renato aragão");
        form.setPhone("999642125");
 
        //datas de horas da viagem
        form.setTravelDate(formatter.parse("22-02-2018 11:01:00"));
        form.setDepartureHour(new Date());
        form.setReturnDate(formatter.parse("22-02-2018 14:00:00"));
        form.setReturnHour(new Date());
        form.setDeparturePoint("Reitoria");
        form.setAddress("Avenida João suassuna");
 
        //passageiros no aeroporto
        //form.setArrivalTime(new Date());
        //form.setFlightNumber("98645");
        //form.setAirCompany(null);
        //form.setTravelOrigin("São Paulo");
 
        ///Setor responsável pelas diárias dos motoristas, justifacao e startus
        form.setDriverSectorResponsibility("setor de humanidades");
        form.setRequestJustification(null);    
        form.setStatus(FormStatus.WAITING);
        form.setTravel(null);
    }
   
    private void form5(Form form) throws ParseException {
        //dados da viagem
        form.setRequesterSector("DSC");
        form.setDestination("USP");
        form.setPurpose("Maratona de Computação");
        form.setRequestDate(formatter.parse("22-02-2010 00:00:00"));
 
        //dados do solicitante
        form.setName("jose Carlos");
        form.setPhone("999663355");
 
        //datas de horas da viagem
        form.setTravelDate(formatter.parse("22-02-2018 14:01:00"));
        form.setDepartureHour(new Date());
        form.setReturnDate(formatter.parse("22-02-2018 16:00:00"));
        form.setReturnHour(new Date());
        form.setDeparturePoint("Reitoria");
        form.setAddress("Parque do povo");
 
        //passageiros no aeroporto
        //form.setArrivalTime(new Date());
        //form.setFlightNumber("98645");
        //form.setAirCompany(null);
        //form.setTravelOrigin("São Paulo");
 
        ///Setor responsável pelas diárias dos motoristas, justifacao e startus
        form.setDriverSectorResponsibility("setor de Compuação");
        form.setRequestJustification(null);    
        form.setStatus(FormStatus.WAITING);
        form.setTravel(null);
    }
   
 
}