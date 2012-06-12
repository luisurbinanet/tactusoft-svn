package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
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
		return modelHolidayBranch;
	}

	public void setModelHolidayBranch(BranchDataModel modelHolidayBranch) {
		this.modelHolidayBranch = modelHolidayBranch;
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
	}

	public void saveAction() {
		String message = null;

		int result = tablesService.saveHoliday(selected);
		if (result == 0) {
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

	public void generateListAction(ActionEvent event) {
		listHolidayBranch = tablesService.getListBranchByHoliday(selected
				.getId());
		modelHolidayBranch = new BranchDataModel(listHolidayBranch);
	}

}
