package co.com.tactusoft.crm.view.backing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.VwFirstDiagnosis;
import co.com.tactusoft.crm.util.FacesUtil;

@Named
@Scope("view")
public class FirstDiagnosisBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private Date startDate;
	private Date endDate;

	private List<VwFirstDiagnosis> list;

	public FirstDiagnosisBacking() {
		newAction(null);
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

	public List<VwFirstDiagnosis> getList() {
		return list;
	}

	public void setList(List<VwFirstDiagnosis> list) {
		this.list = list;
	}

	public void newAction(ActionEvent event) {
		list = new ArrayList<VwFirstDiagnosis>();
		endDate = new Date();
		startDate = FacesUtil.addDaysToDate(endDate, -30);
	}

	public void searchAction(ActionEvent event) {
		if (selectedsBranchObject != null && selectedsBranchObject.length > 0) {
			list = processService.getListFirstDiagnosist(selectedsBranchObject,
					startDate, endDate);
		} else {
			String message = FacesUtil.getMessage("app_no_branch");
			FacesUtil.addWarn(message);
		}
	}

}
