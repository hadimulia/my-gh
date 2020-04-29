package com.app.gh.persistence.dto;

import com.app.generic.persistence.annotation.IsRequired;

public class CustomerDto {

	private Long id;
	
	@IsRequired
	private String customerName;
	
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
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
		return "CustomerDto [id=" + id + ", customerName=" + customerName + ", fullAddress=" + fullAddress
				+ ", storeId=" + storeId + "]";
	}

}
