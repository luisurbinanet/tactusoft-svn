package co.com.tactusoft.crm.view.backing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.IndPatientAppointment;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.beans.OpportunityAgenda;

@Named
@Scope("view")
public class IndicatorsBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private int type;
	private Date startDate;
	private Date endDate;

	private List<OpportunityAgenda> listOpportunityAgenda;
	private List<IndPatientAppointment> listIndPatientAppointment;

	private List<CrmAppointment> listAppointment100;
	private List<CrmAppointment> listAppointment5099;
	private List<CrmAppointment> listAppointment50;
	private List<CrmAppointment> listAppointment0;
	private List<CrmAppointment> listAppointmentFree;

	private String target;

	private enum IndicatorType {
		OPPORTUNITY_AGENDA, CONTROL_NUM, BEHAVIOR_SALE
	}

	public IndicatorsBacking() {
		newAction(null);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<OpportunityAgenda> getListOpportunityAgenda() {
		return listOpportunityAgenda;
	}

	public void setListOpportunityAgenda(
			List<OpportunityAgenda> listOpportunityAgenda) {
		this.listOpportunityAgenda = listOpportunityAgenda;
	}

	public List<IndPatientAppointment> getListIndPatientAppointment() {
		return listIndPatientAppointment;
	}

	public void setListIndPatientAppointment(
			List<IndPatientAppointment> listIndPatientAppointment) {
		this.listIndPatientAppointment = listIndPatientAppointment;
	}

	public List<CrmAppointment> getListAppointment100() {
		return listAppointment100;
	}

	public void setListAppointment100(List<CrmAppointment> listAppointment100) {
		this.listAppointment100 = listAppointment100;
	}

	public List<CrmAppointment> getListAppointment5099() {
		return listAppointment5099;
	}

	public void setListAppointment5099(List<CrmAppointment> listAppointment5099) {
		this.listAppointment5099 = listAppointment5099;
	}

	public List<CrmAppointment> getListAppointment50() {
		return listAppointment50;
	}

	public void setListAppointment50(List<CrmAppointment> listAppointment50) {
		this.listAppointment50 = listAppointment50;
	}

	public List<CrmAppointment> getListAppointment0() {
		return listAppointment0;
	}

	public void setListAppointment0(List<CrmAppointment> listAppointment0) {
		this.listAppointment0 = listAppointment0;
	}

	public List<CrmAppointment> getListAppointmentFree() {
		return listAppointmentFree;
	}

	public void setListAppointmentFree(List<CrmAppointment> listAppointmentFree) {
		this.listAppointmentFree = listAppointmentFree;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public boolean isDisabledExport() {
		boolean result = true;
		if (listOpportunityAgenda != null && listOpportunityAgenda.size() > 0
				&& type == IndicatorType.OPPORTUNITY_AGENDA.ordinal()) {
			result = false;
		} else if (listIndPatientAppointment != null
				&& listIndPatientAppointment.size() > 0
				&& type == IndicatorType.CONTROL_NUM.ordinal()) {
			result = false;
		} else if (listAppointment100 != null && listAppointment100.size() > 0
				&& type == IndicatorType.BEHAVIOR_SALE.ordinal()) {
			result = false;
		}
		return result;
	}

	public void newAction(ActionEvent event) {
		type = IndicatorType.OPPORTUNITY_AGENDA.ordinal();

		listOpportunityAgenda = new ArrayList<OpportunityAgenda>();
		listIndPatientAppointment = new ArrayList<IndPatientAppointment>();

		startDate = new Date();
		endDate = FacesUtil.addDaysToDate(startDate, 30);
		
		target = "selectedTable";
	}

	public void searchAction(ActionEvent event) {
		if (selectedsBranchObject != null && selectedsBranchObject.length > 0) {
			if (type == IndicatorType.OPPORTUNITY_AGENDA.ordinal()) {
				listOpportunityAgenda = processService
						.getListOpportunityAgenda(selectedsBranchObject,
								startDate, endDate);
			} else if (type == IndicatorType.CONTROL_NUM.ordinal()) {
				listIndPatientAppointment = processService
						.getListIndPatientAppointment(selectedsBranchObject,
								startDate, endDate);
			} else {
				listAppointment100 = processService.getListAppointment100(
						selectedsBranchObject, startDate, endDate);
				listAppointment5099 = processService.getListAppointment5099(
						selectedsBranchObject, startDate, endDate);
				listAppointment50 = processService.getListAppointment50(
						selectedsBranchObject, startDate, endDate);
				listAppointment0 = processService.getListAppointment0(
						selectedsBranchObject, startDate, endDate);
			}
		} else {
			String message = FacesUtil.getMessage("app_no_branch");
			FacesUtil.addWarn(message);
		}
	}

	public void handleTypeChange() {
		if (type == IndicatorType.OPPORTUNITY_AGENDA.ordinal()) {
			target = "selectedTable";
		} else if (type == IndicatorType.CONTROL_NUM.ordinal()) {
			target = "selectedTableControlNum";
		} else {
			target = null;
		}
	}

}
