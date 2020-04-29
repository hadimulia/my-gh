package com.app.gh.service.service;

import java.util.Set;

import com.app.generic.service.TypicalGenericService;
import com.app.gh.persistence.dto.CustomerDto;
import com.app.gh.persistence.model.Customer;

public interface CustomerService extends TypicalGenericService<Customer, Long>{

	Set<CustomerDto> getByStoreId(Long storeId);
	CustomerDto getById(Long id);
	CustomerDto save(CustomerDto dto);
}
