package com.app.gh.persistence.dto;

import com.app.generic.persistence.annotation.IsRequired;
import com.app.gh.core.enums.CoaTypeEnum;

public class CoaDto {

	@IsRequired
	private Long id;
	
	@IsRequired
	private String coaCode;
	
	@IsRequired
	private String description;
	
	@IsRequired
	private CoaTypeEnum coaType;
	
	@IsRequired
	private String storeId;
}
