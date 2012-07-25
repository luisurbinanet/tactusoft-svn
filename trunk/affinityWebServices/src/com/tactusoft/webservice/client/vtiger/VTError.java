package com.tactusoft.webservice.client.vtiger;

import java.io.Serializable;

public class VTError implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean result;
	private String message;

	public VTError() {

	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
