package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmHoliday;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.BranchDataModel;
import co.com.tactusoft.crm.view.datamodel.HolidayDataModel;

@Named
@Scope("view")
public class HolidayBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tablesService;

	private List<CrmHoliday> list;
	private HolidayDataModel model;
	private CrmHoliday selected;

	private List<CrmBranch> listHolidayBranch;
	private BranchDataModel modelHolidayBranch;
	private CrmBranch[] selectedsBranch;

	private Date currentDate;

	public HolidayBacking() {
		newAction();
	}

	public List<CrmHoliday> getList() {
		return list;
	}

	public void setList(List<CrmHoliday> list) {
		this.list = list;
	}

	public HolidayDataModel getModel() {
		if (model == null) {
			list = tablesService.getListHoliday();
			model = new HolidayDataModel(list);

			if (list.size() > 0) {
				selected = list.get(0);
			}
		}
		return model;
	}

	public void setModel(HolidayDataModel model) {
		this.model = model;
	}

	public CrmHoliday getSelected() {
		return selected;
	}

	public void setSelected(CrmHoliday selected) {
		this.selected = selected;
	}

	public List<CrmBranch> getListHolidayBranch() {
		return listHolidayBranch;
	}

	public void setListHolidayBranch(List<CrmBranch> listHolidayBranch) {
		this.listHolidayBranch = listHolidayBranch;
	}

	public BranchDataModel getModelHolidayBranch() {
		if (modelHolidayBranch == null) {
			listHolidayBranch = tablesService.getListBranchActive();
			modelHolidayBranch = new BranchDataModel(listHolidayBranch);
		}
		return modelHolidayBranch;
	}

	public void setModelHolidayBranch(BranchDataModel modelHolidayBranch) {
		this.modelHolidayBranch = modelHolidayBranch;
	}

	public CrmBranch[] getSelectedsBranch() {
		return selectedsBranch;
	}

	public void setSelectedsBranch(CrmBranch[] selectedsBranch) {
		this.selectedsBranch = selectedsBranch;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public void newAction() {
		selected = new CrmHoliday();
		currentDate = new Date();
		selectedsBranch = null;
	}

	public void saveAction() {
		String message = null;

		if (selectedsBranch == null || selectedsBranch.length == 0) {
			message = FacesUtil.getMessage("hol_msg_error_not_selected_branch");
			FacesUtil.addError(message);
		} else {
			int result = tablesService.saveHoliday(selected);
			if (result == 0) {
				List<CrmBranch> listSelectedsBranch = Arrays
						.asList(selectedsBranch);
				tablesService.saveHolidayBranch(selected, listSelectedsBranch);
				list = tablesService.getListHoliday();
				model = new HolidayDataModel(list);
				message = FacesUtil.getMessage("msg_record_ok");
				FacesUtil.addInfo(message);
			} else if (result == -1) {
				String paramValue = FacesUtil.getMessage("hol_date");
				message = FacesUtil.getMessage("msg_record_unique_exception",
						paramValue);
				FacesUtil.addError(message);

			}
		}
	}

	public void generateListAction(ActionEvent event) {
		List<CrmBranch> listSelectedsBranch = tablesService
				.getListBranchByHoliday(selected.getId());
		selectedsBranch = (CrmBranch[]) listSelectedsBranch
				.toArray(new CrmBranch[listSelectedsBranch.size()]);
	}

}
