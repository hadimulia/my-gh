package com.app.gh.persistence.dto;

import com.app.generic.persistence.annotation.IsRequired;

public class SuplierDto {

	private Long id;

	@IsRequired
	private String suplierName;

	@IsRequired
	private String fullAddress;

	@IsRequired
	private String storeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSuplierName() {
		return suplierName;
	}

	public void setSuplierName(String suplierName) {
		this.suplierName = suplierName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	@Override
	public String toString() {
		return "SuplierDto [id=" + id + ", suplierName=" + suplierName + ", fullAddress=" + fullAddress + ", storeId="
				+ storeId + "]";
	}
	
	
}
