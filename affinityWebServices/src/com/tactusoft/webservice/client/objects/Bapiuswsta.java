/**
 * Bapiuswsta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

public class Bapiuswsta  implements java.io.Serializable {
    private java.lang.String objtype;

    private java.lang.String objid;

    private org.apache.axis.types.UnsignedByte service;

    private java.lang.String state;

    private java.lang.String uiddate;

    private java.lang.String validto;

    private org.apache.axis.types.UnsignedByte lcnt;

    private java.lang.String ldate;

    private java.lang.String ltime;

    private java.lang.String updpass;

    public Bapiuswsta() {
    }

    public Bapiuswsta(
           java.lang.String objtype,
           java.lang.String objid,
           org.apache.axis.types.UnsignedByte service,
           java.lang.String state,
           java.lang.String uiddate,
           java.lang.String validto,
           org.apache.axis.types.UnsignedByte lcnt,
           java.lang.String ldate,
           java.lang.String ltime,
           java.lang.String updpass) {
           this.objtype = objtype;
           this.objid = objid;
           this.service = service;
           this.state = state;
           this.uiddate = uiddate;
           this.validto = validto;
           this.lcnt = lcnt;
           this.ldate = ldate;
           this.ltime = ltime;
           this.updpass = updpass;
    }


    /**
     * Gets the objtype value for this Bapiuswsta.
     * 
     * @return objtype
     */
    public java.lang.String getObjtype() {
        return objtype;
    }


    /**
     * Sets the objtype value for this Bapiuswsta.
     * 
     * @param objtype
     */
    public void setObjtype(java.lang.String objtype) {
        this.objtype = objtype;
    }


    /**
     * Gets the objid value for this Bapiuswsta.
     * 
     * @return objid
     */
    public java.lang.String getObjid() {
        return objid;
    }


    /**
     * Sets the objid value for this Bapiuswsta.
     * 
     * @param objid
     */
    public void setObjid(java.lang.String objid) {
        this.objid = objid;
    }


    /**
     * Gets the service value for this Bapiuswsta.
     * 
     * @return service
     */
    public org.apache.axis.types.UnsignedByte getService() {
        return service;
    }


    /**
     * Sets the service value for this Bapiuswsta.
     * 
     * @param service
     */
    public void setService(org.apache.axis.types.UnsignedByte service) {
        this.service = service;
    }


    /**
     * Gets the state value for this Bapiuswsta.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this Bapiuswsta.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the uiddate value for this Bapiuswsta.
     * 
     * @return uiddate
     */
    public java.lang.String getUiddate() {
        return uiddate;
    }


    /**
     * Sets the uiddate value for this Bapiuswsta.
     * 
     * @param uiddate
     */
    public void setUiddate(java.lang.String uiddate) {
        this.uiddate = uiddate;
    }


    /**
     * Gets the validto value for this Bapiuswsta.
     * 
     * @return validto
     */
    public java.lang.String getValidto() {
        return validto;
    }


    /**
     * Sets the validto value for this Bapiuswsta.
     * 
     * @param validto
     */
    public void setValidto(java.lang.String validto) {
        this.validto = validto;
    }


    /**
     * Gets the lcnt value for this Bapiuswsta.
     * 
     * @return lcnt
     */
    public org.apache.axis.types.UnsignedByte getLcnt() {
        return lcnt;
    }


    /**
     * Sets the lcnt value for this Bapiuswsta.
     * 
     * @param lcnt
     */
    public void setLcnt(org.apache.axis.types.UnsignedByte lcnt) {
        this.lcnt = lcnt;
    }


    /**
     * Gets the ldate value for this Bapiuswsta.
     * 
     * @return ldate
     */
    public java.lang.String getLdate() {
        return ldate;
    }


    /**
     * Sets the ldate value for this Bapiuswsta.
     * 
     * @param ldate
     */
    public void setLdate(java.lang.String ldate) {
        this.ldate = ldate;
    }


    /**
     * Gets the ltime value for this Bapiuswsta.
     * 
     * @return ltime
     */
    public java.lang.String getLtime() {
        return ltime;
    }


    /**
     * Sets the ltime value for this Bapiuswsta.
     * 
     * @param ltime
     */
    public void setLtime(java.lang.String ltime) {
        this.ltime = ltime;
    }


    /**
     * Gets the updpass value for this Bapiuswsta.
     * 
     * @return updpass
     */
    public java.lang.String getUpdpass() {
        return updpass;
    }


    /**
     * Sets the updpass value for this Bapiuswsta.
     * 
     * @param updpass
     */
    public void setUpdpass(java.lang.String updpass) {
        this.updpass = updpass;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapiuswsta)) return false;
        Bapiuswsta other = (Bapiuswsta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.objtype==null && other.getObjtype()==null) || 
             (this.objtype!=null &&
              this.objtype.equals(other.getObjtype()))) &&
            ((this.objid==null && other.getObjid()==null) || 
             (this.objid!=null &&
              this.objid.equals(other.getObjid()))) &&
            ((this.service==null && other.getService()==null) || 
             (this.service!=null &&
              this.service.equals(other.getService()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.uiddate==null && other.getUiddate()==null) || 
             (this.uiddate!=null &&
              this.uiddate.equals(other.getUiddate()))) &&
            ((this.validto==null && other.getValidto()==null) || 
             (this.validto!=null &&
              this.validto.equals(other.getValidto()))) &&
            ((this.lcnt==null && other.getLcnt()==null) || 
             (this.lcnt!=null &&
              this.lcnt.equals(other.getLcnt()))) &&
            ((this.ldate==null && other.getLdate()==null) || 
             (this.ldate!=null &&
              this.ldate.equals(other.getLdate()))) &&
            ((this.ltime==null && other.getLtime()==null) || 
             (this.ltime!=null &&
              this.ltime.equals(other.getLtime()))) &&
            ((this.updpass==null && other.getUpdpass()==null) || 
             (this.updpass!=null &&
              this.updpass.equals(other.getUpdpass())));
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
        if (getObjtype() != null) {
            _hashCode += getObjtype().hashCode();
        }
        if (getObjid() != null) {
            _hashCode += getObjid().hashCode();
        }
        if (getService() != null) {
            _hashCode += getService().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getUiddate() != null) {
            _hashCode += getUiddate().hashCode();
        }
        if (getValidto() != null) {
            _hashCode += getValidto().hashCode();
        }
        if (getLcnt() != null) {
            _hashCode += getLcnt().hashCode();
        }
        if (getLdate() != null) {
            _hashCode += getLdate().hashCode();
        }
        if (getLtime() != null) {
            _hashCode += getLtime().hashCode();
        }
        if (getUpdpass() != null) {
            _hashCode += getUpdpass().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapiuswsta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiuswsta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objtype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Objtype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Objid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("service");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Service"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("", "State"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uiddate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Uiddate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Validto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lcnt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Lcnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ldate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Ldate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ltime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Ltime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updpass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Updpass"));
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
