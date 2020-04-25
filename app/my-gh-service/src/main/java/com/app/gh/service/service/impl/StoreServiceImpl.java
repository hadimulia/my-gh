package com.app.gh.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.generic.service.impl.GenericServiceImpl;
import com.app.gh.persistence.dao.StoreDao;
import com.app.gh.persistence.dto.StoreDto;
import com.app.gh.persistence.model.Store;
import com.app.gh.service.converter.StoreConverter;
import com.app.gh.service.service.StoreService;

public class StoreServiceImpl extends GenericServiceImpl<Store, Long> implements StoreService{

	@Autowired
	private StoreConverter converter;
	
	private StoreDao storeDao;
	
	@Autowired
	public void setStoreDao(StoreDao storeDao) {
		this.storeDao = storeDao;
		this.genericDao = storeDao;
	}

	@Override
	public List<StoreDto> getAllActive() {
		return converter.toDtos(storeDao.getAll());
	}

	@Override
	public StoreDto getById(Long id) {
		return converter.toDto(storeDao.get(id));
	}

	@Override
	public StoreDto save(StoreDto dto) {
		return converter.toDto(storeDao.save(converter.toModel(dto)));
	}
	


	

}
