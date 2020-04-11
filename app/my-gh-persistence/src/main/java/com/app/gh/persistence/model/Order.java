package com.app.gh.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.generic.persistence.model.TypicalGenericModel;
import com.app.gh.core.enums.OrderStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_seller")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order extends TypicalGenericModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4242718765540260603L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "order_code",length = 10)
	private String orderCode; // it will be auto generate
	
	@Column(name = "order_status")
	private OrderStatusEnum orderStatus;
	
	@Column(name = "term")
	private Long term;
	
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

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderCode=" + orderCode + ",  orderStatus=" + orderStatus
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderCode == null) ? 0 : orderCode.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderCode == null) {
			if (other.orderCode != null)
				return false;
		} else if (!orderCode.equals(other.orderCode))
			return false;
		if (orderStatus != other.orderStatus)
			return false;
		return true;
	}
	
	
}
