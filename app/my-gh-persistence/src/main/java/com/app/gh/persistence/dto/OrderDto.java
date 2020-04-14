package com.app.gh.persistence.dto;

import java.util.Set;

import com.app.generic.persistence.annotation.IsRequired;
import com.app.gh.core.enums.OrderStatusEnum;

public class OrderDto {

	private Long id;

	private String orderCode; // it will be auto generate
	
	private OrderStatusEnum orderStatus;
	
	@IsRequired
	private Long term;
	
	@IsRequired
	private String storeId;
	
	private Set<OrderDetailDto> orders;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public OrderStatusEnum getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatusEnum orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getTerm() {
		return term;
	}

	public void setTerm(Long term) {
		this.term = term;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public Set<OrderDetailDto> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderDetailDto> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "OrderDto [id=" + id + ", orderCode=" + orderCode + ", orderStatus=" + orderStatus + ", term=" + term
				+ ", storeId=" + storeId + ", orders=" + orders + "]";
	}

}
