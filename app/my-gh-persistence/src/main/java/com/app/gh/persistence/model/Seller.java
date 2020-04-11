package com.app.gh.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.app.generic.persistence.model.TypicalGenericModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_seller")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Seller extends TypicalGenericModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5583890115077550514L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "seller_name", length = 50,nullable = false)
	private String sellerName;
	
	@Column(name = "full_address")
	@Type(type = "text")
	private String fullAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", sellerName=" + sellerName + ", fullAddress=" + fullAddress + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullAddress == null) ? 0 : fullAddress.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sellerName == null) ? 0 : sellerName.hashCode());
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
		Seller other = (Seller) obj;
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
		if (sellerName == null) {
			if (other.sellerName != null)
				return false;
		} else if (!sellerName.equals(other.sellerName))
			return false;
		return true;
	}
	
}
