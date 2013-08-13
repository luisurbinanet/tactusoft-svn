package co.com.tactusoft.crm.view.backing;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmCaseStudy;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.CaseStudyDataModel;
import co.com.tactusoft.crm.view.datamodel.VwPatientTicketDataModel;

@Named
@Scope("view")
public class TicketBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private List<CrmCaseStudy> list;
	private VwPatientTicketDataModel model;
	private CrmCaseStudy selected;

	private Date startDate;
	private Date endDate;

	public TicketBacking() {
		newAction();
	}

	@PostConstruct
	public void init() {
		
	}

	public List<CrmCaseStudy> getList() {
		return list;
	}

	public void setList(List<CrmCaseStudy> list) {
		this.list = list;
	}

	public VwPatientTicketDataModel getModel() {
		return model;
	}

	public void setModel(VwPatientTicketDataModel model) {
		this.model = model;
	}

	public CrmCaseStudy getSelected() {
		return selected;
	}

	public void setSelected(CrmCaseStudy selected) {
		this.selected = selected;
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
		selected = new CrmCaseStudy();
		selectedsBranchObject = null;
		startDate = new Date();
		endDate = new Date();
	}

	public void searchAction(ActionEvent event) {
		if (selectedsBranchObject != null && selectedsBranchObject.length > 0) {
			String startDateString = FacesUtil.formatDate(startDate,
					"yyyy-MM-dd");
			String endDateString = FacesUtil.formatDate(endDate, "yyyy-MM-dd");

			list = tablesService.getListCaseStudy(startDateString,
					endDateString);
			//model = new VwPatientTicketDataModel(list);

			if (list.size() > 0) {
				selected = list.get(0);
			}
		} else {
			String message = FacesUtil.getMessage("app_no_branch");
			FacesUtil.addInfo(message);
		}
	}

}
