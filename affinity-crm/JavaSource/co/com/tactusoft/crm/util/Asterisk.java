package co.com.tactusoft.crm.util;

import java.io.IOException;

import org.asteriskjava.live.AsteriskChannel;
import org.asteriskjava.live.AsteriskServer;
import org.asteriskjava.live.DefaultAsteriskServer;
import org.asteriskjava.live.ManagerCommunicationException;
import org.asteriskjava.live.NoSuchChannelException;
import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.EventTimeoutException;
import org.asteriskjava.manager.ResponseEvents;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.QueueStatusAction;
import org.asteriskjava.manager.event.QueueParamsEvent;
import org.asteriskjava.manager.event.ResponseEvent;

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
				// System.out.println(asteriskChannel);
				asteriskChannel.getAccount();
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

	public void callActionExtension(String channel, String extension,
			String account) throws ManagerCommunicationException,
			NoSuchChannelException {
		asteriskServer.originateToExtension(channel, "from-internal",
				extension, new Integer(1), new Long(60000));
	}

	public String callActionAplication(String channel, String agent,
			String account) throws ManagerCommunicationException,
			NoSuchChannelException {
		String result = null;
		asteriskServer.executeCliCommand("queue unpause member Agent/" + agent
				+ " queue 8" + agent);
		AsteriskChannel request = asteriskServer.originateToApplication(
				channel, "queue", "8" + agent, new Long(60000));
		if (request != null) {
			result = request.getId();
		}
		return result;
	}

	public static void main(String[] args) throws IOException,
			AuthenticationFailedException, TimeoutException,
			ManagerCommunicationException, NoSuchChannelException {

		Asterisk asterisk = new Asterisk("192.168.1.251", 5038, "crmaffinity",
				"4dm1n.aff");

		// asterisk.callAction("SIP/N2P6737/011573112510963", "7005", "123");
		asterisk.callActionAplication("SIP/Lyric-MovTigo/3003044115", "7005",
				"cSIkGm0dy1cr9atH7");

		System.out.println(asterisk.getNumCalls());
	}

}
