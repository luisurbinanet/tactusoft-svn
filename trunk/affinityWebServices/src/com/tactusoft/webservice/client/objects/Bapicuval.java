/**
 * Bapicuval.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Bapicuval  implements java.io.Serializable {
    private java.lang.String configId;

    private java.lang.String instId;

    private java.lang.String charc;

    private java.lang.String charcTxt;

    private java.lang.String value;

    private java.lang.String valueTxt;

    private java.lang.String author;

    private java.lang.String valueTo;

    private java.lang.String valcode;

    public Bapicuval() {
    }

    public Bapicuval(
           java.lang.String configId,
           java.lang.String instId,
           java.lang.String charc,
           java.lang.String charcTxt,
           java.lang.String value,
           java.lang.String valueTxt,
           java.lang.String author,
           java.lang.String valueTo,
           java.lang.String valcode) {
           this.configId = configId;
           this.instId = instId;
           this.charc = charc;
           this.charcTxt = charcTxt;
           this.value = value;
           this.valueTxt = valueTxt;
           this.author = author;
           this.valueTo = valueTo;
           this.valcode = valcode;
    }


    /**
     * Gets the configId value for this Bapicuval.
     * 
     * @return configId
     */
    public java.lang.String getConfigId() {
        return configId;
    }


    /**
     * Sets the configId value for this Bapicuval.
     * 
     * @param configId
     */
    public void setConfigId(java.lang.String configId) {
        this.configId = configId;
    }


    /**
     * Gets the instId value for this Bapicuval.
     * 
     * @return instId
     */
    public java.lang.String getInstId() {
        return instId;
    }


    /**
     * Sets the instId value for this Bapicuval.
     * 
     * @param instId
     */
    public void setInstId(java.lang.String instId) {
        this.instId = instId;
    }


    /**
     * Gets the charc value for this Bapicuval.
     * 
     * @return charc
     */
    public java.lang.String getCharc() {
        return charc;
    }


    /**
     * Sets the charc value for this Bapicuval.
     * 
     * @param charc
     */
    public void setCharc(java.lang.String charc) {
        this.charc = charc;
    }


    /**
     * Gets the charcTxt value for this Bapicuval.
     * 
     * @return charcTxt
     */
    public java.lang.String getCharcTxt() {
        return charcTxt;
    }


    /**
     * Sets the charcTxt value for this Bapicuval.
     * 
     * @param charcTxt
     */
    public void setCharcTxt(java.lang.String charcTxt) {
        this.charcTxt = charcTxt;
    }


    /**
     * Gets the value value for this Bapicuval.
     * 
     * @return value
     */
    public java.lang.String getValue() {
        return value;
    }


    /**
     * Sets the value value for this Bapicuval.
     * 
     * @param value
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }


    /**
     * Gets the valueTxt value for this Bapicuval.
     * 
     * @return valueTxt
     */
    public java.lang.String getValueTxt() {
        return valueTxt;
    }


    /**
     * Sets the valueTxt value for this Bapicuval.
     * 
     * @param valueTxt
     */
    public void setValueTxt(java.lang.String valueTxt) {
        this.valueTxt = valueTxt;
    }


    /**
     * Gets the author value for this Bapicuval.
     * 
     * @return author
     */
    public java.lang.String getAuthor() {
        return author;
    }


    /**
     * Sets the author value for this Bapicuval.
     * 
     * @param author
     */
    public void setAuthor(java.lang.String author) {
        this.author = author;
    }


    /**
     * Gets the valueTo value for this Bapicuval.
     * 
     * @return valueTo
     */
    public java.lang.String getValueTo() {
        return valueTo;
    }


    /**
     * Sets the valueTo value for this Bapicuval.
     * 
     * @param valueTo
     */
    public void setValueTo(java.lang.String valueTo) {
        this.valueTo = valueTo;
    }


    /**
     * Gets the valcode value for this Bapicuval.
     * 
     * @return valcode
     */
    public java.lang.String getValcode() {
        return valcode;
    }


    /**
     * Sets the valcode value for this Bapicuval.
     * 
     * @param valcode
     */
    public void setValcode(java.lang.String valcode) {
        this.valcode = valcode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapicuval)) return false;
        Bapicuval other = (Bapicuval) obj;
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
            ((this.charc==null && other.getCharc()==null) || 
             (this.charc!=null &&
              this.charc.equals(other.getCharc()))) &&
            ((this.charcTxt==null && other.getCharcTxt()==null) || 
             (this.charcTxt!=null &&
              this.charcTxt.equals(other.getCharcTxt()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue()))) &&
            ((this.valueTxt==null && other.getValueTxt()==null) || 
             (this.valueTxt!=null &&
              this.valueTxt.equals(other.getValueTxt()))) &&
            ((this.author==null && other.getAuthor()==null) || 
             (this.author!=null &&
              this.author.equals(other.getAuthor()))) &&
            ((this.valueTo==null && other.getValueTo()==null) || 
             (this.valueTo!=null &&
              this.valueTo.equals(other.getValueTo()))) &&
            ((this.valcode==null && other.getValcode()==null) || 
             (this.valcode!=null &&
              this.valcode.equals(other.getValcode())));
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
        if (getCharc() != null) {
            _hashCode += getCharc().hashCode();
        }
        if (getCharcTxt() != null) {
            _hashCode += getCharcTxt().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        if (getValueTxt() != null) {
            _hashCode += getValueTxt().hashCode();
        }
        if (getAuthor() != null) {
            _hashCode += getAuthor().hashCode();
        }
        if (getValueTo() != null) {
            _hashCode += getValueTo().hashCode();
        }
        if (getValcode() != null) {
            _hashCode += getValcode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapicuval.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapicuval"));
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
        elemField.setFieldName("charc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Charc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("charcTxt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CharcTxt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valueTxt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ValueTxt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("author");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Author"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valueTo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ValueTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valcode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Valcode"));
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
