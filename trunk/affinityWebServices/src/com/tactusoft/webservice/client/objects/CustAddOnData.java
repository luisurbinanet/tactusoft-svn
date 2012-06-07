/**
 * CustAddOnData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class CustAddOnData  implements java.io.Serializable {
    private java.lang.String changed;

    private java.lang.String kunnr;

    public CustAddOnData() {
    }

    public CustAddOnData(
           java.lang.String changed,
           java.lang.String kunnr) {
           this.changed = changed;
           this.kunnr = kunnr;
    }


    /**
     * Gets the changed value for this CustAddOnData.
     * 
     * @return changed
     */
    public java.lang.String getChanged() {
        return changed;
    }


    /**
     * Sets the changed value for this CustAddOnData.
     * 
     * @param changed
     */
    public void setChanged(java.lang.String changed) {
        this.changed = changed;
    }


    /**
     * Gets the kunnr value for this CustAddOnData.
     * 
     * @return kunnr
     */
    public java.lang.String getKunnr() {
        return kunnr;
    }


    /**
     * Sets the kunnr value for this CustAddOnData.
     * 
     * @param kunnr
     */
    public void setKunnr(java.lang.String kunnr) {
        this.kunnr = kunnr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustAddOnData)) return false;
        CustAddOnData other = (CustAddOnData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.changed==null && other.getChanged()==null) || 
             (this.changed!=null &&
              this.changed.equals(other.getChanged()))) &&
            ((this.kunnr==null && other.getKunnr()==null) || 
             (this.kunnr!=null &&
              this.kunnr.equals(other.getKunnr())));
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
        if (getChanged() != null) {
            _hashCode += getChanged().hashCode();
        }
        if (getKunnr() != null) {
            _hashCode += getKunnr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustAddOnData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "CustAddOnData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Changed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kunnr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Kunnr"));
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
