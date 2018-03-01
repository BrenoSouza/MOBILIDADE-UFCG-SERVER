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

import com.server.entities.Travel;
import com.server.entities.Vehicle;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TravelServiceTest {

	@Autowired
	private TravelService travelService;

	@Test
	public void testGetTravel() {
		List<Travel> list = this.travelService.getAllTravel();
		Travel travel;
		
		for (int i = 0; i < list.size(); i++) {
			travel = travelService.getTravel(list.get(i).getId());
			assertEquals(list.get(i).getTravelDate(), travel.getTravelDate());
		}
	}

	@Test
	public void testGetAllTravel() {
		List<Travel> list = this.travelService.getAllTravel();
		
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
			assertNotNull(list.get(i).getDriver());
			assertNotNull(list.get(i).getTravelDate());
			assertNotNull(list.get(i).getStatus());
		}
	}

	@Test
	public void testAddTravelVehicle() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteTravel() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckVehicleAvailable() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckDriverAvailable() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddRide() {
		fail("Not yet implemented");
	}

}
