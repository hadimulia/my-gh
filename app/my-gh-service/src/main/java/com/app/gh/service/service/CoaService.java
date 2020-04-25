package com.app.gh.service.service;

import java.util.Set;

import com.app.generic.service.TypicalGenericService;
import com.app.gh.persistence.dto.CoaDto;
import com.app.gh.persistence.model.Coa;

public interface CoaService extends TypicalGenericService<Coa, Long>{

	Set<CoaDto> getByStoreId(Long storeId);
	CoaDto getById(Long id);
	CoaDto save(CoaDto dto);
	
}
