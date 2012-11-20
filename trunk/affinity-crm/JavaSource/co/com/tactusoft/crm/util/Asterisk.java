package co.com.tactusoft.crm.util;

import java.io.IOException;

import org.asteriskjava.live.AsteriskChannel;
import org.asteriskjava.live.AsteriskServer;
import org.asteriskjava.live.DefaultAsteriskServer;
import org.asteriskjava.live.ManagerCommunicationException;
import org.asteriskjava.manager.EventTimeoutException;
import org.asteriskjava.manager.ResponseEvents;
import org.asteriskjava.manager.action.QueueStatusAction;
import org.asteriskjava.manager.event.QueueParamsEvent;
import org.asteriskjava.manager.event.ResponseEvent;

public class Asterisk {

	private String user = "admin";
	private String password = "lukro9753";
	private String url = "192.168.1.20";

	private AsteriskServer asteriskServer;
	private int numCalls = 0;

	public Asterisk(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
		asteriskServer = new DefaultAsteriskServer(this.url, this.user,
				this.password);
	}

	public int getNumCalls() {
		return numCalls;
	}

	public void setNumCalls(int numCalls) {
		this.numCalls = numCalls;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void run() throws ManagerCommunicationException {
		for (AsteriskChannel asteriskChannel : asteriskServer.getChannels()) {
			System.out.println(asteriskChannel);
		}

		try {
			ResponseEvents responseEvents = asteriskServer
					.getManagerConnection().sendEventGeneratingAction(
							new QueueStatusAction());
			for (ResponseEvent event : responseEvents.getEvents()) {
				if (event instanceof QueueParamsEvent) {
					QueueParamsEvent qe = (QueueParamsEvent) event;
					numCalls = numCalls + qe.getCalls();
				}
			}
		} catch (EventTimeoutException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
