package co.com.tactusoft.crm.dialer.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.asteriskjava.live.AsteriskChannel;
import org.asteriskjava.live.AsteriskServer;
import org.asteriskjava.live.CallerId;
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

	public void callActionExtension(String channel, String extension,
			String account) throws ManagerCommunicationException,
			NoSuchChannelException {
		asteriskServer.originateToExtension(channel, "from-internal",
				extension, new Integer(1), new Long(60000));
	}

	public List<String> unpausedAgent(String agent, String queue) {
		List<String> list = asteriskServer
				.executeCliCommand("queue unpause member Agent/" + agent
						+ " queue " + queue);
		return list;
	}

	public String callActionAplication(String channel, String agent,
			String account, String queue, String idUser, String phone)
			throws ManagerCommunicationException, NoSuchChannelException {
		String result = null;
		Map<String, String> mapVariables = new HashMap<String, String>();
		mapVariables.put("account", account);
		CallerId callerId = new CallerId(idUser + ":" + phone, idUser + ":"
				+ phone);

		/*
		 * AsteriskChannel request = asteriskServer.originateToApplication(
		 * channel, "Queue", queue, new Long(60000), callerId, mapVariables); if
		 * (request != null) { result = request.getId(); }
		 */
		asteriskServer.originateToApplicationAsync(channel, "Queue", queue,
				new Long(60000), callerId, mapVariables, null);
		return result;
	}

	public List<String> exceuteCliCommand(String command) {
		return asteriskServer.executeCliCommand(command);
	}

	public boolean getAgent(String queue, String agent) {
		boolean result = false;
		List<String> list = asteriskServer.executeCliCommand("queue show "
				+ queue);
		for (String row : list) {
			if (row.indexOf("(Not in use)") >= 0
					&& row.indexOf("(paused)") == -1) {
				int idx = row.indexOf("Agent");
				String agentStr = row.substring(idx, idx + 10);
				if (agentStr.equalsIgnoreCase("Agent/" + agent)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException,
			AuthenticationFailedException, TimeoutException,
			ManagerCommunicationException, NoSuchChannelException {

		Asterisk asterisk = new Asterisk("192.168.1.251", 5038, "crmaffinity",
				"4dm1n.aff");

		// asterisk.getAgent("6060");
		String str = "      Agent/7005 (Unavailable) has taken no calls yet";
		int idx = str.indexOf("Agent");
		String x = str.substring(idx, idx + 10);
		System.out.println(x);

		/* asterisk.callAction("SIP/N2P6737/011573112510963", "7005", "123"); */
		/*
		 * asterisk.callActionAplication("SIP/Lyric-MovTigo/3003044115", "7005",
		 * "cSIkGm0dy1cr9atH7");
		 */

		// asterisk.run();

		System.out.println(asterisk.getNumCalls());
	}

}
