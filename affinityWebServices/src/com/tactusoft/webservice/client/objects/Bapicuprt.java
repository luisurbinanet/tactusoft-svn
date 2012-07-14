/**
 * Bapicuprt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

@SuppressWarnings({ "rawtypes", "unused" })
public class Bapicuprt  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String configId;

    private java.lang.String parentId;

    private java.lang.String instId;

    private java.lang.String partOfNo;

    private java.lang.String objType;

    private java.lang.String classType;

    private java.lang.String objKey;

    private java.lang.String author;

    private java.lang.String salesRelevant;

    private java.lang.String partOfGuid;

    public Bapicuprt() {
    }

    public Bapicuprt(
           java.lang.String configId,
           java.lang.String parentId,
           java.lang.String instId,
           java.lang.String partOfNo,
           java.lang.String objType,
           java.lang.String classType,
           java.lang.String objKey,
           java.lang.String author,
           java.lang.String salesRelevant,
           java.lang.String partOfGuid) {
           this.configId = configId;
           this.parentId = parentId;
           this.instId = instId;
           this.partOfNo = partOfNo;
           this.objType = objType;
           this.classType = classType;
           this.objKey = objKey;
           this.author = author;
           this.salesRelevant = salesRelevant;
           this.partOfGuid = partOfGuid;
    }


    /**
     * Gets the configId value for this Bapicuprt.
     * 
     * @return configId
     */
    public java.lang.String getConfigId() {
        return configId;
    }


    /**
     * Sets the configId value for this Bapicuprt.
     * 
     * @param configId
     */
    public void setConfigId(java.lang.String configId) {
        this.configId = configId;
    }


    /**
     * Gets the parentId value for this Bapicuprt.
     * 
     * @return parentId
     */
    public java.lang.String getParentId() {
        return parentId;
    }


    /**
     * Sets the parentId value for this Bapicuprt.
     * 
     * @param parentId
     */
    public void setParentId(java.lang.String parentId) {
        this.parentId = parentId;
    }


    /**
     * Gets the instId value for this Bapicuprt.
     * 
     * @return instId
     */
    public java.lang.String getInstId() {
        return instId;
    }


    /**
     * Sets the instId value for this Bapicuprt.
     * 
     * @param instId
     */
    public void setInstId(java.lang.String instId) {
        this.instId = instId;
    }


    /**
     * Gets the partOfNo value for this Bapicuprt.
     * 
     * @return partOfNo
     */
    public java.lang.String getPartOfNo() {
        return partOfNo;
    }


    /**
     * Sets the partOfNo value for this Bapicuprt.
     * 
     * @param partOfNo
     */
    public void setPartOfNo(java.lang.String partOfNo) {
        this.partOfNo = partOfNo;
    }


    /**
     * Gets the objType value for this Bapicuprt.
     * 
     * @return objType
     */
    public java.lang.String getObjType() {
        return objType;
    }


    /**
     * Sets the objType value for this Bapicuprt.
     * 
     * @param objType
     */
    public void setObjType(java.lang.String objType) {
        this.objType = objType;
    }


    /**
     * Gets the classType value for this Bapicuprt.
     * 
     * @return classType
     */
    public java.lang.String getClassType() {
        return classType;
    }


    /**
     * Sets the classType value for this Bapicuprt.
     * 
     * @param classType
     */
    public void setClassType(java.lang.String classType) {
        this.classType = classType;
    }


    /**
     * Gets the objKey value for this Bapicuprt.
     * 
     * @return objKey
     */
    public java.lang.String getObjKey() {
        return objKey;
    }


    /**
     * Sets the objKey value for this Bapicuprt.
     * 
     * @param objKey
     */
    public void setObjKey(java.lang.String objKey) {
        this.objKey = objKey;
    }


    /**
     * Gets the author value for this Bapicuprt.
     * 
     * @return author
     */
    public java.lang.String getAuthor() {
        return author;
    }


    /**
     * Sets the author value for this Bapicuprt.
     * 
     * @param author
     */
    public void setAuthor(java.lang.String author) {
        this.author = author;
    }


    /**
     * Gets the salesRelevant value for this Bapicuprt.
     * 
     * @return salesRelevant
     */
    public java.lang.String getSalesRelevant() {
        return salesRelevant;
    }


    /**
     * Sets the salesRelevant value for this Bapicuprt.
     * 
     * @param salesRelevant
     */
    public void setSalesRelevant(java.lang.String salesRelevant) {
        this.salesRelevant = salesRelevant;
    }


    /**
     * Gets the partOfGuid value for this Bapicuprt.
     * 
     * @return partOfGuid
     */
    public java.lang.String getPartOfGuid() {
        return partOfGuid;
    }


    /**
     * Sets the partOfGuid value for this Bapicuprt.
     * 
     * @param partOfGuid
     */
    public void setPartOfGuid(java.lang.String partOfGuid) {
        this.partOfGuid = partOfGuid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapicuprt)) return false;
        Bapicuprt other = (Bapicuprt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.configId==null && other.getConfigId()==null) || 
             (this.configId!=null &&
              this.configId.equals(other.getConfigId()))) &&
            ((this.parentId==null && other.getParentId()==null) || 
             (this.parentId!=null &&
              this.parentId.equals(other.getParentId()))) &&
            ((this.instId==null && other.getInstId()==null) || 
             (this.instId!=null &&
              this.instId.equals(other.getInstId()))) &&
            ((this.partOfNo==null && other.getPartOfNo()==null) || 
             (this.partOfNo!=null &&
              this.partOfNo.equals(other.getPartOfNo()))) &&
            ((this.objType==null && other.getObjType()==null) || 
             (this.objType!=null &&
              this.objType.equals(other.getObjType()))) &&
            ((this.classType==null && other.getClassType()==null) || 
             (this.classType!=null &&
              this.classType.equals(other.getClassType()))) &&
            ((this.objKey==null && other.getObjKey()==null) || 
             (this.objKey!=null &&
              this.objKey.equals(other.getObjKey()))) &&
            ((this.author==null && other.getAuthor()==null) || 
             (this.author!=null &&
              this.author.equals(other.getAuthor()))) &&
            ((this.salesRelevant==null && other.getSalesRelevant()==null) || 
             (this.salesRelevant!=null &&
              this.salesRelevant.equals(other.getSalesRelevant()))) &&
            ((this.partOfGuid==null && other.getPartOfGuid()==null) || 
             (this.partOfGuid!=null &&
              this.partOfGuid.equals(other.getPartOfGuid())));
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
        if (getConfigId() != null) {
            _hashCode += getConfigId().hashCode();
        }
        if (getParentId() != null) {
            _hashCode += getParentId().hashCode();
        }
        if (getInstId() != null) {
            _hashCode += getInstId().hashCode();
        }
        if (getPartOfNo() != null) {
            _hashCode += getPartOfNo().hashCode();
        }
        if (getObjType() != null) {
            _hashCode += getObjType().hashCode();
        }
        if (getClassType() != null) {
            _hashCode += getClassType().hashCode();
        }
        if (getObjKey() != null) {
            _hashCode += getObjKey().hashCode();
        }
        if (getAuthor() != null) {
            _hashCode += getAuthor().hashCode();
        }
        if (getSalesRelevant() != null) {
            _hashCode += getSalesRelevant().hashCode();
        }
        if (getPartOfGuid() != null) {
            _hashCode += getPartOfGuid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapicuprt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapicuprt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("configId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ConfigId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ParentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "InstId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partOfNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PartOfNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ObjType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ClassType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ObjKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("author");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Author"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesRelevant");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SalesRelevant"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partOfGuid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PartOfGuid"));
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
