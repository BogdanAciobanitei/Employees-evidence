package com.yonder.study.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yonder.study.model.Employee;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Employee get(Long id) {
		return getCurrentSession().get(Employee.class, id);
	}

	@Override
	public Employee create(Employee entity) {
		getCurrentSession().save(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {
		return getCurrentSession().createCriteria(Employee.class).list();
	}

	@Override
	public Employee update(Employee entity) {
		getCurrentSession().update(entity);
		return entity;
	}

	@Override
	public void delete(Employee entity) {
		if(entity != null)
			getCurrentSession().delete(entity);
	}

}
