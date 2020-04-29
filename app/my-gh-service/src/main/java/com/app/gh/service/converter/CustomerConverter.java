package com.app.gh.service.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.app.generic.service.converter.ToDtoConverter;
import com.app.generic.service.converter.ToModelConverter;
import com.app.gh.persistence.dto.CustomerDto;
import com.app.gh.persistence.model.Customer;

@Component
public class CustomerConverter implements ToDtoConverter<Customer, CustomerDto>,ToModelConverter<CustomerDto, Customer>{

	
	public Customer toModel(CustomerDto object) {
		Customer model = new Customer();
		model.setId(object.getId());
		model.setCustomerName(object.getCustomerName());
		model.setFullAddress(object.getFullAddress());
		model.setStoreId(object.getStoreId());
		return model;
	}

	public List<Customer> toModels(List<CustomerDto> objects) {
		return objects.stream()
					  .map(m -> toModel(m))
					  .collect(Collectors.toList());
	}

	public CustomerDto toDto(Customer object) {
		CustomerDto dto = new CustomerDto();
		dto.setId(object.getId());
		dto.setCustomerName(object.getCustomerName());
		dto.setFullAddress(object.getFullAddress());
		dto.setStoreId(object.getStoreId());
		return dto;
	}

	public List<CustomerDto> toDtos(List<Customer> objects) {
		return objects.stream()
					  .map(m -> toDto(m))
					  .collect(Collectors.toList());
	}

}
