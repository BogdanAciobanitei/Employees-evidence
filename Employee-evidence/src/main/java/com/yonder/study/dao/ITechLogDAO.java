package com.yonder.study.dao;

import java.util.List;

import com.yonder.study.base.AbstractDAO;
import com.yonder.study.model.TechLog;

public interface ITechLogDAO extends AbstractDAO<TechLog>{

	public List<TechLog> getTechLogForEmployee(long employeeId);
	
	public List<TechLog> getTechLogForTechnology(long technologyId);
	
	public List<TechLog> getTechLog(long employeeId, long technologyId);
	
}
