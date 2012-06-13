/**
 * Zweblistline.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

package mc_style.functions.soap.sap.document.sap_com;

/**
 * Zweblistline bean class
 */
@SuppressWarnings({ "unchecked", "unused" })
public class Zweblistline implements org.apache.axis2.databinding.ADBBean {
	/*
	 * This type was generated from the piece of schema that had name =
	 * Zweblistline Namespace URI =
	 * urn:sap-com:document:sap:soap:functions:mc-style Namespace Prefix = ns2
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * field for Text1
	 */

	protected functions.rfc.sap.document.sap_com.Char132 localText1;

	/**
	 * Auto generated getter method
	 * 
	 * @return functions.rfc.sap.document.sap_com.Char132
	 */
	public functions.rfc.sap.document.sap_com.Char132 getText1() {
		return localText1;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            Text1
	 */
	public void setText1(functions.rfc.sap.document.sap_com.Char132 param) {

		this.localText1 = param;

	}

	/**
	 * field for Text2
	 */

	protected functions.rfc.sap.document.sap_com.Char132 localText2;

	/**
	 * Auto generated getter method
	 * 
	 * @return functions.rfc.sap.document.sap_com.Char132
	 */
	public functions.rfc.sap.document.sap_com.Char132 getText2() {
		return localText2;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            Text2
	 */
	public void setText2(functions.rfc.sap.document.sap_com.Char132 param) {

		this.localText2 = param;

	}

	/**
	 * field for Text3
	 */

	protected functions.rfc.sap.document.sap_com.Char132 localText3;

	/**
	 * Auto generated getter method
	 * 
	 * @return functions.rfc.sap.document.sap_com.Char132
	 */
	public functions.rfc.sap.document.sap_com.Char132 getText3() {
		return localText3;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            Text3
	 */
	public void setText3(functions.rfc.sap.document.sap_com.Char132 param) {

		this.localText3 = param;

	}

	/**
	 * field for Text4
	 */

	protected functions.rfc.sap.document.sap_com.Char132 localText4;

	/**
	 * Auto generated getter method
	 * 
	 * @return functions.rfc.sap.document.sap_com.Char132
	 */
	public functions.rfc.sap.document.sap_com.Char132 getText4() {
		return localText4;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            Text4
	 */
	public void setText4(functions.rfc.sap.document.sap_com.Char132 param) {

		this.localText4 = param;

	}

	/**
	 * field for Text5
	 */

	protected functions.rfc.sap.document.sap_com.Char132 localText5;

	/**
	 * Auto generated getter method
	 * 
	 * @return functions.rfc.sap.document.sap_com.Char132
	 */
	public functions.rfc.sap.document.sap_com.Char132 getText5() {
		return localText5;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            Text5
	 */
	public void setText5(functions.rfc.sap.document.sap_com.Char132 param) {

		this.localText5 = param;

	}

	/**
	 * 
	 * @param parentQName
	 * @param factory
	 * @return org.apache.axiom.om.OMElement
	 */
	public org.apache.axiom.om.OMElement getOMElement(
			final javax.xml.namespace.QName parentQName,
			final org.apache.axiom.om.OMFactory factory)
			throws org.apache.axis2.databinding.ADBException {

		org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
				this, parentQName);
		return factory.createOMElement(dataSource, parentQName);

	}

	public void serialize(final javax.xml.namespace.QName parentQName,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException,
			org.apache.axis2.databinding.ADBException {
		serialize(parentQName, xmlWriter, false);
	}

	public void serialize(final javax.xml.namespace.QName parentQName,
			javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
			throws javax.xml.stream.XMLStreamException,
			org.apache.axis2.databinding.ADBException {

		java.lang.String prefix = null;
		java.lang.String namespace = null;

		prefix = parentQName.getPrefix();
		namespace = parentQName.getNamespaceURI();
		writeStartElement(prefix, namespace, parentQName.getLocalPart(),
				xmlWriter);

		if (serializeType) {

			java.lang.String namespacePrefix = registerPrefix(xmlWriter,
					"urn:sap-com:document:sap:soap:functions:mc-style");
			if ((namespacePrefix != null)
					&& (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						namespacePrefix + ":Zweblistline", xmlWriter);
			} else {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						"Zweblistline", xmlWriter);
			}

		}

		if (localText1 == null) {
			throw new org.apache.axis2.databinding.ADBException(
					"Text1 cannot be null!!");
		}
		localText1.serialize(new javax.xml.namespace.QName("", "Text1"),
				xmlWriter);

		if (localText2 == null) {
			throw new org.apache.axis2.databinding.ADBException(
					"Text2 cannot be null!!");
		}
		localText2.serialize(new javax.xml.namespace.QName("", "Text2"),
				xmlWriter);

		if (localText3 == null) {
			throw new org.apache.axis2.databinding.ADBException(
					"Text3 cannot be null!!");
		}
		localText3.serialize(new javax.xml.namespace.QName("", "Text3"),
				xmlWriter);

		if (localText4 == null) {
			throw new org.apache.axis2.databinding.ADBException(
					"Text4 cannot be null!!");
		}
		localText4.serialize(new javax.xml.namespace.QName("", "Text4"),
				xmlWriter);

		if (localText5 == null) {
			throw new org.apache.axis2.databinding.ADBException(
					"Text5 cannot be null!!");
		}
		localText5.serialize(new javax.xml.namespace.QName("", "Text5"),
				xmlWriter);

		xmlWriter.writeEndElement();

	}

	private static java.lang.String generatePrefix(java.lang.String namespace) {
		if (namespace
				.equals("urn:sap-com:document:sap:soap:functions:mc-style")) {
			return "ns2";
		}
		return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
	}

	/**
	 * Utility method to write an element start tag.
	 */
	private void writeStartElement(java.lang.String prefix,
			java.lang.String namespace, java.lang.String localPart,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {
		java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
		if (writerPrefix != null) {
			xmlWriter.writeStartElement(namespace, localPart);
		} else {
			if (namespace.length() == 0) {
				prefix = "";
			} else if (prefix == null) {
				prefix = generatePrefix(namespace);
			}

			xmlWriter.writeStartElement(prefix, localPart, namespace);
			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);
		}
	}

	/**
	 * Util method to write an attribute with the ns prefix
	 */
	private void writeAttribute(java.lang.String prefix,
			java.lang.String namespace, java.lang.String attName,
			java.lang.String attValue,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {
		if (xmlWriter.getPrefix(namespace) == null) {
			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);
		}
		xmlWriter.writeAttribute(namespace, attName, attValue);
	}

	/**
	 * Util method to write an attribute without the ns prefix
	 */
	private void writeAttribute(java.lang.String namespace,
			java.lang.String attName, java.lang.String attValue,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {
		if (namespace.equals("")) {
			xmlWriter.writeAttribute(attName, attValue);
		} else {
			registerPrefix(xmlWriter, namespace);
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}
	}

	/**
	 * Util method to write an attribute without the ns prefix
	 */
	private void writeQNameAttribute(java.lang.String namespace,
			java.lang.String attName, javax.xml.namespace.QName qname,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {

		java.lang.String attributeNamespace = qname.getNamespaceURI();
		java.lang.String attributePrefix = xmlWriter
				.getPrefix(attributeNamespace);
		if (attributePrefix == null) {
			attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
		}
		java.lang.String attributeValue;
		if (attributePrefix.trim().length() > 0) {
			attributeValue = attributePrefix + ":" + qname.getLocalPart();
		} else {
			attributeValue = qname.getLocalPart();
		}

		if (namespace.equals("")) {
			xmlWriter.writeAttribute(attName, attributeValue);
		} else {
			registerPrefix(xmlWriter, namespace);
			xmlWriter.writeAttribute(namespace, attName, attributeValue);
		}
	}

	/**
	 * method to handle Qnames
	 */

	private void writeQName(javax.xml.namespace.QName qname,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {
		java.lang.String namespaceURI = qname.getNamespaceURI();
		if (namespaceURI != null) {
			java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
			if (prefix == null) {
				prefix = generatePrefix(namespaceURI);
				xmlWriter.writeNamespace(prefix, namespaceURI);
				xmlWriter.setPrefix(prefix, namespaceURI);
			}

			if (prefix.trim().length() > 0) {
				xmlWriter.writeCharacters(prefix
						+ ":"
						+ org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			} else {
				// i.e this is the default namespace
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}

		} else {
			xmlWriter
					.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(qname));
		}
	}

	private void writeQNames(javax.xml.namespace.QName[] qnames,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {

		if (qnames != null) {
			// we have to store this data until last moment since it is not
			// possible to write any
			// namespace data after writing the charactor data
			java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
			java.lang.String namespaceURI = null;
			java.lang.String prefix = null;

			for (int i = 0; i < qnames.length; i++) {
				if (i > 0) {
					stringToWrite.append(" ");
				}
				namespaceURI = qnames[i].getNamespaceURI();
				if (namespaceURI != null) {
					prefix = xmlWriter.getPrefix(namespaceURI);
					if ((prefix == null) || (prefix.length() == 0)) {
						prefix = generatePrefix(namespaceURI);
						xmlWriter.writeNamespace(prefix, namespaceURI);
						xmlWriter.setPrefix(prefix, namespaceURI);
					}

					if (prefix.trim().length() > 0) {
						stringToWrite
								.append(prefix)
								.append(":")
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				} else {
					stringToWrite
							.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
				}
			}
			xmlWriter.writeCharacters(stringToWrite.toString());
		}

	}

	/**
	 * Register a namespace prefix
	 */
	private java.lang.String registerPrefix(
			javax.xml.stream.XMLStreamWriter xmlWriter,
			java.lang.String namespace)
			throws javax.xml.stream.XMLStreamException {
		java.lang.String prefix = xmlWriter.getPrefix(namespace);
		if (prefix == null) {
			prefix = generatePrefix(namespace);
			javax.xml.namespace.NamespaceContext nsContext = xmlWriter
					.getNamespaceContext();
			while (true) {
				java.lang.String uri = nsContext.getNamespaceURI(prefix);
				if (uri == null || uri.length() == 0) {
					break;
				}
				prefix = org.apache.axis2.databinding.utils.BeanUtil
						.getUniquePrefix();
			}
			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);
		}
		return prefix;
	}

	/**
	 * databinding method to get an XML representation of this object
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public javax.xml.stream.XMLStreamReader getPullParser(
			javax.xml.namespace.QName qName)
			throws org.apache.axis2.databinding.ADBException {

		java.util.ArrayList elementList = new java.util.ArrayList();
		java.util.ArrayList attribList = new java.util.ArrayList();

		elementList.add(new javax.xml.namespace.QName("", "Text1"));

		if (localText1 == null) {
			throw new org.apache.axis2.databinding.ADBException(
					"Text1 cannot be null!!");
		}
		elementList.add(localText1);

		elementList.add(new javax.xml.namespace.QName("", "Text2"));

		if (localText2 == null) {
			throw new org.apache.axis2.databinding.ADBException(
					"Text2 cannot be null!!");
		}
		elementList.add(localText2);

		elementList.add(new javax.xml.namespace.QName("", "Text3"));

		if (localText3 == null) {
			throw new org.apache.axis2.databinding.ADBException(
					"Text3 cannot be null!!");
		}
		elementList.add(localText3);

		elementList.add(new javax.xml.namespace.QName("", "Text4"));

		if (localText4 == null) {
			throw new org.apache.axis2.databinding.ADBException(
					"Text4 cannot be null!!");
		}
		elementList.add(localText4);

		elementList.add(new javax.xml.namespace.QName("", "Text5"));

		if (localText5 == null) {
			throw new org.apache.axis2.databinding.ADBException(
					"Text5 cannot be null!!");
		}
		elementList.add(localText5);

		return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
				qName, elementList.toArray(), attribList.toArray());

	}

	/**
	 * Factory class that keeps the parse method
	 */
	public static class Factory {

		/**
		 * static method to create the object Precondition: If this object is an
		 * element, the current or next start element starts this object and any
		 * intervening reader events are ignorable If this object is not an
		 * element, it is a complex type and the reader is at the event just
		 * after the outer start element Postcondition: If this object is an
		 * element, the reader is positioned at its end element If this object
		 * is a complex type, the reader is positioned at the end element of its
		 * outer element
		 */
		@SuppressWarnings("rawtypes")
		public static Zweblistline parse(javax.xml.stream.XMLStreamReader reader)
				throws java.lang.Exception {
			Zweblistline object = new Zweblistline();

			int event;
			java.lang.String nillableValue = null;
			java.lang.String prefix = "";
			java.lang.String namespaceuri = "";
			try {

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.getAttributeValue(
						"http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
					java.lang.String fullTypeName = reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type");
					if (fullTypeName != null) {
						java.lang.String nsPrefix = null;
						if (fullTypeName.indexOf(":") > -1) {
							nsPrefix = fullTypeName.substring(0,
									fullTypeName.indexOf(":"));
						}
						nsPrefix = nsPrefix == null ? "" : nsPrefix;

						java.lang.String type = fullTypeName
								.substring(fullTypeName.indexOf(":") + 1);

						if (!"Zweblistline".equals(type)) {
							// find namespace for the prefix
							java.lang.String nsUri = reader
									.getNamespaceContext().getNamespaceURI(
											nsPrefix);
							return (Zweblistline) functions.rfc.sap.document.sap_com.ExtensionMapper
									.getTypeObject(nsUri, type, reader);
						}

					}

				}

				// Note all attributes that were handled. Used to differ normal
				// attributes
				// from anyAttributes.
				java.util.Vector handledAttributes = new java.util.Vector();

				reader.next();

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("", "Text1")
								.equals(reader.getName())) {

					object.setText1(functions.rfc.sap.document.sap_com.Char132.Factory
							.parse(reader));

					reader.next();

				} // End of if for expected property start element

				else {
					// A start element we are not expecting indicates an invalid
					// parameter was passed
					throw new org.apache.axis2.databinding.ADBException(
							"Unexpected subelement " + reader.getName());
				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("", "Text2")
								.equals(reader.getName())) {

					object.setText2(functions.rfc.sap.document.sap_com.Char132.Factory
							.parse(reader));

					reader.next();

				} // End of if for expected property start element

				else {
					// A start element we are not expecting indicates an invalid
					// parameter was passed
					throw new org.apache.axis2.databinding.ADBException(
							"Unexpected subelement " + reader.getName());
				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("", "Text3")
								.equals(reader.getName())) {

					object.setText3(functions.rfc.sap.document.sap_com.Char132.Factory
							.parse(reader));

					reader.next();

				} // End of if for expected property start element

				else {
					// A start element we are not expecting indicates an invalid
					// parameter was passed
					throw new org.apache.axis2.databinding.ADBException(
							"Unexpected subelement " + reader.getName());
				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("", "Text4")
								.equals(reader.getName())) {

					object.setText4(functions.rfc.sap.document.sap_com.Char132.Factory
							.parse(reader));

					reader.next();

				} // End of if for expected property start element

				else {
					// A start element we are not expecting indicates an invalid
					// parameter was passed
					throw new org.apache.axis2.databinding.ADBException(
							"Unexpected subelement " + reader.getName());
				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("", "Text5")
								.equals(reader.getName())) {

					object.setText5(functions.rfc.sap.document.sap_com.Char132.Factory
							.parse(reader));

					reader.next();

				} // End of if for expected property start element

				else {
					// A start element we are not expecting indicates an invalid
					// parameter was passed
					throw new org.apache.axis2.databinding.ADBException(
							"Unexpected subelement " + reader.getName());
				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement())
					// A start element we are not expecting indicates a trailing
					// invalid property
					throw new org.apache.axis2.databinding.ADBException(
							"Unexpected subelement " + reader.getName());

			} catch (javax.xml.stream.XMLStreamException e) {
				throw new java.lang.Exception(e);
			}

			return object;
		}

	}// end of factory class

}
