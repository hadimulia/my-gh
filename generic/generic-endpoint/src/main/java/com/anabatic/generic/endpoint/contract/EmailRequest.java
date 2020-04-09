package com.anabatic.generic.endpoint.contract;

import java.util.ArrayList;
import java.util.List;

import com.app.generic.persistence.dto.Attachment;

public class EmailRequest{
	private List<String> recipients ;
	private String subject;
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
