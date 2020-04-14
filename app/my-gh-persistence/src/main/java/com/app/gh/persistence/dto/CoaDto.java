package com.app.gh.persistence.dto;

import com.app.generic.persistence.annotation.IsRequired;
import com.app.gh.core.enums.CoaTypeEnum;

public class CoaDto {

	private Long id;
	
	@IsRequired
	private String coaCode;
	
	@IsRequired
	private String description;
	
	@IsRequired
	private CoaTypeEnum coaType;
	
	@IsRequired
	private String storeId;

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

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	@Override
	public String toString() {
		return "CoaDto [id=" + id + ", coaCode=" + coaCode + ", description=" + description + ", coaType=" + coaType
				+ ", storeId=" + storeId + "]";
	}
	
	
}
