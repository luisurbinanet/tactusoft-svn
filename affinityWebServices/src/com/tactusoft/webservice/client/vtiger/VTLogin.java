package com.tactusoft.webservice.client.vtiger;

import java.io.Serializable;

public class VTLogin implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String sessionId;
	private Object userId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Object getUserId() {
		return userId;
	}

	public void setUserId(Object userId) {
		this.userId = userId;
	}

}
