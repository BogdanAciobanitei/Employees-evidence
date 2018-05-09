package com.yonder.study.service;

import java.util.List;

import com.yonder.study.base.AbstractService;
import com.yonder.study.model.TechLog;

public interface ITechLogService extends AbstractService<TechLog>{

	public List<TechLog> getTechLogForEmployee(long employeeId);
	
	public List<TechLog> getTechLogForTechnology(long technologyId);
	
	public List<TechLog> getTechLog(long employeeId, long technologyId);
	
}
