/**
 * Fknas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Fknas  implements java.io.Serializable {
    private java.lang.String mandt;

    private java.lang.String kunnr;

    private java.lang.String land1;

    private java.lang.String stceg;

    private java.lang.String kz;

    public Fknas() {
    }

    public Fknas(
           java.lang.String mandt,
           java.lang.String kunnr,
           java.lang.String land1,
           java.lang.String stceg,
           java.lang.String kz) {
           this.mandt = mandt;
           this.kunnr = kunnr;
           this.land1 = land1;
           this.stceg = stceg;
           this.kz = kz;
    }


    /**
     * Gets the mandt value for this Fknas.
     * 
     * @return mandt
     */
    public java.lang.String getMandt() {
        return mandt;
    }


    /**
     * Sets the mandt value for this Fknas.
     * 
     * @param mandt
     */
    public void setMandt(java.lang.String mandt) {
        this.mandt = mandt;
    }


    /**
     * Gets the kunnr value for this Fknas.
     * 
     * @return kunnr
     */
    public java.lang.String getKunnr() {
        return kunnr;
    }


    /**
     * Sets the kunnr value for this Fknas.
     * 
     * @param kunnr
     */
    public void setKunnr(java.lang.String kunnr) {
        this.kunnr = kunnr;
    }


    /**
     * Gets the land1 value for this Fknas.
     * 
     * @return land1
     */
    public java.lang.String getLand1() {
        return land1;
    }


    /**
     * Sets the land1 value for this Fknas.
     * 
     * @param land1
     */
    public void setLand1(java.lang.String land1) {
        this.land1 = land1;
    }


    /**
     * Gets the stceg value for this Fknas.
     * 
     * @return stceg
     */
    public java.lang.String getStceg() {
        return stceg;
    }


    /**
     * Sets the stceg value for this Fknas.
     * 
     * @param stceg
     */
    public void setStceg(java.lang.String stceg) {
        this.stceg = stceg;
    }


    /**
     * Gets the kz value for this Fknas.
     * 
     * @return kz
     */
    public java.lang.String getKz() {
        return kz;
    }


    /**
     * Sets the kz value for this Fknas.
     * 
     * @param kz
     */
    public void setKz(java.lang.String kz) {
        this.kz = kz;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Fknas)) return false;
        Fknas other = (Fknas) obj;
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
            ((this.land1==null && other.getLand1()==null) || 
             (this.land1!=null &&
              this.land1.equals(other.getLand1()))) &&
            ((this.stceg==null && other.getStceg()==null) || 
             (this.stceg!=null &&
              this.stceg.equals(other.getStceg()))) &&
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
        if (getLand1() != null) {
            _hashCode += getLand1().hashCode();
        }
        if (getStceg() != null) {
            _hashCode += getStceg().hashCode();
        }
        if (getKz() != null) {
            _hashCode += getKz().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Fknas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Fknas"));
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
        elemField.setFieldName("land1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Land1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stceg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Stceg"));
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
