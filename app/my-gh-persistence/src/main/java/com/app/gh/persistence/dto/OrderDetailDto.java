package com.app.gh.persistence.dto;

public class OrderDetailDto {

	private Long id;

	private Long stockId;

	private Long qty;

	private Long qtySent = 0L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public Long getQtySent() {
		return qtySent;
	}

	public void setQtySent(Long qtySent) {
		this.qtySent = qtySent;
	}

	@Override
	public String toString() {
		return "OrderDetailDto [id=" + id + ", stockId=" + stockId + ", qty=" + qty + ", qtySent=" + qtySent + "]";
	}

	
}
