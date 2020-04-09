package com.app.generic.persistence.dto;

import java.util.List;

/**
 * This class using for Paging result.
 * 
 * @author M Lukmanul Hakim (m.hakim &copy;Jan 15, 2019) 
 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
 * @param <M>
 */
public class Paging<M> {
	private Integer page;
	private Integer pageSize;
	private Long recordTotal;
	private List<M> data;
	
	
	public Paging() {
		super();
	}
	public Paging(Integer page, Integer pageSize, Long recordTotal, List<M> data) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.recordTotal = recordTotal;
		this.data = data;
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
	public Long getRecordTotal() {
		return recordTotal;
	}
	public void setRecordTotal(Long recordTotal) {
		this.recordTotal = recordTotal;
	}
	public List<M> getData() {
		return data;
	}
	public void setData(List<M> data) {
		this.data = data;
	}
}
