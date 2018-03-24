package com.server.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.server.entities.Driver;
import com.server.repositories.DriverRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DriverServiceTest {


	@Autowired
	private DriverService driverService;
	
	
	Driver driverTest1 = new Driver();
	Driver driverTest2 = new Driver();
	
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
	public void testFindById() {
		Driver  driver = this.driverService.findById(driverTest1.getId());
		assertTrue(driver.getId()== driverTest1.getId());
	}

	@Test
	public void testFindAll() {
		List<Driver> list = new ArrayList<Driver>();
		list.add(driverTest1);
		list.add(driverTest2);
		
		List<Driver> list2 = this.driverService.findAll();
		
		assertTrue(list.equals(list2));
		
	}

}
