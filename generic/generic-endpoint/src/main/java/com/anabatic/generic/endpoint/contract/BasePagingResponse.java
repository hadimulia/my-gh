package com.anabatic.generic.endpoint.contract;

import com.app.generic.persistence.dto.Paging;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Using for paging response result
 * 
 * @author M Lukmanul Hakim (m.hakim &copy;Jan 15, 2019) 
 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
 */
@JsonInclude(Include.NON_NULL)
public class BasePagingResponse extends BaseResponse{
	
	private static final long serialVersionUID = -7532540710562984757L;
	
	private Integer page;
	private Integer pageSize;
	private Long recordTotal;
	
	public BasePagingResponse() {
		super();
	}
	public BasePagingResponse(Integer page, Integer pageSize, Long recordTotal) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.recordTotal = recordTotal;
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

	@Override
	public void setResponse(Object response) {
		if (response instanceof Paging<?>) {
			Paging<?> paging = (Paging<?>) response;
			this.page = paging.getPage();
			this.pageSize = paging.getPageSize();
			this.recordTotal = paging.getRecordTotal();
			super.setResponse(paging.getData());
		}
	}
}
