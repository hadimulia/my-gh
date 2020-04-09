package com.app.generic.persistence.dto;

import java.util.ArrayList;
import java.util.List;

import com.app.generic.persistence.dto.Attachment;

/**
 * An object to store information of the email which will be sent.
 * 
 * @author Muhammad Lukmanul Hakim (m.hakim)
 *
 */
public class EmailDto {
	/**
	 * List of recipients which the email will be sent to.
	 */
	private List<String> recipients ;
	
	/**
	 * The subject of the email.
	 */
	private String subject;
	
	/**
	 * The message / body of the email
	 */
	private String message;
	private List<Attachment> attachment  ;
	
	public List<String> getRecipients() {
		return recipients == null ? new ArrayList<String>() :this.recipients;
	}
	public void setRecipients(List<String> recipients) {
		this.recipients = recipients == null ?new ArrayList<String>() : recipients;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Attachment> getAttachment() {
		return attachment == null ?  new ArrayList<Attachment>() :  this.attachment;
	}
	public void setAttachment(List<Attachment> attachment) {
		this.attachment = attachment == null ? new ArrayList<Attachment>() : attachment;
	}
	
	
}
