package com.yonder.study.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.yonder.study.model.Technology;
import com.yonder.study.service.ITechnologyService;

@ManagedBean
@FacesConverter(forClass = Technology.class)
public class TechnologyConverter implements Converter{
	
	@ManagedProperty("#{technologyService}")
	private ITechnologyService service;
	
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
		Technology tech;
		tech = (Technology)value;
		return String.valueOf(tech.getId());
	}

	public ITechnologyService getService() {
		return service;
	}

	public void setService(ITechnologyService service) {
		this.service = service;
	}
	
	

}
