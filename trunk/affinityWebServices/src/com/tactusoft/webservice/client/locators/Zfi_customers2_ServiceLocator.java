/**
 * Customers2Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.locators;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Zfi_customers2_ServiceLocator extends
		org.apache.axis.client.Service implements
		com.tactusoft.webservice.client.locators.Zfi_customers2_Service {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	// Use to get a proxy class for Customers2
	private java.lang.String Customers2_address;

	// The WSDD service name defaults to the port name.
	private java.lang.String Customers2WSDDServiceName = "Customers2";

	public Zfi_customers2_ServiceLocator() {
		Customers2_address = "http://ansrv07.affinitycolombia.com:8000/sap/bc/srt/rfc/sap/zfi_customers2/200/customers2/customers2";
	}

	public Zfi_customers2_ServiceLocator(String url) {
		Customers2_address = url;
	}

	public Zfi_customers2_ServiceLocator(
			org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public Zfi_customers2_ServiceLocator(java.lang.String wsdlLoc,
			javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	public java.lang.String getCustomers2Address() {
		return Customers2_address;
	}

	public java.lang.String getCustomers2WSDDServiceName() {
		return Customers2WSDDServiceName;
	}

	public void setCustomers2WSDDServiceName(java.lang.String name) {
		Customers2WSDDServiceName = name;
	}

	public com.tactusoft.webservice.client.locators.Zfi_customers2_PortType getCustomers2(
			String username, String password)
			throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			this.username = username;
			this.password = password;
			endpoint = new java.net.URL(Customers2_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getCustomers2(endpoint);
	}

	public com.tactusoft.webservice.client.locators.Zfi_customers2_PortType getCustomers2(
			java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
		try {
			com.tactusoft.webservice.client.locators.Zfi_customers2_BindingStub _stub = new com.tactusoft.webservice.client.locators.Zfi_customers2_BindingStub(
					portAddress, this);
			_stub.setUsername(this.username);
			_stub.setPassword(this.password);
			_stub.setPortName(getCustomers2WSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setCustomers2EndpointAddress(java.lang.String address) {
		Customers2_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		try {
			if (com.tactusoft.webservice.client.locators.Zfi_customers2_PortType.class
					.isAssignableFrom(serviceEndpointInterface)) {
				com.tactusoft.webservice.client.locators.Zfi_customers2_BindingStub _stub = new com.tactusoft.webservice.client.locators.Zfi_customers2_BindingStub(
						new java.net.URL(Customers2_address), this);
				_stub.setPortName(getCustomers2WSDDServiceName());
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
		if ("Customers2".equals(inputPortName)) {
			return getCustomers2(this.username, this.password);
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Customers2");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName(
					"urn:sap-com:document:sap:soap:functions:mc-style",
					"Customers2"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {

		if ("Customers2".equals(portName)) {
			setCustomers2EndpointAddress(address);
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
