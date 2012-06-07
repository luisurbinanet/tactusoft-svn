/**
 * Sdvtber.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Sdvtber  implements java.io.Serializable {
    private java.lang.String salesOrg;

    private java.lang.String distrChan;

    private java.lang.String division;

    public Sdvtber() {
    }

    public Sdvtber(
           java.lang.String salesOrg,
           java.lang.String distrChan,
           java.lang.String division) {
           this.salesOrg = salesOrg;
           this.distrChan = distrChan;
           this.division = division;
    }


    /**
     * Gets the salesOrg value for this Sdvtber.
     * 
     * @return salesOrg
     */
    public java.lang.String getSalesOrg() {
        return salesOrg;
    }


    /**
     * Sets the salesOrg value for this Sdvtber.
     * 
     * @param salesOrg
     */
    public void setSalesOrg(java.lang.String salesOrg) {
        this.salesOrg = salesOrg;
    }


    /**
     * Gets the distrChan value for this Sdvtber.
     * 
     * @return distrChan
     */
    public java.lang.String getDistrChan() {
        return distrChan;
    }


    /**
     * Sets the distrChan value for this Sdvtber.
     * 
     * @param distrChan
     */
    public void setDistrChan(java.lang.String distrChan) {
        this.distrChan = distrChan;
    }


    /**
     * Gets the division value for this Sdvtber.
     * 
     * @return division
     */
    public java.lang.String getDivision() {
        return division;
    }


    /**
     * Sets the division value for this Sdvtber.
     * 
     * @param division
     */
    public void setDivision(java.lang.String division) {
        this.division = division;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Sdvtber)) return false;
        Sdvtber other = (Sdvtber) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.salesOrg==null && other.getSalesOrg()==null) || 
             (this.salesOrg!=null &&
              this.salesOrg.equals(other.getSalesOrg()))) &&
            ((this.distrChan==null && other.getDistrChan()==null) || 
             (this.distrChan!=null &&
              this.distrChan.equals(other.getDistrChan()))) &&
            ((this.division==null && other.getDivision()==null) || 
             (this.division!=null &&
              this.division.equals(other.getDivision())));
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
        if (getSalesOrg() != null) {
            _hashCode += getSalesOrg().hashCode();
        }
        if (getDistrChan() != null) {
            _hashCode += getDistrChan().hashCode();
        }
        if (getDivision() != null) {
            _hashCode += getDivision().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Sdvtber.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Sdvtber"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesOrg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SalesOrg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distrChan");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DistrChan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("division");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Division"));
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
