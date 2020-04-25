package com.app.gh.service.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.app.generic.service.converter.ToDtoConverter;
import com.app.generic.service.converter.ToModelConverter;
import com.app.gh.persistence.dto.StoreDto;
import com.app.gh.persistence.model.Store;

@Component
public class StoreConverter implements ToDtoConverter<Store, StoreDto>,ToModelConverter<StoreDto, Store>{

	public Store toModel(StoreDto object) {
		Store model = new Store();
		model.setId(object.getId());
		model.setStoreName(object.getStoreName());
		model.setFullAddress(object.getFullAddress());
		model.setLogo(object.getLogo());
		return model;
	}

	public List<Store> toModels(List<StoreDto> objects) {
		return objects.stream()
					  .map(m -> toModel(m))
					  .collect(Collectors.toList());
	}

	public StoreDto toDto(Store object) {
		StoreDto dto = new StoreDto();
		dto.setId(object.getId());
		dto.setStoreName(object.getStoreName());
		dto.setFullAddress(object.getFullAddress());
		dto.setLogo(object.getLogo());
		return dto;
	}

	public List<StoreDto> toDtos(List<Store> objects) {
		return objects.stream()
					  .map(m -> toDto(m))
					  .collect(Collectors.toList());
	}

}
