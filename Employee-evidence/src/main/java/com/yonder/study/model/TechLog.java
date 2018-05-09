package com.yonder.study.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.yonder.study.base.BaseEntity;


@Entity
@Table(name = "TechLog")
public class TechLog extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "idTechnology", nullable = false)
	private Technology technology;
	
	@ManyToOne
	@JoinColumn(name = "idEmployee", nullable = false)
	private Employee employee;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "rate", nullable = false)
	private Integer rate;

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		result = prime * result + ((technology == null) ? 0 : technology.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TechLog other = (TechLog) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		if (technology == null) {
			if (other.technology != null)
				return false;
		} else if (!technology.equals(other.technology))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TechLog [technology=" + technology + ", employee=" + employee + ", date=" + date + ", rate=" + rate
				+ "]";
	}
	
	
	
}
