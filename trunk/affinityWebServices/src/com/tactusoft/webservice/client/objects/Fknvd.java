/**
 * Fknvd.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Fknvd  implements java.io.Serializable {
    private java.lang.String mandt;

    private java.lang.String kunnr;

    private java.lang.String vkorg;

    private java.lang.String vtweg;

    private java.lang.String spart;

    private java.lang.String doctp;

    private java.lang.String spras;

    private java.math.BigDecimal doanz;

    private java.lang.String dover;

    private java.lang.String nacha;

    private java.lang.String kz;

    public Fknvd() {
    }

    public Fknvd(
           java.lang.String mandt,
           java.lang.String kunnr,
           java.lang.String vkorg,
           java.lang.String vtweg,
           java.lang.String spart,
           java.lang.String doctp,
           java.lang.String spras,
           java.math.BigDecimal doanz,
           java.lang.String dover,
           java.lang.String nacha,
           java.lang.String kz) {
           this.mandt = mandt;
           this.kunnr = kunnr;
           this.vkorg = vkorg;
           this.vtweg = vtweg;
           this.spart = spart;
           this.doctp = doctp;
           this.spras = spras;
           this.doanz = doanz;
           this.dover = dover;
           this.nacha = nacha;
           this.kz = kz;
    }


    /**
     * Gets the mandt value for this Fknvd.
     * 
     * @return mandt
     */
    public java.lang.String getMandt() {
        return mandt;
    }


    /**
     * Sets the mandt value for this Fknvd.
     * 
     * @param mandt
     */
    public void setMandt(java.lang.String mandt) {
        this.mandt = mandt;
    }


    /**
     * Gets the kunnr value for this Fknvd.
     * 
     * @return kunnr
     */
    public java.lang.String getKunnr() {
        return kunnr;
    }


    /**
     * Sets the kunnr value for this Fknvd.
     * 
     * @param kunnr
     */
    public void setKunnr(java.lang.String kunnr) {
        this.kunnr = kunnr;
    }


    /**
     * Gets the vkorg value for this Fknvd.
     * 
     * @return vkorg
     */
    public java.lang.String getVkorg() {
        return vkorg;
    }


    /**
     * Sets the vkorg value for this Fknvd.
     * 
     * @param vkorg
     */
    public void setVkorg(java.lang.String vkorg) {
        this.vkorg = vkorg;
    }


    /**
     * Gets the vtweg value for this Fknvd.
     * 
     * @return vtweg
     */
    public java.lang.String getVtweg() {
        return vtweg;
    }


    /**
     * Sets the vtweg value for this Fknvd.
     * 
     * @param vtweg
     */
    public void setVtweg(java.lang.String vtweg) {
        this.vtweg = vtweg;
    }


    /**
     * Gets the spart value for this Fknvd.
     * 
     * @return spart
     */
    public java.lang.String getSpart() {
        return spart;
    }


    /**
     * Sets the spart value for this Fknvd.
     * 
     * @param spart
     */
    public void setSpart(java.lang.String spart) {
        this.spart = spart;
    }


    /**
     * Gets the doctp value for this Fknvd.
     * 
     * @return doctp
     */
    public java.lang.String getDoctp() {
        return doctp;
    }


    /**
     * Sets the doctp value for this Fknvd.
     * 
     * @param doctp
     */
    public void setDoctp(java.lang.String doctp) {
        this.doctp = doctp;
    }


    /**
     * Gets the spras value for this Fknvd.
     * 
     * @return spras
     */
    public java.lang.String getSpras() {
        return spras;
    }


    /**
     * Sets the spras value for this Fknvd.
     * 
     * @param spras
     */
    public void setSpras(java.lang.String spras) {
        this.spras = spras;
    }


    /**
     * Gets the doanz value for this Fknvd.
     * 
     * @return doanz
     */
    public java.math.BigDecimal getDoanz() {
        return doanz;
    }


    /**
     * Sets the doanz value for this Fknvd.
     * 
     * @param doanz
     */
    public void setDoanz(java.math.BigDecimal doanz) {
        this.doanz = doanz;
    }


    /**
     * Gets the dover value for this Fknvd.
     * 
     * @return dover
     */
    public java.lang.String getDover() {
        return dover;
    }


    /**
     * Sets the dover value for this Fknvd.
     * 
     * @param dover
     */
    public void setDover(java.lang.String dover) {
        this.dover = dover;
    }


    /**
     * Gets the nacha value for this Fknvd.
     * 
     * @return nacha
     */
    public java.lang.String getNacha() {
        return nacha;
    }


    /**
     * Sets the nacha value for this Fknvd.
     * 
     * @param nacha
     */
    public void setNacha(java.lang.String nacha) {
        this.nacha = nacha;
    }


    /**
     * Gets the kz value for this Fknvd.
     * 
     * @return kz
     */
    public java.lang.String getKz() {
        return kz;
    }


    /**
     * Sets the kz value for this Fknvd.
     * 
     * @param kz
     */
    public void setKz(java.lang.String kz) {
        this.kz = kz;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Fknvd)) return false;
        Fknvd other = (Fknvd) obj;
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
            ((this.vkorg==null && other.getVkorg()==null) || 
             (this.vkorg!=null &&
              this.vkorg.equals(other.getVkorg()))) &&
            ((this.vtweg==null && other.getVtweg()==null) || 
             (this.vtweg!=null &&
              this.vtweg.equals(other.getVtweg()))) &&
            ((this.spart==null && other.getSpart()==null) || 
             (this.spart!=null &&
              this.spart.equals(other.getSpart()))) &&
            ((this.doctp==null && other.getDoctp()==null) || 
             (this.doctp!=null &&
              this.doctp.equals(other.getDoctp()))) &&
            ((this.spras==null && other.getSpras()==null) || 
             (this.spras!=null &&
              this.spras.equals(other.getSpras()))) &&
            ((this.doanz==null && other.getDoanz()==null) || 
             (this.doanz!=null &&
              this.doanz.equals(other.getDoanz()))) &&
            ((this.dover==null && other.getDover()==null) || 
             (this.dover!=null &&
              this.dover.equals(other.getDover()))) &&
            ((this.nacha==null && other.getNacha()==null) || 
             (this.nacha!=null &&
              this.nacha.equals(other.getNacha()))) &&
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
        if (getVkorg() != null) {
            _hashCode += getVkorg().hashCode();
        }
        if (getVtweg() != null) {
            _hashCode += getVtweg().hashCode();
        }
        if (getSpart() != null) {
            _hashCode += getSpart().hashCode();
        }
        if (getDoctp() != null) {
            _hashCode += getDoctp().hashCode();
        }
        if (getSpras() != null) {
            _hashCode += getSpras().hashCode();
        }
        if (getDoanz() != null) {
            _hashCode += getDoanz().hashCode();
        }
        if (getDover() != null) {
            _hashCode += getDover().hashCode();
        }
        if (getNacha() != null) {
            _hashCode += getNacha().hashCode();
        }
        if (getKz() != null) {
            _hashCode += getKz().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Fknvd.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Fknvd"));
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
        elemField.setFieldName("doctp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Doctp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("spras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Spras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("doanz");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Doanz"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dover");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Dover"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nacha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Nacha"));
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
