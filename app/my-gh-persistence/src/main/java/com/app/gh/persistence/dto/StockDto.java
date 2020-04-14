package com.app.gh.persistence.dto;

import com.app.generic.persistence.annotation.IsRequired;
import com.app.gh.core.enums.StockStatusEnum;
import com.app.gh.core.enums.UnitEnum;

public class StockDto {

	private Long id;

	@IsRequired
	private String name;

	@IsRequired
	private String code;

	@IsRequired
	private UnitEnum unit;

	@IsRequired
	private Long qty;

	@IsRequired
	private Long price;

	@IsRequired
	private StockStatusEnum stockStatus;
	
	@IsRequired
	private String storeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public UnitEnum getUnit() {
		return unit;
	}

	public void setUnit(UnitEnum unit) {
		this.unit = unit;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public StockStatusEnum getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(StockStatusEnum stockStatus) {
		this.stockStatus = stockStatus;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	@Override
	public String toString() {
		return "StockDto [id=" + id + ", name=" + name + ", code=" + code + ", unit=" + unit + ", qty=" + qty
				+ ", price=" + price + ", stockStatus=" + stockStatus + ", storeId=" + storeId + "]";
	}
	
	
}
