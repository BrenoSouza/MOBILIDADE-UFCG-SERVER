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

import com.server.entities.Driver;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DriverServiceTest {


	@Autowired
	private DriverService driverService;

	@Test
	public void testFindAll() {
		List<Driver> list = this.driverService.findAll();
		
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
			assertNotNull(list.get(i).getAddress());
			assertNotNull(list.get(i).getCnh());
			assertNotNull(list.get(i).getCpf());
			assertNotNull(list.get(i).getName());
			assertNotNull(list.get(i).getPhone());
		}
		
	}
	
	@Test
	public void testFindById() {
		List<Driver> list = this.driverService.findAll();
		Driver driver;
		
		for (int i = 0; i < list.size(); i++) {
			driver = driverService.findById(list.get(i).getId());
			assertEquals(list.get(i).getName(), driver.getName());
		}
	}
	
	@Test
	public void testSave() {
		List<Driver> initialList = this.driverService.findAll();
		
		Driver driver = new Driver(2, "Joao Terceiro", "12345678910", "123456", "Vila", "912345678");
		driverService.save(driver);
		
		List<Driver> parcialList = this.driverService.findAll();

		assertEquals(initialList.size() + 1, parcialList.size());
		
		Driver errorDriver = new Driver();
		try {
			driverService.save(errorDriver);
		} catch (Exception e) {
			assertEquals("org.springframework.transaction.TransactionSystemException: "
					+ "Could not commit JPA transaction; nested exception is javax.persistence.RollbackException: "
					+ "Error while committing the transaction", e.toString());
		}
		
		List<Driver> finalList = this.driverService.findAll();
		
		assertEquals(parcialList.size(), finalList.size());
		
	}
	
	@Test
	public void testDelete() {
		List<Driver> initialList = this.driverService.findAll();
		
		Driver driver = new Driver(2, "Joao Terceiro", "12345678910", "123456", "Vila", "912345678");
		driverService.save(driver);
		
		List<Driver> parcialList = this.driverService.findAll();

		assertEquals(initialList.size() + 1, parcialList.size());
		
		long driverId = parcialList.get(parcialList.size() - 1).getId();
		
		driverService.delete(driverId);
		
		List<Driver> finalList = this.driverService.findAll();
		
		assertEquals(parcialList.size() - 1, finalList.size());
		assertEquals(initialList, finalList);
	}

}
