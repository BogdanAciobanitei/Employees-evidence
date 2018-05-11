package com.yonder.study.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yonder.study.dao.IEmployeeDAO;
import com.yonder.study.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ServiceContextConfiguration.class })
@Transactional
public class EmployeeServiceTest {

	IEmployeeService employeeService;
	IEmployeeDAO employeeDao;

	@Before
	public void doSetup() {
		employeeDao = mock(IEmployeeDAO.class);
		employeeService = new EmployeeServiceImpl(employeeDao);
	}

	@Test
	public void testGetExistingEmployee() {
		when(employeeDao.get(1L)).thenAnswer(new Answer<Employee>(){

			@Override
			public Employee answer(InvocationOnMock invocation) throws Throwable {
				Employee employee = new Employee();
				employee.setId((Long) invocation.getArguments()[0]);
                return employee;
			}
			
		});
		
		Employee employee = employeeService.get(1L);
		
		assertNotNull("No employee found", employee);
	}
	
	@Test
	public void testGetNotExistingEmployee(){
		
		when(employeeDao.get(1L)).thenAnswer(new Answer<Employee>(){

			@Override
			public Employee answer(InvocationOnMock invocation) throws Throwable {
                return null;
			}
			
		});
		
		Employee employee = employeeService.get(1L);
		
		assertNull("Employee found but it shoudn't", employee);
	}

	@Test
	public void testCreate() {

	}

	@Test
	public void testFindAll() {

	}

	@Test
	public void testUpdate() {

	}

	@Test
	public void testDelete() {

	}

	@After
	public void tearDown() {

	}

}
