package com.yonder.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yonder.study.dao.IEmployeeDAO;
import com.yonder.study.model.Employee;

@Service("employeeService")
@Transactional(rollbackFor = Exception.class)
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private IEmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl() {
	};

	public EmployeeServiceImpl(IEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@Override
	public Employee get(Long id) {
		return employeeDAO.get(id);
	}

	@Override
	public Employee create(Employee entity) {
		return employeeDAO.create(entity);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public Employee update(Employee entity) {
		return employeeDAO.update(entity);
	}

	@Override
	public void delete(Employee entity) {
		employeeDAO.delete(entity);
		
	}
}
