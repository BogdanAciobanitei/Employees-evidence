package com.yonder.study.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.yonder.study.model.Employee;
import com.yonder.study.model.Technology;
import com.yonder.study.service.IEmployeeService;

@ManagedBean
@FacesConverter(forClass = Technology.class)
public class EmployeeConverter implements Converter{
	
	@ManagedProperty("#{employeeService}")
	private IEmployeeService service;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Long id = null;
		if(value!=null)
			id = Long.valueOf(value);
		if(id!=null)
			return service.get(id);
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Employee emp;
		emp = (Employee) value;
		return String.valueOf(emp.getId());
	}

	public IEmployeeService getService() {
		return service;
	}

	public void setService(IEmployeeService service) {
		this.service = service;
	}
	
	

}
