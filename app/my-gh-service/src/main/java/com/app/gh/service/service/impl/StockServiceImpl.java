package com.app.gh.service.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.generic.service.impl.TypicalGenericServiceImpl;
import com.app.gh.persistence.dao.StockDao;
import com.app.gh.persistence.dto.StockDto;
import com.app.gh.persistence.model.Stock;
import com.app.gh.service.converter.StockConverter;
import com.app.gh.service.service.StockService;

public class StockServiceImpl extends TypicalGenericServiceImpl<Stock, Long> implements StockService{

	@Autowired
	private StockConverter converter;
	
	private StockDao stockDao;
	
	@Autowired
	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
		this.typicalGenericDao =  stockDao;
		this.genericDao = stockDao;
	}

	@Override
	public Set<StockDto> getByStoreId(Long storeId) {
		return new HashSet<>(converter.toDtos(stockDao.getByStoreId(String.valueOf(storeId))));
	}

	@Override
	public StockDto getById(Long id) {
		return converter.toDto(stockDao.get(id));
	}

	@Override
	public StockDto save(StockDto dto) {
		return converter.toDto(stockDao.save(converter.toModel(dto)));
	}

}
