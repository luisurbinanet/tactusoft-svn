package co.com.tactusoft.crm.view.beans;

import java.io.Serializable;
import java.util.Date;

import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmProcedureDetail;

public class OpportunityAgenda implements Serializable {

	private static final long serialVersionUID = 1L;
	private CrmBranch crmBranch;
	private CrmProcedureDetail crmProcedureDetail;
	private Date date;
	private Integer num;

	public OpportunityAgenda() {

	}

	public OpportunityAgenda(CrmBranch crmBranch,
			CrmProcedureDetail crmProcedureDetail, Date date) {
		this.crmBranch = crmBranch;
		this.crmProcedureDetail = crmProcedureDetail;
		this.date = date;
	}

	public CrmBranch getCrmBranch() {
		return crmBranch;
	}

	public void setCrmBranch(CrmBranch crmBranch) {
		this.crmBranch = crmBranch;
	}

	public CrmProcedureDetail getCrmProcedureDetail() {
		return crmProcedureDetail;
	}

	public void setCrmProcedureDetail(CrmProcedureDetail crmProcedureDetail) {
		this.crmProcedureDetail = crmProcedureDetail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}
