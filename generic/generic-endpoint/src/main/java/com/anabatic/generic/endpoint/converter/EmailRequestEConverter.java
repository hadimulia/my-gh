package com.anabatic.generic.endpoint.converter;

import com.anabatic.generic.endpoint.contract.EmailRequest;
import com.app.generic.persistence.dto.EmailDto;
import com.app.generic.service.converter.ToDtoConverter;

/**
 * Converter which convert {@link EmailRequest} into {@link EmailDto}
 * 
 * @author Kusmawati
 */
public interface EmailRequestEConverter extends ToDtoConverter<EmailRequest, EmailDto>{

}
