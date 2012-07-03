/**
 * Bapiccard.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

@SuppressWarnings({ "rawtypes", "unused" })
public class Bapiccard  implements java.io.Serializable {
  
	private static final long serialVersionUID = 1L;

	private java.lang.String ccType;

    private java.lang.String ccNumber;

    private java.lang.String ccValidT;

    private java.lang.String ccName;

    private java.math.BigDecimal billamount;

    private java.lang.String authFlag;

    private java.math.BigDecimal authamount;

    private java.lang.String currency;

    private java.lang.String currIso;

    private java.lang.String authDate;

    private java.lang.String authTime;

    private java.lang.String authCcNo;

    private java.lang.String authRefno;

    private java.lang.String ccReact;

    private java.math.BigDecimal ccReAmount;

    private java.lang.String glAccount;

    private java.lang.String ccStatEx;

    private java.lang.String ccReactT;

    private java.lang.String virtCard;

    private java.lang.String merchidcl;

    private java.lang.String preAuth;

    private java.lang.String ccSeqNo;

    private java.lang.String amountchan;

    private java.lang.String authortype;

    private java.lang.String dataorigin;

    private java.lang.String radrcheck1;

    private java.lang.String radrcheck2;

    private java.lang.String radrcheck3;

    private java.lang.String rcardcheck;

    private java.lang.String ccLimited;

    private java.lang.String ccVerifValue;

    private java.lang.String ccCtrlField;

    private java.lang.String ccInUseSt;

    public Bapiccard() {
    }

    public Bapiccard(
           java.lang.String ccType,
           java.lang.String ccNumber,
           java.lang.String ccValidT,
           java.lang.String ccName,
           java.math.BigDecimal billamount,
           java.lang.String authFlag,
           java.math.BigDecimal authamount,
           java.lang.String currency,
           java.lang.String currIso,
           java.lang.String authDate,
           java.lang.String authTime,
           java.lang.String authCcNo,
           java.lang.String authRefno,
           java.lang.String ccReact,
           java.math.BigDecimal ccReAmount,
           java.lang.String glAccount,
           java.lang.String ccStatEx,
           java.lang.String ccReactT,
           java.lang.String virtCard,
           java.lang.String merchidcl,
           java.lang.String preAuth,
           java.lang.String ccSeqNo,
           java.lang.String amountchan,
           java.lang.String authortype,
           java.lang.String dataorigin,
           java.lang.String radrcheck1,
           java.lang.String radrcheck2,
           java.lang.String radrcheck3,
           java.lang.String rcardcheck,
           java.lang.String ccLimited,
           java.lang.String ccVerifValue,
           java.lang.String ccCtrlField,
           java.lang.String ccInUseSt) {
           this.ccType = ccType;
           this.ccNumber = ccNumber;
           this.ccValidT = ccValidT;
           this.ccName = ccName;
           this.billamount = billamount;
           this.authFlag = authFlag;
           this.authamount = authamount;
           this.currency = currency;
           this.currIso = currIso;
           this.authDate = authDate;
           this.authTime = authTime;
           this.authCcNo = authCcNo;
           this.authRefno = authRefno;
           this.ccReact = ccReact;
           this.ccReAmount = ccReAmount;
           this.glAccount = glAccount;
           this.ccStatEx = ccStatEx;
           this.ccReactT = ccReactT;
           this.virtCard = virtCard;
           this.merchidcl = merchidcl;
           this.preAuth = preAuth;
           this.ccSeqNo = ccSeqNo;
           this.amountchan = amountchan;
           this.authortype = authortype;
           this.dataorigin = dataorigin;
           this.radrcheck1 = radrcheck1;
           this.radrcheck2 = radrcheck2;
           this.radrcheck3 = radrcheck3;
           this.rcardcheck = rcardcheck;
           this.ccLimited = ccLimited;
           this.ccVerifValue = ccVerifValue;
           this.ccCtrlField = ccCtrlField;
           this.ccInUseSt = ccInUseSt;
    }


    /**
     * Gets the ccType value for this Bapiccard.
     * 
     * @return ccType
     */
    public java.lang.String getCcType() {
        return ccType;
    }


    /**
     * Sets the ccType value for this Bapiccard.
     * 
     * @param ccType
     */
    public void setCcType(java.lang.String ccType) {
        this.ccType = ccType;
    }


    /**
     * Gets the ccNumber value for this Bapiccard.
     * 
     * @return ccNumber
     */
    public java.lang.String getCcNumber() {
        return ccNumber;
    }


    /**
     * Sets the ccNumber value for this Bapiccard.
     * 
     * @param ccNumber
     */
    public void setCcNumber(java.lang.String ccNumber) {
        this.ccNumber = ccNumber;
    }


    /**
     * Gets the ccValidT value for this Bapiccard.
     * 
     * @return ccValidT
     */
    public java.lang.String getCcValidT() {
        return ccValidT;
    }


    /**
     * Sets the ccValidT value for this Bapiccard.
     * 
     * @param ccValidT
     */
    public void setCcValidT(java.lang.String ccValidT) {
        this.ccValidT = ccValidT;
    }


    /**
     * Gets the ccName value for this Bapiccard.
     * 
     * @return ccName
     */
    public java.lang.String getCcName() {
        return ccName;
    }


    /**
     * Sets the ccName value for this Bapiccard.
     * 
     * @param ccName
     */
    public void setCcName(java.lang.String ccName) {
        this.ccName = ccName;
    }


    /**
     * Gets the billamount value for this Bapiccard.
     * 
     * @return billamount
     */
    public java.math.BigDecimal getBillamount() {
        return billamount;
    }


    /**
     * Sets the billamount value for this Bapiccard.
     * 
     * @param billamount
     */
    public void setBillamount(java.math.BigDecimal billamount) {
        this.billamount = billamount;
    }


    /**
     * Gets the authFlag value for this Bapiccard.
     * 
     * @return authFlag
     */
    public java.lang.String getAuthFlag() {
        return authFlag;
    }


    /**
     * Sets the authFlag value for this Bapiccard.
     * 
     * @param authFlag
     */
    public void setAuthFlag(java.lang.String authFlag) {
        this.authFlag = authFlag;
    }


    /**
     * Gets the authamount value for this Bapiccard.
     * 
     * @return authamount
     */
    public java.math.BigDecimal getAuthamount() {
        return authamount;
    }


    /**
     * Sets the authamount value for this Bapiccard.
     * 
     * @param authamount
     */
    public void setAuthamount(java.math.BigDecimal authamount) {
        this.authamount = authamount;
    }


    /**
     * Gets the currency value for this Bapiccard.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Bapiccard.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the currIso value for this Bapiccard.
     * 
     * @return currIso
     */
    public java.lang.String getCurrIso() {
        return currIso;
    }


    /**
     * Sets the currIso value for this Bapiccard.
     * 
     * @param currIso
     */
    public void setCurrIso(java.lang.String currIso) {
        this.currIso = currIso;
    }


    /**
     * Gets the authDate value for this Bapiccard.
     * 
     * @return authDate
     */
    public java.lang.String getAuthDate() {
        return authDate;
    }


    /**
     * Sets the authDate value for this Bapiccard.
     * 
     * @param authDate
     */
    public void setAuthDate(java.lang.String authDate) {
        this.authDate = authDate;
    }


    /**
     * Gets the authTime value for this Bapiccard.
     * 
     * @return authTime
     */
    public java.lang.String getAuthTime() {
        return authTime;
    }


    /**
     * Sets the authTime value for this Bapiccard.
     * 
     * @param authTime
     */
    public void setAuthTime(java.lang.String authTime) {
        this.authTime = authTime;
    }


    /**
     * Gets the authCcNo value for this Bapiccard.
     * 
     * @return authCcNo
     */
    public java.lang.String getAuthCcNo() {
        return authCcNo;
    }


    /**
     * Sets the authCcNo value for this Bapiccard.
     * 
     * @param authCcNo
     */
    public void setAuthCcNo(java.lang.String authCcNo) {
        this.authCcNo = authCcNo;
    }


    /**
     * Gets the authRefno value for this Bapiccard.
     * 
     * @return authRefno
     */
    public java.lang.String getAuthRefno() {
        return authRefno;
    }


    /**
     * Sets the authRefno value for this Bapiccard.
     * 
     * @param authRefno
     */
    public void setAuthRefno(java.lang.String authRefno) {
        this.authRefno = authRefno;
    }


    /**
     * Gets the ccReact value for this Bapiccard.
     * 
     * @return ccReact
     */
    public java.lang.String getCcReact() {
        return ccReact;
    }


    /**
     * Sets the ccReact value for this Bapiccard.
     * 
     * @param ccReact
     */
    public void setCcReact(java.lang.String ccReact) {
        this.ccReact = ccReact;
    }


    /**
     * Gets the ccReAmount value for this Bapiccard.
     * 
     * @return ccReAmount
     */
    public java.math.BigDecimal getCcReAmount() {
        return ccReAmount;
    }


    /**
     * Sets the ccReAmount value for this Bapiccard.
     * 
     * @param ccReAmount
     */
    public void setCcReAmount(java.math.BigDecimal ccReAmount) {
        this.ccReAmount = ccReAmount;
    }


    /**
     * Gets the glAccount value for this Bapiccard.
     * 
     * @return glAccount
     */
    public java.lang.String getGlAccount() {
        return glAccount;
    }


    /**
     * Sets the glAccount value for this Bapiccard.
     * 
     * @param glAccount
     */
    public void setGlAccount(java.lang.String glAccount) {
        this.glAccount = glAccount;
    }


    /**
     * Gets the ccStatEx value for this Bapiccard.
     * 
     * @return ccStatEx
     */
    public java.lang.String getCcStatEx() {
        return ccStatEx;
    }


    /**
     * Sets the ccStatEx value for this Bapiccard.
     * 
     * @param ccStatEx
     */
    public void setCcStatEx(java.lang.String ccStatEx) {
        this.ccStatEx = ccStatEx;
    }


    /**
     * Gets the ccReactT value for this Bapiccard.
     * 
     * @return ccReactT
     */
    public java.lang.String getCcReactT() {
        return ccReactT;
    }


    /**
     * Sets the ccReactT value for this Bapiccard.
     * 
     * @param ccReactT
     */
    public void setCcReactT(java.lang.String ccReactT) {
        this.ccReactT = ccReactT;
    }


    /**
     * Gets the virtCard value for this Bapiccard.
     * 
     * @return virtCard
     */
    public java.lang.String getVirtCard() {
        return virtCard;
    }


    /**
     * Sets the virtCard value for this Bapiccard.
     * 
     * @param virtCard
     */
    public void setVirtCard(java.lang.String virtCard) {
        this.virtCard = virtCard;
    }


    /**
     * Gets the merchidcl value for this Bapiccard.
     * 
     * @return merchidcl
     */
    public java.lang.String getMerchidcl() {
        return merchidcl;
    }


    /**
     * Sets the merchidcl value for this Bapiccard.
     * 
     * @param merchidcl
     */
    public void setMerchidcl(java.lang.String merchidcl) {
        this.merchidcl = merchidcl;
    }


    /**
     * Gets the preAuth value for this Bapiccard.
     * 
     * @return preAuth
     */
    public java.lang.String getPreAuth() {
        return preAuth;
    }


    /**
     * Sets the preAuth value for this Bapiccard.
     * 
     * @param preAuth
     */
    public void setPreAuth(java.lang.String preAuth) {
        this.preAuth = preAuth;
    }


    /**
     * Gets the ccSeqNo value for this Bapiccard.
     * 
     * @return ccSeqNo
     */
    public java.lang.String getCcSeqNo() {
        return ccSeqNo;
    }


    /**
     * Sets the ccSeqNo value for this Bapiccard.
     * 
     * @param ccSeqNo
     */
    public void setCcSeqNo(java.lang.String ccSeqNo) {
        this.ccSeqNo = ccSeqNo;
    }


    /**
     * Gets the amountchan value for this Bapiccard.
     * 
     * @return amountchan
     */
    public java.lang.String getAmountchan() {
        return amountchan;
    }


    /**
     * Sets the amountchan value for this Bapiccard.
     * 
     * @param amountchan
     */
    public void setAmountchan(java.lang.String amountchan) {
        this.amountchan = amountchan;
    }


    /**
     * Gets the authortype value for this Bapiccard.
     * 
     * @return authortype
     */
    public java.lang.String getAuthortype() {
        return authortype;
    }


    /**
     * Sets the authortype value for this Bapiccard.
     * 
     * @param authortype
     */
    public void setAuthortype(java.lang.String authortype) {
        this.authortype = authortype;
    }


    /**
     * Gets the dataorigin value for this Bapiccard.
     * 
     * @return dataorigin
     */
    public java.lang.String getDataorigin() {
        return dataorigin;
    }


    /**
     * Sets the dataorigin value for this Bapiccard.
     * 
     * @param dataorigin
     */
    public void setDataorigin(java.lang.String dataorigin) {
        this.dataorigin = dataorigin;
    }


    /**
     * Gets the radrcheck1 value for this Bapiccard.
     * 
     * @return radrcheck1
     */
    public java.lang.String getRadrcheck1() {
        return radrcheck1;
    }


    /**
     * Sets the radrcheck1 value for this Bapiccard.
     * 
     * @param radrcheck1
     */
    public void setRadrcheck1(java.lang.String radrcheck1) {
        this.radrcheck1 = radrcheck1;
    }


    /**
     * Gets the radrcheck2 value for this Bapiccard.
     * 
     * @return radrcheck2
     */
    public java.lang.String getRadrcheck2() {
        return radrcheck2;
    }


    /**
     * Sets the radrcheck2 value for this Bapiccard.
     * 
     * @param radrcheck2
     */
    public void setRadrcheck2(java.lang.String radrcheck2) {
        this.radrcheck2 = radrcheck2;
    }


    /**
     * Gets the radrcheck3 value for this Bapiccard.
     * 
     * @return radrcheck3
     */
    public java.lang.String getRadrcheck3() {
        return radrcheck3;
    }


    /**
     * Sets the radrcheck3 value for this Bapiccard.
     * 
     * @param radrcheck3
     */
    public void setRadrcheck3(java.lang.String radrcheck3) {
        this.radrcheck3 = radrcheck3;
    }


    /**
     * Gets the rcardcheck value for this Bapiccard.
     * 
     * @return rcardcheck
     */
    public java.lang.String getRcardcheck() {
        return rcardcheck;
    }


    /**
     * Sets the rcardcheck value for this Bapiccard.
     * 
     * @param rcardcheck
     */
    public void setRcardcheck(java.lang.String rcardcheck) {
        this.rcardcheck = rcardcheck;
    }


    /**
     * Gets the ccLimited value for this Bapiccard.
     * 
     * @return ccLimited
     */
    public java.lang.String getCcLimited() {
        return ccLimited;
    }


    /**
     * Sets the ccLimited value for this Bapiccard.
     * 
     * @param ccLimited
     */
    public void setCcLimited(java.lang.String ccLimited) {
        this.ccLimited = ccLimited;
    }


    /**
     * Gets the ccVerifValue value for this Bapiccard.
     * 
     * @return ccVerifValue
     */
    public java.lang.String getCcVerifValue() {
        return ccVerifValue;
    }


    /**
     * Sets the ccVerifValue value for this Bapiccard.
     * 
     * @param ccVerifValue
     */
    public void setCcVerifValue(java.lang.String ccVerifValue) {
        this.ccVerifValue = ccVerifValue;
    }


    /**
     * Gets the ccCtrlField value for this Bapiccard.
     * 
     * @return ccCtrlField
     */
    public java.lang.String getCcCtrlField() {
        return ccCtrlField;
    }


    /**
     * Sets the ccCtrlField value for this Bapiccard.
     * 
     * @param ccCtrlField
     */
    public void setCcCtrlField(java.lang.String ccCtrlField) {
        this.ccCtrlField = ccCtrlField;
    }


    /**
     * Gets the ccInUseSt value for this Bapiccard.
     * 
     * @return ccInUseSt
     */
    public java.lang.String getCcInUseSt() {
        return ccInUseSt;
    }


    /**
     * Sets the ccInUseSt value for this Bapiccard.
     * 
     * @param ccInUseSt
     */
    public void setCcInUseSt(java.lang.String ccInUseSt) {
        this.ccInUseSt = ccInUseSt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapiccard)) return false;
        Bapiccard other = (Bapiccard) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ccType==null && other.getCcType()==null) || 
             (this.ccType!=null &&
              this.ccType.equals(other.getCcType()))) &&
            ((this.ccNumber==null && other.getCcNumber()==null) || 
             (this.ccNumber!=null &&
              this.ccNumber.equals(other.getCcNumber()))) &&
            ((this.ccValidT==null && other.getCcValidT()==null) || 
             (this.ccValidT!=null &&
              this.ccValidT.equals(other.getCcValidT()))) &&
            ((this.ccName==null && other.getCcName()==null) || 
             (this.ccName!=null &&
              this.ccName.equals(other.getCcName()))) &&
            ((this.billamount==null && other.getBillamount()==null) || 
             (this.billamount!=null &&
              this.billamount.equals(other.getBillamount()))) &&
            ((this.authFlag==null && other.getAuthFlag()==null) || 
             (this.authFlag!=null &&
              this.authFlag.equals(other.getAuthFlag()))) &&
            ((this.authamount==null && other.getAuthamount()==null) || 
             (this.authamount!=null &&
              this.authamount.equals(other.getAuthamount()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.currIso==null && other.getCurrIso()==null) || 
             (this.currIso!=null &&
              this.currIso.equals(other.getCurrIso()))) &&
            ((this.authDate==null && other.getAuthDate()==null) || 
             (this.authDate!=null &&
              this.authDate.equals(other.getAuthDate()))) &&
            ((this.authTime==null && other.getAuthTime()==null) || 
             (this.authTime!=null &&
              this.authTime.equals(other.getAuthTime()))) &&
            ((this.authCcNo==null && other.getAuthCcNo()==null) || 
             (this.authCcNo!=null &&
              this.authCcNo.equals(other.getAuthCcNo()))) &&
            ((this.authRefno==null && other.getAuthRefno()==null) || 
             (this.authRefno!=null &&
              this.authRefno.equals(other.getAuthRefno()))) &&
            ((this.ccReact==null && other.getCcReact()==null) || 
             (this.ccReact!=null &&
              this.ccReact.equals(other.getCcReact()))) &&
            ((this.ccReAmount==null && other.getCcReAmount()==null) || 
             (this.ccReAmount!=null &&
              this.ccReAmount.equals(other.getCcReAmount()))) &&
            ((this.glAccount==null && other.getGlAccount()==null) || 
             (this.glAccount!=null &&
              this.glAccount.equals(other.getGlAccount()))) &&
            ((this.ccStatEx==null && other.getCcStatEx()==null) || 
             (this.ccStatEx!=null &&
              this.ccStatEx.equals(other.getCcStatEx()))) &&
            ((this.ccReactT==null && other.getCcReactT()==null) || 
             (this.ccReactT!=null &&
              this.ccReactT.equals(other.getCcReactT()))) &&
            ((this.virtCard==null && other.getVirtCard()==null) || 
             (this.virtCard!=null &&
              this.virtCard.equals(other.getVirtCard()))) &&
            ((this.merchidcl==null && other.getMerchidcl()==null) || 
             (this.merchidcl!=null &&
              this.merchidcl.equals(other.getMerchidcl()))) &&
            ((this.preAuth==null && other.getPreAuth()==null) || 
             (this.preAuth!=null &&
              this.preAuth.equals(other.getPreAuth()))) &&
            ((this.ccSeqNo==null && other.getCcSeqNo()==null) || 
             (this.ccSeqNo!=null &&
              this.ccSeqNo.equals(other.getCcSeqNo()))) &&
            ((this.amountchan==null && other.getAmountchan()==null) || 
             (this.amountchan!=null &&
              this.amountchan.equals(other.getAmountchan()))) &&
            ((this.authortype==null && other.getAuthortype()==null) || 
             (this.authortype!=null &&
              this.authortype.equals(other.getAuthortype()))) &&
            ((this.dataorigin==null && other.getDataorigin()==null) || 
             (this.dataorigin!=null &&
              this.dataorigin.equals(other.getDataorigin()))) &&
            ((this.radrcheck1==null && other.getRadrcheck1()==null) || 
             (this.radrcheck1!=null &&
              this.radrcheck1.equals(other.getRadrcheck1()))) &&
            ((this.radrcheck2==null && other.getRadrcheck2()==null) || 
             (this.radrcheck2!=null &&
              this.radrcheck2.equals(other.getRadrcheck2()))) &&
            ((this.radrcheck3==null && other.getRadrcheck3()==null) || 
             (this.radrcheck3!=null &&
              this.radrcheck3.equals(other.getRadrcheck3()))) &&
            ((this.rcardcheck==null && other.getRcardcheck()==null) || 
             (this.rcardcheck!=null &&
              this.rcardcheck.equals(other.getRcardcheck()))) &&
            ((this.ccLimited==null && other.getCcLimited()==null) || 
             (this.ccLimited!=null &&
              this.ccLimited.equals(other.getCcLimited()))) &&
            ((this.ccVerifValue==null && other.getCcVerifValue()==null) || 
             (this.ccVerifValue!=null &&
              this.ccVerifValue.equals(other.getCcVerifValue()))) &&
            ((this.ccCtrlField==null && other.getCcCtrlField()==null) || 
             (this.ccCtrlField!=null &&
              this.ccCtrlField.equals(other.getCcCtrlField()))) &&
            ((this.ccInUseSt==null && other.getCcInUseSt()==null) || 
             (this.ccInUseSt!=null &&
              this.ccInUseSt.equals(other.getCcInUseSt())));
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
        if (getCcType() != null) {
            _hashCode += getCcType().hashCode();
        }
        if (getCcNumber() != null) {
            _hashCode += getCcNumber().hashCode();
        }
        if (getCcValidT() != null) {
            _hashCode += getCcValidT().hashCode();
        }
        if (getCcName() != null) {
            _hashCode += getCcName().hashCode();
        }
        if (getBillamount() != null) {
            _hashCode += getBillamount().hashCode();
        }
        if (getAuthFlag() != null) {
            _hashCode += getAuthFlag().hashCode();
        }
        if (getAuthamount() != null) {
            _hashCode += getAuthamount().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getCurrIso() != null) {
            _hashCode += getCurrIso().hashCode();
        }
        if (getAuthDate() != null) {
            _hashCode += getAuthDate().hashCode();
        }
        if (getAuthTime() != null) {
            _hashCode += getAuthTime().hashCode();
        }
        if (getAuthCcNo() != null) {
            _hashCode += getAuthCcNo().hashCode();
        }
        if (getAuthRefno() != null) {
            _hashCode += getAuthRefno().hashCode();
        }
        if (getCcReact() != null) {
            _hashCode += getCcReact().hashCode();
        }
        if (getCcReAmount() != null) {
            _hashCode += getCcReAmount().hashCode();
        }
        if (getGlAccount() != null) {
            _hashCode += getGlAccount().hashCode();
        }
        if (getCcStatEx() != null) {
            _hashCode += getCcStatEx().hashCode();
        }
        if (getCcReactT() != null) {
            _hashCode += getCcReactT().hashCode();
        }
        if (getVirtCard() != null) {
            _hashCode += getVirtCard().hashCode();
        }
        if (getMerchidcl() != null) {
            _hashCode += getMerchidcl().hashCode();
        }
        if (getPreAuth() != null) {
            _hashCode += getPreAuth().hashCode();
        }
        if (getCcSeqNo() != null) {
            _hashCode += getCcSeqNo().hashCode();
        }
        if (getAmountchan() != null) {
            _hashCode += getAmountchan().hashCode();
        }
        if (getAuthortype() != null) {
            _hashCode += getAuthortype().hashCode();
        }
        if (getDataorigin() != null) {
            _hashCode += getDataorigin().hashCode();
        }
        if (getRadrcheck1() != null) {
            _hashCode += getRadrcheck1().hashCode();
        }
        if (getRadrcheck2() != null) {
            _hashCode += getRadrcheck2().hashCode();
        }
        if (getRadrcheck3() != null) {
            _hashCode += getRadrcheck3().hashCode();
        }
        if (getRcardcheck() != null) {
            _hashCode += getRcardcheck().hashCode();
        }
        if (getCcLimited() != null) {
            _hashCode += getCcLimited().hashCode();
        }
        if (getCcVerifValue() != null) {
            _hashCode += getCcVerifValue().hashCode();
        }
        if (getCcCtrlField() != null) {
            _hashCode += getCcCtrlField().hashCode();
        }
        if (getCcInUseSt() != null) {
            _hashCode += getCcInUseSt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapiccard.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiccard"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CcType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CcNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccValidT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CcValidT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CcName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("billamount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Billamount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AuthFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authamount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Authamount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currIso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CurrIso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AuthDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AuthTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authCcNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AuthCcNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authRefno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AuthRefno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccReact");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CcReact"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccReAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CcReAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("glAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GlAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccStatEx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CcStatEx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccReactT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CcReactT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("virtCard");
        elemField.setXmlName(new javax.xml.namespace.QName("", "VirtCard"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("merchidcl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Merchidcl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preAuth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PreAuth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccSeqNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CcSeqNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amountchan");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Amountchan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authortype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Authortype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataorigin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Dataorigin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("radrcheck1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Radrcheck1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("radrcheck2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Radrcheck2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("radrcheck3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Radrcheck3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rcardcheck");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Rcardcheck"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccLimited");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CcLimited"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccVerifValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CcVerifValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccCtrlField");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CcCtrlField"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccInUseSt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CcInUseSt"));
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
