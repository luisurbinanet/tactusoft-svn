package co.com.tactusoft.dialer.dao.entities;

import java.io.Serializable;

public class Agent implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer agent;
	private Integer readyForCall;

	public Agent() {

	}

	public Agent(Integer agent, Integer readyForCall) {
		this.agent = agent;
		this.readyForCall = readyForCall;
	}

	public Integer getAgent() {
		return agent;
	}

	public void setAgent(Integer agent) {
		this.agent = agent;
	}

	public Integer getReadyForCall() {
		return readyForCall;
	}

	public void setReadyForCall(Integer readyForCall) {
		this.readyForCall = readyForCall;
	}

}
