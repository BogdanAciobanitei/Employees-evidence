package com.yonder.study.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yonder.study.base.BaseEntity;

@Entity
@Table(name = "Team")
public class Team extends BaseEntity{


	private static final long serialVersionUID = 1L;

	@Column(name = "name",unique = true, nullable = false, length = 100)
	private String name;
	
	@Column(name = "nbOfMembers", nullable = true)
	private Integer nbOfMembers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNbOfMembers() {
		return nbOfMembers;
	}

	public void setNbOfMembers(Integer nbOfMembers) {
		this.nbOfMembers = nbOfMembers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nbOfMembers == null) ? 0 : nbOfMembers.hashCode());
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
		Team other = (Team) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nbOfMembers == null) {
			if (other.nbOfMembers != null)
				return false;
		} else if (!nbOfMembers.equals(other.nbOfMembers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", nbOfMembers=" + nbOfMembers + "]";
	}

	
	
}
