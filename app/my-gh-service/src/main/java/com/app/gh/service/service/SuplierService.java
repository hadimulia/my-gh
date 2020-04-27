package com.app.gh.service.service;

import java.util.Set;

import com.app.generic.service.TypicalGenericService;
import com.app.gh.persistence.dto.SuplierDto;
import com.app.gh.persistence.model.Suplier;

public interface SuplierService extends TypicalGenericService<Suplier, Long> {

	Set<SuplierDto> getByStoreId(Long storeId);
	SuplierDto getById(Long id);
	SuplierDto save(SuplierDto dto);
}
