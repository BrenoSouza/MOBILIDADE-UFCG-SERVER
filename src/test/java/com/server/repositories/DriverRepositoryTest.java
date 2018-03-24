package com.server.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.server.entities.Driver;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DriverRepositoryTest {

	@Autowired
	DriverRepository driverRepository;
	
	Driver driverTest1 = new Driver();
	Driver driverTest2 = new Driver();
	
	
	//Add drivers to bd;
	@Before
	public void setUp() { 
		
		driverTest1.setCnh("123456"); 
		driverTest1.setCpf("123456789");
		driverTest1.setName("José");
		driverTest1.setRegistration(1234563); 
		
		driverTest2.setCnh("987654");
		driverTest2.setCpf("987654321");
		driverTest2.setName("João");
		driverTest2.setRegistration(1234563);
		
	
		
		this.driverRepository.save(driverTest1);
		this.driverRepository.save(driverTest2);
	
	}
	
	@After
	public final void tearDown() {
		this.driverRepository.deleteAll();
		
	}
	
	@Test
	public void testfindById() { 
		System.out.println("testfindbyid:" + this.driverRepository.findAll());
		Driver driver1 = this.driverRepository.findById( driverTest1.getId());
		Driver driver2 = this.driverRepository.findById( driverTest2.getId());
		
		assertEquals(driverTest1, driver1); 
		assertNotEquals(driverTest1, driver2);
		assertEquals(driverTest2, driver2);
		assertNotEquals(driverTest2, driver1);
	}
	
	@Test
	public void testGetname() {
		System.out.println("testGetName:" + this.driverRepository.findAll());
		Driver driver1 = this.driverRepository.findById( driverTest1.getId());
		Driver driver2 = this.driverRepository.findById( driverTest2.getId());
		
		assertEquals(driverTest1.getName(),driver1.getName());
		assertEquals(driverTest2.getName(),driver2.getName()); 
		
	}
	
	@Test
	public void testGetCnh() {
		System.out.println("testGetCnh:" + this.driverRepository.findAll());
		Driver driver1 = this.driverRepository.findById(driverTest1.getId());
		Driver driver2 = this.driverRepository.findById(driverTest2.getId());
		
		assertEquals(driverTest1.getCnh(),driver1.getCnh());
		assertEquals(driverTest2.getCnh(),driver2.getCnh());
		
	}
	
	@Test
	public void testGetCpf() {
		System.out.println("testGetCpf:" + this.driverRepository.findAll());
		Driver driver1 = this.driverRepository.findById(driverTest1.getId());
		Driver driver2 = this.driverRepository.findById(driverTest2.getId());
		
		assertEquals(driverTest1.getCpf(),driver1.getCpf());
		assertEquals(driverTest2.getCpf(),driver2.getCpf());
	} 
	
	@Test
	public void testRegistration() {
		System.out.println("testRegistration:" + this.driverRepository.findAll());
		Driver driver1 = this.driverRepository.findById(driverTest1.getId());
		Driver driver2 = this.driverRepository.findById(driverTest2.getId());
		
		assertEquals(driverTest1.getRegistration(),driver1.getRegistration()); 
		assertEquals(driverTest2.getRegistration(),driver2.getRegistration());
	}
	
	
} 
