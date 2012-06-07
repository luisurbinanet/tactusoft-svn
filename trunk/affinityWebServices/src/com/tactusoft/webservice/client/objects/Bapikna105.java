/**
 * Bapikna105.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Bapikna105  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String transpzone;

    private java.lang.String controlAccount;

    private java.lang.String pmnttrms;

    private java.lang.String shipCond;

    private java.lang.String delygPlnt;

    private java.lang.String partDlv;

    private java.lang.String CCtrArea;

    private java.lang.String taxjurcode;

    public Bapikna105() {
    }

    public Bapikna105(
           java.lang.String transpzone,
           java.lang.String controlAccount,
           java.lang.String pmnttrms,
           java.lang.String shipCond,
           java.lang.String delygPlnt,
           java.lang.String partDlv,
           java.lang.String CCtrArea,
           java.lang.String taxjurcode) {
           this.transpzone = transpzone;
           this.controlAccount = controlAccount;
           this.pmnttrms = pmnttrms;
           this.shipCond = shipCond;
           this.delygPlnt = delygPlnt;
           this.partDlv = partDlv;
           this.CCtrArea = CCtrArea;
           this.taxjurcode = taxjurcode;
    }


    /**
     * Gets the transpzone value for this Bapikna105.
     * 
     * @return transpzone
     */
    public java.lang.String getTranspzone() {
        return transpzone;
    }


    /**
     * Sets the transpzone value for this Bapikna105.
     * 
     * @param transpzone
     */
    public void setTranspzone(java.lang.String transpzone) {
        this.transpzone = transpzone;
    }


    /**
     * Gets the controlAccount value for this Bapikna105.
     * 
     * @return controlAccount
     */
    public java.lang.String getControlAccount() {
        return controlAccount;
    }


    /**
     * Sets the controlAccount value for this Bapikna105.
     * 
     * @param controlAccount
     */
    public void setControlAccount(java.lang.String controlAccount) {
        this.controlAccount = controlAccount;
    }


    /**
     * Gets the pmnttrms value for this Bapikna105.
     * 
     * @return pmnttrms
     */
    public java.lang.String getPmnttrms() {
        return pmnttrms;
    }


    /**
     * Sets the pmnttrms value for this Bapikna105.
     * 
     * @param pmnttrms
     */
    public void setPmnttrms(java.lang.String pmnttrms) {
        this.pmnttrms = pmnttrms;
    }


    /**
     * Gets the shipCond value for this Bapikna105.
     * 
     * @return shipCond
     */
    public java.lang.String getShipCond() {
        return shipCond;
    }


    /**
     * Sets the shipCond value for this Bapikna105.
     * 
     * @param shipCond
     */
    public void setShipCond(java.lang.String shipCond) {
        this.shipCond = shipCond;
    }


    /**
     * Gets the delygPlnt value for this Bapikna105.
     * 
     * @return delygPlnt
     */
    public java.lang.String getDelygPlnt() {
        return delygPlnt;
    }


    /**
     * Sets the delygPlnt value for this Bapikna105.
     * 
     * @param delygPlnt
     */
    public void setDelygPlnt(java.lang.String delygPlnt) {
        this.delygPlnt = delygPlnt;
    }


    /**
     * Gets the partDlv value for this Bapikna105.
     * 
     * @return partDlv
     */
    public java.lang.String getPartDlv() {
        return partDlv;
    }


    /**
     * Sets the partDlv value for this Bapikna105.
     * 
     * @param partDlv
     */
    public void setPartDlv(java.lang.String partDlv) {
        this.partDlv = partDlv;
    }


    /**
     * Gets the CCtrArea value for this Bapikna105.
     * 
     * @return CCtrArea
     */
    public java.lang.String getCCtrArea() {
        return CCtrArea;
    }


    /**
     * Sets the CCtrArea value for this Bapikna105.
     * 
     * @param CCtrArea
     */
    public void setCCtrArea(java.lang.String CCtrArea) {
        this.CCtrArea = CCtrArea;
    }


    /**
     * Gets the taxjurcode value for this Bapikna105.
     * 
     * @return taxjurcode
     */
    public java.lang.String getTaxjurcode() {
        return taxjurcode;
    }


    /**
     * Sets the taxjurcode value for this Bapikna105.
     * 
     * @param taxjurcode
     */
    public void setTaxjurcode(java.lang.String taxjurcode) {
        this.taxjurcode = taxjurcode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapikna105)) return false;
        Bapikna105 other = (Bapikna105) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.transpzone==null && other.getTranspzone()==null) || 
             (this.transpzone!=null &&
              this.transpzone.equals(other.getTranspzone()))) &&
            ((this.controlAccount==null && other.getControlAccount()==null) || 
             (this.controlAccount!=null &&
              this.controlAccount.equals(other.getControlAccount()))) &&
            ((this.pmnttrms==null && other.getPmnttrms()==null) || 
             (this.pmnttrms!=null &&
              this.pmnttrms.equals(other.getPmnttrms()))) &&
            ((this.shipCond==null && other.getShipCond()==null) || 
             (this.shipCond!=null &&
              this.shipCond.equals(other.getShipCond()))) &&
            ((this.delygPlnt==null && other.getDelygPlnt()==null) || 
             (this.delygPlnt!=null &&
              this.delygPlnt.equals(other.getDelygPlnt()))) &&
            ((this.partDlv==null && other.getPartDlv()==null) || 
             (this.partDlv!=null &&
              this.partDlv.equals(other.getPartDlv()))) &&
            ((this.CCtrArea==null && other.getCCtrArea()==null) || 
             (this.CCtrArea!=null &&
              this.CCtrArea.equals(other.getCCtrArea()))) &&
            ((this.taxjurcode==null && other.getTaxjurcode()==null) || 
             (this.taxjurcode!=null &&
              this.taxjurcode.equals(other.getTaxjurcode())));
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
        if (getTranspzone() != null) {
            _hashCode += getTranspzone().hashCode();
        }
        if (getControlAccount() != null) {
            _hashCode += getControlAccount().hashCode();
        }
        if (getPmnttrms() != null) {
            _hashCode += getPmnttrms().hashCode();
        }
        if (getShipCond() != null) {
            _hashCode += getShipCond().hashCode();
        }
        if (getDelygPlnt() != null) {
            _hashCode += getDelygPlnt().hashCode();
        }
        if (getPartDlv() != null) {
            _hashCode += getPartDlv().hashCode();
        }
        if (getCCtrArea() != null) {
            _hashCode += getCCtrArea().hashCode();
        }
        if (getTaxjurcode() != null) {
            _hashCode += getTaxjurcode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapikna105.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapikna105"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transpzone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Transpzone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("controlAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ControlAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pmnttrms");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Pmnttrms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shipCond");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ShipCond"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("delygPlnt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DelygPlnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partDlv");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PartDlv"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CCtrArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CCtrArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxjurcode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Taxjurcode"));
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
