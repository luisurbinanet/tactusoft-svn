/**
 * Bapicustomer02.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Bapicustomer02  implements java.io.Serializable {
    private java.lang.String customer;

    private java.lang.String bankCtry;

    private java.lang.String bankKey;

    private java.lang.String bankAcct;

    private java.lang.String ctrlKey;

    private java.lang.String partnerBk;

    private java.lang.String collAuth;

    private java.lang.String bankRef;

    public Bapicustomer02() {
    }

    public Bapicustomer02(
           java.lang.String customer,
           java.lang.String bankCtry,
           java.lang.String bankKey,
           java.lang.String bankAcct,
           java.lang.String ctrlKey,
           java.lang.String partnerBk,
           java.lang.String collAuth,
           java.lang.String bankRef) {
           this.customer = customer;
           this.bankCtry = bankCtry;
           this.bankKey = bankKey;
           this.bankAcct = bankAcct;
           this.ctrlKey = ctrlKey;
           this.partnerBk = partnerBk;
           this.collAuth = collAuth;
           this.bankRef = bankRef;
    }


    /**
     * Gets the customer value for this Bapicustomer02.
     * 
     * @return customer
     */
    public java.lang.String getCustomer() {
        return customer;
    }


    /**
     * Sets the customer value for this Bapicustomer02.
     * 
     * @param customer
     */
    public void setCustomer(java.lang.String customer) {
        this.customer = customer;
    }


    /**
     * Gets the bankCtry value for this Bapicustomer02.
     * 
     * @return bankCtry
     */
    public java.lang.String getBankCtry() {
        return bankCtry;
    }


    /**
     * Sets the bankCtry value for this Bapicustomer02.
     * 
     * @param bankCtry
     */
    public void setBankCtry(java.lang.String bankCtry) {
        this.bankCtry = bankCtry;
    }


    /**
     * Gets the bankKey value for this Bapicustomer02.
     * 
     * @return bankKey
     */
    public java.lang.String getBankKey() {
        return bankKey;
    }


    /**
     * Sets the bankKey value for this Bapicustomer02.
     * 
     * @param bankKey
     */
    public void setBankKey(java.lang.String bankKey) {
        this.bankKey = bankKey;
    }


    /**
     * Gets the bankAcct value for this Bapicustomer02.
     * 
     * @return bankAcct
     */
    public java.lang.String getBankAcct() {
        return bankAcct;
    }


    /**
     * Sets the bankAcct value for this Bapicustomer02.
     * 
     * @param bankAcct
     */
    public void setBankAcct(java.lang.String bankAcct) {
        this.bankAcct = bankAcct;
    }


    /**
     * Gets the ctrlKey value for this Bapicustomer02.
     * 
     * @return ctrlKey
     */
    public java.lang.String getCtrlKey() {
        return ctrlKey;
    }


    /**
     * Sets the ctrlKey value for this Bapicustomer02.
     * 
     * @param ctrlKey
     */
    public void setCtrlKey(java.lang.String ctrlKey) {
        this.ctrlKey = ctrlKey;
    }


    /**
     * Gets the partnerBk value for this Bapicustomer02.
     * 
     * @return partnerBk
     */
    public java.lang.String getPartnerBk() {
        return partnerBk;
    }


    /**
     * Sets the partnerBk value for this Bapicustomer02.
     * 
     * @param partnerBk
     */
    public void setPartnerBk(java.lang.String partnerBk) {
        this.partnerBk = partnerBk;
    }


    /**
     * Gets the collAuth value for this Bapicustomer02.
     * 
     * @return collAuth
     */
    public java.lang.String getCollAuth() {
        return collAuth;
    }


    /**
     * Sets the collAuth value for this Bapicustomer02.
     * 
     * @param collAuth
     */
    public void setCollAuth(java.lang.String collAuth) {
        this.collAuth = collAuth;
    }


    /**
     * Gets the bankRef value for this Bapicustomer02.
     * 
     * @return bankRef
     */
    public java.lang.String getBankRef() {
        return bankRef;
    }


    /**
     * Sets the bankRef value for this Bapicustomer02.
     * 
     * @param bankRef
     */
    public void setBankRef(java.lang.String bankRef) {
        this.bankRef = bankRef;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapicustomer02)) return false;
        Bapicustomer02 other = (Bapicustomer02) obj;
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
            ((this.bankCtry==null && other.getBankCtry()==null) || 
             (this.bankCtry!=null &&
              this.bankCtry.equals(other.getBankCtry()))) &&
            ((this.bankKey==null && other.getBankKey()==null) || 
             (this.bankKey!=null &&
              this.bankKey.equals(other.getBankKey()))) &&
            ((this.bankAcct==null && other.getBankAcct()==null) || 
             (this.bankAcct!=null &&
              this.bankAcct.equals(other.getBankAcct()))) &&
            ((this.ctrlKey==null && other.getCtrlKey()==null) || 
             (this.ctrlKey!=null &&
              this.ctrlKey.equals(other.getCtrlKey()))) &&
            ((this.partnerBk==null && other.getPartnerBk()==null) || 
             (this.partnerBk!=null &&
              this.partnerBk.equals(other.getPartnerBk()))) &&
            ((this.collAuth==null && other.getCollAuth()==null) || 
             (this.collAuth!=null &&
              this.collAuth.equals(other.getCollAuth()))) &&
            ((this.bankRef==null && other.getBankRef()==null) || 
             (this.bankRef!=null &&
              this.bankRef.equals(other.getBankRef())));
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
        if (getBankCtry() != null) {
            _hashCode += getBankCtry().hashCode();
        }
        if (getBankKey() != null) {
            _hashCode += getBankKey().hashCode();
        }
        if (getBankAcct() != null) {
            _hashCode += getBankAcct().hashCode();
        }
        if (getCtrlKey() != null) {
            _hashCode += getCtrlKey().hashCode();
        }
        if (getPartnerBk() != null) {
            _hashCode += getPartnerBk().hashCode();
        }
        if (getCollAuth() != null) {
            _hashCode += getCollAuth().hashCode();
        }
        if (getBankRef() != null) {
            _hashCode += getBankRef().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapicustomer02.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapicustomer02"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Customer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankCtry");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BankCtry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BankKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankAcct");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BankAcct"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctrlKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CtrlKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partnerBk");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PartnerBk"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("collAuth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CollAuth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankRef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BankRef"));
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
