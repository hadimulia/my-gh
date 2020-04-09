package com.app.generic.persistence.dto;


/**
 * @author Muhammad Lukmanul Hakim (m.hakim)
 *
 */
public class Attachment implements Cloneable {
	/**
	 * name for the attachment file
	 * 
	 */
	private String name;
	/**
	 * file that encoded to String base64
	 * 
	 */
	private String base64Content;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBase64Content() {
		return base64Content;
	}
	public void setBase64Content(String base64Content) {
		this.base64Content = base64Content;
	}
	
	@Override
	public Attachment clone() throws CloneNotSupportedException {
		return (Attachment)super.clone();
	}
}
