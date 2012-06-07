/**
 * Bapikna102.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Bapikna102  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String salesorg;

    private java.lang.String distrChan;

    private java.lang.String division;

    private java.lang.String refCustmr;

    public Bapikna102() {
    }

    public Bapikna102(
           java.lang.String salesorg,
           java.lang.String distrChan,
           java.lang.String division,
           java.lang.String refCustmr) {
           this.salesorg = salesorg;
           this.distrChan = distrChan;
           this.division = division;
           this.refCustmr = refCustmr;
    }


    /**
     * Gets the salesorg value for this Bapikna102.
     * 
     * @return salesorg
     */
    public java.lang.String getSalesorg() {
        return salesorg;
    }


    /**
     * Sets the salesorg value for this Bapikna102.
     * 
     * @param salesorg
     */
    public void setSalesorg(java.lang.String salesorg) {
        this.salesorg = salesorg;
    }


    /**
     * Gets the distrChan value for this Bapikna102.
     * 
     * @return distrChan
     */
    public java.lang.String getDistrChan() {
        return distrChan;
    }


    /**
     * Sets the distrChan value for this Bapikna102.
     * 
     * @param distrChan
     */
    public void setDistrChan(java.lang.String distrChan) {
        this.distrChan = distrChan;
    }


    /**
     * Gets the division value for this Bapikna102.
     * 
     * @return division
     */
    public java.lang.String getDivision() {
        return division;
    }


    /**
     * Sets the division value for this Bapikna102.
     * 
     * @param division
     */
    public void setDivision(java.lang.String division) {
        this.division = division;
    }


    /**
     * Gets the refCustmr value for this Bapikna102.
     * 
     * @return refCustmr
     */
    public java.lang.String getRefCustmr() {
        return refCustmr;
    }


    /**
     * Sets the refCustmr value for this Bapikna102.
     * 
     * @param refCustmr
     */
    public void setRefCustmr(java.lang.String refCustmr) {
        this.refCustmr = refCustmr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapikna102)) return false;
        Bapikna102 other = (Bapikna102) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.salesorg==null && other.getSalesorg()==null) || 
             (this.salesorg!=null &&
              this.salesorg.equals(other.getSalesorg()))) &&
            ((this.distrChan==null && other.getDistrChan()==null) || 
             (this.distrChan!=null &&
              this.distrChan.equals(other.getDistrChan()))) &&
            ((this.division==null && other.getDivision()==null) || 
             (this.division!=null &&
              this.division.equals(other.getDivision()))) &&
            ((this.refCustmr==null && other.getRefCustmr()==null) || 
             (this.refCustmr!=null &&
              this.refCustmr.equals(other.getRefCustmr())));
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
        if (getSalesorg() != null) {
            _hashCode += getSalesorg().hashCode();
        }
        if (getDistrChan() != null) {
            _hashCode += getDistrChan().hashCode();
        }
        if (getDivision() != null) {
            _hashCode += getDivision().hashCode();
        }
        if (getRefCustmr() != null) {
            _hashCode += getRefCustmr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapikna102.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapikna102"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesorg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Salesorg"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refCustmr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RefCustmr"));
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
