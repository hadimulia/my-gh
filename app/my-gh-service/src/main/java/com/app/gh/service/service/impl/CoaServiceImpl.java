package com.app.gh.service.service.impl;

import com.app.generic.service.impl.TypicalGenericServiceImpl;
import com.app.gh.persistence.dao.CoaDao;
import com.app.gh.persistence.model.Coa;
import com.app.gh.service.service.CoaService;

public class CoaServiceImpl extends TypicalGenericServiceImpl<Coa, Long> implements CoaService{

	private CoaDao coaDao;

	public void setCoaDao(CoaDao coaDao) {
		this.coaDao = coaDao;
		this.typicalGenericDao = coaDao;
		this.coaDao = coaDao;
	}
	
	
}
