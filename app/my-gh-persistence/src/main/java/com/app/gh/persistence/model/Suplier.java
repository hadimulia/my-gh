package com.app.gh.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.app.generic.persistence.model.TypicalGenericModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_suplier")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Suplier extends TypicalGenericModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 617997988631277220L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "suplier_name", length = 50,nullable = false)
	private String suplierName;
	
	@Column(name = "full_address")
	@Type(type = "text")
	private String fullAddress;
	
	@OneToOne(mappedBy = "suplier")
	private Stock stock;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSuplierName() {
		return suplierName;
	}

	public void setSuplierName(String suplierName) {
		this.suplierName = suplierName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}


	@Override
	public String toString() {
		return "Suplier [id=" + id + ", suplierName=" + suplierName + ", fullAddress=" + fullAddress + ", stock="
				+ stock + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullAddress == null) ? 0 : fullAddress.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result + ((suplierName == null) ? 0 : suplierName.hashCode());
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
		Suplier other = (Suplier) obj;
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
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (suplierName == null) {
			if (other.suplierName != null)
				return false;
		} else if (!suplierName.equals(other.suplierName))
			return false;
		return true;
	}

	
}
