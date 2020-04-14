package com.app.gh.persistence.dto;

import com.app.generic.persistence.annotation.IsRequired;

public class TransactionCodeDto {

	
	private Long id;

	@IsRequired
	private String trxCode;

	@IsRequired
	private String description;
	
	@IsRequired
	private Long coaId;
	
	@IsRequired
	private String storeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrxCode() {
		return trxCode;
	}

	public void setTrxCode(String trxCode) {
		this.trxCode = trxCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCoaId() {
		return coaId;
	}

	public void setCoaId(Long coaId) {
		this.coaId = coaId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	@Override
	public String toString() {
		return "TransactionCodeDto [id=" + id + ", trxCode=" + trxCode + ", description=" + description + ", coaId="
				+ coaId + ", storeId=" + storeId + "]";
	}

}
