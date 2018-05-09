package com.yonder.study.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.yonder.study.model.Employee;
import com.yonder.study.model.Person;
import com.yonder.study.service.IEmployeeService;


@ManagedBean
@SessionScoped
public class RegisterEmployee {

	@ManagedProperty("#{employeeService}")
	private IEmployeeService employeeService;
	
	private Employee employee = new Employee();
	
	private Person person = new Person();
	
	public IEmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String register() {
		employeeService.create(employee);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("The Employee " + this.employee.getFullName() + " Is Registered Successfully"));
		return "";
	}
}
