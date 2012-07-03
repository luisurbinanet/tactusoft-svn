/**
 * Bapicond.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.objects;

@SuppressWarnings({ "rawtypes", "unused" })
public class Bapicond  implements java.io.Serializable {
    
	private static final long serialVersionUID = 1L;

	private java.lang.String itmNumber;

    private java.lang.String condStNo;

    private java.lang.String condCount;

    private java.lang.String condType;

    private java.math.BigDecimal condValue;

    private java.lang.String currency;

    private java.lang.String condUnit;

    private java.math.BigDecimal condPUnt;

    private java.lang.String currIso;

    private java.lang.String cdUntIso;

    private java.lang.String refobjtype;

    private java.lang.String refobjkey;

    private java.lang.String reflogsys;

    private java.lang.String applicatio;

    private java.lang.String conpricdat;

    private java.lang.String calctypcon;

    private java.math.BigDecimal conbaseval;

    private java.math.BigDecimal conexchrat;

    private java.math.BigDecimal numconvert;

    private java.math.BigDecimal denominato;

    private java.lang.String condtype;

    private java.lang.String statCon;

    private java.lang.String scaletype;

    private java.lang.String accruals;

    private java.lang.String coninvolst;

    private java.lang.String condorigin;

    private java.lang.String groupcond;

    private java.lang.String condUpdat;

    private java.lang.String accessSeq;

    private java.lang.String condcount;

    private java.math.BigDecimal roundoffdi;

    private java.math.BigDecimal condvalue;

    private java.lang.String currency2;

    private java.lang.String currIso2;

    private java.lang.String condcntrl;

    private java.lang.String condisacti;

    private java.lang.String condclass;

    private float factbasval;

    private java.lang.String scalebasin;

    private java.math.BigDecimal scalbasval;

    private java.lang.String unitmeasur;

    private java.lang.String isoUnit;

    private java.lang.String currenckey;

    private java.lang.String curreniso;

    private java.lang.String condincomp;

    private java.lang.String condconfig;

    private java.lang.String condchaman;

    private java.lang.String condNo;

    private java.lang.String taxCode;

    private java.lang.String varcond;

    private java.lang.String accountkey;

    private java.lang.String accountKe;

    private java.lang.String wtWithcd;

    private java.lang.String structcond;

    private float factconbas;

    private java.lang.String condcoinhd;

    public Bapicond() {
    }

    public Bapicond(
           java.lang.String itmNumber,
           java.lang.String condStNo,
           java.lang.String condCount,
           java.lang.String condType,
           java.math.BigDecimal condValue,
           java.lang.String currency,
           java.lang.String condUnit,
           java.math.BigDecimal condPUnt,
           java.lang.String currIso,
           java.lang.String cdUntIso,
           java.lang.String refobjtype,
           java.lang.String refobjkey,
           java.lang.String reflogsys,
           java.lang.String applicatio,
           java.lang.String conpricdat,
           java.lang.String calctypcon,
           java.math.BigDecimal conbaseval,
           java.math.BigDecimal conexchrat,
           java.math.BigDecimal numconvert,
           java.math.BigDecimal denominato,
           java.lang.String condtype,
           java.lang.String statCon,
           java.lang.String scaletype,
           java.lang.String accruals,
           java.lang.String coninvolst,
           java.lang.String condorigin,
           java.lang.String groupcond,
           java.lang.String condUpdat,
           java.lang.String accessSeq,
           java.lang.String condcount,
           java.math.BigDecimal roundoffdi,
           java.math.BigDecimal condvalue,
           java.lang.String currency2,
           java.lang.String currIso2,
           java.lang.String condcntrl,
           java.lang.String condisacti,
           java.lang.String condclass,
           float factbasval,
           java.lang.String scalebasin,
           java.math.BigDecimal scalbasval,
           java.lang.String unitmeasur,
           java.lang.String isoUnit,
           java.lang.String currenckey,
           java.lang.String curreniso,
           java.lang.String condincomp,
           java.lang.String condconfig,
           java.lang.String condchaman,
           java.lang.String condNo,
           java.lang.String taxCode,
           java.lang.String varcond,
           java.lang.String accountkey,
           java.lang.String accountKe,
           java.lang.String wtWithcd,
           java.lang.String structcond,
           float factconbas,
           java.lang.String condcoinhd) {
           this.itmNumber = itmNumber;
           this.condStNo = condStNo;
           this.condCount = condCount;
           this.condType = condType;
           this.condValue = condValue;
           this.currency = currency;
           this.condUnit = condUnit;
           this.condPUnt = condPUnt;
           this.currIso = currIso;
           this.cdUntIso = cdUntIso;
           this.refobjtype = refobjtype;
           this.refobjkey = refobjkey;
           this.reflogsys = reflogsys;
           this.applicatio = applicatio;
           this.conpricdat = conpricdat;
           this.calctypcon = calctypcon;
           this.conbaseval = conbaseval;
           this.conexchrat = conexchrat;
           this.numconvert = numconvert;
           this.denominato = denominato;
           this.condtype = condtype;
           this.statCon = statCon;
           this.scaletype = scaletype;
           this.accruals = accruals;
           this.coninvolst = coninvolst;
           this.condorigin = condorigin;
           this.groupcond = groupcond;
           this.condUpdat = condUpdat;
           this.accessSeq = accessSeq;
           this.condcount = condcount;
           this.roundoffdi = roundoffdi;
           this.condvalue = condvalue;
           this.currency2 = currency2;
           this.currIso2 = currIso2;
           this.condcntrl = condcntrl;
           this.condisacti = condisacti;
           this.condclass = condclass;
           this.factbasval = factbasval;
           this.scalebasin = scalebasin;
           this.scalbasval = scalbasval;
           this.unitmeasur = unitmeasur;
           this.isoUnit = isoUnit;
           this.currenckey = currenckey;
           this.curreniso = curreniso;
           this.condincomp = condincomp;
           this.condconfig = condconfig;
           this.condchaman = condchaman;
           this.condNo = condNo;
           this.taxCode = taxCode;
           this.varcond = varcond;
           this.accountkey = accountkey;
           this.accountKe = accountKe;
           this.wtWithcd = wtWithcd;
           this.structcond = structcond;
           this.factconbas = factconbas;
           this.condcoinhd = condcoinhd;
    }


    /**
     * Gets the itmNumber value for this Bapicond.
     * 
     * @return itmNumber
     */
    public java.lang.String getItmNumber() {
        return itmNumber;
    }


    /**
     * Sets the itmNumber value for this Bapicond.
     * 
     * @param itmNumber
     */
    public void setItmNumber(java.lang.String itmNumber) {
        this.itmNumber = itmNumber;
    }


    /**
     * Gets the condStNo value for this Bapicond.
     * 
     * @return condStNo
     */
    public java.lang.String getCondStNo() {
        return condStNo;
    }


    /**
     * Sets the condStNo value for this Bapicond.
     * 
     * @param condStNo
     */
    public void setCondStNo(java.lang.String condStNo) {
        this.condStNo = condStNo;
    }


    /**
     * Gets the condCount value for this Bapicond.
     * 
     * @return condCount
     */
    public java.lang.String getCondCount() {
        return condCount;
    }


    /**
     * Sets the condCount value for this Bapicond.
     * 
     * @param condCount
     */
    public void setCondCount(java.lang.String condCount) {
        this.condCount = condCount;
    }


    /**
     * Gets the condType value for this Bapicond.
     * 
     * @return condType
     */
    public java.lang.String getCondType() {
        return condType;
    }


    /**
     * Sets the condType value for this Bapicond.
     * 
     * @param condType
     */
    public void setCondType(java.lang.String condType) {
        this.condType = condType;
    }


    /**
     * Gets the condValue value for this Bapicond.
     * 
     * @return condValue
     */
    public java.math.BigDecimal getCondValue() {
        return condValue;
    }


    /**
     * Sets the condValue value for this Bapicond.
     * 
     * @param condValue
     */
    public void setCondValue(java.math.BigDecimal condValue) {
        this.condValue = condValue;
    }


    /**
     * Gets the currency value for this Bapicond.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Bapicond.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the condUnit value for this Bapicond.
     * 
     * @return condUnit
     */
    public java.lang.String getCondUnit() {
        return condUnit;
    }


    /**
     * Sets the condUnit value for this Bapicond.
     * 
     * @param condUnit
     */
    public void setCondUnit(java.lang.String condUnit) {
        this.condUnit = condUnit;
    }


    /**
     * Gets the condPUnt value for this Bapicond.
     * 
     * @return condPUnt
     */
    public java.math.BigDecimal getCondPUnt() {
        return condPUnt;
    }


    /**
     * Sets the condPUnt value for this Bapicond.
     * 
     * @param condPUnt
     */
    public void setCondPUnt(java.math.BigDecimal condPUnt) {
        this.condPUnt = condPUnt;
    }


    /**
     * Gets the currIso value for this Bapicond.
     * 
     * @return currIso
     */
    public java.lang.String getCurrIso() {
        return currIso;
    }


    /**
     * Sets the currIso value for this Bapicond.
     * 
     * @param currIso
     */
    public void setCurrIso(java.lang.String currIso) {
        this.currIso = currIso;
    }


    /**
     * Gets the cdUntIso value for this Bapicond.
     * 
     * @return cdUntIso
     */
    public java.lang.String getCdUntIso() {
        return cdUntIso;
    }


    /**
     * Sets the cdUntIso value for this Bapicond.
     * 
     * @param cdUntIso
     */
    public void setCdUntIso(java.lang.String cdUntIso) {
        this.cdUntIso = cdUntIso;
    }


    /**
     * Gets the refobjtype value for this Bapicond.
     * 
     * @return refobjtype
     */
    public java.lang.String getRefobjtype() {
        return refobjtype;
    }


    /**
     * Sets the refobjtype value for this Bapicond.
     * 
     * @param refobjtype
     */
    public void setRefobjtype(java.lang.String refobjtype) {
        this.refobjtype = refobjtype;
    }


    /**
     * Gets the refobjkey value for this Bapicond.
     * 
     * @return refobjkey
     */
    public java.lang.String getRefobjkey() {
        return refobjkey;
    }


    /**
     * Sets the refobjkey value for this Bapicond.
     * 
     * @param refobjkey
     */
    public void setRefobjkey(java.lang.String refobjkey) {
        this.refobjkey = refobjkey;
    }


    /**
     * Gets the reflogsys value for this Bapicond.
     * 
     * @return reflogsys
     */
    public java.lang.String getReflogsys() {
        return reflogsys;
    }


    /**
     * Sets the reflogsys value for this Bapicond.
     * 
     * @param reflogsys
     */
    public void setReflogsys(java.lang.String reflogsys) {
        this.reflogsys = reflogsys;
    }


    /**
     * Gets the applicatio value for this Bapicond.
     * 
     * @return applicatio
     */
    public java.lang.String getApplicatio() {
        return applicatio;
    }


    /**
     * Sets the applicatio value for this Bapicond.
     * 
     * @param applicatio
     */
    public void setApplicatio(java.lang.String applicatio) {
        this.applicatio = applicatio;
    }


    /**
     * Gets the conpricdat value for this Bapicond.
     * 
     * @return conpricdat
     */
    public java.lang.String getConpricdat() {
        return conpricdat;
    }


    /**
     * Sets the conpricdat value for this Bapicond.
     * 
     * @param conpricdat
     */
    public void setConpricdat(java.lang.String conpricdat) {
        this.conpricdat = conpricdat;
    }


    /**
     * Gets the calctypcon value for this Bapicond.
     * 
     * @return calctypcon
     */
    public java.lang.String getCalctypcon() {
        return calctypcon;
    }


    /**
     * Sets the calctypcon value for this Bapicond.
     * 
     * @param calctypcon
     */
    public void setCalctypcon(java.lang.String calctypcon) {
        this.calctypcon = calctypcon;
    }


    /**
     * Gets the conbaseval value for this Bapicond.
     * 
     * @return conbaseval
     */
    public java.math.BigDecimal getConbaseval() {
        return conbaseval;
    }


    /**
     * Sets the conbaseval value for this Bapicond.
     * 
     * @param conbaseval
     */
    public void setConbaseval(java.math.BigDecimal conbaseval) {
        this.conbaseval = conbaseval;
    }


    /**
     * Gets the conexchrat value for this Bapicond.
     * 
     * @return conexchrat
     */
    public java.math.BigDecimal getConexchrat() {
        return conexchrat;
    }


    /**
     * Sets the conexchrat value for this Bapicond.
     * 
     * @param conexchrat
     */
    public void setConexchrat(java.math.BigDecimal conexchrat) {
        this.conexchrat = conexchrat;
    }


    /**
     * Gets the numconvert value for this Bapicond.
     * 
     * @return numconvert
     */
    public java.math.BigDecimal getNumconvert() {
        return numconvert;
    }


    /**
     * Sets the numconvert value for this Bapicond.
     * 
     * @param numconvert
     */
    public void setNumconvert(java.math.BigDecimal numconvert) {
        this.numconvert = numconvert;
    }


    /**
     * Gets the denominato value for this Bapicond.
     * 
     * @return denominato
     */
    public java.math.BigDecimal getDenominato() {
        return denominato;
    }


    /**
     * Sets the denominato value for this Bapicond.
     * 
     * @param denominato
     */
    public void setDenominato(java.math.BigDecimal denominato) {
        this.denominato = denominato;
    }


    /**
     * Gets the condtype value for this Bapicond.
     * 
     * @return condtype
     */
    public java.lang.String getCondtype() {
        return condtype;
    }


    /**
     * Sets the condtype value for this Bapicond.
     * 
     * @param condtype
     */
    public void setCondtype(java.lang.String condtype) {
        this.condtype = condtype;
    }


    /**
     * Gets the statCon value for this Bapicond.
     * 
     * @return statCon
     */
    public java.lang.String getStatCon() {
        return statCon;
    }


    /**
     * Sets the statCon value for this Bapicond.
     * 
     * @param statCon
     */
    public void setStatCon(java.lang.String statCon) {
        this.statCon = statCon;
    }


    /**
     * Gets the scaletype value for this Bapicond.
     * 
     * @return scaletype
     */
    public java.lang.String getScaletype() {
        return scaletype;
    }


    /**
     * Sets the scaletype value for this Bapicond.
     * 
     * @param scaletype
     */
    public void setScaletype(java.lang.String scaletype) {
        this.scaletype = scaletype;
    }


    /**
     * Gets the accruals value for this Bapicond.
     * 
     * @return accruals
     */
    public java.lang.String getAccruals() {
        return accruals;
    }


    /**
     * Sets the accruals value for this Bapicond.
     * 
     * @param accruals
     */
    public void setAccruals(java.lang.String accruals) {
        this.accruals = accruals;
    }


    /**
     * Gets the coninvolst value for this Bapicond.
     * 
     * @return coninvolst
     */
    public java.lang.String getConinvolst() {
        return coninvolst;
    }


    /**
     * Sets the coninvolst value for this Bapicond.
     * 
     * @param coninvolst
     */
    public void setConinvolst(java.lang.String coninvolst) {
        this.coninvolst = coninvolst;
    }


    /**
     * Gets the condorigin value for this Bapicond.
     * 
     * @return condorigin
     */
    public java.lang.String getCondorigin() {
        return condorigin;
    }


    /**
     * Sets the condorigin value for this Bapicond.
     * 
     * @param condorigin
     */
    public void setCondorigin(java.lang.String condorigin) {
        this.condorigin = condorigin;
    }


    /**
     * Gets the groupcond value for this Bapicond.
     * 
     * @return groupcond
     */
    public java.lang.String getGroupcond() {
        return groupcond;
    }


    /**
     * Sets the groupcond value for this Bapicond.
     * 
     * @param groupcond
     */
    public void setGroupcond(java.lang.String groupcond) {
        this.groupcond = groupcond;
    }


    /**
     * Gets the condUpdat value for this Bapicond.
     * 
     * @return condUpdat
     */
    public java.lang.String getCondUpdat() {
        return condUpdat;
    }


    /**
     * Sets the condUpdat value for this Bapicond.
     * 
     * @param condUpdat
     */
    public void setCondUpdat(java.lang.String condUpdat) {
        this.condUpdat = condUpdat;
    }


    /**
     * Gets the accessSeq value for this Bapicond.
     * 
     * @return accessSeq
     */
    public java.lang.String getAccessSeq() {
        return accessSeq;
    }


    /**
     * Sets the accessSeq value for this Bapicond.
     * 
     * @param accessSeq
     */
    public void setAccessSeq(java.lang.String accessSeq) {
        this.accessSeq = accessSeq;
    }


    /**
     * Gets the condcount value for this Bapicond.
     * 
     * @return condcount
     */
    public java.lang.String getCondcount() {
        return condcount;
    }


    /**
     * Sets the condcount value for this Bapicond.
     * 
     * @param condcount
     */
    public void setCondcount(java.lang.String condcount) {
        this.condcount = condcount;
    }


    /**
     * Gets the roundoffdi value for this Bapicond.
     * 
     * @return roundoffdi
     */
    public java.math.BigDecimal getRoundoffdi() {
        return roundoffdi;
    }


    /**
     * Sets the roundoffdi value for this Bapicond.
     * 
     * @param roundoffdi
     */
    public void setRoundoffdi(java.math.BigDecimal roundoffdi) {
        this.roundoffdi = roundoffdi;
    }


    /**
     * Gets the condvalue value for this Bapicond.
     * 
     * @return condvalue
     */
    public java.math.BigDecimal getCondvalue() {
        return condvalue;
    }


    /**
     * Sets the condvalue value for this Bapicond.
     * 
     * @param condvalue
     */
    public void setCondvalue(java.math.BigDecimal condvalue) {
        this.condvalue = condvalue;
    }


    /**
     * Gets the currency2 value for this Bapicond.
     * 
     * @return currency2
     */
    public java.lang.String getCurrency2() {
        return currency2;
    }


    /**
     * Sets the currency2 value for this Bapicond.
     * 
     * @param currency2
     */
    public void setCurrency2(java.lang.String currency2) {
        this.currency2 = currency2;
    }


    /**
     * Gets the currIso2 value for this Bapicond.
     * 
     * @return currIso2
     */
    public java.lang.String getCurrIso2() {
        return currIso2;
    }


    /**
     * Sets the currIso2 value for this Bapicond.
     * 
     * @param currIso2
     */
    public void setCurrIso2(java.lang.String currIso2) {
        this.currIso2 = currIso2;
    }


    /**
     * Gets the condcntrl value for this Bapicond.
     * 
     * @return condcntrl
     */
    public java.lang.String getCondcntrl() {
        return condcntrl;
    }


    /**
     * Sets the condcntrl value for this Bapicond.
     * 
     * @param condcntrl
     */
    public void setCondcntrl(java.lang.String condcntrl) {
        this.condcntrl = condcntrl;
    }


    /**
     * Gets the condisacti value for this Bapicond.
     * 
     * @return condisacti
     */
    public java.lang.String getCondisacti() {
        return condisacti;
    }


    /**
     * Sets the condisacti value for this Bapicond.
     * 
     * @param condisacti
     */
    public void setCondisacti(java.lang.String condisacti) {
        this.condisacti = condisacti;
    }


    /**
     * Gets the condclass value for this Bapicond.
     * 
     * @return condclass
     */
    public java.lang.String getCondclass() {
        return condclass;
    }


    /**
     * Sets the condclass value for this Bapicond.
     * 
     * @param condclass
     */
    public void setCondclass(java.lang.String condclass) {
        this.condclass = condclass;
    }


    /**
     * Gets the factbasval value for this Bapicond.
     * 
     * @return factbasval
     */
    public float getFactbasval() {
        return factbasval;
    }


    /**
     * Sets the factbasval value for this Bapicond.
     * 
     * @param factbasval
     */
    public void setFactbasval(float factbasval) {
        this.factbasval = factbasval;
    }


    /**
     * Gets the scalebasin value for this Bapicond.
     * 
     * @return scalebasin
     */
    public java.lang.String getScalebasin() {
        return scalebasin;
    }


    /**
     * Sets the scalebasin value for this Bapicond.
     * 
     * @param scalebasin
     */
    public void setScalebasin(java.lang.String scalebasin) {
        this.scalebasin = scalebasin;
    }


    /**
     * Gets the scalbasval value for this Bapicond.
     * 
     * @return scalbasval
     */
    public java.math.BigDecimal getScalbasval() {
        return scalbasval;
    }


    /**
     * Sets the scalbasval value for this Bapicond.
     * 
     * @param scalbasval
     */
    public void setScalbasval(java.math.BigDecimal scalbasval) {
        this.scalbasval = scalbasval;
    }


    /**
     * Gets the unitmeasur value for this Bapicond.
     * 
     * @return unitmeasur
     */
    public java.lang.String getUnitmeasur() {
        return unitmeasur;
    }


    /**
     * Sets the unitmeasur value for this Bapicond.
     * 
     * @param unitmeasur
     */
    public void setUnitmeasur(java.lang.String unitmeasur) {
        this.unitmeasur = unitmeasur;
    }


    /**
     * Gets the isoUnit value for this Bapicond.
     * 
     * @return isoUnit
     */
    public java.lang.String getIsoUnit() {
        return isoUnit;
    }


    /**
     * Sets the isoUnit value for this Bapicond.
     * 
     * @param isoUnit
     */
    public void setIsoUnit(java.lang.String isoUnit) {
        this.isoUnit = isoUnit;
    }


    /**
     * Gets the currenckey value for this Bapicond.
     * 
     * @return currenckey
     */
    public java.lang.String getCurrenckey() {
        return currenckey;
    }


    /**
     * Sets the currenckey value for this Bapicond.
     * 
     * @param currenckey
     */
    public void setCurrenckey(java.lang.String currenckey) {
        this.currenckey = currenckey;
    }


    /**
     * Gets the curreniso value for this Bapicond.
     * 
     * @return curreniso
     */
    public java.lang.String getCurreniso() {
        return curreniso;
    }


    /**
     * Sets the curreniso value for this Bapicond.
     * 
     * @param curreniso
     */
    public void setCurreniso(java.lang.String curreniso) {
        this.curreniso = curreniso;
    }


    /**
     * Gets the condincomp value for this Bapicond.
     * 
     * @return condincomp
     */
    public java.lang.String getCondincomp() {
        return condincomp;
    }


    /**
     * Sets the condincomp value for this Bapicond.
     * 
     * @param condincomp
     */
    public void setCondincomp(java.lang.String condincomp) {
        this.condincomp = condincomp;
    }


    /**
     * Gets the condconfig value for this Bapicond.
     * 
     * @return condconfig
     */
    public java.lang.String getCondconfig() {
        return condconfig;
    }


    /**
     * Sets the condconfig value for this Bapicond.
     * 
     * @param condconfig
     */
    public void setCondconfig(java.lang.String condconfig) {
        this.condconfig = condconfig;
    }


    /**
     * Gets the condchaman value for this Bapicond.
     * 
     * @return condchaman
     */
    public java.lang.String getCondchaman() {
        return condchaman;
    }


    /**
     * Sets the condchaman value for this Bapicond.
     * 
     * @param condchaman
     */
    public void setCondchaman(java.lang.String condchaman) {
        this.condchaman = condchaman;
    }


    /**
     * Gets the condNo value for this Bapicond.
     * 
     * @return condNo
     */
    public java.lang.String getCondNo() {
        return condNo;
    }


    /**
     * Sets the condNo value for this Bapicond.
     * 
     * @param condNo
     */
    public void setCondNo(java.lang.String condNo) {
        this.condNo = condNo;
    }


    /**
     * Gets the taxCode value for this Bapicond.
     * 
     * @return taxCode
     */
    public java.lang.String getTaxCode() {
        return taxCode;
    }


    /**
     * Sets the taxCode value for this Bapicond.
     * 
     * @param taxCode
     */
    public void setTaxCode(java.lang.String taxCode) {
        this.taxCode = taxCode;
    }


    /**
     * Gets the varcond value for this Bapicond.
     * 
     * @return varcond
     */
    public java.lang.String getVarcond() {
        return varcond;
    }


    /**
     * Sets the varcond value for this Bapicond.
     * 
     * @param varcond
     */
    public void setVarcond(java.lang.String varcond) {
        this.varcond = varcond;
    }


    /**
     * Gets the accountkey value for this Bapicond.
     * 
     * @return accountkey
     */
    public java.lang.String getAccountkey() {
        return accountkey;
    }


    /**
     * Sets the accountkey value for this Bapicond.
     * 
     * @param accountkey
     */
    public void setAccountkey(java.lang.String accountkey) {
        this.accountkey = accountkey;
    }


    /**
     * Gets the accountKe value for this Bapicond.
     * 
     * @return accountKe
     */
    public java.lang.String getAccountKe() {
        return accountKe;
    }


    /**
     * Sets the accountKe value for this Bapicond.
     * 
     * @param accountKe
     */
    public void setAccountKe(java.lang.String accountKe) {
        this.accountKe = accountKe;
    }


    /**
     * Gets the wtWithcd value for this Bapicond.
     * 
     * @return wtWithcd
     */
    public java.lang.String getWtWithcd() {
        return wtWithcd;
    }


    /**
     * Sets the wtWithcd value for this Bapicond.
     * 
     * @param wtWithcd
     */
    public void setWtWithcd(java.lang.String wtWithcd) {
        this.wtWithcd = wtWithcd;
    }


    /**
     * Gets the structcond value for this Bapicond.
     * 
     * @return structcond
     */
    public java.lang.String getStructcond() {
        return structcond;
    }


    /**
     * Sets the structcond value for this Bapicond.
     * 
     * @param structcond
     */
    public void setStructcond(java.lang.String structcond) {
        this.structcond = structcond;
    }


    /**
     * Gets the factconbas value for this Bapicond.
     * 
     * @return factconbas
     */
    public float getFactconbas() {
        return factconbas;
    }


    /**
     * Sets the factconbas value for this Bapicond.
     * 
     * @param factconbas
     */
    public void setFactconbas(float factconbas) {
        this.factconbas = factconbas;
    }


    /**
     * Gets the condcoinhd value for this Bapicond.
     * 
     * @return condcoinhd
     */
    public java.lang.String getCondcoinhd() {
        return condcoinhd;
    }


    /**
     * Sets the condcoinhd value for this Bapicond.
     * 
     * @param condcoinhd
     */
    public void setCondcoinhd(java.lang.String condcoinhd) {
        this.condcoinhd = condcoinhd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapicond)) return false;
        Bapicond other = (Bapicond) obj;
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
            ((this.currIso==null && other.getCurrIso()==null) || 
             (this.currIso!=null &&
              this.currIso.equals(other.getCurrIso()))) &&
            ((this.cdUntIso==null && other.getCdUntIso()==null) || 
             (this.cdUntIso!=null &&
              this.cdUntIso.equals(other.getCdUntIso()))) &&
            ((this.refobjtype==null && other.getRefobjtype()==null) || 
             (this.refobjtype!=null &&
              this.refobjtype.equals(other.getRefobjtype()))) &&
            ((this.refobjkey==null && other.getRefobjkey()==null) || 
             (this.refobjkey!=null &&
              this.refobjkey.equals(other.getRefobjkey()))) &&
            ((this.reflogsys==null && other.getReflogsys()==null) || 
             (this.reflogsys!=null &&
              this.reflogsys.equals(other.getReflogsys()))) &&
            ((this.applicatio==null && other.getApplicatio()==null) || 
             (this.applicatio!=null &&
              this.applicatio.equals(other.getApplicatio()))) &&
            ((this.conpricdat==null && other.getConpricdat()==null) || 
             (this.conpricdat!=null &&
              this.conpricdat.equals(other.getConpricdat()))) &&
            ((this.calctypcon==null && other.getCalctypcon()==null) || 
             (this.calctypcon!=null &&
              this.calctypcon.equals(other.getCalctypcon()))) &&
            ((this.conbaseval==null && other.getConbaseval()==null) || 
             (this.conbaseval!=null &&
              this.conbaseval.equals(other.getConbaseval()))) &&
            ((this.conexchrat==null && other.getConexchrat()==null) || 
             (this.conexchrat!=null &&
              this.conexchrat.equals(other.getConexchrat()))) &&
            ((this.numconvert==null && other.getNumconvert()==null) || 
             (this.numconvert!=null &&
              this.numconvert.equals(other.getNumconvert()))) &&
            ((this.denominato==null && other.getDenominato()==null) || 
             (this.denominato!=null &&
              this.denominato.equals(other.getDenominato()))) &&
            ((this.condtype==null && other.getCondtype()==null) || 
             (this.condtype!=null &&
              this.condtype.equals(other.getCondtype()))) &&
            ((this.statCon==null && other.getStatCon()==null) || 
             (this.statCon!=null &&
              this.statCon.equals(other.getStatCon()))) &&
            ((this.scaletype==null && other.getScaletype()==null) || 
             (this.scaletype!=null &&
              this.scaletype.equals(other.getScaletype()))) &&
            ((this.accruals==null && other.getAccruals()==null) || 
             (this.accruals!=null &&
              this.accruals.equals(other.getAccruals()))) &&
            ((this.coninvolst==null && other.getConinvolst()==null) || 
             (this.coninvolst!=null &&
              this.coninvolst.equals(other.getConinvolst()))) &&
            ((this.condorigin==null && other.getCondorigin()==null) || 
             (this.condorigin!=null &&
              this.condorigin.equals(other.getCondorigin()))) &&
            ((this.groupcond==null && other.getGroupcond()==null) || 
             (this.groupcond!=null &&
              this.groupcond.equals(other.getGroupcond()))) &&
            ((this.condUpdat==null && other.getCondUpdat()==null) || 
             (this.condUpdat!=null &&
              this.condUpdat.equals(other.getCondUpdat()))) &&
            ((this.accessSeq==null && other.getAccessSeq()==null) || 
             (this.accessSeq!=null &&
              this.accessSeq.equals(other.getAccessSeq()))) &&
            ((this.condcount==null && other.getCondcount()==null) || 
             (this.condcount!=null &&
              this.condcount.equals(other.getCondcount()))) &&
            ((this.roundoffdi==null && other.getRoundoffdi()==null) || 
             (this.roundoffdi!=null &&
              this.roundoffdi.equals(other.getRoundoffdi()))) &&
            ((this.condvalue==null && other.getCondvalue()==null) || 
             (this.condvalue!=null &&
              this.condvalue.equals(other.getCondvalue()))) &&
            ((this.currency2==null && other.getCurrency2()==null) || 
             (this.currency2!=null &&
              this.currency2.equals(other.getCurrency2()))) &&
            ((this.currIso2==null && other.getCurrIso2()==null) || 
             (this.currIso2!=null &&
              this.currIso2.equals(other.getCurrIso2()))) &&
            ((this.condcntrl==null && other.getCondcntrl()==null) || 
             (this.condcntrl!=null &&
              this.condcntrl.equals(other.getCondcntrl()))) &&
            ((this.condisacti==null && other.getCondisacti()==null) || 
             (this.condisacti!=null &&
              this.condisacti.equals(other.getCondisacti()))) &&
            ((this.condclass==null && other.getCondclass()==null) || 
             (this.condclass!=null &&
              this.condclass.equals(other.getCondclass()))) &&
            this.factbasval == other.getFactbasval() &&
            ((this.scalebasin==null && other.getScalebasin()==null) || 
             (this.scalebasin!=null &&
              this.scalebasin.equals(other.getScalebasin()))) &&
            ((this.scalbasval==null && other.getScalbasval()==null) || 
             (this.scalbasval!=null &&
              this.scalbasval.equals(other.getScalbasval()))) &&
            ((this.unitmeasur==null && other.getUnitmeasur()==null) || 
             (this.unitmeasur!=null &&
              this.unitmeasur.equals(other.getUnitmeasur()))) &&
            ((this.isoUnit==null && other.getIsoUnit()==null) || 
             (this.isoUnit!=null &&
              this.isoUnit.equals(other.getIsoUnit()))) &&
            ((this.currenckey==null && other.getCurrenckey()==null) || 
             (this.currenckey!=null &&
              this.currenckey.equals(other.getCurrenckey()))) &&
            ((this.curreniso==null && other.getCurreniso()==null) || 
             (this.curreniso!=null &&
              this.curreniso.equals(other.getCurreniso()))) &&
            ((this.condincomp==null && other.getCondincomp()==null) || 
             (this.condincomp!=null &&
              this.condincomp.equals(other.getCondincomp()))) &&
            ((this.condconfig==null && other.getCondconfig()==null) || 
             (this.condconfig!=null &&
              this.condconfig.equals(other.getCondconfig()))) &&
            ((this.condchaman==null && other.getCondchaman()==null) || 
             (this.condchaman!=null &&
              this.condchaman.equals(other.getCondchaman()))) &&
            ((this.condNo==null && other.getCondNo()==null) || 
             (this.condNo!=null &&
              this.condNo.equals(other.getCondNo()))) &&
            ((this.taxCode==null && other.getTaxCode()==null) || 
             (this.taxCode!=null &&
              this.taxCode.equals(other.getTaxCode()))) &&
            ((this.varcond==null && other.getVarcond()==null) || 
             (this.varcond!=null &&
              this.varcond.equals(other.getVarcond()))) &&
            ((this.accountkey==null && other.getAccountkey()==null) || 
             (this.accountkey!=null &&
              this.accountkey.equals(other.getAccountkey()))) &&
            ((this.accountKe==null && other.getAccountKe()==null) || 
             (this.accountKe!=null &&
              this.accountKe.equals(other.getAccountKe()))) &&
            ((this.wtWithcd==null && other.getWtWithcd()==null) || 
             (this.wtWithcd!=null &&
              this.wtWithcd.equals(other.getWtWithcd()))) &&
            ((this.structcond==null && other.getStructcond()==null) || 
             (this.structcond!=null &&
              this.structcond.equals(other.getStructcond()))) &&
            this.factconbas == other.getFactconbas() &&
            ((this.condcoinhd==null && other.getCondcoinhd()==null) || 
             (this.condcoinhd!=null &&
              this.condcoinhd.equals(other.getCondcoinhd())));
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
        if (getCurrIso() != null) {
            _hashCode += getCurrIso().hashCode();
        }
        if (getCdUntIso() != null) {
            _hashCode += getCdUntIso().hashCode();
        }
        if (getRefobjtype() != null) {
            _hashCode += getRefobjtype().hashCode();
        }
        if (getRefobjkey() != null) {
            _hashCode += getRefobjkey().hashCode();
        }
        if (getReflogsys() != null) {
            _hashCode += getReflogsys().hashCode();
        }
        if (getApplicatio() != null) {
            _hashCode += getApplicatio().hashCode();
        }
        if (getConpricdat() != null) {
            _hashCode += getConpricdat().hashCode();
        }
        if (getCalctypcon() != null) {
            _hashCode += getCalctypcon().hashCode();
        }
        if (getConbaseval() != null) {
            _hashCode += getConbaseval().hashCode();
        }
        if (getConexchrat() != null) {
            _hashCode += getConexchrat().hashCode();
        }
        if (getNumconvert() != null) {
            _hashCode += getNumconvert().hashCode();
        }
        if (getDenominato() != null) {
            _hashCode += getDenominato().hashCode();
        }
        if (getCondtype() != null) {
            _hashCode += getCondtype().hashCode();
        }
        if (getStatCon() != null) {
            _hashCode += getStatCon().hashCode();
        }
        if (getScaletype() != null) {
            _hashCode += getScaletype().hashCode();
        }
        if (getAccruals() != null) {
            _hashCode += getAccruals().hashCode();
        }
        if (getConinvolst() != null) {
            _hashCode += getConinvolst().hashCode();
        }
        if (getCondorigin() != null) {
            _hashCode += getCondorigin().hashCode();
        }
        if (getGroupcond() != null) {
            _hashCode += getGroupcond().hashCode();
        }
        if (getCondUpdat() != null) {
            _hashCode += getCondUpdat().hashCode();
        }
        if (getAccessSeq() != null) {
            _hashCode += getAccessSeq().hashCode();
        }
        if (getCondcount() != null) {
            _hashCode += getCondcount().hashCode();
        }
        if (getRoundoffdi() != null) {
            _hashCode += getRoundoffdi().hashCode();
        }
        if (getCondvalue() != null) {
            _hashCode += getCondvalue().hashCode();
        }
        if (getCurrency2() != null) {
            _hashCode += getCurrency2().hashCode();
        }
        if (getCurrIso2() != null) {
            _hashCode += getCurrIso2().hashCode();
        }
        if (getCondcntrl() != null) {
            _hashCode += getCondcntrl().hashCode();
        }
        if (getCondisacti() != null) {
            _hashCode += getCondisacti().hashCode();
        }
        if (getCondclass() != null) {
            _hashCode += getCondclass().hashCode();
        }
        _hashCode += new Float(getFactbasval()).hashCode();
        if (getScalebasin() != null) {
            _hashCode += getScalebasin().hashCode();
        }
        if (getScalbasval() != null) {
            _hashCode += getScalbasval().hashCode();
        }
        if (getUnitmeasur() != null) {
            _hashCode += getUnitmeasur().hashCode();
        }
        if (getIsoUnit() != null) {
            _hashCode += getIsoUnit().hashCode();
        }
        if (getCurrenckey() != null) {
            _hashCode += getCurrenckey().hashCode();
        }
        if (getCurreniso() != null) {
            _hashCode += getCurreniso().hashCode();
        }
        if (getCondincomp() != null) {
            _hashCode += getCondincomp().hashCode();
        }
        if (getCondconfig() != null) {
            _hashCode += getCondconfig().hashCode();
        }
        if (getCondchaman() != null) {
            _hashCode += getCondchaman().hashCode();
        }
        if (getCondNo() != null) {
            _hashCode += getCondNo().hashCode();
        }
        if (getTaxCode() != null) {
            _hashCode += getTaxCode().hashCode();
        }
        if (getVarcond() != null) {
            _hashCode += getVarcond().hashCode();
        }
        if (getAccountkey() != null) {
            _hashCode += getAccountkey().hashCode();
        }
        if (getAccountKe() != null) {
            _hashCode += getAccountKe().hashCode();
        }
        if (getWtWithcd() != null) {
            _hashCode += getWtWithcd().hashCode();
        }
        if (getStructcond() != null) {
            _hashCode += getStructcond().hashCode();
        }
        _hashCode += new Float(getFactconbas()).hashCode();
        if (getCondcoinhd() != null) {
            _hashCode += getCondcoinhd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapicond.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapicond"));
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
        elemField.setFieldName("condValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CondValue"));
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
        elemField.setFieldName("condUnit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CondUnit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condPUnt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CondPUnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currIso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CurrIso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdUntIso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CdUntIso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refobjtype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Refobjtype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refobjkey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Refobjkey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reflogsys");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Reflogsys"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicatio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Applicatio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conpricdat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Conpricdat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calctypcon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Calctypcon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conbaseval");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Conbaseval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conexchrat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Conexchrat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numconvert");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Numconvert"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("denominato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Denominato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condtype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Condtype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statCon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "StatCon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scaletype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Scaletype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accruals");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Accruals"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coninvolst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Coninvolst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condorigin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Condorigin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupcond");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Groupcond"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condUpdat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CondUpdat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accessSeq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AccessSeq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condcount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Condcount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roundoffdi");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Roundoffdi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condvalue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Condvalue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Currency2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currIso2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CurrIso2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condcntrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Condcntrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condisacti");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Condisacti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condclass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Condclass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("factbasval");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Factbasval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scalebasin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Scalebasin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scalbasval");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Scalbasval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unitmeasur");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Unitmeasur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isoUnit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IsoUnit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currenckey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Currenckey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("curreniso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Curreniso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condincomp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Condincomp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condconfig");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Condconfig"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condchaman");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Condchaman"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CondNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TaxCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varcond");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Varcond"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountkey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Accountkey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountKe");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AccountKe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wtWithcd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "WtWithcd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("structcond");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Structcond"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("factconbas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Factconbas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condcoinhd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Condcoinhd"));
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
