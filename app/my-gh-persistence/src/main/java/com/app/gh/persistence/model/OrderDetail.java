package com.app.gh.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.generic.persistence.model.GenericModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_seller")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderDetail extends GenericModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7912944253925237156L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "stock_id")
	private Stock stock;
	
	@Column(name = "qty")
	private Long qty;
	
	@Column(name = "qty_sent")
	private Long qtySent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}
	
	public Long getQtySent() {
		return qtySent;
	}

	public void setQtySent(Long qtySent) {
		this.qtySent = qtySent;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", stock=" + stock + ", qty=" + qty + ", qtySent=" + qtySent + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((qty == null) ? 0 : qty.hashCode());
		result = prime * result + ((qtySent == null) ? 0 : qtySent.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
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
		OrderDetail other = (OrderDetail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (qty == null) {
			if (other.qty != null)
				return false;
		} else if (!qty.equals(other.qty))
			return false;
		if (qtySent == null) {
			if (other.qtySent != null)
				return false;
		} else if (!qtySent.equals(other.qtySent))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}

}
