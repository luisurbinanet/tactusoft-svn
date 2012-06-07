/**
 * Bapikna109.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Bapikna109  implements java.io.Serializable {
    private java.lang.String addrtype;

    private java.lang.String adrnr;

    private java.lang.String adrnp2;

    private java.lang.String prsnr;

    public Bapikna109() {
    }

    public Bapikna109(
           java.lang.String addrtype,
           java.lang.String adrnr,
           java.lang.String adrnp2,
           java.lang.String prsnr) {
           this.addrtype = addrtype;
           this.adrnr = adrnr;
           this.adrnp2 = adrnp2;
           this.prsnr = prsnr;
    }


    /**
     * Gets the addrtype value for this Bapikna109.
     * 
     * @return addrtype
     */
    public java.lang.String getAddrtype() {
        return addrtype;
    }


    /**
     * Sets the addrtype value for this Bapikna109.
     * 
     * @param addrtype
     */
    public void setAddrtype(java.lang.String addrtype) {
        this.addrtype = addrtype;
    }


    /**
     * Gets the adrnr value for this Bapikna109.
     * 
     * @return adrnr
     */
    public java.lang.String getAdrnr() {
        return adrnr;
    }


    /**
     * Sets the adrnr value for this Bapikna109.
     * 
     * @param adrnr
     */
    public void setAdrnr(java.lang.String adrnr) {
        this.adrnr = adrnr;
    }


    /**
     * Gets the adrnp2 value for this Bapikna109.
     * 
     * @return adrnp2
     */
    public java.lang.String getAdrnp2() {
        return adrnp2;
    }


    /**
     * Sets the adrnp2 value for this Bapikna109.
     * 
     * @param adrnp2
     */
    public void setAdrnp2(java.lang.String adrnp2) {
        this.adrnp2 = adrnp2;
    }


    /**
     * Gets the prsnr value for this Bapikna109.
     * 
     * @return prsnr
     */
    public java.lang.String getPrsnr() {
        return prsnr;
    }


    /**
     * Sets the prsnr value for this Bapikna109.
     * 
     * @param prsnr
     */
    public void setPrsnr(java.lang.String prsnr) {
        this.prsnr = prsnr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapikna109)) return false;
        Bapikna109 other = (Bapikna109) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.addrtype==null && other.getAddrtype()==null) || 
             (this.addrtype!=null &&
              this.addrtype.equals(other.getAddrtype()))) &&
            ((this.adrnr==null && other.getAdrnr()==null) || 
             (this.adrnr!=null &&
              this.adrnr.equals(other.getAdrnr()))) &&
            ((this.adrnp2==null && other.getAdrnp2()==null) || 
             (this.adrnp2!=null &&
              this.adrnp2.equals(other.getAdrnp2()))) &&
            ((this.prsnr==null && other.getPrsnr()==null) || 
             (this.prsnr!=null &&
              this.prsnr.equals(other.getPrsnr())));
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
        if (getAddrtype() != null) {
            _hashCode += getAddrtype().hashCode();
        }
        if (getAdrnr() != null) {
            _hashCode += getAdrnr().hashCode();
        }
        if (getAdrnp2() != null) {
            _hashCode += getAdrnp2().hashCode();
        }
        if (getPrsnr() != null) {
            _hashCode += getPrsnr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapikna109.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapikna109"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addrtype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Addrtype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adrnr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Adrnr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adrnp2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Adrnp2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prsnr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Prsnr"));
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
