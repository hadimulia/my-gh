package com.app.gh.persistence.dto;

import com.app.generic.persistence.annotation.IsRequired;

public class SellerDto {

	private Long id;

	@IsRequired
	private String sellerName;

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

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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
		return "SellerDto [id=" + id + ", sellerName=" + sellerName + ", fullAddress=" + fullAddress + ", storeId="
				+ storeId + "]";
	}
	
}
