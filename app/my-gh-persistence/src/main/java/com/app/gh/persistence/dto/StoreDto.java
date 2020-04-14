package com.app.gh.persistence.dto;

import com.app.generic.persistence.annotation.IsRequired;

public class StoreDto {

	private Long id;

	@IsRequired
	private String storeName;

	@IsRequired
	private String fullAddress;

	@IsRequired
	private String logo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "StoreDto [id=" + id + ", storeName=" + storeName + ", fullAddress=" + fullAddress + ", logo=" + logo
				+ "]";
	}
	
	
}
