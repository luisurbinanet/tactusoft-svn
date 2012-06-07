/**
 * Bapisdls.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Bapisdls  implements java.io.Serializable {
    private java.lang.String pricing;

    private java.lang.String atpWrkmod;

    private java.lang.String scheduling;

    private java.lang.String nostructure;

    private java.lang.String condHandl;

    public Bapisdls() {
    }

    public Bapisdls(
           java.lang.String pricing,
           java.lang.String atpWrkmod,
           java.lang.String scheduling,
           java.lang.String nostructure,
           java.lang.String condHandl) {
           this.pricing = pricing;
           this.atpWrkmod = atpWrkmod;
           this.scheduling = scheduling;
           this.nostructure = nostructure;
           this.condHandl = condHandl;
    }


    /**
     * Gets the pricing value for this Bapisdls.
     * 
     * @return pricing
     */
    public java.lang.String getPricing() {
        return pricing;
    }


    /**
     * Sets the pricing value for this Bapisdls.
     * 
     * @param pricing
     */
    public void setPricing(java.lang.String pricing) {
        this.pricing = pricing;
    }


    /**
     * Gets the atpWrkmod value for this Bapisdls.
     * 
     * @return atpWrkmod
     */
    public java.lang.String getAtpWrkmod() {
        return atpWrkmod;
    }


    /**
     * Sets the atpWrkmod value for this Bapisdls.
     * 
     * @param atpWrkmod
     */
    public void setAtpWrkmod(java.lang.String atpWrkmod) {
        this.atpWrkmod = atpWrkmod;
    }


    /**
     * Gets the scheduling value for this Bapisdls.
     * 
     * @return scheduling
     */
    public java.lang.String getScheduling() {
        return scheduling;
    }


    /**
     * Sets the scheduling value for this Bapisdls.
     * 
     * @param scheduling
     */
    public void setScheduling(java.lang.String scheduling) {
        this.scheduling = scheduling;
    }


    /**
     * Gets the nostructure value for this Bapisdls.
     * 
     * @return nostructure
     */
    public java.lang.String getNostructure() {
        return nostructure;
    }


    /**
     * Sets the nostructure value for this Bapisdls.
     * 
     * @param nostructure
     */
    public void setNostructure(java.lang.String nostructure) {
        this.nostructure = nostructure;
    }


    /**
     * Gets the condHandl value for this Bapisdls.
     * 
     * @return condHandl
     */
    public java.lang.String getCondHandl() {
        return condHandl;
    }


    /**
     * Sets the condHandl value for this Bapisdls.
     * 
     * @param condHandl
     */
    public void setCondHandl(java.lang.String condHandl) {
        this.condHandl = condHandl;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapisdls)) return false;
        Bapisdls other = (Bapisdls) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pricing==null && other.getPricing()==null) || 
             (this.pricing!=null &&
              this.pricing.equals(other.getPricing()))) &&
            ((this.atpWrkmod==null && other.getAtpWrkmod()==null) || 
             (this.atpWrkmod!=null &&
              this.atpWrkmod.equals(other.getAtpWrkmod()))) &&
            ((this.scheduling==null && other.getScheduling()==null) || 
             (this.scheduling!=null &&
              this.scheduling.equals(other.getScheduling()))) &&
            ((this.nostructure==null && other.getNostructure()==null) || 
             (this.nostructure!=null &&
              this.nostructure.equals(other.getNostructure()))) &&
            ((this.condHandl==null && other.getCondHandl()==null) || 
             (this.condHandl!=null &&
              this.condHandl.equals(other.getCondHandl())));
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
        if (getPricing() != null) {
            _hashCode += getPricing().hashCode();
        }
        if (getAtpWrkmod() != null) {
            _hashCode += getAtpWrkmod().hashCode();
        }
        if (getScheduling() != null) {
            _hashCode += getScheduling().hashCode();
        }
        if (getNostructure() != null) {
            _hashCode += getNostructure().hashCode();
        }
        if (getCondHandl() != null) {
            _hashCode += getCondHandl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapisdls.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapisdls"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pricing");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Pricing"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("atpWrkmod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AtpWrkmod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduling");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Scheduling"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nostructure");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Nostructure"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condHandl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CondHandl"));
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
