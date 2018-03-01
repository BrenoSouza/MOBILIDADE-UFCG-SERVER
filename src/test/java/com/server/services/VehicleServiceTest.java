package com.server.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.server.entities.Vehicle;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class VehicleServiceTest {

	@Autowired
	private VehicleService vehicleService;
	
	@Test
	public void testFindById() {
		List<Vehicle> list = this.vehicleService.findAll();
		Vehicle vehicle;
		
		for (int i = 0; i < list.size(); i++) {
			vehicle = vehicleService.findById(list.get(i).getId());
			assertEquals(list.get(i).getVehicle(), vehicle.getVehicle());
		}
	}

	@Test
	public void testFindAll() {
		List<Vehicle> list = this.vehicleService.findAll();
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i != j) {
					assertTrue(list.get(i).getId() != list.get(j).getId());
				}else {
					assertTrue(list.get(i).getId() == list.get(j).getId());
				}
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			assertNotNull(list.get(i).getVehicle());
			assertNotNull(list.get(i).getCapacity());
			assertNotNull(list.get(i).getYear());
			assertNotNull(list.get(i).getPlate());
			assertNotNull(list.get(i).getConservationState());
			assertNotNull(list.get(i).getFuel());
			assertNotNull(list.get(i).getColor());
		}
	}

	@Test
	public void testSave() {
		List<Vehicle> initialList = this.vehicleService.findAll();
		
		Vehicle vehicle = new Vehicle();
        vehicle.setBrand("fiat");
        vehicle.setCapacity(4);
        vehicle.setColor("prata");
        vehicle.setConservationState("bom");
        vehicle.setFuel("gasolina");
        vehicle.setPlate("AAA9999");
        vehicle.setVehicle("carro");
        vehicle.setYear(2013);
        
		vehicleService.save(vehicle);
		
		List<Vehicle> parcialList = this.vehicleService.findAll();

		assertEquals(initialList.size() + 1, parcialList.size());
		
		Vehicle errorVehicle = new Vehicle();
		try {
			vehicleService.save(errorVehicle);
		} catch (Exception e) {
			assertEquals("org.springframework.transaction.TransactionSystemException: "
					+ "Could not commit JPA transaction; nested exception is javax.persistence.RollbackException: "
					+ "Error while committing the transaction", e.toString());
		}
		
		List<Vehicle> finalList = this.vehicleService.findAll();
		
		assertEquals(parcialList.size(), finalList.size());
	}

	@Test
	public void testDelete() {
		List<Vehicle> initialList = this.vehicleService.findAll();
		
		Vehicle vehicle = new Vehicle();
        vehicle.setBrand("fiat");
        vehicle.setCapacity(4);
        vehicle.setColor("prata");
        vehicle.setConservationState("bom");
        vehicle.setFuel("gasolina");
        vehicle.setPlate("AAA9999");
        vehicle.setVehicle("carro");
        vehicle.setYear(2013);
        
		vehicleService.save(vehicle);
		
		List<Vehicle> parcialList = this.vehicleService.findAll();

		assertEquals(initialList.size() + 1, parcialList.size());
		
		long vehicleId = parcialList.get(parcialList.size() - 1).getId();
		
		vehicleService.delete(vehicleId);
		
		List<Vehicle> finalList = this.vehicleService.findAll();
		
		assertEquals(parcialList.size() - 1, finalList.size());
		assertEquals(initialList, finalList);
	}

	@Test
	public void testGetAllTravelOfVehicleInDay() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllVehicleAvailableInInterval() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllVehicleUnavailableInDate() {
		fail("Not yet implemented");
	}

}
