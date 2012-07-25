package com.tactusoft.webservice.client.vtiger;

import java.io.Serializable;

public class VTToken implements Serializable {

	private static final long serialVersionUID = 1L;
	private String token;
	private String servertime;
	private String expiretime;

	public VTToken() {

	}

	public VTToken(String token, String servertime, String expiretime) {
		this.token = token;
		this.servertime = servertime;
		this.expiretime = expiretime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getServertime() {
		return servertime;
	}

	public void setServertime(String servertime) {
		this.servertime = servertime;
	}

	public String getExpiretime() {
		return expiretime;
	}

	public void setExpiretime(String expiretime) {
		this.expiretime = expiretime;
	}

}
