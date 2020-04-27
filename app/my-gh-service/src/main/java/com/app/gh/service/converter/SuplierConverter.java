package com.app.gh.service.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.app.generic.service.converter.ToDtoConverter;
import com.app.generic.service.converter.ToModelConverter;
import com.app.gh.persistence.dto.SuplierDto;
import com.app.gh.persistence.model.Suplier;

@Component
public class SuplierConverter implements ToDtoConverter<Suplier, SuplierDto>,ToModelConverter<SuplierDto, Suplier>{

	
	public Suplier toModel(SuplierDto object) {
		Suplier model = new Suplier();
		model.setId(object.getId());
		model.setSuplierName(object.getSuplierName());
		model.setFullAddress(object.getFullAddress());
		model.setStoreId(object.getStoreId());
		return model;
	}

	public List<Suplier> toModels(List<SuplierDto> objects) {
		return objects.stream()
					  .map(m -> toModel(m))
					  .collect(Collectors.toList());
	}

	public SuplierDto toDto(Suplier object) {
		SuplierDto dto = new SuplierDto();
		dto.setId(object.getId());
		dto.setSuplierName(object.getSuplierName());
		dto.setFullAddress(object.getFullAddress());
		dto.setStoreId(object.getStoreId());
		return dto;
	}

	public List<SuplierDto> toDtos(List<Suplier> objects) {
		return objects.stream()
					  .map(m -> toDto(m))
					  .collect(Collectors.toList());
	}

}
