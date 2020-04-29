package com.app.gh.service.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.generic.service.impl.TypicalGenericServiceImpl;
import com.app.gh.persistence.dao.SellerDao;
import com.app.gh.persistence.dto.SellerDto;
import com.app.gh.persistence.model.Seller;
import com.app.gh.service.converter.SellerConverter;
import com.app.gh.service.service.SellerService;

public class SellerServiceImpl extends TypicalGenericServiceImpl<Seller, Long> implements SellerService{

	@Autowired
	private SellerConverter converter;
	
	private SellerDao sellerDao;
	
	@Autowired
	public void setStockDao(SellerDao sellerDao) {
		this.sellerDao = sellerDao;
		this.typicalGenericDao = sellerDao;
		this.genericDao = sellerDao;
	}

	@Override
	public Set<SellerDto> getByStoreId(Long storeId) {
		return new HashSet<>(converter.toDtos(sellerDao.getByStoreId(String.valueOf(storeId))));
	}

	@Override
	public SellerDto getById(Long id) {
		return converter.toDto(sellerDao.get(id));
	}

	@Override
	public SellerDto save(SellerDto dto) {
		return converter.toDto(sellerDao.save(converter.toModel(dto)));
	}

}
