/**
 * Customers2Stub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.locators;

@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
public class Zfi_customers2_BindingStub extends org.apache.axis.client.Stub implements
		com.tactusoft.webservice.client.locators.Zfi_customers2_PortType {
	private java.util.Vector cachedSerClasses = new java.util.Vector();
	private java.util.Vector cachedSerQNames = new java.util.Vector();
	private java.util.Vector cachedSerFactories = new java.util.Vector();
	private java.util.Vector cachedDeserFactories = new java.util.Vector();

	static org.apache.axis.description.OperationDesc[] _operations;

	static {
		_operations = new org.apache.axis.description.OperationDesc[35];
		_initOperationDesc1();
		_initOperationDesc2();
		_initOperationDesc3();
		_initOperationDesc4();
	}

	private static void _initOperationDesc1() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerCreatePassword");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapireturn"));
		oper.setReturnClass(com.tactusoft.webservice.client.objects.Bapireturn.class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "Return"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[0] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerGetDetail1");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "DistributionChannel"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char2"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Division"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char2"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "SalesOrganiation"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char4"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "AddressTypeNo"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna109"),
				com.tactusoft.webservice.client.objects.Bapikna109.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CompanyData"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna106"),
				com.tactusoft.webservice.client.objects.Bapikna106.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ConsumerFlag"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OptionalCompanyData"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna105"),
				com.tactusoft.webservice.client.objects.Bapikna105.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OptionalPersonalData"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna105"),
				com.tactusoft.webservice.client.objects.Bapikna105.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OptionalPersonalDataNew"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna105"),
				com.tactusoft.webservice.client.objects.Bapikna105.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PersonalData"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna1011"),
				com.tactusoft.webservice.client.objects.Bapikna1011.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PersonalDataNew"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna1011"),
				com.tactusoft.webservice.client.objects.Bapikna1011.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapireturn1"),
				com.tactusoft.webservice.client.objects.Bapireturn1.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[1] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerGetDetail2");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CompanyCode"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char4"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerAddress"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapicustomer04"),
				com.tactusoft.webservice.client.objects.Bapicustomer04.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerBankDetail"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapicustomer02"),
				com.tactusoft.webservice.client.objects.Bapicustomer02[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerCompanyDetail"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapicustomer05"),
				com.tactusoft.webservice.client.objects.Bapicustomer05.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerGeneralDetail"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"BapicustomerKna1"),
				com.tactusoft.webservice.client.objects.BapicustomerKna1.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapiret1"),
				com.tactusoft.webservice.client.objects.Bapiret1.class, false,
				false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[2] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerGetHierarchyChildren");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustHiTyp"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "NodeLevel"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "numeric2"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "SalesArea"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapiSdvtber"),
				com.tactusoft.webservice.client.objects.Sdvtber[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ValidOn"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "date"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "NodeList"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapikna1Knvh"),
				com.tactusoft.webservice.client.objects.Bapikna1Knvh[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapiret2"),
				com.tactusoft.webservice.client.objects.Bapiret2.class, false,
				false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[3] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerAddHierarchyNodes");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "NodeList"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapikna1KnvhProcess"),
				com.tactusoft.webservice.client.objects.Bapikna1KnvhProcess[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapiret2"));
		oper.setReturnClass(com.tactusoft.webservice.client.objects.Bapiret2[].class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "Return"));
		param = oper.getReturnParamDesc();
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[4] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerDeletePassword");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapireturn"));
		oper.setReturnClass(com.tactusoft.webservice.client.objects.Bapireturn.class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "Return"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[5] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerFind");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "MaxCnt"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "int"),
				java.lang.Integer.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PlHold"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "SeloptTab"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapikna110"),
				com.tactusoft.webservice.client.objects.Bapikna110[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ResultTab"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapikna111"),
				com.tactusoft.webservice.client.objects.Bapikna111[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapireturn1"),
				com.tactusoft.webservice.client.objects.Bapireturn1.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[6] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerGetSalesAreas");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapireturn"),
				com.tactusoft.webservice.client.objects.Bapireturn.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "SalesAreas"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapiknvvky"),
				com.tactusoft.webservice.client.objects.Bapiknvvky[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[7] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerSearch1");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Email"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char241"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Salesorganisation"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char4"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Multiple"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapikna103"),
				com.tactusoft.webservice.client.objects.Bapikna103[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapireturn1"),
				com.tactusoft.webservice.client.objects.Bapireturn1.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[8] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("BapiServiceTransactionCommit");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "WAIT"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiret2"));
		oper.setReturnClass(com.tactusoft.webservice.client.objects.Bapiret2.class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "Return"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[9] = oper;

	}

	private static void _initOperationDesc2() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerChangePassword");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "NewPassword"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char16"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Password"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char16"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "VerifyPassword"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char16"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapireturn"));
		oper.setReturnClass(com.tactusoft.webservice.client.objects.Bapireturn.class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "Return"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[10] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerCreateFromData1");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CompanyData"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna106"),
				com.tactusoft.webservice.client.objects.Bapikna106.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ConsumerEn"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CopyReference"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna102"),
				com.tactusoft.webservice.client.objects.Bapikna102.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CreditControlFlag"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OptionalCompanyData"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna105"),
				com.tactusoft.webservice.client.objects.Bapikna105.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OptionalPersonalData"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna105"),
				com.tactusoft.webservice.client.objects.Bapikna105.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PersonalData"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna1011"),
				com.tactusoft.webservice.client.objects.Bapikna1011.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapireturn1"),
				com.tactusoft.webservice.client.objects.Bapireturn1.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[11] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerDelete");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiret1"));
		oper.setReturnClass(com.tactusoft.webservice.client.objects.Bapiret1.class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "Return"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[12] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerExistenceCheck");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CompanyCode"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char4"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "DistributionChannel"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char2"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Division"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char2"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "SalesOrganization"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char4"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiret1"));
		oper.setReturnClass(com.tactusoft.webservice.client.objects.Bapiret1.class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "Return"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[13] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerGetInternalNumber");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "AccountGroup"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char4"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Quantity"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "unsignedByte"),
				org.apache.axis.types.UnsignedByte.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Customer"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapicustomerNumbers"),
				com.tactusoft.webservice.client.objects.BapicustomerNumbers[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerId"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapireturn1"),
				com.tactusoft.webservice.client.objects.Bapireturn1.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[14] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerGetHierarchyRootList");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustHiTyp"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "SalesArea"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapiSdvtber"),
				com.tactusoft.webservice.client.objects.Sdvtber[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ValidOn"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "date"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "NodeList"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapikna1Knvh"),
				com.tactusoft.webservice.client.objects.Bapikna1Knvh[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapiret2"),
				com.tactusoft.webservice.client.objects.Bapiret2.class, false,
				false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[15] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerSearch");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PiAddress"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna101"),
				com.tactusoft.webservice.client.objects.Bapikna101.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PiSalesorg"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char4"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PiSearchFlag"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Multiple"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapikna103"),
				com.tactusoft.webservice.client.objects.Bapikna103[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PeCustomer"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapireturn"),
				com.tactusoft.webservice.client.objects.Bapireturn.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[16] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerCheckPassword");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "DistributionChannel"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char2"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Division"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char2"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Password"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char16"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "SalesOrganization"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char4"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerData"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Kna1"),
				com.tactusoft.webservice.client.objects.Kna1.class, false,
				false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNumberOut"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapireturn"),
				com.tactusoft.webservice.client.objects.Bapireturn.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[17] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerRemoveHierarchyNodes");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "NodeList"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapikna1KnvhProcess"),
				com.tactusoft.webservice.client.objects.Bapikna1KnvhProcess[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapiret2"));
		oper.setReturnClass(com.tactusoft.webservice.client.objects.Bapiret2[].class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "Return"));
		param = oper.getReturnParamDesc();
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[18] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerChangeFromData1");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CompanyData"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna106"),
				com.tactusoft.webservice.client.objects.Bapikna106.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CompanyDataX"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna106x"),
				com.tactusoft.webservice.client.objects.Bapikna106X.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "DistributionChannel"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char2"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Division"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char2"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OptionalCompanyData"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna105"),
				com.tactusoft.webservice.client.objects.Bapikna105.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OptionalCompanyDataX"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna105x"),
				com.tactusoft.webservice.client.objects.Bapikna105X.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OptionalPersonalData"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna105"),
				com.tactusoft.webservice.client.objects.Bapikna105.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OptionalPersonalDataX"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna105x"),
				com.tactusoft.webservice.client.objects.Bapikna105X.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PersonalData"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna1011"),
				com.tactusoft.webservice.client.objects.Bapikna1011.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PersonalDataX"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna1011x"),
				com.tactusoft.webservice.client.objects.Bapikna1011X.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "SalesOrganisation"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char4"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapireturn1"));
		oper.setReturnClass(com.tactusoft.webservice.client.objects.Bapireturn1.class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "Return"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[19] = oper;

	}

	private static void _initOperationDesc3() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerCheckPassword1");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Password"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char16"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiret1"));
		oper.setReturnClass(com.tactusoft.webservice.client.objects.Bapiret1.class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "Return"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[20] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerGetDetail");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "DistributionChannel"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char2"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Division"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char2"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PassBuffer"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PiSalesorg"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char4"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PeAddress"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna101"),
				com.tactusoft.webservice.client.objects.Bapikna101.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapireturn"),
				com.tactusoft.webservice.client.objects.Bapireturn.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[21] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerGetHierarchyRoot");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustHiTyp"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "SalesArea"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapiSdvtber"),
				com.tactusoft.webservice.client.objects.Sdvtber[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ValidOn"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "date"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "NodeList"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapikna1Knvh"),
				com.tactusoft.webservice.client.objects.Bapikna1Knvh[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapiret2"),
				com.tactusoft.webservice.client.objects.Bapiret2.class, false,
				false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[22] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerCheckExistence");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "DistributionChannel"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char2"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Division"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char2"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "SalesOrganization"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char4"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerData"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Kna1"),
				com.tactusoft.webservice.client.objects.Kna1.class, false,
				false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNumberOut"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapireturn"),
				com.tactusoft.webservice.client.objects.Bapireturn.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[23] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerCreateFromData");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PiAddress"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna101"),
				com.tactusoft.webservice.client.objects.Bapikna101.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PiCopyreference"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna102"),
				com.tactusoft.webservice.client.objects.Bapikna102.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PeCustomer"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapireturn"),
				com.tactusoft.webservice.client.objects.Bapireturn.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[24] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerGetPassword");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Statusinfo"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapiuswsta"),
				com.tactusoft.webservice.client.objects.Bapiuswsta[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapireturn"));
		oper.setReturnClass(com.tactusoft.webservice.client.objects.Bapireturn.class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "Return"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[25] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerChangeHierarchyNodes");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "NodeListAfter"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapikna1KnvhProcess"),
				com.tactusoft.webservice.client.objects.Bapikna1KnvhProcess[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "NodeListBefore"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapikna1KnvhProcess"),
				com.tactusoft.webservice.client.objects.Bapikna1KnvhProcess[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapiret2"));
		oper.setReturnClass(com.tactusoft.webservice.client.objects.Bapiret2[].class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "Return"));
		param = oper.getReturnParamDesc();
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[26] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerChangeFromData");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PiAddress"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna101"),
				com.tactusoft.webservice.client.objects.Bapikna101.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PiDistrChan"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char2"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PiDivision"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char2"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PiSalesorg"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char4"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "PeAddress"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapikna101"),
				com.tactusoft.webservice.client.objects.Bapikna101.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapireturn"),
				com.tactusoft.webservice.client.objects.Bapireturn.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[27] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerDisplay");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiret1"));
		oper.setReturnClass(com.tactusoft.webservice.client.objects.Bapiret1.class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "Return"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[28] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerGetContactList");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerRange"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapicustomerIdrange"),
				com.tactusoft.webservice.client.objects.BapicustomerIdrange[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "MaxRows"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "int"),
				java.lang.Integer.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ContactAddressData"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapicontactAddressdata"),
				com.tactusoft.webservice.client.objects.BapicontactAddressdata[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapireturn1"),
				com.tactusoft.webservice.client.objects.Bapireturn1.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[29] = oper;

	}

	private static void _initOperationDesc4() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerInitPassword");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Password"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char16"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapireturn"),
				com.tactusoft.webservice.client.objects.Bapireturn.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[30] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerCreate");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "InitializeCustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Customer"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapiret1"),
				com.tactusoft.webservice.client.objects.Bapiret1.class, false,
				false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[31] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerEdit");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CustomerNo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiret1"));
		oper.setReturnClass(com.tactusoft.webservice.client.objects.Bapiret1.class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "Return"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[32] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CustomerGetList");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "CPDOnly"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "IdRange"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapicustomerIdrange"),
				com.tactusoft.webservice.client.objects.BapicustomerIdrange[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "MaxRows"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "int"),
				java.lang.Integer.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "AddressData"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapicustomerAddressdata"),
				com.tactusoft.webservice.client.objects.BapicustomerAddressdata[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapireturn1"),
				com.tactusoft.webservice.client.objects.Bapireturn1.class,
				false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "SpecialData"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapicustomerSpecialdata"),
				com.tactusoft.webservice.client.objects.BapicustomerSpecialdata[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[33] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("BapiServiceTransactionRollback");
		oper.setReturnType(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiret2"));
		oper.setReturnClass(com.tactusoft.webservice.client.objects.Bapiret2.class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "Return"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[34] = oper;

	}

	public Zfi_customers2_BindingStub() throws org.apache.axis.AxisFault {
		this(null);
	}

	public Zfi_customers2_BindingStub(java.net.URL endpointURL,
			javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
		this(service);
		super.cachedEndpoint = endpointURL;
	}

	public Zfi_customers2_BindingStub(javax.xml.rpc.Service service)
			throws org.apache.axis.AxisFault {
		if (service == null) {
			super.service = new org.apache.axis.client.Service();
		} else {
			super.service = service;
		}
		((org.apache.axis.client.Service) super.service)
				.setTypeMappingVersion("1.2");
		java.lang.Class cls;
		javax.xml.namespace.QName qName;
		javax.xml.namespace.QName qName2;
		java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
		java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
		java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
		java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
		java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
		java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
		java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
		java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
		java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
		java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char1");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char10");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char11");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char12");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char130");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char132");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char14");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char15");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char16");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char18");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char2");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char20");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char220");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char241");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char25");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char28");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char3");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char30");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char31");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char32");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char35");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char4");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char40");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char5");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char50");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char6");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char60");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char8");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char9");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "clnt3");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "cuky5");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "curr15.2");
		cachedSerQNames.add(qName);
		cls = java.math.BigDecimal.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "curr8.2");
		cachedSerQNames.add(qName);
		cls = java.math.BigDecimal.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "date");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "decimal23.4");
		cachedSerQNames.add(qName);
		cls = java.math.BigDecimal.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "lang");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "numeric1");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "numeric10");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "numeric2");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "numeric3");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "numeric4");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "numeric5");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "numeric6");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "numeric7");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "quantum13.3");
		cachedSerQNames.add(qName);
		cls = java.math.BigDecimal.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "time");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "unit3");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"BapicontactAddressdata");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.BapicontactAddressdata.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapicustomer02");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicustomer02.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapicustomer04");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicustomer04.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapicustomer05");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicustomer05.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"BapicustomerAddressdata");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.BapicustomerAddressdata.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"BapicustomerIdrange");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.BapicustomerIdrange.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"BapicustomerKna1");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.BapicustomerKna1.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"BapicustomerNumbers");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.BapicustomerNumbers.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"BapicustomerSpecialdata");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.BapicustomerSpecialdata.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna101");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna101.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna1011");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna1011.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna1011x");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna1011X.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna102");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna102.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna103");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna103.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna105");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna105.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna105x");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna105X.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna106");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna106.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna106x");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna106X.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna109");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna109.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna110");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna110.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna111");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna111.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna1Knvh");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna1Knvh.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna1KnvhProcess");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna1KnvhProcess.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapiknvvky");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapiknvvky.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiret1");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapiret1.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiret2");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapiret2.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapireturn");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapireturn.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapireturn1");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapireturn1.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapiuswsta");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapiuswsta.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Kna1");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Kna1.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Sdvtber");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Sdvtber.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapicontactAddressdata");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.BapicontactAddressdata[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"BapicontactAddressdata");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapicustomer02");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicustomer02[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapicustomer02");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapicustomerAddressdata");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.BapicustomerAddressdata[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"BapicustomerAddressdata");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapicustomerIdrange");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.BapicustomerIdrange[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"BapicustomerIdrange");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapicustomerNumbers");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.BapicustomerNumbers[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"BapicustomerNumbers");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapicustomerSpecialdata");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.BapicustomerSpecialdata[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"BapicustomerSpecialdata");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapikna103");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna103[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna103");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapikna110");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna110[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna110");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapikna111");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna111[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna111");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapikna1Knvh");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna1Knvh[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna1Knvh");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapikna1KnvhProcess");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapikna1KnvhProcess[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapikna1KnvhProcess");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapiknvvky");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapiknvvky[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapiknvvky");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapiret2");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapiret2[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiret2");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapiSdvtber");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Sdvtber[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Sdvtber");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapiuswsta");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapiuswsta[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapiuswsta");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

	}

	protected org.apache.axis.client.Call createCall()
			throws java.rmi.RemoteException {
		try {
			org.apache.axis.client.Call _call = super._createCall();
			if (super.maintainSessionSet) {
				_call.setMaintainSession(super.maintainSession);
			}
			if (super.cachedUsername != null) {
				_call.setUsername(super.cachedUsername);
			}

			if (super.cachedPassword != null) {
				_call.setPassword(super.cachedPassword);
			}
			if (super.cachedEndpoint != null) {
				_call.setTargetEndpointAddress(super.cachedEndpoint);
			}
			if (super.cachedTimeout != null) {
				_call.setTimeout(super.cachedTimeout);
			}
			if (super.cachedPortName != null) {
				_call.setPortName(super.cachedPortName);
			}
			java.util.Enumeration keys = super.cachedProperties.keys();
			while (keys.hasMoreElements()) {
				java.lang.String key = (java.lang.String) keys.nextElement();
				_call.setProperty(key, super.cachedProperties.get(key));
			}
			// All the type mapping information is registered
			// when the first call is made.
			// The type mapping information is actually registered in
			// the TypeMappingRegistry of the service, which
			// is the reason why registration is only needed for the first call.
			synchronized (this) {
				if (firstCall()) {
					// must set encoding style before registering serializers
					_call.setEncodingStyle(null);
					for (int i = 0; i < cachedSerFactories.size(); ++i) {
						java.lang.Class cls = (java.lang.Class) cachedSerClasses
								.get(i);
						javax.xml.namespace.QName qName = (javax.xml.namespace.QName) cachedSerQNames
								.get(i);
						java.lang.Object x = cachedSerFactories.get(i);
						if (x instanceof Class) {
							java.lang.Class sf = (java.lang.Class) cachedSerFactories
									.get(i);
							java.lang.Class df = (java.lang.Class) cachedDeserFactories
									.get(i);
							_call.registerTypeMapping(cls, qName, sf, df, false);
						} else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
							org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory) cachedSerFactories
									.get(i);
							org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory) cachedDeserFactories
									.get(i);
							_call.registerTypeMapping(cls, qName, sf, df, false);
						}
					}
				}
			}
			return _call;
		} catch (java.lang.Throwable _t) {
			throw new org.apache.axis.AxisFault(
					"Failure trying to get the Call object", _t);
		}
	}

	public com.tactusoft.webservice.client.objects.Bapireturn customerCreatePassword(
			java.lang.String customerNo) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[0]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerCreatePassword"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { customerNo });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.tactusoft.webservice.client.objects.Bapireturn) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.tactusoft.webservice.client.objects.Bapireturn) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.tactusoft.webservice.client.objects.Bapireturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerGetDetail1(
			java.lang.String customerNo,
			java.lang.String distributionChannel,
			java.lang.String division,
			java.lang.String salesOrganiation,
			com.tactusoft.webservice.client.holders.Bapikna109Holder addressTypeNo,
			com.tactusoft.webservice.client.holders.Bapikna106Holder companyData,
			javax.xml.rpc.holders.StringHolder consumerFlag,
			com.tactusoft.webservice.client.holders.Bapikna105Holder optionalCompanyData,
			com.tactusoft.webservice.client.holders.Bapikna105Holder optionalPersonalData,
			com.tactusoft.webservice.client.holders.Bapikna105Holder optionalPersonalDataNew,
			com.tactusoft.webservice.client.holders.Bapikna1011Holder personalData,
			com.tactusoft.webservice.client.holders.Bapikna1011Holder personalDataNew,
			com.tactusoft.webservice.client.holders.Bapireturn1Holder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[1]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerGetDetail1"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { customerNo,
							distributionChannel, division, salesOrganiation });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					addressTypeNo.value = (com.tactusoft.webservice.client.objects.Bapikna109) _output
							.get(new javax.xml.namespace.QName("",
									"AddressTypeNo"));
				} catch (java.lang.Exception _exception) {
					addressTypeNo.value = (com.tactusoft.webservice.client.objects.Bapikna109) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "AddressTypeNo")),
									com.tactusoft.webservice.client.objects.Bapikna109.class);
				}
				try {
					companyData.value = (com.tactusoft.webservice.client.objects.Bapikna106) _output
							.get(new javax.xml.namespace.QName("",
									"CompanyData"));
				} catch (java.lang.Exception _exception) {
					companyData.value = (com.tactusoft.webservice.client.objects.Bapikna106) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "CompanyData")),
									com.tactusoft.webservice.client.objects.Bapikna106.class);
				}
				try {
					consumerFlag.value = (java.lang.String) _output
							.get(new javax.xml.namespace.QName("",
									"ConsumerFlag"));
				} catch (java.lang.Exception _exception) {
					consumerFlag.value = (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_output.get(new javax.xml.namespace.QName(
									"", "ConsumerFlag")),
									java.lang.String.class);
				}
				try {
					optionalCompanyData.value = (com.tactusoft.webservice.client.objects.Bapikna105) _output
							.get(new javax.xml.namespace.QName("",
									"OptionalCompanyData"));
				} catch (java.lang.Exception _exception) {
					optionalCompanyData.value = (com.tactusoft.webservice.client.objects.Bapikna105) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OptionalCompanyData")),
									com.tactusoft.webservice.client.objects.Bapikna105.class);
				}
				try {
					optionalPersonalData.value = (com.tactusoft.webservice.client.objects.Bapikna105) _output
							.get(new javax.xml.namespace.QName("",
									"OptionalPersonalData"));
				} catch (java.lang.Exception _exception) {
					optionalPersonalData.value = (com.tactusoft.webservice.client.objects.Bapikna105) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OptionalPersonalData")),
									com.tactusoft.webservice.client.objects.Bapikna105.class);
				}
				try {
					optionalPersonalDataNew.value = (com.tactusoft.webservice.client.objects.Bapikna105) _output
							.get(new javax.xml.namespace.QName("",
									"OptionalPersonalDataNew"));
				} catch (java.lang.Exception _exception) {
					optionalPersonalDataNew.value = (com.tactusoft.webservice.client.objects.Bapikna105) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OptionalPersonalDataNew")),
									com.tactusoft.webservice.client.objects.Bapikna105.class);
				}
				try {
					personalData.value = (com.tactusoft.webservice.client.objects.Bapikna1011) _output
							.get(new javax.xml.namespace.QName("",
									"PersonalData"));
				} catch (java.lang.Exception _exception) {
					personalData.value = (com.tactusoft.webservice.client.objects.Bapikna1011) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "PersonalData")),
									com.tactusoft.webservice.client.objects.Bapikna1011.class);
				}
				try {
					personalDataNew.value = (com.tactusoft.webservice.client.objects.Bapikna1011) _output
							.get(new javax.xml.namespace.QName("",
									"PersonalDataNew"));
				} catch (java.lang.Exception _exception) {
					personalDataNew.value = (com.tactusoft.webservice.client.objects.Bapikna1011) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "PersonalDataNew")),
									com.tactusoft.webservice.client.objects.Bapikna1011.class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn1) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn1) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapireturn1.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerGetDetail2(
			java.lang.String companyCode,
			java.lang.String customerNo,
			com.tactusoft.webservice.client.holders.Bapicustomer04Holder customerAddress,
			com.tactusoft.webservice.client.holders.TableOfBapicustomer02Holder customerBankDetail,
			com.tactusoft.webservice.client.holders.Bapicustomer05Holder customerCompanyDetail,
			com.tactusoft.webservice.client.holders.BapicustomerKna1Holder customerGeneralDetail,
			com.tactusoft.webservice.client.holders.Bapiret1Holder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[2]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerGetDetail2"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					companyCode, customerNo });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					customerAddress.value = (com.tactusoft.webservice.client.objects.Bapicustomer04) _output
							.get(new javax.xml.namespace.QName("",
									"CustomerAddress"));
				} catch (java.lang.Exception _exception) {
					customerAddress.value = (com.tactusoft.webservice.client.objects.Bapicustomer04) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "CustomerAddress")),
									com.tactusoft.webservice.client.objects.Bapicustomer04.class);
				}
				try {
					customerBankDetail.value = (com.tactusoft.webservice.client.objects.Bapicustomer02[]) _output
							.get(new javax.xml.namespace.QName("",
									"CustomerBankDetail"));
				} catch (java.lang.Exception _exception) {
					customerBankDetail.value = (com.tactusoft.webservice.client.objects.Bapicustomer02[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "CustomerBankDetail")),
									com.tactusoft.webservice.client.objects.Bapicustomer02[].class);
				}
				try {
					customerCompanyDetail.value = (com.tactusoft.webservice.client.objects.Bapicustomer05) _output
							.get(new javax.xml.namespace.QName("",
									"CustomerCompanyDetail"));
				} catch (java.lang.Exception _exception) {
					customerCompanyDetail.value = (com.tactusoft.webservice.client.objects.Bapicustomer05) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "CustomerCompanyDetail")),
									com.tactusoft.webservice.client.objects.Bapicustomer05.class);
				}
				try {
					customerGeneralDetail.value = (com.tactusoft.webservice.client.objects.BapicustomerKna1) _output
							.get(new javax.xml.namespace.QName("",
									"CustomerGeneralDetail"));
				} catch (java.lang.Exception _exception) {
					customerGeneralDetail.value = (com.tactusoft.webservice.client.objects.BapicustomerKna1) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "CustomerGeneralDetail")),
									com.tactusoft.webservice.client.objects.BapicustomerKna1.class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapiret1) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapiret1) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapiret1.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerGetHierarchyChildren(
			java.lang.String custHiTyp,
			java.lang.String customerNo,
			java.lang.String nodeLevel,
			com.tactusoft.webservice.client.objects.Sdvtber[] salesArea,
			java.lang.String validOn,
			com.tactusoft.webservice.client.holders.TableOfBapikna1KnvhHolder nodeList,
			com.tactusoft.webservice.client.holders.Bapiret2Holder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[3]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerGetHierarchyChildren"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					custHiTyp, customerNo, nodeLevel, salesArea, validOn });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					nodeList.value = (com.tactusoft.webservice.client.objects.Bapikna1Knvh[]) _output
							.get(new javax.xml.namespace.QName("", "NodeList"));
				} catch (java.lang.Exception _exception) {
					nodeList.value = (com.tactusoft.webservice.client.objects.Bapikna1Knvh[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "NodeList")),
									com.tactusoft.webservice.client.objects.Bapikna1Knvh[].class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapiret2) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapiret2) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapiret2.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public com.tactusoft.webservice.client.objects.Bapiret2[] customerAddHierarchyNodes(
			com.tactusoft.webservice.client.holders.TableOfBapikna1KnvhProcessHolder nodeList)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[4]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerAddHierarchyNodes"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { nodeList.value });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					nodeList.value = (com.tactusoft.webservice.client.objects.Bapikna1KnvhProcess[]) _output
							.get(new javax.xml.namespace.QName("", "NodeList"));
				} catch (java.lang.Exception _exception) {
					nodeList.value = (com.tactusoft.webservice.client.objects.Bapikna1KnvhProcess[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "NodeList")),
									com.tactusoft.webservice.client.objects.Bapikna1KnvhProcess[].class);
				}
				try {
					return (com.tactusoft.webservice.client.objects.Bapiret2[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.tactusoft.webservice.client.objects.Bapiret2[]) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.tactusoft.webservice.client.objects.Bapiret2[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public com.tactusoft.webservice.client.objects.Bapireturn customerDeletePassword(
			java.lang.String customerNo) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[5]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerDeletePassword"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { customerNo });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.tactusoft.webservice.client.objects.Bapireturn) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.tactusoft.webservice.client.objects.Bapireturn) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.tactusoft.webservice.client.objects.Bapireturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerFind(
			java.lang.Integer maxCnt,
			java.lang.String plHold,
			com.tactusoft.webservice.client.objects.Bapikna110[] seloptTab,
			com.tactusoft.webservice.client.holders.TableOfBapikna111Holder resultTab,
			com.tactusoft.webservice.client.holders.Bapireturn1Holder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[6]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerFind"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					maxCnt, plHold, seloptTab });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					resultTab.value = (com.tactusoft.webservice.client.objects.Bapikna111[]) _output
							.get(new javax.xml.namespace.QName("", "ResultTab"));
				} catch (java.lang.Exception _exception) {
					resultTab.value = (com.tactusoft.webservice.client.objects.Bapikna111[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ResultTab")),
									com.tactusoft.webservice.client.objects.Bapikna111[].class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn1) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn1) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapireturn1.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerGetSalesAreas(
			java.lang.String customerNo,
			com.tactusoft.webservice.client.holders.BapireturnHolder _return,
			com.tactusoft.webservice.client.holders.TableOfBapiknvvkyHolder salesAreas)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[7]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerGetSalesAreas"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { customerNo });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapireturn.class);
				}
				try {
					salesAreas.value = (com.tactusoft.webservice.client.objects.Bapiknvvky[]) _output
							.get(new javax.xml.namespace.QName("", "SalesAreas"));
				} catch (java.lang.Exception _exception) {
					salesAreas.value = (com.tactusoft.webservice.client.objects.Bapiknvvky[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "SalesAreas")),
									com.tactusoft.webservice.client.objects.Bapiknvvky[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerSearch1(
			java.lang.String email,
			java.lang.String salesorganisation,
			javax.xml.rpc.holders.StringHolder customerNo,
			com.tactusoft.webservice.client.holders.TableOfBapikna103Holder multiple,
			com.tactusoft.webservice.client.holders.Bapireturn1Holder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[8]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerSearch1"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					email, salesorganisation });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					customerNo.value = (java.lang.String) _output
							.get(new javax.xml.namespace.QName("", "CustomerNo"));
				} catch (java.lang.Exception _exception) {
					customerNo.value = (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_output.get(new javax.xml.namespace.QName(
									"", "CustomerNo")), java.lang.String.class);
				}
				try {
					multiple.value = (com.tactusoft.webservice.client.objects.Bapikna103[]) _output
							.get(new javax.xml.namespace.QName("", "Multiple"));
				} catch (java.lang.Exception _exception) {
					multiple.value = (com.tactusoft.webservice.client.objects.Bapikna103[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Multiple")),
									com.tactusoft.webservice.client.objects.Bapikna103[].class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn1) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn1) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapireturn1.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public com.tactusoft.webservice.client.objects.Bapiret2 bapiServiceTransactionCommit(
			java.lang.String WAIT) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[9]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"BapiServiceTransactionCommit"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { WAIT });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.tactusoft.webservice.client.objects.Bapiret2) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.tactusoft.webservice.client.objects.Bapiret2) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.tactusoft.webservice.client.objects.Bapiret2.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public com.tactusoft.webservice.client.objects.Bapireturn customerChangePassword(
			java.lang.String customerNo, java.lang.String newPassword,
			java.lang.String password, java.lang.String verifyPassword)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[10]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerChangePassword"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					customerNo, newPassword, password, verifyPassword });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.tactusoft.webservice.client.objects.Bapireturn) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.tactusoft.webservice.client.objects.Bapireturn) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.tactusoft.webservice.client.objects.Bapireturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerCreateFromData1(
			com.tactusoft.webservice.client.objects.Bapikna106 companyData,
			java.lang.String consumerEn,
			com.tactusoft.webservice.client.objects.Bapikna102 copyReference,
			java.lang.String creditControlFlag,
			com.tactusoft.webservice.client.objects.Bapikna105 optionalCompanyData,
			com.tactusoft.webservice.client.objects.Bapikna105 optionalPersonalData,
			com.tactusoft.webservice.client.objects.Bapikna1011 personalData,
			javax.xml.rpc.holders.StringHolder customerNo,
			com.tactusoft.webservice.client.holders.Bapireturn1Holder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[11]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerCreateFromData1"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					companyData, consumerEn, copyReference, creditControlFlag,
					optionalCompanyData, optionalPersonalData, personalData });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					customerNo.value = (java.lang.String) _output
							.get(new javax.xml.namespace.QName("", "CustomerNo"));
				} catch (java.lang.Exception _exception) {
					customerNo.value = (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_output.get(new javax.xml.namespace.QName(
									"", "CustomerNo")), java.lang.String.class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn1) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn1) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapireturn1.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public com.tactusoft.webservice.client.objects.Bapiret1 customerDelete(
			java.lang.String customerNo) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[12]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerDelete"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { customerNo });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.tactusoft.webservice.client.objects.Bapiret1) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.tactusoft.webservice.client.objects.Bapiret1) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.tactusoft.webservice.client.objects.Bapiret1.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public com.tactusoft.webservice.client.objects.Bapiret1 customerExistenceCheck(
			java.lang.String companyCode, java.lang.String customerNo,
			java.lang.String distributionChannel, java.lang.String division,
			java.lang.String salesOrganization) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[13]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerExistenceCheck"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					companyCode, customerNo, distributionChannel, division,
					salesOrganization });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.tactusoft.webservice.client.objects.Bapiret1) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.tactusoft.webservice.client.objects.Bapiret1) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.tactusoft.webservice.client.objects.Bapiret1.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerGetInternalNumber(
			java.lang.String accountGroup,
			org.apache.axis.holders.UnsignedByteHolder quantity,
			com.tactusoft.webservice.client.holders.TableOfBapicustomerNumbersHolder customer,
			javax.xml.rpc.holders.StringHolder customerId,
			com.tactusoft.webservice.client.holders.Bapireturn1Holder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[14]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerGetInternalNumber"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					accountGroup, quantity.value });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					quantity.value = (org.apache.axis.types.UnsignedByte) _output
							.get(new javax.xml.namespace.QName("", "Quantity"));
				} catch (java.lang.Exception _exception) {
					quantity.value = (org.apache.axis.types.UnsignedByte) org.apache.axis.utils.JavaUtils
							.convert(_output.get(new javax.xml.namespace.QName(
									"", "Quantity")),
									org.apache.axis.types.UnsignedByte.class);
				}
				try {
					customer.value = (com.tactusoft.webservice.client.objects.BapicustomerNumbers[]) _output
							.get(new javax.xml.namespace.QName("", "Customer"));
				} catch (java.lang.Exception _exception) {
					customer.value = (com.tactusoft.webservice.client.objects.BapicustomerNumbers[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Customer")),
									com.tactusoft.webservice.client.objects.BapicustomerNumbers[].class);
				}
				try {
					customerId.value = (java.lang.String) _output
							.get(new javax.xml.namespace.QName("", "CustomerId"));
				} catch (java.lang.Exception _exception) {
					customerId.value = (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_output.get(new javax.xml.namespace.QName(
									"", "CustomerId")), java.lang.String.class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn1) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn1) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapireturn1.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerGetHierarchyRootList(
			java.lang.String custHiTyp,
			com.tactusoft.webservice.client.objects.Sdvtber[] salesArea,
			java.lang.String validOn,
			com.tactusoft.webservice.client.holders.TableOfBapikna1KnvhHolder nodeList,
			com.tactusoft.webservice.client.holders.Bapiret2Holder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[15]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerGetHierarchyRootList"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					custHiTyp, salesArea, validOn });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					nodeList.value = (com.tactusoft.webservice.client.objects.Bapikna1Knvh[]) _output
							.get(new javax.xml.namespace.QName("", "NodeList"));
				} catch (java.lang.Exception _exception) {
					nodeList.value = (com.tactusoft.webservice.client.objects.Bapikna1Knvh[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "NodeList")),
									com.tactusoft.webservice.client.objects.Bapikna1Knvh[].class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapiret2) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapiret2) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapiret2.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerSearch(
			com.tactusoft.webservice.client.objects.Bapikna101 piAddress,
			java.lang.String piSalesorg,
			java.lang.String piSearchFlag,
			com.tactusoft.webservice.client.holders.TableOfBapikna103Holder multiple,
			javax.xml.rpc.holders.StringHolder peCustomer,
			com.tactusoft.webservice.client.holders.BapireturnHolder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[16]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerSearch"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					piAddress, piSalesorg, piSearchFlag });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					multiple.value = (com.tactusoft.webservice.client.objects.Bapikna103[]) _output
							.get(new javax.xml.namespace.QName("", "Multiple"));
				} catch (java.lang.Exception _exception) {
					multiple.value = (com.tactusoft.webservice.client.objects.Bapikna103[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Multiple")),
									com.tactusoft.webservice.client.objects.Bapikna103[].class);
				}
				try {
					peCustomer.value = (java.lang.String) _output
							.get(new javax.xml.namespace.QName("", "PeCustomer"));
				} catch (java.lang.Exception _exception) {
					peCustomer.value = (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_output.get(new javax.xml.namespace.QName(
									"", "PeCustomer")), java.lang.String.class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapireturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerCheckPassword(java.lang.String customerNo,
			java.lang.String distributionChannel, java.lang.String division,
			java.lang.String password, java.lang.String salesOrganization,
			com.tactusoft.webservice.client.holders.Kna1Holder customerData,
			javax.xml.rpc.holders.StringHolder customerNumberOut,
			com.tactusoft.webservice.client.holders.BapireturnHolder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[17]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerCheckPassword"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					customerNo, distributionChannel, division, password,
					salesOrganization });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					customerData.value = (com.tactusoft.webservice.client.objects.Kna1) _output
							.get(new javax.xml.namespace.QName("",
									"CustomerData"));
				} catch (java.lang.Exception _exception) {
					customerData.value = (com.tactusoft.webservice.client.objects.Kna1) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "CustomerData")),
									com.tactusoft.webservice.client.objects.Kna1.class);
				}
				try {
					customerNumberOut.value = (java.lang.String) _output
							.get(new javax.xml.namespace.QName("",
									"CustomerNumberOut"));
				} catch (java.lang.Exception _exception) {
					customerNumberOut.value = (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_output.get(new javax.xml.namespace.QName(
									"", "CustomerNumberOut")),
									java.lang.String.class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapireturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public com.tactusoft.webservice.client.objects.Bapiret2[] customerRemoveHierarchyNodes(
			com.tactusoft.webservice.client.holders.TableOfBapikna1KnvhProcessHolder nodeList)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[18]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerRemoveHierarchyNodes"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { nodeList.value });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					nodeList.value = (com.tactusoft.webservice.client.objects.Bapikna1KnvhProcess[]) _output
							.get(new javax.xml.namespace.QName("", "NodeList"));
				} catch (java.lang.Exception _exception) {
					nodeList.value = (com.tactusoft.webservice.client.objects.Bapikna1KnvhProcess[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "NodeList")),
									com.tactusoft.webservice.client.objects.Bapikna1KnvhProcess[].class);
				}
				try {
					return (com.tactusoft.webservice.client.objects.Bapiret2[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.tactusoft.webservice.client.objects.Bapiret2[]) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.tactusoft.webservice.client.objects.Bapiret2[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public com.tactusoft.webservice.client.objects.Bapireturn1 customerChangeFromData1(
			com.tactusoft.webservice.client.objects.Bapikna106 companyData,
			com.tactusoft.webservice.client.objects.Bapikna106X companyDataX,
			java.lang.String customerNo,
			java.lang.String distributionChannel,
			java.lang.String division,
			com.tactusoft.webservice.client.objects.Bapikna105 optionalCompanyData,
			com.tactusoft.webservice.client.objects.Bapikna105X optionalCompanyDataX,
			com.tactusoft.webservice.client.objects.Bapikna105 optionalPersonalData,
			com.tactusoft.webservice.client.objects.Bapikna105X optionalPersonalDataX,
			com.tactusoft.webservice.client.objects.Bapikna1011 personalData,
			com.tactusoft.webservice.client.objects.Bapikna1011X personalDataX,
			java.lang.String salesOrganisation) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[19]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerChangeFromData1"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					companyData, companyDataX, customerNo, distributionChannel,
					division, optionalCompanyData, optionalCompanyDataX,
					optionalPersonalData, optionalPersonalDataX, personalData,
					personalDataX, salesOrganisation });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.tactusoft.webservice.client.objects.Bapireturn1) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.tactusoft.webservice.client.objects.Bapireturn1) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.tactusoft.webservice.client.objects.Bapireturn1.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public com.tactusoft.webservice.client.objects.Bapiret1 customerCheckPassword1(
			java.lang.String customerNo, java.lang.String password)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[20]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerCheckPassword1"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					customerNo, password });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.tactusoft.webservice.client.objects.Bapiret1) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.tactusoft.webservice.client.objects.Bapiret1) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.tactusoft.webservice.client.objects.Bapiret1.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerGetDetail(java.lang.String customerNo,
			java.lang.String distributionChannel, java.lang.String division,
			java.lang.String passBuffer, java.lang.String piSalesorg,
			com.tactusoft.webservice.client.holders.Bapikna101Holder peAddress,
			com.tactusoft.webservice.client.holders.BapireturnHolder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[21]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerGetDetail"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					customerNo, distributionChannel, division, passBuffer,
					piSalesorg });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					peAddress.value = (com.tactusoft.webservice.client.objects.Bapikna101) _output
							.get(new javax.xml.namespace.QName("", "PeAddress"));
				} catch (java.lang.Exception _exception) {
					peAddress.value = (com.tactusoft.webservice.client.objects.Bapikna101) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "PeAddress")),
									com.tactusoft.webservice.client.objects.Bapikna101.class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapireturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerGetHierarchyRoot(
			java.lang.String custHiTyp,
			java.lang.String customerNo,
			com.tactusoft.webservice.client.objects.Sdvtber[] salesArea,
			java.lang.String validOn,
			com.tactusoft.webservice.client.holders.TableOfBapikna1KnvhHolder nodeList,
			com.tactusoft.webservice.client.holders.Bapiret2Holder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[22]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerGetHierarchyRoot"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					custHiTyp, customerNo, salesArea, validOn });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					nodeList.value = (com.tactusoft.webservice.client.objects.Bapikna1Knvh[]) _output
							.get(new javax.xml.namespace.QName("", "NodeList"));
				} catch (java.lang.Exception _exception) {
					nodeList.value = (com.tactusoft.webservice.client.objects.Bapikna1Knvh[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "NodeList")),
									com.tactusoft.webservice.client.objects.Bapikna1Knvh[].class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapiret2) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapiret2) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapiret2.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerCheckExistence(java.lang.String customerNo,
			java.lang.String distributionChannel, java.lang.String division,
			java.lang.String salesOrganization,
			com.tactusoft.webservice.client.holders.Kna1Holder customerData,
			javax.xml.rpc.holders.StringHolder customerNumberOut,
			com.tactusoft.webservice.client.holders.BapireturnHolder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[23]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerCheckExistence"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					customerNo, distributionChannel, division,
					salesOrganization });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					customerData.value = (com.tactusoft.webservice.client.objects.Kna1) _output
							.get(new javax.xml.namespace.QName("",
									"CustomerData"));
				} catch (java.lang.Exception _exception) {
					customerData.value = (com.tactusoft.webservice.client.objects.Kna1) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "CustomerData")),
									com.tactusoft.webservice.client.objects.Kna1.class);
				}
				try {
					customerNumberOut.value = (java.lang.String) _output
							.get(new javax.xml.namespace.QName("",
									"CustomerNumberOut"));
				} catch (java.lang.Exception _exception) {
					customerNumberOut.value = (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_output.get(new javax.xml.namespace.QName(
									"", "CustomerNumberOut")),
									java.lang.String.class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapireturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerCreateFromData(
			com.tactusoft.webservice.client.objects.Bapikna101 piAddress,
			com.tactusoft.webservice.client.objects.Bapikna102 piCopyreference,
			javax.xml.rpc.holders.StringHolder customerNo,
			javax.xml.rpc.holders.StringHolder peCustomer,
			com.tactusoft.webservice.client.holders.BapireturnHolder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[24]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerCreateFromData"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					piAddress, piCopyreference });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					customerNo.value = (java.lang.String) _output
							.get(new javax.xml.namespace.QName("", "CustomerNo"));
				} catch (java.lang.Exception _exception) {
					customerNo.value = (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_output.get(new javax.xml.namespace.QName(
									"", "CustomerNo")), java.lang.String.class);
				}
				try {
					peCustomer.value = (java.lang.String) _output
							.get(new javax.xml.namespace.QName("", "PeCustomer"));
				} catch (java.lang.Exception _exception) {
					peCustomer.value = (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_output.get(new javax.xml.namespace.QName(
									"", "PeCustomer")), java.lang.String.class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapireturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public com.tactusoft.webservice.client.objects.Bapireturn customerGetPassword(
			java.lang.String customerNo,
			com.tactusoft.webservice.client.holders.TableOfBapiuswstaHolder statusinfo)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[25]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerGetPassword"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					customerNo, statusinfo.value });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					statusinfo.value = (com.tactusoft.webservice.client.objects.Bapiuswsta[]) _output
							.get(new javax.xml.namespace.QName("", "Statusinfo"));
				} catch (java.lang.Exception _exception) {
					statusinfo.value = (com.tactusoft.webservice.client.objects.Bapiuswsta[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Statusinfo")),
									com.tactusoft.webservice.client.objects.Bapiuswsta[].class);
				}
				try {
					return (com.tactusoft.webservice.client.objects.Bapireturn) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.tactusoft.webservice.client.objects.Bapireturn) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.tactusoft.webservice.client.objects.Bapireturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public com.tactusoft.webservice.client.objects.Bapiret2[] customerChangeHierarchyNodes(
			com.tactusoft.webservice.client.objects.Bapikna1KnvhProcess[] nodeListAfter,
			com.tactusoft.webservice.client.objects.Bapikna1KnvhProcess[] nodeListBefore)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[26]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerChangeHierarchyNodes"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					nodeListAfter, nodeListBefore });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.tactusoft.webservice.client.objects.Bapiret2[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.tactusoft.webservice.client.objects.Bapiret2[]) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.tactusoft.webservice.client.objects.Bapiret2[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerChangeFromData(java.lang.String customerNo,
			com.tactusoft.webservice.client.objects.Bapikna101 piAddress,
			java.lang.String piDistrChan, java.lang.String piDivision,
			java.lang.String piSalesorg,
			com.tactusoft.webservice.client.holders.Bapikna101Holder peAddress,
			com.tactusoft.webservice.client.holders.BapireturnHolder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[27]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerChangeFromData"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { customerNo, piAddress,
							piDistrChan, piDivision, piSalesorg });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					peAddress.value = (com.tactusoft.webservice.client.objects.Bapikna101) _output
							.get(new javax.xml.namespace.QName("", "PeAddress"));
				} catch (java.lang.Exception _exception) {
					peAddress.value = (com.tactusoft.webservice.client.objects.Bapikna101) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "PeAddress")),
									com.tactusoft.webservice.client.objects.Bapikna101.class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapireturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public com.tactusoft.webservice.client.objects.Bapiret1 customerDisplay(
			java.lang.String customerNo) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[28]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerDisplay"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { customerNo });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.tactusoft.webservice.client.objects.Bapiret1) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.tactusoft.webservice.client.objects.Bapiret1) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.tactusoft.webservice.client.objects.Bapiret1.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerGetContactList(
			com.tactusoft.webservice.client.objects.BapicustomerIdrange[] customerRange,
			java.lang.Integer maxRows,
			com.tactusoft.webservice.client.holders.TableOfBapicontactAddressdataHolder contactAddressData,
			com.tactusoft.webservice.client.holders.Bapireturn1Holder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[29]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerGetContactList"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					customerRange, maxRows });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					contactAddressData.value = (com.tactusoft.webservice.client.objects.BapicontactAddressdata[]) _output
							.get(new javax.xml.namespace.QName("",
									"ContactAddressData"));
				} catch (java.lang.Exception _exception) {
					contactAddressData.value = (com.tactusoft.webservice.client.objects.BapicontactAddressdata[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ContactAddressData")),
									com.tactusoft.webservice.client.objects.BapicontactAddressdata[].class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn1) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn1) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapireturn1.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerInitPassword(java.lang.String customerNo,
			javax.xml.rpc.holders.StringHolder password,
			com.tactusoft.webservice.client.holders.BapireturnHolder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[30]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerInitPassword"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { customerNo });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					password.value = (java.lang.String) _output
							.get(new javax.xml.namespace.QName("", "Password"));
				} catch (java.lang.Exception _exception) {
					password.value = (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_output.get(new javax.xml.namespace.QName(
									"", "Password")), java.lang.String.class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapireturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerCreate(java.lang.String initializeCustomerNo,
			javax.xml.rpc.holders.StringHolder customer,
			javax.xml.rpc.holders.StringHolder customerNo,
			com.tactusoft.webservice.client.holders.Bapiret1Holder _return)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[31]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerCreate"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { initializeCustomerNo });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					customer.value = (java.lang.String) _output
							.get(new javax.xml.namespace.QName("", "Customer"));
				} catch (java.lang.Exception _exception) {
					customer.value = (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_output.get(new javax.xml.namespace.QName(
									"", "Customer")), java.lang.String.class);
				}
				try {
					customerNo.value = (java.lang.String) _output
							.get(new javax.xml.namespace.QName("", "CustomerNo"));
				} catch (java.lang.Exception _exception) {
					customerNo.value = (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_output.get(new javax.xml.namespace.QName(
									"", "CustomerNo")), java.lang.String.class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapiret1) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapiret1) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapiret1.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public com.tactusoft.webservice.client.objects.Bapiret1 customerEdit(
			java.lang.String customerNo) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[32]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerEdit"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { customerNo });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.tactusoft.webservice.client.objects.Bapiret1) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.tactusoft.webservice.client.objects.Bapiret1) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.tactusoft.webservice.client.objects.Bapiret1.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public void customerGetList(
			java.lang.String CPDOnly,
			com.tactusoft.webservice.client.objects.BapicustomerIdrange[] idRange,
			java.lang.Integer maxRows,
			com.tactusoft.webservice.client.holders.TableOfBapicustomerAddressdataHolder addressData,
			com.tactusoft.webservice.client.holders.Bapireturn1Holder _return,
			com.tactusoft.webservice.client.holders.TableOfBapicustomerSpecialdataHolder specialData)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[33]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustomerGetList"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					CPDOnly, idRange, maxRows });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					addressData.value = (com.tactusoft.webservice.client.objects.BapicustomerAddressdata[]) _output
							.get(new javax.xml.namespace.QName("",
									"AddressData"));
				} catch (java.lang.Exception _exception) {
					addressData.value = (com.tactusoft.webservice.client.objects.BapicustomerAddressdata[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "AddressData")),
									com.tactusoft.webservice.client.objects.BapicustomerAddressdata[].class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn1) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapireturn1) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapireturn1.class);
				}
				try {
					specialData.value = (com.tactusoft.webservice.client.objects.BapicustomerSpecialdata[]) _output
							.get(new javax.xml.namespace.QName("",
									"SpecialData"));
				} catch (java.lang.Exception _exception) {
					specialData.value = (com.tactusoft.webservice.client.objects.BapicustomerSpecialdata[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "SpecialData")),
									com.tactusoft.webservice.client.objects.BapicustomerSpecialdata[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public com.tactusoft.webservice.client.objects.Bapiret2 bapiServiceTransactionRollback()
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[34]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"BapiServiceTransactionRollback"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.tactusoft.webservice.client.objects.Bapiret2) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.tactusoft.webservice.client.objects.Bapiret2) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.tactusoft.webservice.client.objects.Bapiret2.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

}
