package com.app.generic.service.impl;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.generic.core.util.AdapterUtil;
import com.app.generic.core.util.PropertiesUtil;
import com.app.generic.persistence.dto.ReportResponseDto;
import com.app.generic.service.ReportService;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReportServiceImpl implements ReportService {

	private final Logger LOG = LogManager.getLogger(this.getClass());
	private static final int REPORT_ID = 30100001;
	private static final String FILE_TYPE = "EXCEL";
	private static final String URL = PropertiesUtil.get("bre.url");
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private AdapterUtil adapterUtil;
	
	@Override
	public ReportResponseDto generateReportStatus() {
		ReportResponseDto response = new ReportResponseDto();
		HashMap<Object, Object> requestAccountReport = new HashMap<>();
		requestAccountReport.put("formId", REPORT_ID);
		requestAccountReport.put("fileType", FILE_TYPE);
		requestAccountReport.put("dividerType", "MAXIMUM_ROW");
		requestAccountReport.put("dividerValue", 150000);
		requestAccountReport.put("isWaiting", Boolean.TRUE);
		AdapterUtil adapterUtil = getAdapterUtil();
		try {
			Object result = adapterUtil.sendPost(requestAccountReport,new HashMap<>());
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			response = objectMapper.convertValue(result, ReportResponseDto.class);
		}catch (Exception e) {
			LOG.error(e, e);
			return response;
		}
		return response;
	}

	
	public AdapterUtil getAdapterUtil() {
		return this.adapterUtil.setUrl(URL);
	}
}
