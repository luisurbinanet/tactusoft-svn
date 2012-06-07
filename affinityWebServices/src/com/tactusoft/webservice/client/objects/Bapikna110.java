/**
 * Bapikna110.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Bapikna110  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String compCode;

    private java.lang.String tabname;

    private java.lang.String fieldname;

    private java.lang.String fieldvalue;

    public Bapikna110() {
    }

    public Bapikna110(
           java.lang.String compCode,
           java.lang.String tabname,
           java.lang.String fieldname,
           java.lang.String fieldvalue) {
           this.compCode = compCode;
           this.tabname = tabname;
           this.fieldname = fieldname;
           this.fieldvalue = fieldvalue;
    }


    /**
     * Gets the compCode value for this Bapikna110.
     * 
     * @return compCode
     */
    public java.lang.String getCompCode() {
        return compCode;
    }


    /**
     * Sets the compCode value for this Bapikna110.
     * 
     * @param compCode
     */
    public void setCompCode(java.lang.String compCode) {
        this.compCode = compCode;
    }


    /**
     * Gets the tabname value for this Bapikna110.
     * 
     * @return tabname
     */
    public java.lang.String getTabname() {
        return tabname;
    }


    /**
     * Sets the tabname value for this Bapikna110.
     * 
     * @param tabname
     */
    public void setTabname(java.lang.String tabname) {
        this.tabname = tabname;
    }


    /**
     * Gets the fieldname value for this Bapikna110.
     * 
     * @return fieldname
     */
    public java.lang.String getFieldname() {
        return fieldname;
    }


    /**
     * Sets the fieldname value for this Bapikna110.
     * 
     * @param fieldname
     */
    public void setFieldname(java.lang.String fieldname) {
        this.fieldname = fieldname;
    }


    /**
     * Gets the fieldvalue value for this Bapikna110.
     * 
     * @return fieldvalue
     */
    public java.lang.String getFieldvalue() {
        return fieldvalue;
    }


    /**
     * Sets the fieldvalue value for this Bapikna110.
     * 
     * @param fieldvalue
     */
    public void setFieldvalue(java.lang.String fieldvalue) {
        this.fieldvalue = fieldvalue;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapikna110)) return false;
        Bapikna110 other = (Bapikna110) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.compCode==null && other.getCompCode()==null) || 
             (this.compCode!=null &&
              this.compCode.equals(other.getCompCode()))) &&
            ((this.tabname==null && other.getTabname()==null) || 
             (this.tabname!=null &&
              this.tabname.equals(other.getTabname()))) &&
            ((this.fieldname==null && other.getFieldname()==null) || 
             (this.fieldname!=null &&
              this.fieldname.equals(other.getFieldname()))) &&
            ((this.fieldvalue==null && other.getFieldvalue()==null) || 
             (this.fieldvalue!=null &&
              this.fieldvalue.equals(other.getFieldvalue())));
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
        if (getCompCode() != null) {
            _hashCode += getCompCode().hashCode();
        }
        if (getTabname() != null) {
            _hashCode += getTabname().hashCode();
        }
        if (getFieldname() != null) {
            _hashCode += getFieldname().hashCode();
        }
        if (getFieldvalue() != null) {
            _hashCode += getFieldvalue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapikna110.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapikna110"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CompCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tabname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Tabname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fieldname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Fieldname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fieldvalue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Fieldvalue"));
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
