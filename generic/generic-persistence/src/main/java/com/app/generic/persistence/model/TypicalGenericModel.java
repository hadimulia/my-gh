package com.app.generic.persistence.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.app.generic.persistence.annotation.IsRequired;

/**
 * @author Taufik Muliahadi (taufik.m &copy;Sep 24, 2018) <br>
 *         for further info contact: <i>kotaksurat.taufik@gmail.com</i>
 */
@MappedSuperclass
public class TypicalGenericModel extends GenericModel {

	/**
	 *
	 * long serialVersionUID
	 */
	private static final long serialVersionUID = -3715274391449303045L;
	
	@IsRequired
	@Column(name = "store_id", nullable = false, insertable = true, updatable = false, length = 25, precision = 0)
	protected String storeId;

	public TypicalGenericModel() {
		/* constructor */
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	
}
