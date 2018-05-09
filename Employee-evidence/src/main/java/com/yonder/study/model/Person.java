package com.yonder.study.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.yonder.study.base.BaseEntity;

@MappedSuperclass
public class Person extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column(name = "fullName",unique = true, nullable = false, length = 100)
	protected String fullName;

	@Column(name = "email", nullable = true,unique = true, length = 100)
	protected String email;
	
	@Column(name = "sex", nullable = true, length = 6)
	protected String sex;
	
	@Column(name = "address", nullable = true, length = 255)
	protected String address;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [fullName=" + fullName + ", email=" + email + ", sex=" + sex + ", address=" + address + "]";
	}
	
}
