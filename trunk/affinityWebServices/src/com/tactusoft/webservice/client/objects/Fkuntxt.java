/**
 * Fkuntxt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Fkuntxt  implements java.io.Serializable {
    private java.lang.String kunnr;

    private java.lang.String parnr;

    private java.lang.String bukrs;

    private java.lang.String vkorg;

    private java.lang.String vtweg;

    private java.lang.String spart;

    private java.lang.String updA;

    private java.lang.String updB;

    private java.lang.String updV;

    private java.lang.String updAp;

    public Fkuntxt() {
    }

    public Fkuntxt(
           java.lang.String kunnr,
           java.lang.String parnr,
           java.lang.String bukrs,
           java.lang.String vkorg,
           java.lang.String vtweg,
           java.lang.String spart,
           java.lang.String updA,
           java.lang.String updB,
           java.lang.String updV,
           java.lang.String updAp) {
           this.kunnr = kunnr;
           this.parnr = parnr;
           this.bukrs = bukrs;
           this.vkorg = vkorg;
           this.vtweg = vtweg;
           this.spart = spart;
           this.updA = updA;
           this.updB = updB;
           this.updV = updV;
           this.updAp = updAp;
    }


    /**
     * Gets the kunnr value for this Fkuntxt.
     * 
     * @return kunnr
     */
    public java.lang.String getKunnr() {
        return kunnr;
    }


    /**
     * Sets the kunnr value for this Fkuntxt.
     * 
     * @param kunnr
     */
    public void setKunnr(java.lang.String kunnr) {
        this.kunnr = kunnr;
    }


    /**
     * Gets the parnr value for this Fkuntxt.
     * 
     * @return parnr
     */
    public java.lang.String getParnr() {
        return parnr;
    }


    /**
     * Sets the parnr value for this Fkuntxt.
     * 
     * @param parnr
     */
    public void setParnr(java.lang.String parnr) {
        this.parnr = parnr;
    }


    /**
     * Gets the bukrs value for this Fkuntxt.
     * 
     * @return bukrs
     */
    public java.lang.String getBukrs() {
        return bukrs;
    }


    /**
     * Sets the bukrs value for this Fkuntxt.
     * 
     * @param bukrs
     */
    public void setBukrs(java.lang.String bukrs) {
        this.bukrs = bukrs;
    }


    /**
     * Gets the vkorg value for this Fkuntxt.
     * 
     * @return vkorg
     */
    public java.lang.String getVkorg() {
        return vkorg;
    }


    /**
     * Sets the vkorg value for this Fkuntxt.
     * 
     * @param vkorg
     */
    public void setVkorg(java.lang.String vkorg) {
        this.vkorg = vkorg;
    }


    /**
     * Gets the vtweg value for this Fkuntxt.
     * 
     * @return vtweg
     */
    public java.lang.String getVtweg() {
        return vtweg;
    }


    /**
     * Sets the vtweg value for this Fkuntxt.
     * 
     * @param vtweg
     */
    public void setVtweg(java.lang.String vtweg) {
        this.vtweg = vtweg;
    }


    /**
     * Gets the spart value for this Fkuntxt.
     * 
     * @return spart
     */
    public java.lang.String getSpart() {
        return spart;
    }


    /**
     * Sets the spart value for this Fkuntxt.
     * 
     * @param spart
     */
    public void setSpart(java.lang.String spart) {
        this.spart = spart;
    }


    /**
     * Gets the updA value for this Fkuntxt.
     * 
     * @return updA
     */
    public java.lang.String getUpdA() {
        return updA;
    }


    /**
     * Sets the updA value for this Fkuntxt.
     * 
     * @param updA
     */
    public void setUpdA(java.lang.String updA) {
        this.updA = updA;
    }


    /**
     * Gets the updB value for this Fkuntxt.
     * 
     * @return updB
     */
    public java.lang.String getUpdB() {
        return updB;
    }


    /**
     * Sets the updB value for this Fkuntxt.
     * 
     * @param updB
     */
    public void setUpdB(java.lang.String updB) {
        this.updB = updB;
    }


    /**
     * Gets the updV value for this Fkuntxt.
     * 
     * @return updV
     */
    public java.lang.String getUpdV() {
        return updV;
    }


    /**
     * Sets the updV value for this Fkuntxt.
     * 
     * @param updV
     */
    public void setUpdV(java.lang.String updV) {
        this.updV = updV;
    }


    /**
     * Gets the updAp value for this Fkuntxt.
     * 
     * @return updAp
     */
    public java.lang.String getUpdAp() {
        return updAp;
    }


    /**
     * Sets the updAp value for this Fkuntxt.
     * 
     * @param updAp
     */
    public void setUpdAp(java.lang.String updAp) {
        this.updAp = updAp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Fkuntxt)) return false;
        Fkuntxt other = (Fkuntxt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.kunnr==null && other.getKunnr()==null) || 
             (this.kunnr!=null &&
              this.kunnr.equals(other.getKunnr()))) &&
            ((this.parnr==null && other.getParnr()==null) || 
             (this.parnr!=null &&
              this.parnr.equals(other.getParnr()))) &&
            ((this.bukrs==null && other.getBukrs()==null) || 
             (this.bukrs!=null &&
              this.bukrs.equals(other.getBukrs()))) &&
            ((this.vkorg==null && other.getVkorg()==null) || 
             (this.vkorg!=null &&
              this.vkorg.equals(other.getVkorg()))) &&
            ((this.vtweg==null && other.getVtweg()==null) || 
             (this.vtweg!=null &&
              this.vtweg.equals(other.getVtweg()))) &&
            ((this.spart==null && other.getSpart()==null) || 
             (this.spart!=null &&
              this.spart.equals(other.getSpart()))) &&
            ((this.updA==null && other.getUpdA()==null) || 
             (this.updA!=null &&
              this.updA.equals(other.getUpdA()))) &&
            ((this.updB==null && other.getUpdB()==null) || 
             (this.updB!=null &&
              this.updB.equals(other.getUpdB()))) &&
            ((this.updV==null && other.getUpdV()==null) || 
             (this.updV!=null &&
              this.updV.equals(other.getUpdV()))) &&
            ((this.updAp==null && other.getUpdAp()==null) || 
             (this.updAp!=null &&
              this.updAp.equals(other.getUpdAp())));
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
        if (getKunnr() != null) {
            _hashCode += getKunnr().hashCode();
        }
        if (getParnr() != null) {
            _hashCode += getParnr().hashCode();
        }
        if (getBukrs() != null) {
            _hashCode += getBukrs().hashCode();
        }
        if (getVkorg() != null) {
            _hashCode += getVkorg().hashCode();
        }
        if (getVtweg() != null) {
            _hashCode += getVtweg().hashCode();
        }
        if (getSpart() != null) {
            _hashCode += getSpart().hashCode();
        }
        if (getUpdA() != null) {
            _hashCode += getUpdA().hashCode();
        }
        if (getUpdB() != null) {
            _hashCode += getUpdB().hashCode();
        }
        if (getUpdV() != null) {
            _hashCode += getUpdV().hashCode();
        }
        if (getUpdAp() != null) {
            _hashCode += getUpdAp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Fkuntxt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Fkuntxt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kunnr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Kunnr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parnr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Parnr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bukrs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Bukrs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vkorg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Vkorg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vtweg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Vtweg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("spart");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Spart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UpdA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updB");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UpdB"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updV");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UpdV"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updAp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UpdAp"));
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
