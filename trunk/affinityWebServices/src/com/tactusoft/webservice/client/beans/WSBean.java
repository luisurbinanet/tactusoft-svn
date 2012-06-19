package com.tactusoft.webservice.client.beans;

import java.io.Serializable;

public class WSBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String names;
	private String branch;

	public WSBean() {

	}

	public WSBean(String code, String names) {
		this.code = code;
		this.names = names;
	}

	public WSBean(String code, String names, String branch) {
		this.code = code;
		this.names = names;
		this.branch = branch;
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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
