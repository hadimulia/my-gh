package com.app.generic.service.converter;

import java.util.List;

/**
 * Interface for converter which convert an object into DTO
 * 
 * @author Kusmawati
 */
public interface ToDtoConverter<OBJECT, DTO> {
	DTO toDto(OBJECT object);

	List<DTO> toDtos(List<OBJECT> objects);
}
