package com.app.gh.service.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.generic.service.impl.TypicalGenericServiceImpl;
import com.app.gh.persistence.dao.CustomerDao;
import com.app.gh.persistence.dto.CustomerDto;
import com.app.gh.persistence.model.Customer;
import com.app.gh.service.converter.CustomerConverter;
import com.app.gh.service.service.CustomerService;

public class CustomerServiceImpl extends TypicalGenericServiceImpl<Customer, Long> implements CustomerService{

	@Autowired
	private CustomerConverter converter;
	
	private CustomerDao customerDao;
	
	@Autowired
	public void setStockDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
		this.typicalGenericDao = customerDao;
		this.genericDao = customerDao;
	}

	@Override
	public Set<CustomerDto> getByStoreId(Long storeId) {
		return new HashSet<>(converter.toDtos(customerDao.getByStoreId(String.valueOf(storeId))));
	}

	@Override
	public CustomerDto getById(Long id) {
		return converter.toDto(customerDao.get(id));
	}

	@Override
	public CustomerDto save(CustomerDto dto) {
		return converter.toDto(customerDao.save(converter.toModel(dto)));
	}

}
