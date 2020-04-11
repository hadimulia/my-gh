package com.app.gh.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.generic.persistence.model.TypicalGenericModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_transaction_code")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TransactionCode extends TypicalGenericModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 464576026988937189L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name = "trx_code")
	private String trxCode;
	
	@Column(name = "description")
	private String description;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "coa_id")
	private Coa coaId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrxCode() {
		return trxCode;
	}

	public void setTrxCode(String trxCode) {
		this.trxCode = trxCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Coa getCoaId() {
		return coaId;
	}

	public void setCoaId(Coa coaId) {
		this.coaId = coaId;
	}

	@Override
	public String toString() {
		return "TransactionCode [id=" + id + ", trxCode=" + trxCode + ", description="
				+ description + ", coaId=" + coaId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coaId == null) ? 0 : coaId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((trxCode == null) ? 0 : trxCode.hashCode());
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
		TransactionCode other = (TransactionCode) obj;
		if (coaId == null) {
			if (other.coaId != null)
				return false;
		} else if (!coaId.equals(other.coaId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (trxCode == null) {
			if (other.trxCode != null)
				return false;
		} else if (!trxCode.equals(other.trxCode))
			return false;
		return true;
	}
	
}
