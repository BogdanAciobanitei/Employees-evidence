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

import com.yonder.study.model.TechLog;
import com.yonder.study.service.ITechLogService;

@RestController
@RequestMapping("/techlog")
public class TechLogController {
	
	@Autowired
	ITechLogService service;
	
	@RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<TechLog> getTechLog(@PathVariable long id) {
		TechLog techLog = service.get(id);
		if(techLog != null)
			return new ResponseEntity<TechLog>(techLog, HttpStatus.OK);
		else
			return new ResponseEntity<TechLog>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/get/employee/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<TechLog>> getTechLogForEmployee(@PathVariable long id) {
		List<TechLog> techLogs = service.getTechLogForEmployee(id);
		if(techLogs != null)
			return new ResponseEntity<List<TechLog>>(techLogs, HttpStatus.OK);
		else
			return new ResponseEntity<List<TechLog>>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/get/technology/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<TechLog>> getTechLogForTechnology(@PathVariable long id) {
		List<TechLog> techLogs = service.getTechLogForTechnology(id);
		if(techLogs != null)
			return new ResponseEntity<List<TechLog>>(techLogs, HttpStatus.OK);
		else
			return new ResponseEntity<List<TechLog>>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/get/employee/{employeeId}/technology/{technologyId}", method = RequestMethod.GET)
	public ResponseEntity<List<TechLog>> getTechLog(@PathVariable long employeeId, @PathVariable long technologyId) {
		List<TechLog> techLogs = service.getTechLog(employeeId, technologyId);
		if(techLogs != null)
			return new ResponseEntity<List<TechLog>>(techLogs, HttpStatus.OK);
		else
			return new ResponseEntity<List<TechLog>>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<TechLog>> getTechLogs() {
		List<TechLog> techLogs = service.findAll();
		return new ResponseEntity<List<TechLog>>(techLogs, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public ResponseEntity<TechLog> createTechLog(@RequestBody TechLog techLog) {
		
		techLog = service.create(techLog);
		if(techLog != null)
			return new ResponseEntity<TechLog>(techLog, HttpStatus.CREATED);
		else
			return new ResponseEntity<TechLog>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TechLog> updateTechLog(@RequestBody TechLog techLog, @PathVariable long id) {
		
		TechLog currentTechLog;
		currentTechLog = service.get(id);
		if(currentTechLog == null)
			return new ResponseEntity<TechLog>(HttpStatus.NOT_FOUND);
		
		currentTechLog.setEmployee(techLog.getEmployee());
		currentTechLog.setTechnology(techLog.getTechnology());
		currentTechLog.setDate(techLog.getDate());
		currentTechLog.setRate(techLog.getRate());
		service.update(currentTechLog);
		
		return new ResponseEntity<TechLog>(currentTechLog, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TechLog> createTechLog(@PathVariable long id) {
		TechLog techLog = service.get(id);
		if(techLog == null){
			return new ResponseEntity<TechLog>(HttpStatus.NOT_FOUND);
		}
		else{
			service.delete(techLog);
			return new ResponseEntity<TechLog>(HttpStatus.OK);
		}
	}
}
