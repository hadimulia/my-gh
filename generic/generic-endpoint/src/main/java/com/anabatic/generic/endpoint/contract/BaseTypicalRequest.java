package com.anabatic.generic.endpoint.contract;

import java.util.Map;

import com.app.generic.persistence.annotation.IsRequired;

public class BaseTypicalRequest {
	@IsRequired
	private String clientId;
	private Map<String, Object> customParams;
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public Map<String, Object> getCustomParams() {
		return customParams;
	}
	public void setCustomParams(Map<String, Object> customParams) {
		this.customParams = customParams;
	}
	
	@Override
	public String toString() {
		return "BaseTypicalRequest [clientId=" + clientId + ", customParams=" + customParams + "]";
	}
}