/**
 * Bapicuref.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

@SuppressWarnings({ "rawtypes", "unused" })
public class Bapicuref  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String posex;

    private java.lang.String configId;

    private java.lang.String instId;

    public Bapicuref() {
    }

    public Bapicuref(
           java.lang.String posex,
           java.lang.String configId,
           java.lang.String instId) {
           this.posex = posex;
           this.configId = configId;
           this.instId = instId;
    }


    /**
     * Gets the posex value for this Bapicuref.
     * 
     * @return posex
     */
    public java.lang.String getPosex() {
        return posex;
    }


    /**
     * Sets the posex value for this Bapicuref.
     * 
     * @param posex
     */
    public void setPosex(java.lang.String posex) {
        this.posex = posex;
    }


    /**
     * Gets the configId value for this Bapicuref.
     * 
     * @return configId
     */
    public java.lang.String getConfigId() {
        return configId;
    }


    /**
     * Sets the configId value for this Bapicuref.
     * 
     * @param configId
     */
    public void setConfigId(java.lang.String configId) {
        this.configId = configId;
    }


    /**
     * Gets the instId value for this Bapicuref.
     * 
     * @return instId
     */
    public java.lang.String getInstId() {
        return instId;
    }


    /**
     * Sets the instId value for this Bapicuref.
     * 
     * @param instId
     */
    public void setInstId(java.lang.String instId) {
        this.instId = instId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapicuref)) return false;
        Bapicuref other = (Bapicuref) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.posex==null && other.getPosex()==null) || 
             (this.posex!=null &&
              this.posex.equals(other.getPosex()))) &&
            ((this.configId==null && other.getConfigId()==null) || 
             (this.configId!=null &&
              this.configId.equals(other.getConfigId()))) &&
            ((this.instId==null && other.getInstId()==null) || 
             (this.instId!=null &&
              this.instId.equals(other.getInstId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getPosex() != null) {
            _hashCode += getPosex().hashCode();
        }
        if (getConfigId() != null) {
            _hashCode += getConfigId().hashCode();
        }
        if (getInstId() != null) {
            _hashCode += getInstId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapicuref.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapicuref"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posex");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Posex"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("configId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ConfigId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "InstId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
