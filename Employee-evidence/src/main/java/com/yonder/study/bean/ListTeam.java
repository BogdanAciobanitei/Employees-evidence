package com.yonder.study.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import com.yonder.study.model.Employee;
import com.yonder.study.model.Team;
import com.yonder.study.model.TeamEmployee;
import com.yonder.study.service.IEmployeeService;
import com.yonder.study.service.ITeamEmployeeService;
import com.yonder.study.service.ITeamService;

@ManagedBean
@ViewScoped
public class ListTeam {

	@ManagedProperty("#{employeeService}")
	private IEmployeeService employeeService;

	@ManagedProperty("#{teamService}")
	private ITeamService teamService;

	@ManagedProperty("#{teamEmployeeService}")
	private ITeamEmployeeService teamEmployeeService;

	private List<Team> teams;
	private Team selectedTeam;
	private List<TeamEmployee> teamEmployees;
	private TeamEmployee selectedTeamEmployee;
	private TeamEmployee teamEmployeeToAdd;
	private List<Employee> allEmployeeList;
	
	private boolean teamsCacheDirty;
	private boolean teamEmployeesCacheDirty;
	private boolean allEmployeeCacheDirty;

	@PostConstruct
	private void init(){
		teamEmployeeToAdd = new TeamEmployee();
	}
	
	public IEmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public ITeamService getTeamService() {
		return teamService;
	}

	public void setTeamService(ITeamService teamService) {
		this.teamService = teamService;
	}

	public ITeamEmployeeService getTeamEmployeeService() {
		return teamEmployeeService;
	}

	public void setTeamEmployeeService(ITeamEmployeeService teamEmployeeService) {
		this.teamEmployeeService = teamEmployeeService;
	}

	public List<Team> getTeams() {
		if (teams == null || teamsCacheDirty) {
			teams = teamService.findAll();
			teamsCacheDirty = false;
		}
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Team getSelectedTeam() {
		return selectedTeam;
	}

	public void setSelectedTeam(Team selectedTeam) {
		if (selectedTeam != this.selectedTeam) {
			this.selectedTeam = selectedTeam;
			markTeamEmployeeCacheDirty();
		}
	}
	
	public TeamEmployee getSelectedTeamEmployee(){
		return selectedTeamEmployee;
	}
	
	public void setSelectedTeamEmployee(TeamEmployee selectedTeamEmployee){
		this.selectedTeamEmployee = selectedTeamEmployee;
	}

	public List<TeamEmployee> getTeamEmployees() {
		if ((teamEmployees == null || teamEmployeesCacheDirty) && selectedTeam != null) {
			teamEmployees = teamEmployeeService.getEmployeesForTeam(selectedTeam.getId());
			teamEmployeesCacheDirty = false;
		}
		return teamEmployees;
	}
	
	public List<Employee> getAllEmployeeList() {
		if(allEmployeeList == null || allEmployeeCacheDirty){
			allEmployeeList = employeeService.findAll();
		}
		return allEmployeeList;
	}

	public void setAllEmployeeList(List<Employee> allEmployeeList) {
		this.allEmployeeList = allEmployeeList;
	}

	public void setTeamEmployees(List<TeamEmployee> teamEmployees) {
		this.teamEmployees = teamEmployees;
	}
	
	public TeamEmployee getTeamEmployeeToAdd() {
		return teamEmployeeToAdd;
	}

	public void setTeamEmployeeToAdd(TeamEmployee teamEmployeeToAdd) {
		this.teamEmployeeToAdd = teamEmployeeToAdd;
	}

	public void addEmployee(ActionEvent event) {

		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean success;
		try {
			teamEmployeeToAdd.setTeam(selectedTeam);
			teamEmployeeService.create(teamEmployeeToAdd);
			selectedTeam.setNbOfMembers(selectedTeam.getNbOfMembers() + 1);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "New employee added!", null);
			success = true;
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Employee add Error: ", null);
			success = false;
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("success", success);
	}
	
	public void removeEmployee(ActionEvent event) {

		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean success;
		try {
			teamEmployeeService.delete(selectedTeamEmployee);
			selectedTeam.setNbOfMembers(selectedTeam.getNbOfMembers() - 1);
			teamService.update(selectedTeam);
			selectedTeamEmployee = null;
			markTeamEmployeeCacheDirty();
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Employee removed from the team!", null);
			success = true;
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Could not remove employee from the team", null);
			success = false;
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("success", success);
	}
	
	public boolean isRemoveButtonDisabled(){
		return selectedTeamEmployee == null;
	}
	
	private void markTeamEmployeeCacheDirty(){
		teamEmployeesCacheDirty = true;
		allEmployeeCacheDirty = true;
		teamsCacheDirty = true;
	}
	
}
