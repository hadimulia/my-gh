package com.app.gh.service.service;

import java.util.Set;

import com.app.generic.service.TypicalGenericService;
import com.app.gh.persistence.dto.StockDto;
import com.app.gh.persistence.model.Stock;

public interface StockService extends TypicalGenericService<Stock, Long>{

	Set<StockDto> getByStoreId(Long storeId);
	StockDto getById(Long id);
	StockDto save(StockDto dto);
}
