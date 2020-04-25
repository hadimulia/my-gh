package com.app.generic.endpoint.converter.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.generic.endpoint.contract.EmailRequest;
import com.app.generic.endpoint.converter.EmailRequestEConverter;
import com.app.generic.persistence.dto.EmailDto;

public class EmailRequestEConverterImpl implements EmailRequestEConverter{

	@Override
	public EmailDto toDto(EmailRequest contract) {
		EmailDto emailDto = new EmailDto();
		emailDto.setSubject(contract.getSubject());
		emailDto.setRecipients(contract.getRecipients());
		emailDto.setMessage(contract.getMessage());
		emailDto.setAttachment(contract.getAttachment());
		
		return emailDto;
	}

	@Override
	public List<EmailDto> toDtos(List<EmailRequest> contracts) {
		List<EmailDto> models = new ArrayList<EmailDto>();

		contracts.forEach(dto -> models.add(toDto(dto)));

		return models;
	}

}
