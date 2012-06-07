/**
 * Fknvl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Fknvl  implements java.io.Serializable {
    private java.lang.String mandt;

    private java.lang.String kunnr;

    private java.lang.String aland;

    private java.lang.String tatyp;

    private java.lang.String licnr;

    private java.lang.String datab;

    private java.lang.String datbi;

    private java.lang.String belic;

    private java.lang.String kz;

    public Fknvl() {
    }

    public Fknvl(
           java.lang.String mandt,
           java.lang.String kunnr,
           java.lang.String aland,
           java.lang.String tatyp,
           java.lang.String licnr,
           java.lang.String datab,
           java.lang.String datbi,
           java.lang.String belic,
           java.lang.String kz) {
           this.mandt = mandt;
           this.kunnr = kunnr;
           this.aland = aland;
           this.tatyp = tatyp;
           this.licnr = licnr;
           this.datab = datab;
           this.datbi = datbi;
           this.belic = belic;
           this.kz = kz;
    }


    /**
     * Gets the mandt value for this Fknvl.
     * 
     * @return mandt
     */
    public java.lang.String getMandt() {
        return mandt;
    }


    /**
     * Sets the mandt value for this Fknvl.
     * 
     * @param mandt
     */
    public void setMandt(java.lang.String mandt) {
        this.mandt = mandt;
    }


    /**
     * Gets the kunnr value for this Fknvl.
     * 
     * @return kunnr
     */
    public java.lang.String getKunnr() {
        return kunnr;
    }


    /**
     * Sets the kunnr value for this Fknvl.
     * 
     * @param kunnr
     */
    public void setKunnr(java.lang.String kunnr) {
        this.kunnr = kunnr;
    }


    /**
     * Gets the aland value for this Fknvl.
     * 
     * @return aland
     */
    public java.lang.String getAland() {
        return aland;
    }


    /**
     * Sets the aland value for this Fknvl.
     * 
     * @param aland
     */
    public void setAland(java.lang.String aland) {
        this.aland = aland;
    }


    /**
     * Gets the tatyp value for this Fknvl.
     * 
     * @return tatyp
     */
    public java.lang.String getTatyp() {
        return tatyp;
    }


    /**
     * Sets the tatyp value for this Fknvl.
     * 
     * @param tatyp
     */
    public void setTatyp(java.lang.String tatyp) {
        this.tatyp = tatyp;
    }


    /**
     * Gets the licnr value for this Fknvl.
     * 
     * @return licnr
     */
    public java.lang.String getLicnr() {
        return licnr;
    }


    /**
     * Sets the licnr value for this Fknvl.
     * 
     * @param licnr
     */
    public void setLicnr(java.lang.String licnr) {
        this.licnr = licnr;
    }


    /**
     * Gets the datab value for this Fknvl.
     * 
     * @return datab
     */
    public java.lang.String getDatab() {
        return datab;
    }


    /**
     * Sets the datab value for this Fknvl.
     * 
     * @param datab
     */
    public void setDatab(java.lang.String datab) {
        this.datab = datab;
    }


    /**
     * Gets the datbi value for this Fknvl.
     * 
     * @return datbi
     */
    public java.lang.String getDatbi() {
        return datbi;
    }


    /**
     * Sets the datbi value for this Fknvl.
     * 
     * @param datbi
     */
    public void setDatbi(java.lang.String datbi) {
        this.datbi = datbi;
    }


    /**
     * Gets the belic value for this Fknvl.
     * 
     * @return belic
     */
    public java.lang.String getBelic() {
        return belic;
    }


    /**
     * Sets the belic value for this Fknvl.
     * 
     * @param belic
     */
    public void setBelic(java.lang.String belic) {
        this.belic = belic;
    }


    /**
     * Gets the kz value for this Fknvl.
     * 
     * @return kz
     */
    public java.lang.String getKz() {
        return kz;
    }


    /**
     * Sets the kz value for this Fknvl.
     * 
     * @param kz
     */
    public void setKz(java.lang.String kz) {
        this.kz = kz;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Fknvl)) return false;
        Fknvl other = (Fknvl) obj;
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
            ((this.licnr==null && other.getLicnr()==null) || 
             (this.licnr!=null &&
              this.licnr.equals(other.getLicnr()))) &&
            ((this.datab==null && other.getDatab()==null) || 
             (this.datab!=null &&
              this.datab.equals(other.getDatab()))) &&
            ((this.datbi==null && other.getDatbi()==null) || 
             (this.datbi!=null &&
              this.datbi.equals(other.getDatbi()))) &&
            ((this.belic==null && other.getBelic()==null) || 
             (this.belic!=null &&
              this.belic.equals(other.getBelic()))) &&
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
        if (getLicnr() != null) {
            _hashCode += getLicnr().hashCode();
        }
        if (getDatab() != null) {
            _hashCode += getDatab().hashCode();
        }
        if (getDatbi() != null) {
            _hashCode += getDatbi().hashCode();
        }
        if (getBelic() != null) {
            _hashCode += getBelic().hashCode();
        }
        if (getKz() != null) {
            _hashCode += getKz().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Fknvl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Fknvl"));
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
        elemField.setFieldName("licnr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Licnr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datab");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Datab"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datbi");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Datbi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("belic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Belic"));
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
