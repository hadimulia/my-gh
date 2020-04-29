package com.app.gh.service.service;

import java.util.Set;

import com.app.generic.service.TypicalGenericService;
import com.app.gh.persistence.dto.SellerDto;
import com.app.gh.persistence.model.Seller;

public interface SellerService extends TypicalGenericService<Seller, Long>{

	Set<SellerDto> getByStoreId(Long storeId);
	SellerDto getById(Long id);
	SellerDto save(SellerDto dto);
}
