package com.app.generic.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.generic.core.util.AdapterUtil;
import com.app.generic.core.util.PropertiesUtil;
import com.app.generic.persistence.dto.EmailDto;
import com.app.generic.service.NotificationService;

/**
 * @author M Lukmanul Hakim (m.hakim &copy;Sep 21, 2018) 
 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
 */

public class EmailNotificationServiceImpl implements NotificationService<EmailDto> {
	private static final Logger LOG = LogManager.getLogger(EmailNotificationServiceImpl.class);
	private static final String URL = PropertiesUtil.get("golem.url");
	private static final String HEADER_KEY = "X-CSRF-TOKEN";
	private static final String  GET_TOKEN = "/auth/token";
	private static final String SEND_EMAIL = "/notification/email";
	@Autowired
	private AdapterUtil adapterUtil;
	
	/* 
	 * Sending Email with calling Golem-API
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Sep 21, 2018) 
	 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @see com.anabatic.tpe.generic.service.AccountNotificationService#send(java.lang.Object)
	 */
	@Override
	public Object send(EmailDto emailDto) {
		try {
			adapterUtil = getAdapterUtil(URL + GET_TOKEN);
			setUri(URL + GET_TOKEN);
			String token = adapterUtil.getSingleHeader(null, null, HEADER_KEY);
			Map<String, String> header = new HashMap<>();
			header.put(HEADER_KEY, token);
			
			setUri(URL + SEND_EMAIL);
			return adapterUtil.sendPost(emailDto, header);
		} catch (RuntimeException | URISyntaxException e) {
			LOG.error(e,e);
			return null;
		}
	}
		
	public URI getUri(String url) throws URISyntaxException {
		return new URI(url);
	}
	public AdapterUtil getAdapterUtil(String url) {
		return this.adapterUtil.setUrl(url);
	}
	
	private void setUri(String url) throws URISyntaxException {
		URI sendEmailUri = getUri(url);
		this.adapterUtil.getPostRequest().setURI(sendEmailUri);
	}

}
