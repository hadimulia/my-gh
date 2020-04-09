package com.anabatic.generic.endpoint.contract;

import com.app.generic.persistence.annotation.PositiveNumber;
import com.app.generic.persistence.enums.Order;

/**
 * For request that need paging function.
 * 
 * @author M Lukmanul Hakim (m.hakim &copy;Jan 15, 2019) 
 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
 */
public class BasePagingRequest {
	
	@PositiveNumber(includeZero=false)
	private Integer page;
	@PositiveNumber(includeZero=false)
	private Integer pageSize;
	private String orderBy;
	private Order order;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
