package com.server.controllers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.server.entities.Driver;
import com.server.services.DriverService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class DriverControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private DriverService driverService;
	
	Driver driverTest1 = new Driver();
	Driver driverTest2 = new Driver();
	
	private static final String URL_DRIVE = "/driver";
	
	
	@Before
	public void setUp() throws Exception {
		driverTest1.setCnh("123456"); 
		driverTest1.setCpf("123456789");
		driverTest1.setName("José");
		driverTest1.setRegistration(1234563); 
		
		driverTest2.setCnh("987654");
		driverTest2.setCpf("987654321");
		driverTest2.setName("João");
		driverTest2.setRegistration(1234563);
		
	
		
		this.driverService.save(driverTest1);
		this.driverService.save(driverTest2);
	}

	@After
	public void tearDown() throws Exception {
		this.driverService.delete(driverTest1.getId());
		this.driverService.delete(driverTest2.getId());
	}

	@Test
	public void testRegisterDriver() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllDriver() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDriver() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get(URL_DRIVE + "/"+ driverTest1.getId()).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	public void testUpdateDriver() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteVehicle() {
		fail("Not yet implemented");
	}

}
