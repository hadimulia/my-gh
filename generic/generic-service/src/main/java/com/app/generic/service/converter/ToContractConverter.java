package com.app.generic.service.converter;

import java.util.List;

/**
 * Interface for converter which convert an object into contract
 * 
 * @author Kusmawati
 */
public interface ToContractConverter<OBJECT, CONTRACT> {
	CONTRACT toContract(OBJECT object);

	List<CONTRACT> toContracts(List<OBJECT> objects);
}
