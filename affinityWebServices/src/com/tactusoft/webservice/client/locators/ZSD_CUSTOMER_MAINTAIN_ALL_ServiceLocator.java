/**
 * ZSD_CUSTOMER_MAINTAIN_ALL_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.locators;

@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
public class ZSD_CUSTOMER_MAINTAIN_ALL_ServiceLocator extends
		org.apache.axis.client.Service
		implements
		com.tactusoft.webservice.client.locators.ZSD_CUSTOMER_MAINTAIN_ALL_Service {

	private String username;
	private String password;

	// Use to get a proxy class for ZSD_CUSTOMER_MAINTAIN_ALL
	private java.lang.String ZSD_CUSTOMER_MAINTAIN_ALL_address;

	// The WSDD service name defaults to the port name.
	private java.lang.String ZSD_CUSTOMER_MAINTAIN_ALLWSDDServiceName = "ZSD_CUSTOMER_MAINTAIN_ALL";

	public ZSD_CUSTOMER_MAINTAIN_ALL_ServiceLocator() {
		ZSD_CUSTOMER_MAINTAIN_ALL_address = "http://ansrv07.affinitycolombia.com:8000/sap/bc/srt/rfc/sap/zsd_customer_maintain_all/200/zsd_customer_maintain_all/zsd_customer_maintain_all";
	}

	public ZSD_CUSTOMER_MAINTAIN_ALL_ServiceLocator(String url) {
		ZSD_CUSTOMER_MAINTAIN_ALL_address = url;
	}

	public ZSD_CUSTOMER_MAINTAIN_ALL_ServiceLocator(
			org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public ZSD_CUSTOMER_MAINTAIN_ALL_ServiceLocator(java.lang.String wsdlLoc,
			javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	public java.lang.String getZSD_CUSTOMER_MAINTAIN_ALLAddress() {
		return ZSD_CUSTOMER_MAINTAIN_ALL_address;
	}

	public java.lang.String getZSD_CUSTOMER_MAINTAIN_ALLWSDDServiceName() {
		return ZSD_CUSTOMER_MAINTAIN_ALLWSDDServiceName;
	}

	public void setZSD_CUSTOMER_MAINTAIN_ALLWSDDServiceName(
			java.lang.String name) {
		ZSD_CUSTOMER_MAINTAIN_ALLWSDDServiceName = name;
	}

	public com.tactusoft.webservice.client.locators.ZSD_CUSTOMER_MAINTAIN_ALL_PortType getZSD_CUSTOMER_MAINTAIN_ALL(
			String username, String password) throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(ZSD_CUSTOMER_MAINTAIN_ALL_address);
			this.username = username;
			this.password = password;
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getZSD_CUSTOMER_MAINTAIN_ALL(endpoint);
	}

	public com.tactusoft.webservice.client.locators.ZSD_CUSTOMER_MAINTAIN_ALL_PortType getZSD_CUSTOMER_MAINTAIN_ALL(
			java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
		try {
			com.tactusoft.webservice.client.locators.ZSD_CUSTOMER_MAINTAIN_ALL_BindingStub _stub = new com.tactusoft.webservice.client.locators.ZSD_CUSTOMER_MAINTAIN_ALL_BindingStub(
					portAddress, this);
			_stub.setUsername(this.username);
			_stub.setPassword(this.password);
			_stub.setPortName(getZSD_CUSTOMER_MAINTAIN_ALLWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setZSD_CUSTOMER_MAINTAIN_ALLEndpointAddress(
			java.lang.String address) {
		ZSD_CUSTOMER_MAINTAIN_ALL_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		try {
			if (com.tactusoft.webservice.client.locators.ZSD_CUSTOMER_MAINTAIN_ALL_PortType.class
					.isAssignableFrom(serviceEndpointInterface)) {
				com.tactusoft.webservice.client.locators.ZSD_CUSTOMER_MAINTAIN_ALL_BindingStub _stub = new com.tactusoft.webservice.client.locators.ZSD_CUSTOMER_MAINTAIN_ALL_BindingStub(
						new java.net.URL(ZSD_CUSTOMER_MAINTAIN_ALL_address),
						this);
				_stub.setPortName(getZSD_CUSTOMER_MAINTAIN_ALLWSDDServiceName());
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
		if ("ZSD_CUSTOMER_MAINTAIN_ALL".equals(inputPortName)) {
			return getZSD_CUSTOMER_MAINTAIN_ALL(this.username, this.password);
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"ZSD_CUSTOMER_MAINTAIN_ALL");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName(
					"urn:sap-com:document:sap:soap:functions:mc-style",
					"ZSD_CUSTOMER_MAINTAIN_ALL"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {

		if ("ZSD_CUSTOMER_MAINTAIN_ALL".equals(portName)) {
			setZSD_CUSTOMER_MAINTAIN_ALLEndpointAddress(address);
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
