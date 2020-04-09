package com.app.generic.service.converter;

import java.util.List;

/**
 * Interface for converter which convert an object into Model 
 * 
 * @author Kusmawati
 */
public interface ToModelConverter<OBJECT, MODEL> {
	MODEL toModel(OBJECT object);

	List<MODEL> toModels(List<OBJECT> objects);
}
