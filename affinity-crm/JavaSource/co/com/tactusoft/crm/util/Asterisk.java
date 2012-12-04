package co.com.tactusoft.crm.util;

import java.io.IOException;

import org.asteriskjava.live.AsteriskChannel;
import org.asteriskjava.live.AsteriskServer;
import org.asteriskjava.live.DefaultAsteriskServer;
import org.asteriskjava.live.ManagerCommunicationException;
import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.EventTimeoutException;
import org.asteriskjava.manager.ManagerEventListener;
import org.asteriskjava.manager.ResponseEvents;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.action.QueueStatusAction;
import org.asteriskjava.manager.event.CdrEvent;
import org.asteriskjava.manager.event.ManagerEvent;
import org.asteriskjava.manager.event.QueueParamsEvent;
import org.asteriskjava.manager.event.ResponseEvent;
import org.asteriskjava.manager.response.ManagerResponse;

public class Asterisk {

	private String user;
	private String password;
	private String url;
	private int port;

	private AsteriskServer asteriskServer;
	private String numCalls;

	public Asterisk() {
		asteriskServer = new DefaultAsteriskServer(this.url, this.port,
				this.user, this.password);
	}

	public Asterisk(String url, int port, String user, String password) {
		this.url = url;
		this.port = port;
		this.user = user;
		this.password = password;
		asteriskServer = new DefaultAsteriskServer(this.url, this.user,
				this.password);
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

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getNumCalls() {
		return numCalls;
	}

	public void setNumCalls(String numCalls) {
		this.numCalls = numCalls;
	}

	public void run() throws ManagerCommunicationException {
		int calls = 0;
		try {
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
						calls = calls + qe.getCalls();
					}
				}

				numCalls = String.valueOf(calls);
			} catch (EventTimeoutException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			numCalls = "No Disponible";
		}
	}

	public void run2() throws IOException, AuthenticationFailedException,
			TimeoutException {
		OriginateAction originateAction;
		ManagerResponse originateResponse;

		originateAction = new OriginateAction();
		originateAction.setAccount("999");
		originateAction.setAsync(false);
		originateAction.setChannel("SIP/N2P6737/011573112510963");
		originateAction.setContext("from-internal");
		originateAction.setExten("6503");
		originateAction.setPriority(new Integer(1));
		originateAction.setTimeout(new Long(30000));

		// connect to Asterisk and log in
		asteriskServer.getManagerConnection().login();

		// send the originate action and wait for a maximum of 30 seconds for
		// Asterisk
		// to send a reply
		originateResponse = asteriskServer.getManagerConnection().sendAction(
				originateAction, 30000);

		// print out whether the originate succeeded or not
		System.out.println(originateResponse.getResponse());

		for (AsteriskChannel asteriskChannel : asteriskServer.getChannels()) {
			System.out.println(asteriskChannel);
		}

		asteriskServer.getManagerConnection().addEventListener(
				new ManagerEventListener() {

					@Override
					public void onManagerEvent(ManagerEvent event) {
						if (event instanceof QueueParamsEvent) {
							System.out.println("");
						}

					}
				});

		// and finally log off and disconnect
		// asteriskServer.getManagerConnection().logoff();
	}

	public void event(CdrEvent event) {

	}

	public static void main(String[] args) throws IOException,
			AuthenticationFailedException, TimeoutException {

		Asterisk asterisk = new Asterisk("192.168.1.20", 5038, "admin",
				"lukro9753");

		/*
		 * Asterisk asterisk = new Asterisk("192.168.1.22", 5038, "crmaffinity",
		 * "4dm1n.aff");
		 */
		asterisk.run2();
		// System.out.println(asterisk.getNumCalls());
	}

}
