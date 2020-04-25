package com.app.gh.service.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.generic.service.impl.TypicalGenericServiceImpl;
import com.app.gh.persistence.dao.CoaDao;
import com.app.gh.persistence.dto.CoaDto;
import com.app.gh.persistence.model.Coa;
import com.app.gh.service.converter.CoaConverter;
import com.app.gh.service.service.CoaService;

public class CoaServiceImpl extends TypicalGenericServiceImpl<Coa, Long> implements CoaService{

	@Autowired
	private CoaConverter converter;
	private CoaDao coaDao;

	@Autowired
	public void setCoaDao(CoaDao coaDao) {
		this.coaDao = coaDao;
		this.typicalGenericDao = coaDao;
		this.genericDao = coaDao;
	}

	public CoaDto getById(Long id) {
		return converter.toDto(coaDao.get(id));
	}

	@Override
	public CoaDto save(CoaDto dto) {
		return converter.toDto(coaDao.save(converter.toModel(dto)));
	}

	@Override
	public Set<CoaDto> getByStoreId(Long storeId) {
		return new HashSet<>(converter.toDtos(coaDao.getByStoreId(String.valueOf(storeId))));
	}
	
	
	
}
