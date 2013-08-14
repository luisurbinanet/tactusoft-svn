package co.com.tactusoft.crm.view.backing;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.VwPatientTicket;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.VwPatientTicketDataModel;

@Named
@Scope("view")
public class TicketBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private List<VwPatientTicket> list;
	private VwPatientTicketDataModel model;

	private Date startDate;
	private Date endDate;

	public TicketBacking() {
		newAction();
	}

	@PostConstruct
	public void init() {

	}

	public List<VwPatientTicket> getList() {
		return list;
	}

	public void setList(List<VwPatientTicket> list) {
		this.list = list;
	}

	public VwPatientTicketDataModel getModel() {
		return model;
	}

	public void setModel(VwPatientTicketDataModel model) {
		this.model = model;
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

	public void newAction() {
		selectedsBranchObject = null;
		startDate = new Date();
		endDate = new Date();
	}

	public void searchAction(ActionEvent event) {
		if (selectedsBranchObject != null && selectedsBranchObject.length > 0) {
			String startDateString = FacesUtil.formatDate(startDate,
					"yyyy-MM-dd");
			String endDateString = FacesUtil.formatDate(endDate, "yyyy-MM-dd");

			list = tablesService.getListVwPatientTicket(selectedsBranchObject,
					startDateString, endDateString);
			model = new VwPatientTicketDataModel(list);
		} else {
			String message = FacesUtil.getMessage("app_no_branch");
			FacesUtil.addInfo(message);
		}
	}

}
