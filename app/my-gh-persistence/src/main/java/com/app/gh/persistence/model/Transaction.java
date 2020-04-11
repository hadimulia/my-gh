package com.app.gh.persistence.model;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.generic.persistence.model.TypicalGenericModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_transaction")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transaction extends TypicalGenericModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1325119179925224443L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "trx_code_id")
	private TransactionCode trxCode;
	
	@Column(name = "trx_time")
	private Instant trxTime;
	
	@Column(name = "is_posting",length = 1)
	private Long posting;
	
	@Column(name = "order_code",length = 10,nullable = true)
	private String orderCode;
	
	@Column(name = "amount")
	private BigDecimal amount;

}
