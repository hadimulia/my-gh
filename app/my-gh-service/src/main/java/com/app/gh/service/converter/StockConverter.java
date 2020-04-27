package com.app.gh.service.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.generic.service.converter.ToDtoConverter;
import com.app.generic.service.converter.ToModelConverter;
import com.app.gh.persistence.dto.StockDto;
import com.app.gh.persistence.model.Stock;
import com.app.gh.service.service.SuplierService;

@Component
public class StockConverter implements ToDtoConverter<Stock, StockDto>,ToModelConverter<StockDto, Stock>{

	@Autowired
	private SuplierService suplierService;
	
	public Stock toModel(StockDto object) {
		Stock model = new Stock();
		model.setId(object.getId());
		model.setName(object.getName());
		model.setCode(object.getCode());
		model.setUnit(object.getUnit());
		model.setQty(object.getQty());
		model.setPrice(object.getPrice());
		model.setStockStatus(object.getStockStatus());
		model.setStoreId(object.getStoreId());
		model.setSuplier(suplierService.get(object.getSuplierId()));
		return model;
	}

	public List<Stock> toModels(List<StockDto> objects) {
		return objects.stream()
					  .map(m -> toModel(m))
					  .collect(Collectors.toList());
	}

	public StockDto toDto(Stock object) {
		StockDto dto = new StockDto();
		dto.setId(object.getId());
		dto.setName(object.getName());
		dto.setCode(object.getCode());
		dto.setUnit(object.getUnit());
		dto.setQty(object.getQty());
		dto.setPrice(object.getPrice());
		dto.setStockStatus(object.getStockStatus());
		dto.setStoreId(object.getStoreId());
		dto.setSuplierId(object.getSuplier().getId());
		return dto;
	}

	public List<StockDto> toDtos(List<Stock> objects) {
		return objects.stream()
					  .map(m -> toDto(m))
					  .collect(Collectors.toList());
	}

}
