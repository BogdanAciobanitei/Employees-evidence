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

import com.yonder.study.model.Technology;
import com.yonder.study.service.ITechnologyService;

@RestController
@RequestMapping(path = "/technology")
public class TechnologyController {

	@Autowired
	ITechnologyService service;
	
	@RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Technology> getTechnology(@PathVariable long id) {
		
		Technology technology = service.get(id);
		if(technology != null)
			return new ResponseEntity<Technology>(technology, HttpStatus.OK);
		else
			return new ResponseEntity<Technology>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Technology>> getTechnologies() {
		List<Technology> technologies = service.findAll();
		return new ResponseEntity<List<Technology>>(technologies, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public ResponseEntity<Technology> createTechnology(@RequestBody Technology technology) {
		
		technology = service.create(technology);
		if(technology != null)
			return new ResponseEntity<Technology>(technology, HttpStatus.CREATED);
		else
			return new ResponseEntity<Technology>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Technology> updateTechnology(@RequestBody Technology technology, @PathVariable long id) {
		
		Technology currentTechnology;
		currentTechnology = service.get(id);
		if(currentTechnology == null)
			return new ResponseEntity<Technology>(HttpStatus.NOT_FOUND);
		
		currentTechnology.setName(technology.getName());
		service.update(currentTechnology);
		
		return new ResponseEntity<Technology>(currentTechnology, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Technology> deleteTechnology(@PathVariable long id) {
		Technology technology = service.get(id);
		if(technology == null){
			return new ResponseEntity<Technology>(HttpStatus.NOT_FOUND);
		}
		else{
			service.delete(technology);
			return new ResponseEntity<Technology>(HttpStatus.OK);
		}
	}
	
}
