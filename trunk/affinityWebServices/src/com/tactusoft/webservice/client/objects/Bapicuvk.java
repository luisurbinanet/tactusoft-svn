/**
 * Bapicuvk.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Bapicuvk  implements java.io.Serializable {
    private java.lang.String configId;

    private java.lang.String instId;

    private java.lang.String vkey;

    private java.lang.String factor;

    public Bapicuvk() {
    }

    public Bapicuvk(
           java.lang.String configId,
           java.lang.String instId,
           java.lang.String vkey,
           java.lang.String factor) {
           this.configId = configId;
           this.instId = instId;
           this.vkey = vkey;
           this.factor = factor;
    }


    /**
     * Gets the configId value for this Bapicuvk.
     * 
     * @return configId
     */
    public java.lang.String getConfigId() {
        return configId;
    }


    /**
     * Sets the configId value for this Bapicuvk.
     * 
     * @param configId
     */
    public void setConfigId(java.lang.String configId) {
        this.configId = configId;
    }


    /**
     * Gets the instId value for this Bapicuvk.
     * 
     * @return instId
     */
    public java.lang.String getInstId() {
        return instId;
    }


    /**
     * Sets the instId value for this Bapicuvk.
     * 
     * @param instId
     */
    public void setInstId(java.lang.String instId) {
        this.instId = instId;
    }


    /**
     * Gets the vkey value for this Bapicuvk.
     * 
     * @return vkey
     */
    public java.lang.String getVkey() {
        return vkey;
    }


    /**
     * Sets the vkey value for this Bapicuvk.
     * 
     * @param vkey
     */
    public void setVkey(java.lang.String vkey) {
        this.vkey = vkey;
    }


    /**
     * Gets the factor value for this Bapicuvk.
     * 
     * @return factor
     */
    public java.lang.String getFactor() {
        return factor;
    }


    /**
     * Sets the factor value for this Bapicuvk.
     * 
     * @param factor
     */
    public void setFactor(java.lang.String factor) {
        this.factor = factor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapicuvk)) return false;
        Bapicuvk other = (Bapicuvk) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.configId==null && other.getConfigId()==null) || 
             (this.configId!=null &&
              this.configId.equals(other.getConfigId()))) &&
            ((this.instId==null && other.getInstId()==null) || 
             (this.instId!=null &&
              this.instId.equals(other.getInstId()))) &&
            ((this.vkey==null && other.getVkey()==null) || 
             (this.vkey!=null &&
              this.vkey.equals(other.getVkey()))) &&
            ((this.factor==null && other.getFactor()==null) || 
             (this.factor!=null &&
              this.factor.equals(other.getFactor())));
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
        if (getConfigId() != null) {
            _hashCode += getConfigId().hashCode();
        }
        if (getInstId() != null) {
            _hashCode += getInstId().hashCode();
        }
        if (getVkey() != null) {
            _hashCode += getVkey().hashCode();
        }
        if (getFactor() != null) {
            _hashCode += getFactor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapicuvk.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapicuvk"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vkey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Vkey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("factor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Factor"));
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
