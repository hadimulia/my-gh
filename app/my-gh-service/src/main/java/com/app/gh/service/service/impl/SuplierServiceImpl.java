package com.app.gh.service.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.generic.service.impl.TypicalGenericServiceImpl;
import com.app.gh.persistence.dao.SuplierDao;
import com.app.gh.persistence.dto.SuplierDto;
import com.app.gh.persistence.model.Suplier;
import com.app.gh.service.converter.SuplierConverter;
import com.app.gh.service.service.SuplierService;

public class SuplierServiceImpl extends TypicalGenericServiceImpl<Suplier, Long> implements SuplierService{

	@Autowired
	private SuplierConverter converter;
	
	private SuplierDao suplierDao;
	
	@Autowired
	public void setSuplierDao(SuplierDao suplierDao) {
		this.suplierDao = suplierDao;
		this.typicalGenericDao = suplierDao;
		this.genericDao = suplierDao;
	}

	@Override
	public Set<SuplierDto> getByStoreId(Long storeId) {
		return new HashSet<>(converter.toDtos(suplierDao.getByStoreId(String.valueOf(storeId))));
	}

	@Override
	public SuplierDto getById(Long id) {
		return converter.toDto(suplierDao.get(id));
	}

	@Override
	public SuplierDto save(SuplierDto dto) {
		return converter.toDto(suplierDao.save(converter.toModel(dto)));
	}

}
