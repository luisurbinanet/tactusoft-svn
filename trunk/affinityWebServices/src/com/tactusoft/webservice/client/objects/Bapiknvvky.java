/**
 * Bapiknvvky.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Bapiknvvky  implements java.io.Serializable {
    private java.lang.String customer;

    private java.lang.String salesorg;

    private java.lang.String distrchn;

    private java.lang.String division;

    public Bapiknvvky() {
    }

    public Bapiknvvky(
           java.lang.String customer,
           java.lang.String salesorg,
           java.lang.String distrchn,
           java.lang.String division) {
           this.customer = customer;
           this.salesorg = salesorg;
           this.distrchn = distrchn;
           this.division = division;
    }


    /**
     * Gets the customer value for this Bapiknvvky.
     * 
     * @return customer
     */
    public java.lang.String getCustomer() {
        return customer;
    }


    /**
     * Sets the customer value for this Bapiknvvky.
     * 
     * @param customer
     */
    public void setCustomer(java.lang.String customer) {
        this.customer = customer;
    }


    /**
     * Gets the salesorg value for this Bapiknvvky.
     * 
     * @return salesorg
     */
    public java.lang.String getSalesorg() {
        return salesorg;
    }


    /**
     * Sets the salesorg value for this Bapiknvvky.
     * 
     * @param salesorg
     */
    public void setSalesorg(java.lang.String salesorg) {
        this.salesorg = salesorg;
    }


    /**
     * Gets the distrchn value for this Bapiknvvky.
     * 
     * @return distrchn
     */
    public java.lang.String getDistrchn() {
        return distrchn;
    }


    /**
     * Sets the distrchn value for this Bapiknvvky.
     * 
     * @param distrchn
     */
    public void setDistrchn(java.lang.String distrchn) {
        this.distrchn = distrchn;
    }


    /**
     * Gets the division value for this Bapiknvvky.
     * 
     * @return division
     */
    public java.lang.String getDivision() {
        return division;
    }


    /**
     * Sets the division value for this Bapiknvvky.
     * 
     * @param division
     */
    public void setDivision(java.lang.String division) {
        this.division = division;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapiknvvky)) return false;
        Bapiknvvky other = (Bapiknvvky) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customer==null && other.getCustomer()==null) || 
             (this.customer!=null &&
              this.customer.equals(other.getCustomer()))) &&
            ((this.salesorg==null && other.getSalesorg()==null) || 
             (this.salesorg!=null &&
              this.salesorg.equals(other.getSalesorg()))) &&
            ((this.distrchn==null && other.getDistrchn()==null) || 
             (this.distrchn!=null &&
              this.distrchn.equals(other.getDistrchn()))) &&
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
        if (getCustomer() != null) {
            _hashCode += getCustomer().hashCode();
        }
        if (getSalesorg() != null) {
            _hashCode += getSalesorg().hashCode();
        }
        if (getDistrchn() != null) {
            _hashCode += getDistrchn().hashCode();
        }
        if (getDivision() != null) {
            _hashCode += getDivision().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapiknvvky.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiknvvky"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Customer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesorg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Salesorg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distrchn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Distrchn"));
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
