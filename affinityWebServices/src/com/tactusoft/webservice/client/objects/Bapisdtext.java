/**
 * Bapisdtext.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Bapisdtext  implements java.io.Serializable {
    private java.lang.String docNumber;

    private java.lang.String itmNumber;

    private java.lang.String textId;

    private java.lang.String langu;

    private java.lang.String languIso;

    private java.lang.String formatCol;

    private java.lang.String textLine;

    private java.lang.String function;

    public Bapisdtext() {
    }

    public Bapisdtext(
           java.lang.String docNumber,
           java.lang.String itmNumber,
           java.lang.String textId,
           java.lang.String langu,
           java.lang.String languIso,
           java.lang.String formatCol,
           java.lang.String textLine,
           java.lang.String function) {
           this.docNumber = docNumber;
           this.itmNumber = itmNumber;
           this.textId = textId;
           this.langu = langu;
           this.languIso = languIso;
           this.formatCol = formatCol;
           this.textLine = textLine;
           this.function = function;
    }


    /**
     * Gets the docNumber value for this Bapisdtext.
     * 
     * @return docNumber
     */
    public java.lang.String getDocNumber() {
        return docNumber;
    }


    /**
     * Sets the docNumber value for this Bapisdtext.
     * 
     * @param docNumber
     */
    public void setDocNumber(java.lang.String docNumber) {
        this.docNumber = docNumber;
    }


    /**
     * Gets the itmNumber value for this Bapisdtext.
     * 
     * @return itmNumber
     */
    public java.lang.String getItmNumber() {
        return itmNumber;
    }


    /**
     * Sets the itmNumber value for this Bapisdtext.
     * 
     * @param itmNumber
     */
    public void setItmNumber(java.lang.String itmNumber) {
        this.itmNumber = itmNumber;
    }


    /**
     * Gets the textId value for this Bapisdtext.
     * 
     * @return textId
     */
    public java.lang.String getTextId() {
        return textId;
    }


    /**
     * Sets the textId value for this Bapisdtext.
     * 
     * @param textId
     */
    public void setTextId(java.lang.String textId) {
        this.textId = textId;
    }


    /**
     * Gets the langu value for this Bapisdtext.
     * 
     * @return langu
     */
    public java.lang.String getLangu() {
        return langu;
    }


    /**
     * Sets the langu value for this Bapisdtext.
     * 
     * @param langu
     */
    public void setLangu(java.lang.String langu) {
        this.langu = langu;
    }


    /**
     * Gets the languIso value for this Bapisdtext.
     * 
     * @return languIso
     */
    public java.lang.String getLanguIso() {
        return languIso;
    }


    /**
     * Sets the languIso value for this Bapisdtext.
     * 
     * @param languIso
     */
    public void setLanguIso(java.lang.String languIso) {
        this.languIso = languIso;
    }


    /**
     * Gets the formatCol value for this Bapisdtext.
     * 
     * @return formatCol
     */
    public java.lang.String getFormatCol() {
        return formatCol;
    }


    /**
     * Sets the formatCol value for this Bapisdtext.
     * 
     * @param formatCol
     */
    public void setFormatCol(java.lang.String formatCol) {
        this.formatCol = formatCol;
    }


    /**
     * Gets the textLine value for this Bapisdtext.
     * 
     * @return textLine
     */
    public java.lang.String getTextLine() {
        return textLine;
    }


    /**
     * Sets the textLine value for this Bapisdtext.
     * 
     * @param textLine
     */
    public void setTextLine(java.lang.String textLine) {
        this.textLine = textLine;
    }


    /**
     * Gets the function value for this Bapisdtext.
     * 
     * @return function
     */
    public java.lang.String getFunction() {
        return function;
    }


    /**
     * Sets the function value for this Bapisdtext.
     * 
     * @param function
     */
    public void setFunction(java.lang.String function) {
        this.function = function;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapisdtext)) return false;
        Bapisdtext other = (Bapisdtext) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.docNumber==null && other.getDocNumber()==null) || 
             (this.docNumber!=null &&
              this.docNumber.equals(other.getDocNumber()))) &&
            ((this.itmNumber==null && other.getItmNumber()==null) || 
             (this.itmNumber!=null &&
              this.itmNumber.equals(other.getItmNumber()))) &&
            ((this.textId==null && other.getTextId()==null) || 
             (this.textId!=null &&
              this.textId.equals(other.getTextId()))) &&
            ((this.langu==null && other.getLangu()==null) || 
             (this.langu!=null &&
              this.langu.equals(other.getLangu()))) &&
            ((this.languIso==null && other.getLanguIso()==null) || 
             (this.languIso!=null &&
              this.languIso.equals(other.getLanguIso()))) &&
            ((this.formatCol==null && other.getFormatCol()==null) || 
             (this.formatCol!=null &&
              this.formatCol.equals(other.getFormatCol()))) &&
            ((this.textLine==null && other.getTextLine()==null) || 
             (this.textLine!=null &&
              this.textLine.equals(other.getTextLine()))) &&
            ((this.function==null && other.getFunction()==null) || 
             (this.function!=null &&
              this.function.equals(other.getFunction())));
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
        if (getDocNumber() != null) {
            _hashCode += getDocNumber().hashCode();
        }
        if (getItmNumber() != null) {
            _hashCode += getItmNumber().hashCode();
        }
        if (getTextId() != null) {
            _hashCode += getTextId().hashCode();
        }
        if (getLangu() != null) {
            _hashCode += getLangu().hashCode();
        }
        if (getLanguIso() != null) {
            _hashCode += getLanguIso().hashCode();
        }
        if (getFormatCol() != null) {
            _hashCode += getFormatCol().hashCode();
        }
        if (getTextLine() != null) {
            _hashCode += getTextLine().hashCode();
        }
        if (getFunction() != null) {
            _hashCode += getFunction().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapisdtext.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapisdtext"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DocNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itmNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ItmNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("textId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TextId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("langu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Langu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("languIso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LanguIso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formatCol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FormatCol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("textLine");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TextLine"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("function");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Function"));
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
