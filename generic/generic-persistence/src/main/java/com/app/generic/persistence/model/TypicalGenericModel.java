package com.app.generic.persistence.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.app.generic.persistence.annotation.IsRequired;

/**
 * @author M Lukmanul Hakim (m.hakim &copy;Sep 24, 2018) <br>
 *         for further info contact: <i>vickyhakimm@gmail.com</i>
 */
@MappedSuperclass
public class TypicalGenericModel extends GenericModel {

	/**
	 *
	 * long serialVersionUID
	 */
	private static final long serialVersionUID = -3715274391449303045L;
	
	@IsRequired
	@Column(name = "client_id", nullable = false, insertable = true, updatable = false, length = 25, precision = 0)
	private String clientId;

	public TypicalGenericModel() {
		/* constructor */
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
}
