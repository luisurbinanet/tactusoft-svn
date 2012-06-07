/**
 * ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.locators;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ZBAPI_SALESORDER_CREATEFROMDAT_ServiceLocator extends
		org.apache.axis.client.Service
		implements
		com.tactusoft.webservice.client.locators.ZBAPI_SALESORDER_CREATEFROMDAT_Service {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	// Use to get a proxy class for ZBAPI_SALESORDER_CREATEFROMDAT
	private java.lang.String ZBAPI_SALESORDER_CREATEFROMDAT_address;

	// The WSDD service name defaults to the port name.
	private java.lang.String ZBAPI_SALESORDER_CREATEFROMDATWSDDServiceName = "ZBAPI_SALESORDER_CREATEFROMDAT";

	public ZBAPI_SALESORDER_CREATEFROMDAT_ServiceLocator() {
		ZBAPI_SALESORDER_CREATEFROMDAT_address = "http://ansrv07.affinitycolombia.com:8000/sap/bc/srt/rfc/sap/zbapi_salesorder_createfromdat/200/zbapi_salesorder_createfromdat/zbapi_salesorder_createfromdat";
	}

	public ZBAPI_SALESORDER_CREATEFROMDAT_ServiceLocator(String url) {
		ZBAPI_SALESORDER_CREATEFROMDAT_address = url;
	}

	public ZBAPI_SALESORDER_CREATEFROMDAT_ServiceLocator(
			org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public ZBAPI_SALESORDER_CREATEFROMDAT_ServiceLocator(
			java.lang.String wsdlLoc, javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	public java.lang.String getZBAPI_SALESORDER_CREATEFROMDATAddress() {
		return ZBAPI_SALESORDER_CREATEFROMDAT_address;
	}

	public java.lang.String getZBAPI_SALESORDER_CREATEFROMDATWSDDServiceName() {
		return ZBAPI_SALESORDER_CREATEFROMDATWSDDServiceName;
	}

	public void setZBAPI_SALESORDER_CREATEFROMDATWSDDServiceName(
			java.lang.String name) {
		ZBAPI_SALESORDER_CREATEFROMDATWSDDServiceName = name;
	}

	public com.tactusoft.webservice.client.locators.ZBAPI_SALESORDER_CREATEFROMDAT_PortType getZBAPI_SALESORDER_CREATEFROMDAT(
			String username, String password)
			throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			this.username = username;
			this.password = password;
			endpoint = new java.net.URL(ZBAPI_SALESORDER_CREATEFROMDAT_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getZBAPI_SALESORDER_CREATEFROMDAT(endpoint);
	}

	public com.tactusoft.webservice.client.locators.ZBAPI_SALESORDER_CREATEFROMDAT_PortType getZBAPI_SALESORDER_CREATEFROMDAT(
			java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
		try {
			com.tactusoft.webservice.client.locators.ZBAPI_SALESORDER_CREATEFROMDAT_BindingStub _stub = new com.tactusoft.webservice.client.locators.ZBAPI_SALESORDER_CREATEFROMDAT_BindingStub(
					portAddress, this);
			_stub.setUsername(this.username);
			_stub.setPassword(this.password);
			_stub.setPortName(getZBAPI_SALESORDER_CREATEFROMDATWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setZBAPI_SALESORDER_CREATEFROMDATEndpointAddress(
			java.lang.String address) {
		ZBAPI_SALESORDER_CREATEFROMDAT_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		try {
			if (com.tactusoft.webservice.client.locators.ZBAPI_SALESORDER_CREATEFROMDAT_PortType.class
					.isAssignableFrom(serviceEndpointInterface)) {
				com.tactusoft.webservice.client.locators.ZBAPI_SALESORDER_CREATEFROMDAT_BindingStub _stub = new com.tactusoft.webservice.client.locators.ZBAPI_SALESORDER_CREATEFROMDAT_BindingStub(
						new java.net.URL(ZBAPI_SALESORDER_CREATEFROMDAT_address),
						this);
				_stub.setPortName(getZBAPI_SALESORDER_CREATEFROMDATWSDDServiceName());
				return _stub;
			}
		} catch (java.lang.Throwable t) {
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException(
				"There is no stub implementation for the interface:  "
						+ (serviceEndpointInterface == null ? "null"
								: serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName,
			Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		java.lang.String inputPortName = portName.getLocalPart();
		if ("ZBAPI_SALESORDER_CREATEFROMDAT".equals(inputPortName)) {
			return getZBAPI_SALESORDER_CREATEFROMDAT(this.username,
					this.password);
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "service");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName(
					"urn:sap-com:document:sap:soap:functions:mc-style",
					"ZBAPI_SALESORDER_CREATEFROMDAT"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {

		if ("ZBAPI_SALESORDER_CREATEFROMDAT".equals(portName)) {
			setZBAPI_SALESORDER_CREATEFROMDATEndpointAddress(address);
		} else { // Unknown Port Name
			throw new javax.xml.rpc.ServiceException(
					" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(javax.xml.namespace.QName portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
