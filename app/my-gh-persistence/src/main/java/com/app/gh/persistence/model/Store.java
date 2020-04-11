package com.app.gh.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.app.generic.persistence.model.GenericModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_store")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Store extends GenericModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1670156901676858724L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "store_name", length = 50,nullable = false)
	private String storeName;
	
	@Column(name = "full_address")
	@Type(type = "text")
	private String fullAddress;
	
	@Column(name = "logo")
	@Type(type = "text")
	private String logo;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", storeName=" + storeName + ", fullAddress=" + fullAddress + ", logo=" + logo+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullAddress == null) ? 0 : fullAddress.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((storeName == null) ? 0 : storeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		if (fullAddress == null) {
			if (other.fullAddress != null)
				return false;
		} else if (!fullAddress.equals(other.fullAddress))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (storeName == null) {
			if (other.storeName != null)
				return false;
		} else if (!storeName.equals(other.storeName))
			return false;
		return true;
	}

	
	
}
