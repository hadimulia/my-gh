/*
 * ATI - CORE -TPE
 * Transaction Processing Engine(TPE)
 * @Author- ALOK 
 */

package com.app.generic.persistence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.app.generic.persistence.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class GenericModel implements Serializable {
	/*
	 * @Author- ALOK
	 */
	private static final long serialVersionUID = -6137489307786591982L;

	private static final String TIMEZONE = "Asia/Jakarta";

	@Column(name = "created_time", nullable = true, insertable = true, updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = TIMEZONE)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdTime;

	@Column(name = "created_by", nullable = true, insertable = true, updatable = false, length = 25, precision = 0)
	@CreatedBy
	private String createdBy;

	@Column(name = "updated_time", nullable = true, insertable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = TIMEZONE)
	@LastModifiedDate
	private Date updatedTime;

	@Column(name = "updated_by", nullable = true, insertable = true, updatable = true, length = 25, precision = 0)
	@LastModifiedBy
	private String updatedBy;

	@Column(name = "authoriser", nullable = true, insertable = true, updatable = true, length = 25, precision = 0)
	private String authoriser;

	@Column(name = "authorize_time", nullable = true, insertable = true, updatable = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = TIMEZONE)
	private Date authorizeTime;

	@Column(name = "version")
	private String version;

	@Column(name = "status", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
	@Enumerated(EnumType.STRING)
	private Status status;

	public GenericModel() {
		/* constructor */
	}

	@PrePersist
	protected void onCreate() {
		createdTime = new Date();

	}

	@PreUpdate
	protected void onUpdate() {
		updatedTime = new Date();
	}

	public Date getCreatedTime() {
		return createdTime == null ? null : new Date(createdTime.getTime());
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime == null ? null : new Date(createdTime.getTime());
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedTime() {
		return updatedTime == null ? null : new Date(updatedTime.getTime());
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime == null ? null : new Date(updatedTime.getTime());
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getAuthoriser() {
		return authoriser;
	}

	public void setAuthoriser(String authoriser) {
		this.authoriser = authoriser;
	}

	public Date getAuthorizeTime() {
		return authorizeTime != null ? new Date(authorizeTime.getTime()) : null;
	}

	public void setAuthorizeTime(Date authorizeTime) {
		this.authorizeTime = authorizeTime != null ? new Date(authorizeTime.getTime()) : null;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
