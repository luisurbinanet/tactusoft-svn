package com.tactusoft.webservice.client.custom;

import java.io.Serializable;

import com.tactusoft.webservice.client.holders.TableOfBapiret2Holder;

public class ResultCreateOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TableOfBapiret2Holder messages = new TableOfBapiret2Holder();
	private String salesdocument;

	public ResultCreateOrder() {

	}

	public ResultCreateOrder(TableOfBapiret2Holder messages,
			String salesdocument) {
		this.messages = messages;
		this.salesdocument = salesdocument;
	}

	public TableOfBapiret2Holder getMessages() {
		return messages;
	}

	public void setMessages(TableOfBapiret2Holder messages) {
		this.messages = messages;
	}

	public String getSalesdocument() {
		return salesdocument;
	}

	public void setSalesdocument(String salesdocument) {
		this.salesdocument = salesdocument;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
