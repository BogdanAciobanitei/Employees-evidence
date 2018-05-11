package com.yonder.study.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yonder.study.model.Employee;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DaoContextConfiguration.class })
@Transactional
public class EmployeeDAOTest {

	@Autowired
	IEmployeeDAO employeeDAO;
	
	public List<Employee> employeeList = new LinkedList<Employee>();
	
	@Before
	public void setupData(){

		Employee employeeToBeCreated1 = new Employee();
		
		employeeToBeCreated1.setFullName("Bogdan1");
		employeeToBeCreated1.setCluster("Java1");
		employeeToBeCreated1.setEmail("bogdan1@email.com");
		employeeToBeCreated1.setEmployeeDate("Jul 1, 2016");
		
		employeeDAO.create(employeeToBeCreated1);
		

		Employee employeeToBeCreated2 = new Employee();
		
		employeeToBeCreated2.setFullName("Bogdan2");
		employeeToBeCreated2.setCluster("Java2");
		employeeToBeCreated2.setEmail("bogda2n@email.com");
		employeeToBeCreated2.setEmployeeDate("Jul 2, 2016");
		
		employeeDAO.create(employeeToBeCreated2);
		
		employeeList.add(employeeToBeCreated1);
		employeeList.add(employeeToBeCreated2);
	}
	
	
	@After
	public void tearDown(){
		employeeList.clear();
	}
	
	@Test
	public void testGet(){
		
		Employee expectedEmployee = employeeList.get(0);
		assertNotNull("Setup initialization failed", expectedEmployee);
		
		Employee employeeFound = employeeDAO.get(expectedEmployee.getId());
		
		assertNotNull("Employee not found", employeeFound);
		assertEquals("Wrong employee retrieved", expectedEmployee, employeeFound);

	}
	
	@Test
	@Rollback(true)
	public void testCreate(){
	
		Employee employeeToBeCreated = new Employee();
		
		employeeToBeCreated.setFullName("Bogdan");
		employeeToBeCreated.setCluster("Java");
		employeeToBeCreated.setEmail("bogdan@email.com");
		employeeToBeCreated.setEmployeeDate("Jul 1, 2016");
		
		employeeDAO.create(employeeToBeCreated);
		
		Employee employeeFound = employeeDAO.get(employeeToBeCreated.getId());
		
		assertNotNull("Employee not created", employeeFound);
		assertEquals("Created employee don't match", employeeToBeCreated, employeeFound);
		
	}
	
	@Test
	public void testFindAll(){
		
		List<Employee> employeeListRetrieved = employeeDAO.findAll();
		assertEquals("Wrong number of person retrieved", employeeList.size(), employeeListRetrieved.size());
		
	}
	
	@Test
	@Rollback(true)
	public void testUpdate(){
		
		Employee employeeToBeUpdated = employeeList.get(0);
		
		employeeToBeUpdated.setFullName("Updated name");
		employeeToBeUpdated.setEmail("Updated email");
		employeeToBeUpdated.setAddress("Updated address");
		employeeToBeUpdated.setEmployeeDate("Jul 1, 2016");
		employeeToBeUpdated.setCluster(".Net");
		employeeToBeUpdated.setSex("M");
		
		Employee employeeUpdated = employeeDAO.update(employeeToBeUpdated);
		
		assertEquals("Employee not updated", employeeToBeUpdated, employeeUpdated);
		
	}
	
	@Test
	public void testDelete(){
		
		Employee employeeToBeDeleted = employeeList.get(0);		
		
		employeeDAO.delete(employeeToBeDeleted);
		
		Employee employeeDeleted = employeeDAO.get(employeeToBeDeleted.getId());
		assertNull("Entity not deleted", employeeDeleted);
		
	}
	
	@Test
	public void testDeletNullValue(){
		try {
			employeeDAO.delete(null);
	    } catch (Exception e){
	        assertNull(e);
	    }
	}
	
}
