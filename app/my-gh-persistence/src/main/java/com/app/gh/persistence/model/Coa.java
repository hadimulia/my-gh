package com.app.gh.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.generic.persistence.model.TypicalGenericModel;
import com.app.gh.core.enums.CoaTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_coa")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Coa extends TypicalGenericModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4329122335732501186L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "coa_code")
	private String coaCode;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "coa_type")
	private CoaTypeEnum coaType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCoaCode() {
		return coaCode;
	}

	public void setCoaCode(String coaCode) {
		this.coaCode = coaCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CoaTypeEnum getCoaType() {
		return coaType;
	}

	public void setCoaType(CoaTypeEnum coaType) {
		this.coaType = coaType;
	}

	@Override
	public String toString() {
		return "Coa [id=" + id + ",  coaCode=" + coaCode + ", description=" + description
				+ ", coaType=" + coaType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coaCode == null) ? 0 : coaCode.hashCode());
		result = prime * result + ((coaType == null) ? 0 : coaType.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coa other = (Coa) obj;
		if (coaCode == null) {
			if (other.coaCode != null)
				return false;
		} else if (!coaCode.equals(other.coaCode))
			return false;
		if (coaType != other.coaType)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
