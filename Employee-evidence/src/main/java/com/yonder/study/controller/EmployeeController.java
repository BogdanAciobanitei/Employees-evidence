package com.yonder.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yonder.study.model.Employee;
import com.yonder.study.service.IEmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
	
	@Autowired
	IEmployeeService service;
	
	@RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
		Employee employee = service.get(id);
		if(employee != null)
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		else
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employee = service.findAll();
		return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		
		employee = service.create(employee);
		if(employee != null)
			return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
		else
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
		
		Employee currentEmployee;
		currentEmployee = service.get(id);
		if(currentEmployee == null)
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		
		currentEmployee.setAddress(employee.getAddress());
		currentEmployee.setEmail(employee.getEmail());
		currentEmployee.setFullName(employee.getFullName());
		currentEmployee.setSex(employee.getSex());
		currentEmployee.setCluster(employee.getCluster());
		currentEmployee.setEmployeeDate(employee.getEmployeeDate());
		service.update(currentEmployee);
		
		return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> createEmployee(@PathVariable long id) {
		Employee employee = service.get(id);
		if(employee == null){
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		else{
			service.delete(employee);
			return new ResponseEntity<Employee>(HttpStatus.OK);
		}
	}
	
}
