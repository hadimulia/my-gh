package com.app.gh.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.generic.persistence.model.TypicalGenericModel;
import com.app.gh.core.enums.StockStatusEnum;
import com.app.gh.core.enums.UnitEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_stock",indexes = {@Index(name="stock_idx1",columnList = "store_id" ),
									 @Index(name="stock_idx2",columnList = "suplier_id" ),
									 @Index(name="stock_idx3",columnList = "store_id,suplier_id" )
									}
	  )
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Stock extends TypicalGenericModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1115194816129937671L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name",length = 100, nullable = false)
	private String name;
	
	@Column(name = "code",length = 100, nullable = false)
	private String code;
	
	@Column(name = "unit")
	private UnitEnum unit;
	
	@Column(name = "qty")
	private Long qty;
	
	@Column(name = "price")
	private Long price;
	
	@Column(name = "stock_status")
	private StockStatusEnum stockStatus;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "suplier_id")
	private Suplier suplier;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UnitEnum getUnit() {
		return unit;
	}

	public void setUnit(UnitEnum unit) {
		this.unit = unit;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Suplier getSuplier() {
		return suplier;
	}

	public void setSuplier(Suplier suplier) {
		this.suplier = suplier;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + ", unit=" + unit + ", qty=" + qty
				+ ", price=" + price + ", suplier=" + suplier + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((qty == null) ? 0 : qty.hashCode());
		result = prime * result + ((suplier == null) ? 0 : suplier.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
		Stock other = (Stock) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (qty == null) {
			if (other.qty != null)
				return false;
		} else if (!qty.equals(other.qty))
			return false;
		if (suplier == null) {
			if (other.suplier != null)
				return false;
		} else if (!suplier.equals(other.suplier))
			return false;
		if (unit != other.unit)
			return false;
		return true;
	}
	
	
	
}
