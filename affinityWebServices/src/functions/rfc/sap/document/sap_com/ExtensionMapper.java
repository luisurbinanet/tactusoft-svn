/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

package functions.rfc.sap.document.sap_com;

/**
 * ExtensionMapper class
 */
public class ExtensionMapper {

	public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
			java.lang.String typeName, javax.xml.stream.XMLStreamReader reader)
			throws java.lang.Exception {

		if ("urn:sap-com:document:sap:rfc:functions".equals(namespaceURI)
				&& "char132".equals(typeName)) {

			return functions.rfc.sap.document.sap_com.Char132.Factory
					.parse(reader);

		}

		if ("urn:sap-com:document:sap:soap:functions:mc-style"
				.equals(namespaceURI) && "Zweblistline".equals(typeName)) {

			return mc_style.functions.soap.sap.document.sap_com.Zweblistline.Factory
					.parse(reader);

		}

		if ("urn:sap-com:document:sap:soap:functions:mc-style"
				.equals(namespaceURI) && "Zweblist".equals(typeName)) {

			return mc_style.functions.soap.sap.document.sap_com.Zweblist.Factory
					.parse(reader);

		}

		throw new org.apache.axis2.databinding.ADBException("Unsupported type "
				+ namespaceURI + " " + typeName);
	}

}
