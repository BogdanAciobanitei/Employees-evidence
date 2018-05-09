package com.yonder.study.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import com.yonder.study.model.TechLog;
import com.yonder.study.model.Technology;
import com.yonder.study.service.ITechLogService;
import com.yonder.study.service.ITechnologyService;

@ManagedBean
@SessionScoped
public class ListTechnology implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{techLogService}")
	private ITechLogService techLogService;

	@ManagedProperty("#{technologyService}")
	private ITechnologyService technologyService;

	private List<TechLog> techLogs;
	private List<Technology> technologies;

	private Technology selectedTechnology;
	
	private Technology technologyToADD;

	
	@PostConstruct
	private void init(){
		technologyToADD = new Technology();
		technologies = technologyService.findAll();
	}
	
	
	public ITechLogService getTechLogService() {
		return techLogService;
	}

	public void setTechLogService(ITechLogService techLogService) {
		this.techLogService = techLogService;
	}

	public ITechnologyService getTechnologyService() {
		return technologyService;
	}

	public void setTechnologyService(ITechnologyService technologyService) {
		this.technologyService = technologyService;
	}

	public List<TechLog> getTechLogs() {
		return techLogService.findAll();
	}

	public void setTechLogs(List<TechLog> technLogs) {
		this.techLogs = technLogs;
	}

	public List<Technology> getTechnologies() {
		return technologyService.findAll();
	}

	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}

	public Technology getSelectedTechnology() {
		return selectedTechnology;
	}

	public void setSelectedTechnology(Technology selectedTechnology) {
		this.selectedTechnology = selectedTechnology;
	}
	

	public Technology getTechnologyToADD() {
		return technologyToADD;
	}

	public void setTechnologyToADD(Technology technologyToADD) {
		this.technologyToADD = technologyToADD;
	}

	public void addTech(ActionEvent event) {

		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean loggedIn = false;

		System.out.println("Here we are "  + technologyToADD);
		if (technologyToADD.getName() != null) {
			loggedIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "New technology added!", null);
			technologyService.create(technologyToADD);

		} else {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Technology add Error: ", "Invalid fields!");
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("loggedIn", loggedIn);
	}

}
