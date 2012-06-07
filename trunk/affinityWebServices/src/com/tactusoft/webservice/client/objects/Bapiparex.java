/**
 * Bapiparex.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Bapiparex  implements java.io.Serializable {
    private java.lang.String structure;

    private java.lang.String valuepart1;

    private java.lang.String valuepart2;

    private java.lang.String valuepart3;

    private java.lang.String valuepart4;

    public Bapiparex() {
    }

    public Bapiparex(
           java.lang.String structure,
           java.lang.String valuepart1,
           java.lang.String valuepart2,
           java.lang.String valuepart3,
           java.lang.String valuepart4) {
           this.structure = structure;
           this.valuepart1 = valuepart1;
           this.valuepart2 = valuepart2;
           this.valuepart3 = valuepart3;
           this.valuepart4 = valuepart4;
    }


    /**
     * Gets the structure value for this Bapiparex.
     * 
     * @return structure
     */
    public java.lang.String getStructure() {
        return structure;
    }


    /**
     * Sets the structure value for this Bapiparex.
     * 
     * @param structure
     */
    public void setStructure(java.lang.String structure) {
        this.structure = structure;
    }


    /**
     * Gets the valuepart1 value for this Bapiparex.
     * 
     * @return valuepart1
     */
    public java.lang.String getValuepart1() {
        return valuepart1;
    }


    /**
     * Sets the valuepart1 value for this Bapiparex.
     * 
     * @param valuepart1
     */
    public void setValuepart1(java.lang.String valuepart1) {
        this.valuepart1 = valuepart1;
    }


    /**
     * Gets the valuepart2 value for this Bapiparex.
     * 
     * @return valuepart2
     */
    public java.lang.String getValuepart2() {
        return valuepart2;
    }


    /**
     * Sets the valuepart2 value for this Bapiparex.
     * 
     * @param valuepart2
     */
    public void setValuepart2(java.lang.String valuepart2) {
        this.valuepart2 = valuepart2;
    }


    /**
     * Gets the valuepart3 value for this Bapiparex.
     * 
     * @return valuepart3
     */
    public java.lang.String getValuepart3() {
        return valuepart3;
    }


    /**
     * Sets the valuepart3 value for this Bapiparex.
     * 
     * @param valuepart3
     */
    public void setValuepart3(java.lang.String valuepart3) {
        this.valuepart3 = valuepart3;
    }


    /**
     * Gets the valuepart4 value for this Bapiparex.
     * 
     * @return valuepart4
     */
    public java.lang.String getValuepart4() {
        return valuepart4;
    }


    /**
     * Sets the valuepart4 value for this Bapiparex.
     * 
     * @param valuepart4
     */
    public void setValuepart4(java.lang.String valuepart4) {
        this.valuepart4 = valuepart4;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapiparex)) return false;
        Bapiparex other = (Bapiparex) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.structure==null && other.getStructure()==null) || 
             (this.structure!=null &&
              this.structure.equals(other.getStructure()))) &&
            ((this.valuepart1==null && other.getValuepart1()==null) || 
             (this.valuepart1!=null &&
              this.valuepart1.equals(other.getValuepart1()))) &&
            ((this.valuepart2==null && other.getValuepart2()==null) || 
             (this.valuepart2!=null &&
              this.valuepart2.equals(other.getValuepart2()))) &&
            ((this.valuepart3==null && other.getValuepart3()==null) || 
             (this.valuepart3!=null &&
              this.valuepart3.equals(other.getValuepart3()))) &&
            ((this.valuepart4==null && other.getValuepart4()==null) || 
             (this.valuepart4!=null &&
              this.valuepart4.equals(other.getValuepart4())));
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
        if (getStructure() != null) {
            _hashCode += getStructure().hashCode();
        }
        if (getValuepart1() != null) {
            _hashCode += getValuepart1().hashCode();
        }
        if (getValuepart2() != null) {
            _hashCode += getValuepart2().hashCode();
        }
        if (getValuepart3() != null) {
            _hashCode += getValuepart3().hashCode();
        }
        if (getValuepart4() != null) {
            _hashCode += getValuepart4().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapiparex.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiparex"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("structure");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Structure"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valuepart1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Valuepart1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valuepart2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Valuepart2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valuepart3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Valuepart3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valuepart4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Valuepart4"));
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
