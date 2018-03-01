package com.server.services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.server.entities.Form;
import com.server.entities.enums.FormStatus;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FormServiceTest {

    //dd-MM-yyyy HH:mm:ss
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");//yyyy'-'MM'-'dd'T'HH':'mm':'ss
	
	@Autowired
	private FormService formService;
	
	@Test
	public void testFindByid() {
		List<Form> list = this.formService.findAll();
		Form form;
		
		for (int i = 0; i < list.size(); i++) {
			form = formService.findByid(list.get(i).getId());
			assertEquals(list.get(i).getName(), form.getName());
		}
	}

	@Test
	public void testFindAll() {
		List<Form> list = this.formService.findAll();
		
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
			assertNotNull(list.get(i).getRequesterSector());
			assertNotNull(list.get(i).getDestination());
			assertNotNull(list.get(i).getPurpose());
			assertNotNull(list.get(i).getName());
			assertNotNull(list.get(i).getPhone());
			assertNotNull(list.get(i).getTravelDate());
			assertNotNull(list.get(i).getDeparturePoint());
			assertNotNull(list.get(i).getDriverSectorResponsibility());
		}
	}

	@Test
	public void testSave() throws ParseException {
		List<Form> initialList = this.formService.findAll();
		
		Form form = new Form();
        //dados da viagem
        form.setRequesterSector("DME");
        form.setDestination("UFPB");
        form.setPurpose("Apresentação de tcc");
        form.setRequestDate(formatter.parse("05-12-2017 00:00:00"));
 
        //dados do solicitante
        form.setName("Joao Jao");
        form.setPhone("999555111");
 
        //datas de horas da viagem
        form.setTravelDate(formatter.parse("22-02-2018 08:00:00"));
        form.setDepartureHour(new Date());
        form.setReturnDate(formatter.parse("22-02-2018 10:00:00"));
        form.setReturnHour(new Date());
        form.setDeparturePoint("UFCG");
        form.setAddress("Avenida Floriano Peixoto");
 
        ///Setor responsável pelas diárias dos motoristas, justifacao e startus
        form.setDriverSectorResponsibility("setor de Matemática");
        form.setRequestJustification(null);    
        form.setStatus(FormStatus.WAITING);
        form.setTravel(null);
        
		formService.save(form);
		
		List<Form> parcialList = this.formService.findAll();

		assertEquals(initialList.size() + 1, parcialList.size());
		
		Form errorForm = new Form();
		try {
			formService.save(errorForm);
		} catch (Exception e) {
			assertEquals("org.springframework.transaction.TransactionSystemException: "
					+ "Could not commit JPA transaction; nested exception is javax.persistence.RollbackException: "
					+ "Error while committing the transaction", e.toString());
		}
		
		List<Form> finalList = this.formService.findAll();
		
		assertEquals(parcialList.size(), finalList.size());
	}

	@Test
	public void testDeleteById() throws ParseException {
		List<Form> initialList = this.formService.findAll();
		
		Form form = new Form();
        //dados da viagem
        form.setRequesterSector("DME");
        form.setDestination("UFPB");
        form.setPurpose("Apresentação de tcc");
        form.setRequestDate(formatter.parse("05-12-2017 00:00:00"));
 
        //dados do solicitante
        form.setName("Joao Jao");
        form.setPhone("999555111");
 
        //datas de horas da viagem
        form.setTravelDate(formatter.parse("22-02-2018 08:00:00"));
        form.setDepartureHour(new Date());
        form.setReturnDate(formatter.parse("22-02-2018 10:00:00"));
        form.setReturnHour(new Date());
        form.setDeparturePoint("UFCG");
        form.setAddress("Avenida Floriano Peixoto");
 
        ///Setor responsável pelas diárias dos motoristas, justifacao e startus
        form.setDriverSectorResponsibility("setor de Matemática");
        form.setRequestJustification(null);    
        form.setStatus(FormStatus.WAITING);
        form.setTravel(null);
        
		formService.save(form);
		
		List<Form> parcialList = this.formService.findAll();

		assertEquals(initialList.size() + 1, parcialList.size());
		
		long formId = parcialList.get(parcialList.size() - 1).getId();
		
		formService.deleteById(formId);
		
		List<Form> finalList = this.formService.findAll();
		
		assertEquals(parcialList.size() - 1, finalList.size());
		assertEquals(initialList, finalList);
	}

	@Test
	public void testSearchByRequesterSector() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchByDestination() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchByPurpose() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchByphone() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchBydeparturePoint() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchByaddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchByflightNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchByairCompany() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchBytravelOrigin() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchBydriverSectorResponsibility() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchByrequestJustification() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchBystatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchAllByRequestDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchAllBytravelDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchAllBydepartureHour() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchAllByreturnDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchAllByreturnHour() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchAllByarrivalTime() {
		fail("Not yet implemented");
	}

}
