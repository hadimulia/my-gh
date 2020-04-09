package com.app.generic.persistence.dto;

import com.app.generic.persistence.enums.Order;

/**
 * Pageable object that using for Generic Paging
 * For mapping from request to DTO
 * 
 * @author M Lukmanul Hakim (m.hakim &copy;Jan 15, 2019) 
 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
 */
public class Pageable {
	private Integer page;
	private Integer pageSize;
	private String orderBy;
	private Order order;
	
	public Pageable() {
		super();
	}
	public Pageable(Integer page, Integer pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}
	public Pageable(Integer page, Integer pageSize, String orderBy, Order order) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.orderBy = orderBy;
		this.order = order;
	}
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