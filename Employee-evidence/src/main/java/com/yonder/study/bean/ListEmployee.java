package com.yonder.study.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import com.yonder.study.model.Employee;
import com.yonder.study.model.TechLog;
import com.yonder.study.model.Technology;
import com.yonder.study.service.IEmployeeService;
import com.yonder.study.service.ITechLogService;
import com.yonder.study.service.ITechnologyService;

@ManagedBean
@ViewScoped
public class ListEmployee {

	@ManagedProperty("#{employeeService}")
	private IEmployeeService employeeService;

	@ManagedProperty("#{techLogService}")
	private ITechLogService techLogService;
	
	@ManagedProperty("#{technologyService}")
	private ITechnologyService techService;

	private List<Employee> employees;
	private List<Employee> filteredEmployees;
	private Employee selectedEmployee;

	@SuppressWarnings("unused")
	private List<TechLog> techLogs;
	private List<Technology> technologies;
	private TechLog technologyToADD;

	@PostConstruct
	private void init() {
		employees = employeeService.findAll();
		if (!employees.isEmpty())
			selectedEmployee = employees.get(0);
		technologies = techService.findAll();
		technologyToADD = new TechLog();
	}

	public IEmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public ITechLogService getTechLogService() {
		return techLogService;
	}

	public void setTechLogService(ITechLogService techService) {
		this.techLogService = techService;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public List<Employee> getFilteredEmployees() {
		return filteredEmployees;
	}
	
	
	public void setFilteredEmployees(List<Employee> filteredEmployees) {
		this.filteredEmployees = filteredEmployees;
	}

	public String getTableClientId() {
		FacesContext context = FacesContext.getCurrentInstance();
		UIViewRoot root = context.getViewRoot();

		final String componentId = "techTable";
		UIComponent c = findComponent(root, componentId);
		return c.getClientId(context);
	}

	private UIComponent findComponent(UIComponent c, String id) {
		if (id.equals(c.getId())) {
			return c;
		}
		Iterator<UIComponent> kids = c.getFacetsAndChildren();
		while (kids.hasNext()) {
			UIComponent found = findComponent(kids.next(), id);
			if (found != null) {
				return found;
			}
		}
		return null;
	}


	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
		System.out.println(selectedEmployee.getFullName());
	}

	public ITechnologyService getTechService() {
		return techService;
	}


	public void setTechService(ITechnologyService techService) {
		this.techService = techService;
	}


	public List<Technology> getTechnologies() {
		return technologies;
	}


	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}


	public TechLog getTechnologyToADD() {
		return technologyToADD;
	}

	public List<TechLog> getTechLogs() {
		if(selectedEmployee != null)
				return techLogs = techLogService.getTechLogForEmployee(selectedEmployee.getId());
		else
			return new LinkedList<TechLog>();
	}

	public void setTechLogs(List<TechLog> techLogs) {
		this.techLogs = techLogs;
	}

	public void setTechnologyToADD(TechLog technologyToADD) {
		this.technologyToADD = technologyToADD;
	}

	
	public int getNrTech(){
		List<String> differentTecs = new ArrayList<String>();
		for(TechLog tech: getTechLogs()){
			if(!differentTecs.contains(tech.getTechnology().getName())){
				differentTecs.add(tech.getTechnology().getName());
			}
		}
		
		return differentTecs.size();
	}
	
	public void addTech(ActionEvent event) {

		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean success;
		technologyToADD.setEmployee(selectedEmployee);
		try {
			techLogService.create(technologyToADD);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "New technology added!", null);
			success = true;
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Technology add Error: ", "Invalid fields!");
			success = false;
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("success", success);
	}

}
