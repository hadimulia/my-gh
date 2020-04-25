package com.app.gh.service.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.app.generic.service.converter.ToDtoConverter;
import com.app.generic.service.converter.ToModelConverter;
import com.app.gh.persistence.dto.CoaDto;
import com.app.gh.persistence.model.Coa;

@Component
public class CoaConverter implements ToDtoConverter<Coa, CoaDto>,ToModelConverter<CoaDto, Coa>{

	public Coa toModel(CoaDto object) {
		Coa model = new Coa();
		model.setId(object.getId());
		model.setCoaCode(object.getCoaCode());
		model.setDescription(object.getDescription());
		model.setCoaType(object.getCoaType());
		model.setStoreId(object.getStoreId());
		return model;
	}

	public List<Coa> toModels(List<CoaDto> objects) {
		return objects.stream()
					  .map(m -> toModel(m))
					  .collect(Collectors.toList());
	}

	public CoaDto toDto(Coa object) {
		CoaDto dto = new CoaDto();
		dto.setId(object.getId());
		dto.setCoaCode(object.getCoaCode());
		dto.setDescription(object.getDescription());
		dto.setCoaType(object.getCoaType());
		dto.setStoreId(object.getStoreId());
		return dto;
	}

	public List<CoaDto> toDtos(List<Coa> objects) {
		return objects.stream()
					  .map(m -> toDto(m))
					  .collect(Collectors.toList());
	}

}
