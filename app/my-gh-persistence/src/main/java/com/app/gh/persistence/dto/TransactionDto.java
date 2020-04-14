package com.app.gh.persistence.dto;

import java.math.BigDecimal;
import java.time.Instant;

import com.app.generic.persistence.annotation.IsRequired;

public class TransactionDto {

	private Long id;

	@IsRequired
	private String trxCode;

	private Instant trxTime = Instant.now();

	private Long posting = 0L;
	
	private String orderCode;
	
	@IsRequired
	private BigDecimal amount;

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

	public Instant getTrxTime() {
		return trxTime;
	}

	public void setTrxTime(Instant trxTime) {
		this.trxTime = trxTime;
	}

	public Long getPosting() {
		return posting;
	}

	public void setPosting(Long posting) {
		this.posting = posting;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	@Override
	public String toString() {
		return "TransactionDto [id=" + id + ", trxCode=" + trxCode + ", trxTime=" + trxTime + ", posting=" + posting
				+ ", orderCode=" + orderCode + ", amount=" + amount + ", storeId=" + storeId + "]";
	}
	
}
