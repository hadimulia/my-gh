package com.app.gh.service.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.app.generic.service.converter.ToDtoConverter;
import com.app.generic.service.converter.ToModelConverter;
import com.app.gh.persistence.dto.SellerDto;
import com.app.gh.persistence.model.Seller;

@Component
public class SellerConverter implements ToDtoConverter<Seller, SellerDto>,ToModelConverter<SellerDto, Seller>{

	
	public Seller toModel(SellerDto object) {
		Seller model = new Seller();
		model.setId(object.getId());
		model.setSellerName(object.getSellerName());
		model.setFullAddress(object.getFullAddress());
		model.setStoreId(object.getStoreId());
		return model;
	}

	public List<Seller> toModels(List<SellerDto> objects) {
		return objects.stream()
					  .map(m -> toModel(m))
					  .collect(Collectors.toList());
	}

	public SellerDto toDto(Seller object) {
		SellerDto dto = new SellerDto();
		dto.setId(object.getId());
		dto.setSellerName(object.getSellerName());
		dto.setFullAddress(object.getFullAddress());
		dto.setStoreId(object.getStoreId());
		return dto;
	}

	public List<SellerDto> toDtos(List<Seller> objects) {
		return objects.stream()
					  .map(m -> toDto(m))
					  .collect(Collectors.toList());
	}

}
