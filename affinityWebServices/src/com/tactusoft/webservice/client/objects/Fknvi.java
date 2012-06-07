/**
 * Fknvi.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Fknvi  implements java.io.Serializable {
    private java.lang.String mandt;

    private java.lang.String kunnr;

    private java.lang.String aland;

    private java.lang.String tatyp;

    private java.lang.String taxkd;

    private java.lang.String kz;

    public Fknvi() {
    }

    public Fknvi(
           java.lang.String mandt,
           java.lang.String kunnr,
           java.lang.String aland,
           java.lang.String tatyp,
           java.lang.String taxkd,
           java.lang.String kz) {
           this.mandt = mandt;
           this.kunnr = kunnr;
           this.aland = aland;
           this.tatyp = tatyp;
           this.taxkd = taxkd;
           this.kz = kz;
    }


    /**
     * Gets the mandt value for this Fknvi.
     * 
     * @return mandt
     */
    public java.lang.String getMandt() {
        return mandt;
    }


    /**
     * Sets the mandt value for this Fknvi.
     * 
     * @param mandt
     */
    public void setMandt(java.lang.String mandt) {
        this.mandt = mandt;
    }


    /**
     * Gets the kunnr value for this Fknvi.
     * 
     * @return kunnr
     */
    public java.lang.String getKunnr() {
        return kunnr;
    }


    /**
     * Sets the kunnr value for this Fknvi.
     * 
     * @param kunnr
     */
    public void setKunnr(java.lang.String kunnr) {
        this.kunnr = kunnr;
    }


    /**
     * Gets the aland value for this Fknvi.
     * 
     * @return aland
     */
    public java.lang.String getAland() {
        return aland;
    }


    /**
     * Sets the aland value for this Fknvi.
     * 
     * @param aland
     */
    public void setAland(java.lang.String aland) {
        this.aland = aland;
    }


    /**
     * Gets the tatyp value for this Fknvi.
     * 
     * @return tatyp
     */
    public java.lang.String getTatyp() {
        return tatyp;
    }


    /**
     * Sets the tatyp value for this Fknvi.
     * 
     * @param tatyp
     */
    public void setTatyp(java.lang.String tatyp) {
        this.tatyp = tatyp;
    }


    /**
     * Gets the taxkd value for this Fknvi.
     * 
     * @return taxkd
     */
    public java.lang.String getTaxkd() {
        return taxkd;
    }


    /**
     * Sets the taxkd value for this Fknvi.
     * 
     * @param taxkd
     */
    public void setTaxkd(java.lang.String taxkd) {
        this.taxkd = taxkd;
    }


    /**
     * Gets the kz value for this Fknvi.
     * 
     * @return kz
     */
    public java.lang.String getKz() {
        return kz;
    }


    /**
     * Sets the kz value for this Fknvi.
     * 
     * @param kz
     */
    public void setKz(java.lang.String kz) {
        this.kz = kz;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Fknvi)) return false;
        Fknvi other = (Fknvi) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mandt==null && other.getMandt()==null) || 
             (this.mandt!=null &&
              this.mandt.equals(other.getMandt()))) &&
            ((this.kunnr==null && other.getKunnr()==null) || 
             (this.kunnr!=null &&
              this.kunnr.equals(other.getKunnr()))) &&
            ((this.aland==null && other.getAland()==null) || 
             (this.aland!=null &&
              this.aland.equals(other.getAland()))) &&
            ((this.tatyp==null && other.getTatyp()==null) || 
             (this.tatyp!=null &&
              this.tatyp.equals(other.getTatyp()))) &&
            ((this.taxkd==null && other.getTaxkd()==null) || 
             (this.taxkd!=null &&
              this.taxkd.equals(other.getTaxkd()))) &&
            ((this.kz==null && other.getKz()==null) || 
             (this.kz!=null &&
              this.kz.equals(other.getKz())));
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
        if (getMandt() != null) {
            _hashCode += getMandt().hashCode();
        }
        if (getKunnr() != null) {
            _hashCode += getKunnr().hashCode();
        }
        if (getAland() != null) {
            _hashCode += getAland().hashCode();
        }
        if (getTatyp() != null) {
            _hashCode += getTatyp().hashCode();
        }
        if (getTaxkd() != null) {
            _hashCode += getTaxkd().hashCode();
        }
        if (getKz() != null) {
            _hashCode += getKz().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Fknvi.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Fknvi"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mandt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Mandt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kunnr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Kunnr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aland");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Aland"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tatyp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Tatyp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxkd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Taxkd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kz");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Kz"));
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
