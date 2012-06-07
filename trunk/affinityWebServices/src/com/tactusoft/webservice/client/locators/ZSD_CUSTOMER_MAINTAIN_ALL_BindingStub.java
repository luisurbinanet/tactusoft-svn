/**
 * ZSD_CUSTOMER_MAINTAIN_ALL_BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.locators;

@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
public class ZSD_CUSTOMER_MAINTAIN_ALL_BindingStub extends
		org.apache.axis.client.Stub
		implements
		com.tactusoft.webservice.client.locators.ZSD_CUSTOMER_MAINTAIN_ALL_PortType {

	private java.util.Vector cachedSerClasses = new java.util.Vector();
	private java.util.Vector cachedSerQNames = new java.util.Vector();
	private java.util.Vector cachedSerFactories = new java.util.Vector();
	private java.util.Vector cachedDeserFactories = new java.util.Vector();

	static org.apache.axis.description.OperationDesc[] _operations;

	static {
		_operations = new org.apache.axis.description.OperationDesc[1];
		_initOperationDesc1();
	}

	private static void _initOperationDesc1() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("ZsdCustomerMaintainAll");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZiBapiaddr1"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapiaddr1"),
				com.tactusoft.webservice.client.objects.Bapiaddr1.class, false,
				false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZiBapiaddr2"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapiaddr2"),
				com.tactusoft.webservice.client.objects.Bapiaddr2.class, false,
				false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZiCustomerIsConsumer"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZiForceExternalNumberRange"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZiFromCustomermaster"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZiKna1"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Kna1"),
				com.tactusoft.webservice.client.objects.Kna1.class, false,
				false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZiKnb1"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Knb1"),
				com.tactusoft.webservice.client.objects.Knb1.class, false,
				false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZiKnb1Reference"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZiKnvv"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Knvv"),
				com.tactusoft.webservice.client.objects.Knvv.class, false,
				false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZiMaintainAddressByKna1"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZiNoBankMasterUpdate"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZiRaiseNoBte"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZpiAddOnData"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"CustAddOnData"),
				com.tactusoft.webservice.client.objects.CustAddOnData.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZpiCamChanged"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZpiPostflag"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtUpdTxt"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFkuntxt"),
				com.tactusoft.webservice.client.objects.Fkuntxt[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtXknas"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknas"),
				com.tactusoft.webservice.client.objects.Fknas[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtXknb5"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknb5"),
				com.tactusoft.webservice.client.objects.Fknb5[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtXknbk"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknbk"),
				com.tactusoft.webservice.client.objects.Fknbk[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtXknex"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknex"),
				com.tactusoft.webservice.client.objects.Fknex[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtXknva"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknva"),
				com.tactusoft.webservice.client.objects.Fknva[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtXknvd"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknvd"),
				com.tactusoft.webservice.client.objects.Fknvd[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtXknvi"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknvi"),
				com.tactusoft.webservice.client.objects.Fknvi[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtXknvk"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknvk"),
				com.tactusoft.webservice.client.objects.Fknvk[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtXknvl"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknvl"),
				com.tactusoft.webservice.client.objects.Fknvl[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtXknvp"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknvp"),
				com.tactusoft.webservice.client.objects.Fknvp[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtXknza"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknza"),
				com.tactusoft.webservice.client.objects.Fknza[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtYknas"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknas"),
				com.tactusoft.webservice.client.objects.Fknas[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtYknb5"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknb5"),
				com.tactusoft.webservice.client.objects.Fknb5[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtYknbk"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknbk"),
				com.tactusoft.webservice.client.objects.Fknbk[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtYknex"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknex"),
				com.tactusoft.webservice.client.objects.Fknex[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtYknva"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknva"),
				com.tactusoft.webservice.client.objects.Fknva[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtYknvd"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknvd"),
				com.tactusoft.webservice.client.objects.Fknvd[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtYknvi"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknvi"),
				com.tactusoft.webservice.client.objects.Fknvi[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtYknvk"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknvk"),
				com.tactusoft.webservice.client.objects.Fknvk[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtYknvl"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknvl"),
				com.tactusoft.webservice.client.objects.Fknvl[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtYknvp"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknvp"),
				com.tactusoft.webservice.client.objects.Fknvp[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZtYknza"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfFknza"),
				com.tactusoft.webservice.client.objects.Fknza[].class, false,
				false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZeKunnr"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "ZoKna1"),
				org.apache.axis.description.ParameterDesc.OUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Kna1"),
				com.tactusoft.webservice.client.objects.Kna1.class, false,
				false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[0] = oper;

	}

	public ZSD_CUSTOMER_MAINTAIN_ALL_BindingStub()
			throws org.apache.axis.AxisFault {
		this(null);
	}

	public ZSD_CUSTOMER_MAINTAIN_ALL_BindingStub(java.net.URL endpointURL,
			javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
		this(service);
		super.cachedEndpoint = endpointURL;
	}

	public ZSD_CUSTOMER_MAINTAIN_ALL_BindingStub(javax.xml.rpc.Service service)
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
				"urn:sap-com:document:sap:rfc:functions", "char7");
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
				"urn:sap-com:document:sap:rfc:functions", "char80");
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
				"urn:sap-com:document:sap:rfc:functions", "curr13.2");
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
				"urn:sap-com:document:sap:rfc:functions", "decimal1.0");
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
				"urn:sap-com:document:sap:rfc:functions", "decimal11.0");
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
				"urn:sap-com:document:sap:rfc:functions", "decimal3.0");
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
				"urn:sap-com:document:sap:rfc:functions", "decimal3.1");
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
				"urn:sap-com:document:sap:rfc:functions", "decimal3.2");
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
				"urn:sap-com:document:sap:rfc:functions", "numeric8");
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
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiaddr1");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapiaddr1.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiaddr2");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapiaddr2.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"CustAddOnData");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.CustAddOnData.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknas");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknas.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknb5");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknb5.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknbk");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknbk.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknex");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknex.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknva");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknva.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknvd");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknvd.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknvi");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknvi.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknvk");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknvk.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknvl");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknvl.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknvp");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknvp.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknza");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknza.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fkuntxt");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fkuntxt.class;
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
				"urn:sap-com:document:sap:soap:functions:mc-style", "Knb1");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Knb1.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Knvv");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Knvv.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfFknas");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknas[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknas");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfFknb5");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknb5[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknb5");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfFknbk");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknbk[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknbk");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfFknex");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknex[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknex");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfFknva");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknva[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknva");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfFknvd");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknvd[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknvd");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfFknvi");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknvi[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknvi");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfFknvk");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknvk[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknvk");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfFknvl");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknvl[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknvl");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfFknvp");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknvp[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknvp");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfFknza");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fknza[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fknza");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfFkuntxt");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Fkuntxt[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Fkuntxt");
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

	public void zsdCustomerMaintainAll(
			com.tactusoft.webservice.client.objects.Bapiaddr1 ziBapiaddr1,
			com.tactusoft.webservice.client.objects.Bapiaddr2 ziBapiaddr2,
			java.lang.String ziCustomerIsConsumer,
			java.lang.String ziForceExternalNumberRange,
			java.lang.String ziFromCustomermaster,
			com.tactusoft.webservice.client.objects.Kna1 ziKna1,
			com.tactusoft.webservice.client.objects.Knb1 ziKnb1,
			java.lang.String ziKnb1Reference,
			com.tactusoft.webservice.client.objects.Knvv ziKnvv,
			java.lang.String ziMaintainAddressByKna1,
			java.lang.String ziNoBankMasterUpdate,
			java.lang.String ziRaiseNoBte,
			com.tactusoft.webservice.client.objects.CustAddOnData zpiAddOnData,
			java.lang.String zpiCamChanged,
			java.lang.String zpiPostflag,
			com.tactusoft.webservice.client.holders.TableOfFkuntxtHolder ztUpdTxt,
			com.tactusoft.webservice.client.holders.TableOfFknasHolder ztXknas,
			com.tactusoft.webservice.client.holders.TableOfFknb5Holder ztXknb5,
			com.tactusoft.webservice.client.holders.TableOfFknbkHolder ztXknbk,
			com.tactusoft.webservice.client.holders.TableOfFknexHolder ztXknex,
			com.tactusoft.webservice.client.holders.TableOfFknvaHolder ztXknva,
			com.tactusoft.webservice.client.holders.TableOfFknvdHolder ztXknvd,
			com.tactusoft.webservice.client.holders.TableOfFknviHolder ztXknvi,
			com.tactusoft.webservice.client.holders.TableOfFknvkHolder ztXknvk,
			com.tactusoft.webservice.client.holders.TableOfFknvlHolder ztXknvl,
			com.tactusoft.webservice.client.holders.TableOfFknvpHolder ztXknvp,
			com.tactusoft.webservice.client.holders.TableOfFknzaHolder ztXknza,
			com.tactusoft.webservice.client.holders.TableOfFknasHolder ztYknas,
			com.tactusoft.webservice.client.holders.TableOfFknb5Holder ztYknb5,
			com.tactusoft.webservice.client.holders.TableOfFknbkHolder ztYknbk,
			com.tactusoft.webservice.client.holders.TableOfFknexHolder ztYknex,
			com.tactusoft.webservice.client.holders.TableOfFknvaHolder ztYknva,
			com.tactusoft.webservice.client.holders.TableOfFknvdHolder ztYknvd,
			com.tactusoft.webservice.client.holders.TableOfFknviHolder ztYknvi,
			com.tactusoft.webservice.client.holders.TableOfFknvkHolder ztYknvk,
			com.tactusoft.webservice.client.holders.TableOfFknvlHolder ztYknvl,
			com.tactusoft.webservice.client.holders.TableOfFknvpHolder ztYknvp,
			com.tactusoft.webservice.client.holders.TableOfFknzaHolder ztYknza,
			javax.xml.rpc.holders.StringHolder zeKunnr,
			com.tactusoft.webservice.client.holders.Kna1Holder zoKna1)
			throws java.rmi.RemoteException {
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
				"ZsdCustomerMaintainAll"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					ziBapiaddr1, ziBapiaddr2, ziCustomerIsConsumer,
					ziForceExternalNumberRange, ziFromCustomermaster, ziKna1,
					ziKnb1, ziKnb1Reference, ziKnvv, ziMaintainAddressByKna1,
					ziNoBankMasterUpdate, ziRaiseNoBte, zpiAddOnData,
					zpiCamChanged, zpiPostflag, ztUpdTxt.value, ztXknas.value,
					ztXknb5.value, ztXknbk.value, ztXknex.value, ztXknva.value,
					ztXknvd.value, ztXknvi.value, ztXknvk.value, ztXknvl.value,
					ztXknvp.value, ztXknza.value, ztYknas.value, ztYknb5.value,
					ztYknbk.value, ztYknex.value, ztYknva.value, ztYknvd.value,
					ztYknvi.value, ztYknvk.value, ztYknvl.value, ztYknvp.value,
					ztYknza.value });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					ztUpdTxt.value = (com.tactusoft.webservice.client.objects.Fkuntxt[]) _output
							.get(new javax.xml.namespace.QName("", "ZtUpdTxt"));
				} catch (java.lang.Exception _exception) {
					ztUpdTxt.value = (com.tactusoft.webservice.client.objects.Fkuntxt[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtUpdTxt")),
									com.tactusoft.webservice.client.objects.Fkuntxt[].class);
				}
				try {
					ztXknas.value = (com.tactusoft.webservice.client.objects.Fknas[]) _output
							.get(new javax.xml.namespace.QName("", "ZtXknas"));
				} catch (java.lang.Exception _exception) {
					ztXknas.value = (com.tactusoft.webservice.client.objects.Fknas[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtXknas")),
									com.tactusoft.webservice.client.objects.Fknas[].class);
				}
				try {
					ztXknb5.value = (com.tactusoft.webservice.client.objects.Fknb5[]) _output
							.get(new javax.xml.namespace.QName("", "ZtXknb5"));
				} catch (java.lang.Exception _exception) {
					ztXknb5.value = (com.tactusoft.webservice.client.objects.Fknb5[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtXknb5")),
									com.tactusoft.webservice.client.objects.Fknb5[].class);
				}
				try {
					ztXknbk.value = (com.tactusoft.webservice.client.objects.Fknbk[]) _output
							.get(new javax.xml.namespace.QName("", "ZtXknbk"));
				} catch (java.lang.Exception _exception) {
					ztXknbk.value = (com.tactusoft.webservice.client.objects.Fknbk[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtXknbk")),
									com.tactusoft.webservice.client.objects.Fknbk[].class);
				}
				try {
					ztXknex.value = (com.tactusoft.webservice.client.objects.Fknex[]) _output
							.get(new javax.xml.namespace.QName("", "ZtXknex"));
				} catch (java.lang.Exception _exception) {
					ztXknex.value = (com.tactusoft.webservice.client.objects.Fknex[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtXknex")),
									com.tactusoft.webservice.client.objects.Fknex[].class);
				}
				try {
					ztXknva.value = (com.tactusoft.webservice.client.objects.Fknva[]) _output
							.get(new javax.xml.namespace.QName("", "ZtXknva"));
				} catch (java.lang.Exception _exception) {
					ztXknva.value = (com.tactusoft.webservice.client.objects.Fknva[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtXknva")),
									com.tactusoft.webservice.client.objects.Fknva[].class);
				}
				try {
					ztXknvd.value = (com.tactusoft.webservice.client.objects.Fknvd[]) _output
							.get(new javax.xml.namespace.QName("", "ZtXknvd"));
				} catch (java.lang.Exception _exception) {
					ztXknvd.value = (com.tactusoft.webservice.client.objects.Fknvd[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtXknvd")),
									com.tactusoft.webservice.client.objects.Fknvd[].class);
				}
				try {
					ztXknvi.value = (com.tactusoft.webservice.client.objects.Fknvi[]) _output
							.get(new javax.xml.namespace.QName("", "ZtXknvi"));
				} catch (java.lang.Exception _exception) {
					ztXknvi.value = (com.tactusoft.webservice.client.objects.Fknvi[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtXknvi")),
									com.tactusoft.webservice.client.objects.Fknvi[].class);
				}
				try {
					ztXknvk.value = (com.tactusoft.webservice.client.objects.Fknvk[]) _output
							.get(new javax.xml.namespace.QName("", "ZtXknvk"));
				} catch (java.lang.Exception _exception) {
					ztXknvk.value = (com.tactusoft.webservice.client.objects.Fknvk[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtXknvk")),
									com.tactusoft.webservice.client.objects.Fknvk[].class);
				}
				try {
					ztXknvl.value = (com.tactusoft.webservice.client.objects.Fknvl[]) _output
							.get(new javax.xml.namespace.QName("", "ZtXknvl"));
				} catch (java.lang.Exception _exception) {
					ztXknvl.value = (com.tactusoft.webservice.client.objects.Fknvl[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtXknvl")),
									com.tactusoft.webservice.client.objects.Fknvl[].class);
				}
				try {
					ztXknvp.value = (com.tactusoft.webservice.client.objects.Fknvp[]) _output
							.get(new javax.xml.namespace.QName("", "ZtXknvp"));
				} catch (java.lang.Exception _exception) {
					ztXknvp.value = (com.tactusoft.webservice.client.objects.Fknvp[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtXknvp")),
									com.tactusoft.webservice.client.objects.Fknvp[].class);
				}
				try {
					ztXknza.value = (com.tactusoft.webservice.client.objects.Fknza[]) _output
							.get(new javax.xml.namespace.QName("", "ZtXknza"));
				} catch (java.lang.Exception _exception) {
					ztXknza.value = (com.tactusoft.webservice.client.objects.Fknza[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtXknza")),
									com.tactusoft.webservice.client.objects.Fknza[].class);
				}
				try {
					ztYknas.value = (com.tactusoft.webservice.client.objects.Fknas[]) _output
							.get(new javax.xml.namespace.QName("", "ZtYknas"));
				} catch (java.lang.Exception _exception) {
					ztYknas.value = (com.tactusoft.webservice.client.objects.Fknas[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtYknas")),
									com.tactusoft.webservice.client.objects.Fknas[].class);
				}
				try {
					ztYknb5.value = (com.tactusoft.webservice.client.objects.Fknb5[]) _output
							.get(new javax.xml.namespace.QName("", "ZtYknb5"));
				} catch (java.lang.Exception _exception) {
					ztYknb5.value = (com.tactusoft.webservice.client.objects.Fknb5[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtYknb5")),
									com.tactusoft.webservice.client.objects.Fknb5[].class);
				}
				try {
					ztYknbk.value = (com.tactusoft.webservice.client.objects.Fknbk[]) _output
							.get(new javax.xml.namespace.QName("", "ZtYknbk"));
				} catch (java.lang.Exception _exception) {
					ztYknbk.value = (com.tactusoft.webservice.client.objects.Fknbk[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtYknbk")),
									com.tactusoft.webservice.client.objects.Fknbk[].class);
				}
				try {
					ztYknex.value = (com.tactusoft.webservice.client.objects.Fknex[]) _output
							.get(new javax.xml.namespace.QName("", "ZtYknex"));
				} catch (java.lang.Exception _exception) {
					ztYknex.value = (com.tactusoft.webservice.client.objects.Fknex[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtYknex")),
									com.tactusoft.webservice.client.objects.Fknex[].class);
				}
				try {
					ztYknva.value = (com.tactusoft.webservice.client.objects.Fknva[]) _output
							.get(new javax.xml.namespace.QName("", "ZtYknva"));
				} catch (java.lang.Exception _exception) {
					ztYknva.value = (com.tactusoft.webservice.client.objects.Fknva[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtYknva")),
									com.tactusoft.webservice.client.objects.Fknva[].class);
				}
				try {
					ztYknvd.value = (com.tactusoft.webservice.client.objects.Fknvd[]) _output
							.get(new javax.xml.namespace.QName("", "ZtYknvd"));
				} catch (java.lang.Exception _exception) {
					ztYknvd.value = (com.tactusoft.webservice.client.objects.Fknvd[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtYknvd")),
									com.tactusoft.webservice.client.objects.Fknvd[].class);
				}
				try {
					ztYknvi.value = (com.tactusoft.webservice.client.objects.Fknvi[]) _output
							.get(new javax.xml.namespace.QName("", "ZtYknvi"));
				} catch (java.lang.Exception _exception) {
					ztYknvi.value = (com.tactusoft.webservice.client.objects.Fknvi[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtYknvi")),
									com.tactusoft.webservice.client.objects.Fknvi[].class);
				}
				try {
					ztYknvk.value = (com.tactusoft.webservice.client.objects.Fknvk[]) _output
							.get(new javax.xml.namespace.QName("", "ZtYknvk"));
				} catch (java.lang.Exception _exception) {
					ztYknvk.value = (com.tactusoft.webservice.client.objects.Fknvk[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtYknvk")),
									com.tactusoft.webservice.client.objects.Fknvk[].class);
				}
				try {
					ztYknvl.value = (com.tactusoft.webservice.client.objects.Fknvl[]) _output
							.get(new javax.xml.namespace.QName("", "ZtYknvl"));
				} catch (java.lang.Exception _exception) {
					ztYknvl.value = (com.tactusoft.webservice.client.objects.Fknvl[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtYknvl")),
									com.tactusoft.webservice.client.objects.Fknvl[].class);
				}
				try {
					ztYknvp.value = (com.tactusoft.webservice.client.objects.Fknvp[]) _output
							.get(new javax.xml.namespace.QName("", "ZtYknvp"));
				} catch (java.lang.Exception _exception) {
					ztYknvp.value = (com.tactusoft.webservice.client.objects.Fknvp[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtYknvp")),
									com.tactusoft.webservice.client.objects.Fknvp[].class);
				}
				try {
					ztYknza.value = (com.tactusoft.webservice.client.objects.Fknza[]) _output
							.get(new javax.xml.namespace.QName("", "ZtYknza"));
				} catch (java.lang.Exception _exception) {
					ztYknza.value = (com.tactusoft.webservice.client.objects.Fknza[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZtYknza")),
									com.tactusoft.webservice.client.objects.Fknza[].class);
				}
				try {
					zeKunnr.value = (java.lang.String) _output
							.get(new javax.xml.namespace.QName("", "ZeKunnr"));
				} catch (java.lang.Exception _exception) {
					zeKunnr.value = (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_output.get(new javax.xml.namespace.QName(
									"", "ZeKunnr")), java.lang.String.class);
				}
				try {
					zoKna1.value = (com.tactusoft.webservice.client.objects.Kna1) _output
							.get(new javax.xml.namespace.QName("", "ZoKna1"));
				} catch (java.lang.Exception _exception) {
					zoKna1.value = (com.tactusoft.webservice.client.objects.Kna1) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "ZoKna1")),
									com.tactusoft.webservice.client.objects.Kna1.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

}
