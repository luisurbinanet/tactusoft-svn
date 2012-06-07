package com.tactusoft.webservice.client.locators;

public class ZBAPI_CUSTOMER_FINDProxy implements
		com.tactusoft.webservice.client.locators.ZBAPI_CUSTOMER_FIND_PortType {
	private String _endpoint = null;
	private com.tactusoft.webservice.client.locators.ZBAPI_CUSTOMER_FIND_PortType zBAPI_CUSTOMER_FIND_PortType = null;
	private ZBAPI_CUSTOMER_FIND_ServiceLocator zBAPI_CUSTOMER_FIND_ServiceLocator;
	private String user;
	private String password;

	public ZBAPI_CUSTOMER_FINDProxy() {
		zBAPI_CUSTOMER_FIND_ServiceLocator = new ZBAPI_CUSTOMER_FIND_ServiceLocator();
		_initZBAPI_CUSTOMER_FINDProxy();
	}

	public ZBAPI_CUSTOMER_FINDProxy(String url, String user, String password) {
		zBAPI_CUSTOMER_FIND_ServiceLocator = new ZBAPI_CUSTOMER_FIND_ServiceLocator(
				url);
		this.user = user;
		this.password = password;
		_initZBAPI_CUSTOMER_FINDProxy();
	}

	public ZBAPI_CUSTOMER_FINDProxy(String endpoint) {
		_endpoint = endpoint;
		_initZBAPI_CUSTOMER_FINDProxy();
	}

	private void _initZBAPI_CUSTOMER_FINDProxy() {
		try {
			zBAPI_CUSTOMER_FIND_PortType = zBAPI_CUSTOMER_FIND_ServiceLocator
					.getZBAPI_CUSTOMER_FIND(this.user, this.password);
			if (zBAPI_CUSTOMER_FIND_PortType != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) zBAPI_CUSTOMER_FIND_PortType)
							._setProperty(
									"javax.xml.rpc.service.endpoint.address",
									_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) zBAPI_CUSTOMER_FIND_PortType)
							._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		} catch (javax.xml.rpc.ServiceException serviceException) {
		}
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (zBAPI_CUSTOMER_FIND_PortType != null)
			((javax.xml.rpc.Stub) zBAPI_CUSTOMER_FIND_PortType)._setProperty(
					"javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public com.tactusoft.webservice.client.locators.ZBAPI_CUSTOMER_FIND_PortType getZBAPI_CUSTOMER_FIND_PortType() {
		if (zBAPI_CUSTOMER_FIND_PortType == null)
			_initZBAPI_CUSTOMER_FINDProxy();
		return zBAPI_CUSTOMER_FIND_PortType;
	}

	public com.tactusoft.webservice.client.objects.Bapireturn1 customerFind(
			java.lang.Integer maxCnt,
			java.lang.String plHold,
			com.tactusoft.webservice.client.holders.TableOfBapikna111Holder resultTab,
			com.tactusoft.webservice.client.holders.TableOfBapikna110Holder seloptTab)
			throws java.rmi.RemoteException {
		if (zBAPI_CUSTOMER_FIND_PortType == null)
			_initZBAPI_CUSTOMER_FINDProxy();
		return zBAPI_CUSTOMER_FIND_PortType.customerFind(maxCnt, plHold, resultTab, seloptTab);
	}

}