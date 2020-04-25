package com.app.gh.service.service;

import java.util.List;

import com.app.generic.service.GenericService;
import com.app.gh.persistence.dto.StoreDto;
import com.app.gh.persistence.model.Store;

public interface StoreService extends GenericService<Store, Long>{

	List<StoreDto> getAllActive();
	StoreDto getById(Long id);
	StoreDto save(StoreDto dto);
}
