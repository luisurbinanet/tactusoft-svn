/**
 * ZBAPI_SALESORDER_CREATEFROMDATStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.locators;

@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class ZBAPI_SALESORDER_CREATEFROMDAT_BindingStub extends
		org.apache.axis.client.Stub
		implements
		com.tactusoft.webservice.client.locators.ZBAPI_SALESORDER_CREATEFROMDAT_PortType {
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
		oper.setName("ZbapiSalesorderCreatefromdat");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "BehaveWhenError"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "BinaryRelationshiptype"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char4"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Convert"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Extensionin"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapiparex"),
				com.tactusoft.webservice.client.objects.Bapiparex[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "IntNumberAssignment"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "LogicSwitch"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapisdls"),
				com.tactusoft.webservice.client.objects.Bapisdls.class, false,
				false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderCcard"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapiccard"),
				com.tactusoft.webservice.client.objects.Bapiccard[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderCfgsBlob"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapicublb"),
				com.tactusoft.webservice.client.objects.Bapicublb[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderCfgsInst"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapicuins"),
				com.tactusoft.webservice.client.objects.Bapicuins[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderCfgsPartOf"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapicuprt"),
				com.tactusoft.webservice.client.objects.Bapicuprt[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderCfgsRef"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapicucfg"),
				com.tactusoft.webservice.client.objects.Bapicucfg[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderCfgsRefinst"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapicuref"),
				com.tactusoft.webservice.client.objects.Bapicuref[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderCfgsValue"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapicuval"),
				com.tactusoft.webservice.client.objects.Bapicuval[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderCfgsVk"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapicuvk"),
				com.tactusoft.webservice.client.objects.Bapicuvk[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderConditionsIn"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapicond"),
				com.tactusoft.webservice.client.objects.Bapicond[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderConditionsInx"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapicondx"),
				com.tactusoft.webservice.client.objects.Bapicondx[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderHeaderIn"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapisdhd1"),
				com.tactusoft.webservice.client.objects.Bapisdhd1.class, false,
				false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderHeaderInx"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Bapisdhd1x"),
				com.tactusoft.webservice.client.objects.Bapisdhd1X.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderItemsIn"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapisditm"),
				com.tactusoft.webservice.client.objects.Bapisditm[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderItemsInx"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapisditmx"),
				com.tactusoft.webservice.client.objects.Bapisditmx[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderKeys"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapisdkey"),
				com.tactusoft.webservice.client.objects.Bapisdkey[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderPartners"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapiparnr"),
				com.tactusoft.webservice.client.objects.Bapiparnr[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderSchedulesIn"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapischdl"),
				com.tactusoft.webservice.client.objects.Bapischdl[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderSchedulesInx"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapischdlx"),
				com.tactusoft.webservice.client.objects.Bapischdlx[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "OrderText"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapisdtext"),
				com.tactusoft.webservice.client.objects.Bapisdtext[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Partneraddresses"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapiaddr1"),
				com.tactusoft.webservice.client.objects.Bapiaddr1[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Return"),
				org.apache.axis.description.ParameterDesc.INOUT,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"TableOfBapiret2"),
				com.tactusoft.webservice.client.objects.Bapiret2[].class,
				false, false);
		param.setItemQName(new javax.xml.namespace.QName("", "item"));
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Salesdocumentin"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char10"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Sender"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:soap:functions:mc-style",
						"Sender"),
				com.tactusoft.webservice.client.objects.Sender.class, false,
				false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "Testrun"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"urn:sap-com:document:sap:rfc:functions", "char1"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:rfc:functions", "char10"));
		oper.setReturnClass(java.lang.String.class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "Salesdocument"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[0] = oper;

	}

	public ZBAPI_SALESORDER_CREATEFROMDAT_BindingStub()
			throws org.apache.axis.AxisFault {
		this(null);
	}

	public ZBAPI_SALESORDER_CREATEFROMDAT_BindingStub(java.net.URL endpointURL,
			javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
		this(service);
		super.cachedEndpoint = endpointURL;
	}

	public ZBAPI_SALESORDER_CREATEFROMDAT_BindingStub(
			javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
				"urn:sap-com:document:sap:rfc:functions", "byte16");
		cachedSerQNames.add(qName);
		cls = byte[].class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(arraysf);
		cachedDeserFactories.add(arraydf);

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
				"urn:sap-com:document:sap:rfc:functions", "char22");
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
				"urn:sap-com:document:sap:rfc:functions", "char24");
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
				"urn:sap-com:document:sap:rfc:functions", "char240");
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
				"urn:sap-com:document:sap:rfc:functions", "char250");
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
				"urn:sap-com:document:sap:rfc:functions", "char26");
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
				"urn:sap-com:document:sap:rfc:functions", "char70");
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
				"urn:sap-com:document:sap:rfc:functions", "decimal28.9");
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
				"urn:sap-com:document:sap:rfc:functions", "decimal5.0");
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
				"urn:sap-com:document:sap:rfc:functions", "decimal5.2");
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
				"urn:sap-com:document:sap:rfc:functions", "decimal9.5");
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
				"urn:sap-com:document:sap:rfc:functions", "quantum15.3");
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
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiccard");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapiccard.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicond");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicond.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicondx");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicondx.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicublb");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicublb.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicucfg");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicucfg.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicuins");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicuins.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicuprt");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicuprt.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicuref");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicuref.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicuval");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicuval.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicuvk");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicuvk.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiparex");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapiparex.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiparnr");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapiparnr.class;
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
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapischdl");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapischdl.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapischdlx");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapischdlx.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapisdhd1");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapisdhd1.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapisdhd1x");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapisdhd1X.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapisditm");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapisditm.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapisditmx");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapisditmx.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapisdkey");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapisdkey.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapisdls");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapisdls.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapisdtext");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapisdtext.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Sender");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Sender.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapiaddr1");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapiaddr1[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiaddr1");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapiccard");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapiccard[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiccard");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapicond");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicond[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicond");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapicondx");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicondx[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicondx");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapicublb");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicublb[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicublb");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapicucfg");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicucfg[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicucfg");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapicuins");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicuins[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicuins");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapicuprt");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicuprt[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicuprt");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapicuref");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicuref[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicuref");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapicuval");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicuval[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicuval");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapicuvk");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapicuvk[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapicuvk");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapiparex");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapiparex[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiparex");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapiparnr");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapiparnr[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapiparnr");
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
				"TableOfBapischdl");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapischdl[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapischdl");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapischdlx");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapischdlx[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapischdlx");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapisditm");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapisditm[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapisditm");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapisditmx");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapisditmx[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapisditmx");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapisdkey");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapisdkey[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style", "Bapisdkey");
		qName2 = new javax.xml.namespace.QName("", "item");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"TableOfBapisdtext");
		cachedSerQNames.add(qName);
		cls = com.tactusoft.webservice.client.objects.Bapisdtext[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"urn:sap-com:document:sap:soap:functions:mc-style",
				"Bapisdtext");
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

	public java.lang.String zbapiSalesorderCreatefromdat(
			java.lang.String behaveWhenError,
			java.lang.String binaryRelationshiptype,
			java.lang.String convert,
			com.tactusoft.webservice.client.holders.TableOfBapiparexHolder extensionin,
			java.lang.String intNumberAssignment,
			com.tactusoft.webservice.client.objects.Bapisdls logicSwitch,
			com.tactusoft.webservice.client.holders.TableOfBapiccardHolder orderCcard,
			com.tactusoft.webservice.client.holders.TableOfBapicublbHolder orderCfgsBlob,
			com.tactusoft.webservice.client.holders.TableOfBapicuinsHolder orderCfgsInst,
			com.tactusoft.webservice.client.holders.TableOfBapicuprtHolder orderCfgsPartOf,
			com.tactusoft.webservice.client.holders.TableOfBapicucfgHolder orderCfgsRef,
			com.tactusoft.webservice.client.holders.TableOfBapicurefHolder orderCfgsRefinst,
			com.tactusoft.webservice.client.holders.TableOfBapicuvalHolder orderCfgsValue,
			com.tactusoft.webservice.client.holders.TableOfBapicuvkHolder orderCfgsVk,
			com.tactusoft.webservice.client.holders.TableOfBapicondHolder orderConditionsIn,
			com.tactusoft.webservice.client.holders.TableOfBapicondxHolder orderConditionsInx,
			com.tactusoft.webservice.client.objects.Bapisdhd1 orderHeaderIn,
			com.tactusoft.webservice.client.objects.Bapisdhd1X orderHeaderInx,
			com.tactusoft.webservice.client.holders.TableOfBapisditmHolder orderItemsIn,
			com.tactusoft.webservice.client.holders.TableOfBapisditmxHolder orderItemsInx,
			com.tactusoft.webservice.client.holders.TableOfBapisdkeyHolder orderKeys,
			com.tactusoft.webservice.client.holders.TableOfBapiparnrHolder orderPartners,
			com.tactusoft.webservice.client.holders.TableOfBapischdlHolder orderSchedulesIn,
			com.tactusoft.webservice.client.holders.TableOfBapischdlxHolder orderSchedulesInx,
			com.tactusoft.webservice.client.holders.TableOfBapisdtextHolder orderText,
			com.tactusoft.webservice.client.holders.TableOfBapiaddr1Holder partneraddresses,
			com.tactusoft.webservice.client.holders.TableOfBapiret2Holder _return,
			java.lang.String salesdocumentin,
			com.tactusoft.webservice.client.objects.Sender sender,
			java.lang.String testrun) throws java.rmi.RemoteException {
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
				"ZbapiSalesorderCreatefromdat"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					behaveWhenError, binaryRelationshiptype, convert,
					extensionin.value, intNumberAssignment, logicSwitch,
					orderCcard.value, orderCfgsBlob.value, orderCfgsInst.value,
					orderCfgsPartOf.value, orderCfgsRef.value,
					orderCfgsRefinst.value, orderCfgsValue.value,
					orderCfgsVk.value, orderConditionsIn.value,
					orderConditionsInx.value, orderHeaderIn, orderHeaderInx,
					orderItemsIn.value, orderItemsInx.value, orderKeys.value,
					orderPartners.value, orderSchedulesIn.value,
					orderSchedulesInx.value, orderText.value,
					partneraddresses.value, _return.value, salesdocumentin,
					sender, testrun });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				java.util.Map _output;
				_output = _call.getOutputParams();
				try {
					extensionin.value = (com.tactusoft.webservice.client.objects.Bapiparex[]) _output
							.get(new javax.xml.namespace.QName("",
									"Extensionin"));
				} catch (java.lang.Exception _exception) {
					extensionin.value = (com.tactusoft.webservice.client.objects.Bapiparex[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Extensionin")),
									com.tactusoft.webservice.client.objects.Bapiparex[].class);
				}
				try {
					orderCcard.value = (com.tactusoft.webservice.client.objects.Bapiccard[]) _output
							.get(new javax.xml.namespace.QName("", "OrderCcard"));
				} catch (java.lang.Exception _exception) {
					orderCcard.value = (com.tactusoft.webservice.client.objects.Bapiccard[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OrderCcard")),
									com.tactusoft.webservice.client.objects.Bapiccard[].class);
				}
				try {
					orderCfgsBlob.value = (com.tactusoft.webservice.client.objects.Bapicublb[]) _output
							.get(new javax.xml.namespace.QName("",
									"OrderCfgsBlob"));
				} catch (java.lang.Exception _exception) {
					orderCfgsBlob.value = (com.tactusoft.webservice.client.objects.Bapicublb[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OrderCfgsBlob")),
									com.tactusoft.webservice.client.objects.Bapicublb[].class);
				}
				try {
					orderCfgsInst.value = (com.tactusoft.webservice.client.objects.Bapicuins[]) _output
							.get(new javax.xml.namespace.QName("",
									"OrderCfgsInst"));
				} catch (java.lang.Exception _exception) {
					orderCfgsInst.value = (com.tactusoft.webservice.client.objects.Bapicuins[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OrderCfgsInst")),
									com.tactusoft.webservice.client.objects.Bapicuins[].class);
				}
				try {
					orderCfgsPartOf.value = (com.tactusoft.webservice.client.objects.Bapicuprt[]) _output
							.get(new javax.xml.namespace.QName("",
									"OrderCfgsPartOf"));
				} catch (java.lang.Exception _exception) {
					orderCfgsPartOf.value = (com.tactusoft.webservice.client.objects.Bapicuprt[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OrderCfgsPartOf")),
									com.tactusoft.webservice.client.objects.Bapicuprt[].class);
				}
				try {
					orderCfgsRef.value = (com.tactusoft.webservice.client.objects.Bapicucfg[]) _output
							.get(new javax.xml.namespace.QName("",
									"OrderCfgsRef"));
				} catch (java.lang.Exception _exception) {
					orderCfgsRef.value = (com.tactusoft.webservice.client.objects.Bapicucfg[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OrderCfgsRef")),
									com.tactusoft.webservice.client.objects.Bapicucfg[].class);
				}
				try {
					orderCfgsRefinst.value = (com.tactusoft.webservice.client.objects.Bapicuref[]) _output
							.get(new javax.xml.namespace.QName("",
									"OrderCfgsRefinst"));
				} catch (java.lang.Exception _exception) {
					orderCfgsRefinst.value = (com.tactusoft.webservice.client.objects.Bapicuref[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OrderCfgsRefinst")),
									com.tactusoft.webservice.client.objects.Bapicuref[].class);
				}
				try {
					orderCfgsValue.value = (com.tactusoft.webservice.client.objects.Bapicuval[]) _output
							.get(new javax.xml.namespace.QName("",
									"OrderCfgsValue"));
				} catch (java.lang.Exception _exception) {
					orderCfgsValue.value = (com.tactusoft.webservice.client.objects.Bapicuval[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OrderCfgsValue")),
									com.tactusoft.webservice.client.objects.Bapicuval[].class);
				}
				try {
					orderCfgsVk.value = (com.tactusoft.webservice.client.objects.Bapicuvk[]) _output
							.get(new javax.xml.namespace.QName("",
									"OrderCfgsVk"));
				} catch (java.lang.Exception _exception) {
					orderCfgsVk.value = (com.tactusoft.webservice.client.objects.Bapicuvk[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OrderCfgsVk")),
									com.tactusoft.webservice.client.objects.Bapicuvk[].class);
				}
				try {
					orderConditionsIn.value = (com.tactusoft.webservice.client.objects.Bapicond[]) _output
							.get(new javax.xml.namespace.QName("",
									"OrderConditionsIn"));
				} catch (java.lang.Exception _exception) {
					orderConditionsIn.value = (com.tactusoft.webservice.client.objects.Bapicond[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OrderConditionsIn")),
									com.tactusoft.webservice.client.objects.Bapicond[].class);
				}
				try {
					orderConditionsInx.value = (com.tactusoft.webservice.client.objects.Bapicondx[]) _output
							.get(new javax.xml.namespace.QName("",
									"OrderConditionsInx"));
				} catch (java.lang.Exception _exception) {
					orderConditionsInx.value = (com.tactusoft.webservice.client.objects.Bapicondx[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OrderConditionsInx")),
									com.tactusoft.webservice.client.objects.Bapicondx[].class);
				}
				try {
					orderItemsIn.value = (com.tactusoft.webservice.client.objects.Bapisditm[]) _output
							.get(new javax.xml.namespace.QName("",
									"OrderItemsIn"));
				} catch (java.lang.Exception _exception) {
					orderItemsIn.value = (com.tactusoft.webservice.client.objects.Bapisditm[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OrderItemsIn")),
									com.tactusoft.webservice.client.objects.Bapisditm[].class);
				}
				try {
					orderItemsInx.value = (com.tactusoft.webservice.client.objects.Bapisditmx[]) _output
							.get(new javax.xml.namespace.QName("",
									"OrderItemsInx"));
				} catch (java.lang.Exception _exception) {
					orderItemsInx.value = (com.tactusoft.webservice.client.objects.Bapisditmx[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OrderItemsInx")),
									com.tactusoft.webservice.client.objects.Bapisditmx[].class);
				}
				try {
					orderKeys.value = (com.tactusoft.webservice.client.objects.Bapisdkey[]) _output
							.get(new javax.xml.namespace.QName("", "OrderKeys"));
				} catch (java.lang.Exception _exception) {
					orderKeys.value = (com.tactusoft.webservice.client.objects.Bapisdkey[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OrderKeys")),
									com.tactusoft.webservice.client.objects.Bapisdkey[].class);
				}
				try {
					orderPartners.value = (com.tactusoft.webservice.client.objects.Bapiparnr[]) _output
							.get(new javax.xml.namespace.QName("",
									"OrderPartners"));
				} catch (java.lang.Exception _exception) {
					orderPartners.value = (com.tactusoft.webservice.client.objects.Bapiparnr[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OrderPartners")),
									com.tactusoft.webservice.client.objects.Bapiparnr[].class);
				}
				try {
					orderSchedulesIn.value = (com.tactusoft.webservice.client.objects.Bapischdl[]) _output
							.get(new javax.xml.namespace.QName("",
									"OrderSchedulesIn"));
				} catch (java.lang.Exception _exception) {
					orderSchedulesIn.value = (com.tactusoft.webservice.client.objects.Bapischdl[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OrderSchedulesIn")),
									com.tactusoft.webservice.client.objects.Bapischdl[].class);
				}
				try {
					orderSchedulesInx.value = (com.tactusoft.webservice.client.objects.Bapischdlx[]) _output
							.get(new javax.xml.namespace.QName("",
									"OrderSchedulesInx"));
				} catch (java.lang.Exception _exception) {
					orderSchedulesInx.value = (com.tactusoft.webservice.client.objects.Bapischdlx[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OrderSchedulesInx")),
									com.tactusoft.webservice.client.objects.Bapischdlx[].class);
				}
				try {
					orderText.value = (com.tactusoft.webservice.client.objects.Bapisdtext[]) _output
							.get(new javax.xml.namespace.QName("", "OrderText"));
				} catch (java.lang.Exception _exception) {
					orderText.value = (com.tactusoft.webservice.client.objects.Bapisdtext[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "OrderText")),
									com.tactusoft.webservice.client.objects.Bapisdtext[].class);
				}
				try {
					partneraddresses.value = (com.tactusoft.webservice.client.objects.Bapiaddr1[]) _output
							.get(new javax.xml.namespace.QName("",
									"Partneraddresses"));
				} catch (java.lang.Exception _exception) {
					partneraddresses.value = (com.tactusoft.webservice.client.objects.Bapiaddr1[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Partneraddresses")),
									com.tactusoft.webservice.client.objects.Bapiaddr1[].class);
				}
				try {
					_return.value = (com.tactusoft.webservice.client.objects.Bapiret2[]) _output
							.get(new javax.xml.namespace.QName("", "Return"));
				} catch (java.lang.Exception _exception) {
					_return.value = (com.tactusoft.webservice.client.objects.Bapiret2[]) org.apache.axis.utils.JavaUtils
							.convert(
									_output.get(new javax.xml.namespace.QName(
											"", "Return")),
									com.tactusoft.webservice.client.objects.Bapiret2[].class);
				}
				try {
					return (java.lang.String) _resp;
				} catch (java.lang.Exception _exception) {
					return (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_resp, java.lang.String.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

}
