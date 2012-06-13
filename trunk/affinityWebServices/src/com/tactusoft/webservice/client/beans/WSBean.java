package com.tactusoft.webservice.client.beans;

import java.io.Serializable;

public class WSBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String names;
	
	public WSBean()
	{
		
	}
	
	public WSBean(String code, String names)
	{
		this.code = code;
		this.names = names;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

}
