/**
 * Bapicondx.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

@SuppressWarnings({ "rawtypes", "unused" })
public class Bapicondx  implements java.io.Serializable {
    
	private static final long serialVersionUID = 1L;

	private java.lang.String itmNumber;

    private java.lang.String condStNo;

    private java.lang.String condCount;

    private java.lang.String condType;

    private java.lang.String updateflag;

    private java.lang.String condValue;

    private java.lang.String currency;

    private java.lang.String condUnit;

    private java.lang.String condPUnt;

    private java.lang.String varcond;

    public Bapicondx() {
    }

    public Bapicondx(
           java.lang.String itmNumber,
           java.lang.String condStNo,
           java.lang.String condCount,
           java.lang.String condType,
           java.lang.String updateflag,
           java.lang.String condValue,
           java.lang.String currency,
           java.lang.String condUnit,
           java.lang.String condPUnt,
           java.lang.String varcond) {
           this.itmNumber = itmNumber;
           this.condStNo = condStNo;
           this.condCount = condCount;
           this.condType = condType;
           this.updateflag = updateflag;
           this.condValue = condValue;
           this.currency = currency;
           this.condUnit = condUnit;
           this.condPUnt = condPUnt;
           this.varcond = varcond;
    }


    /**
     * Gets the itmNumber value for this Bapicondx.
     * 
     * @return itmNumber
     */
    public java.lang.String getItmNumber() {
        return itmNumber;
    }


    /**
     * Sets the itmNumber value for this Bapicondx.
     * 
     * @param itmNumber
     */
    public void setItmNumber(java.lang.String itmNumber) {
        this.itmNumber = itmNumber;
    }


    /**
     * Gets the condStNo value for this Bapicondx.
     * 
     * @return condStNo
     */
    public java.lang.String getCondStNo() {
        return condStNo;
    }


    /**
     * Sets the condStNo value for this Bapicondx.
     * 
     * @param condStNo
     */
    public void setCondStNo(java.lang.String condStNo) {
        this.condStNo = condStNo;
    }


    /**
     * Gets the condCount value for this Bapicondx.
     * 
     * @return condCount
     */
    public java.lang.String getCondCount() {
        return condCount;
    }


    /**
     * Sets the condCount value for this Bapicondx.
     * 
     * @param condCount
     */
    public void setCondCount(java.lang.String condCount) {
        this.condCount = condCount;
    }


    /**
     * Gets the condType value for this Bapicondx.
     * 
     * @return condType
     */
    public java.lang.String getCondType() {
        return condType;
    }


    /**
     * Sets the condType value for this Bapicondx.
     * 
     * @param condType
     */
    public void setCondType(java.lang.String condType) {
        this.condType = condType;
    }


    /**
     * Gets the updateflag value for this Bapicondx.
     * 
     * @return updateflag
     */
    public java.lang.String getUpdateflag() {
        return updateflag;
    }


    /**
     * Sets the updateflag value for this Bapicondx.
     * 
     * @param updateflag
     */
    public void setUpdateflag(java.lang.String updateflag) {
        this.updateflag = updateflag;
    }


    /**
     * Gets the condValue value for this Bapicondx.
     * 
     * @return condValue
     */
    public java.lang.String getCondValue() {
        return condValue;
    }


    /**
     * Sets the condValue value for this Bapicondx.
     * 
     * @param condValue
     */
    public void setCondValue(java.lang.String condValue) {
        this.condValue = condValue;
    }


    /**
     * Gets the currency value for this Bapicondx.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Bapicondx.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the condUnit value for this Bapicondx.
     * 
     * @return condUnit
     */
    public java.lang.String getCondUnit() {
        return condUnit;
    }


    /**
     * Sets the condUnit value for this Bapicondx.
     * 
     * @param condUnit
     */
    public void setCondUnit(java.lang.String condUnit) {
        this.condUnit = condUnit;
    }


    /**
     * Gets the condPUnt value for this Bapicondx.
     * 
     * @return condPUnt
     */
    public java.lang.String getCondPUnt() {
        return condPUnt;
    }


    /**
     * Sets the condPUnt value for this Bapicondx.
     * 
     * @param condPUnt
     */
    public void setCondPUnt(java.lang.String condPUnt) {
        this.condPUnt = condPUnt;
    }


    /**
     * Gets the varcond value for this Bapicondx.
     * 
     * @return varcond
     */
    public java.lang.String getVarcond() {
        return varcond;
    }


    /**
     * Sets the varcond value for this Bapicondx.
     * 
     * @param varcond
     */
    public void setVarcond(java.lang.String varcond) {
        this.varcond = varcond;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapicondx)) return false;
        Bapicondx other = (Bapicondx) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.itmNumber==null && other.getItmNumber()==null) || 
             (this.itmNumber!=null &&
              this.itmNumber.equals(other.getItmNumber()))) &&
            ((this.condStNo==null && other.getCondStNo()==null) || 
             (this.condStNo!=null &&
              this.condStNo.equals(other.getCondStNo()))) &&
            ((this.condCount==null && other.getCondCount()==null) || 
             (this.condCount!=null &&
              this.condCount.equals(other.getCondCount()))) &&
            ((this.condType==null && other.getCondType()==null) || 
             (this.condType!=null &&
              this.condType.equals(other.getCondType()))) &&
            ((this.updateflag==null && other.getUpdateflag()==null) || 
             (this.updateflag!=null &&
              this.updateflag.equals(other.getUpdateflag()))) &&
            ((this.condValue==null && other.getCondValue()==null) || 
             (this.condValue!=null &&
              this.condValue.equals(other.getCondValue()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.condUnit==null && other.getCondUnit()==null) || 
             (this.condUnit!=null &&
              this.condUnit.equals(other.getCondUnit()))) &&
            ((this.condPUnt==null && other.getCondPUnt()==null) || 
             (this.condPUnt!=null &&
              this.condPUnt.equals(other.getCondPUnt()))) &&
            ((this.varcond==null && other.getVarcond()==null) || 
             (this.varcond!=null &&
              this.varcond.equals(other.getVarcond())));
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
        if (getItmNumber() != null) {
            _hashCode += getItmNumber().hashCode();
        }
        if (getCondStNo() != null) {
            _hashCode += getCondStNo().hashCode();
        }
        if (getCondCount() != null) {
            _hashCode += getCondCount().hashCode();
        }
        if (getCondType() != null) {
            _hashCode += getCondType().hashCode();
        }
        if (getUpdateflag() != null) {
            _hashCode += getUpdateflag().hashCode();
        }
        if (getCondValue() != null) {
            _hashCode += getCondValue().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getCondUnit() != null) {
            _hashCode += getCondUnit().hashCode();
        }
        if (getCondPUnt() != null) {
            _hashCode += getCondPUnt().hashCode();
        }
        if (getVarcond() != null) {
            _hashCode += getVarcond().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapicondx.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapicondx"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itmNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ItmNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condStNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CondStNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CondCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CondType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updateflag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Updateflag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CondValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condUnit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CondUnit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condPUnt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CondPUnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varcond");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Varcond"));
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
