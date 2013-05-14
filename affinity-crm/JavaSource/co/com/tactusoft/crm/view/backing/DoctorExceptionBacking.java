package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmDoctorException;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.DoctorExceptionDataModel;

@Named
@Scope("view")
public class DoctorExceptionBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tableService;

	private List<CrmDoctorException> list;
	private DoctorExceptionDataModel model;
	private CrmDoctorException selected;

	private List<SelectItem> listDoctor;
	private Map<BigDecimal, CrmDoctor> mapDoctor;
	private CrmDoctor selectedDoctor;
	private BigDecimal idDoctor;
	private Date currentDate;

	private boolean disabled;
	private boolean disabledSearch;
	private boolean disabledNew;

	private List<String> listBranchSelected;

	public DoctorExceptionBacking() {
		newAction();
	}

	public List<CrmDoctorException> getList() {
		return list;
	}

	public void setList(List<CrmDoctorException> list) {
		this.list = list;
	}

	public DoctorExceptionDataModel getModel() {
		return model;
	}

	public void setModel(DoctorExceptionDataModel model) {
		this.model = model;
	}

	public CrmDoctorException getSelected() {
		return selected;
	}

	public void setSelected(CrmDoctorException selected) {
		this.selected = selected;
	}

	public List<SelectItem> getListDoctor() {
		if (listDoctor == null) {
			listDoctor = new LinkedList<SelectItem>();
			mapDoctor = new HashMap<BigDecimal, CrmDoctor>();

			String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
			listDoctor.add(new SelectItem(Constant.DEFAULT_VALUE, label));
			for (CrmDoctor row : tableService.getListDoctorActive()) {
				mapDoctor.put(row.getId(), row);
				listDoctor.add(new SelectItem(row.getId(), row.getNames()));
			}

		}
		return listDoctor;
	}

	public void setListDoctor(List<SelectItem> listDoctor) {
		this.listDoctor = listDoctor;
	}

	public CrmDoctor getSelectedDoctor() {
		return selectedDoctor;
	}

	public void setSelectedDoctor(CrmDoctor selectedDoctor) {
		this.selectedDoctor = selectedDoctor;
	}

	public BigDecimal getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(BigDecimal idDoctor) {
		this.idDoctor = idDoctor;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public boolean isDisabledSearch() {
		return disabledSearch;
	}

	public void setDisabledSearch(boolean disabledSearch) {
		this.disabledSearch = disabledSearch;
	}

	public boolean isDisabledNew() {
		return disabledNew;
	}

	public void setDisabledNew(boolean disabledNew) {
		this.disabledNew = disabledNew;
	}

	public List<String> getListBranchSelected() {
		return listBranchSelected;
	}

	public void setListBranchSelected(List<String> listBranchSelected) {
		this.listBranchSelected = listBranchSelected;
	}

	public void newAction() {
		selected = new CrmDoctorException();
		currentDate = new Date();
		idDoctor = Constant.DEFAULT_VALUE;
		disabled = true;
		disabledSearch = true;
		disabledNew = true;
		listBranchSelected = new LinkedList<String>();
	}

	public void saveAction() {
		String message = null;

		if (selected.getId() == null) {
			selected.setCrmDoctor(selectedDoctor);
		}

		int result = 0;
		if (listBranchSelected.size() == listCrmBranch.size()) {
			selected.setCrmBranch(null);
			result = tableService.saveDoctorException(selected);
		} else {
			int i = 0;
			for (String id : listBranchSelected) {
				if (i > 0) {
					selected.setId(null);
				}
				CrmBranch crmBranch = new CrmBranch();
				crmBranch.setId(new BigDecimal(id));
				selected.setCrmBranch(crmBranch);
				result = tableService.saveDoctorException(selected);
				i++;
			}
		}

		if (result == 0) {
			list = tableService.getListDoctorExceptionByDoctor(selectedDoctor
					.getId());
			model = new DoctorExceptionDataModel(list);
			message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		} else if (result == -1) {
			String paramValue = FacesUtil.getMessage("hol_date");
			message = FacesUtil.getMessage("msg_record_unique_exception",
					paramValue);
			FacesUtil.addError(message);
		}
	}

	public void searchAction() {
		selectedDoctor = mapDoctor.get(idDoctor);
		list = tableService.getListDoctorExceptionByDoctor(idDoctor);
		model = new DoctorExceptionDataModel(list);

		if (list.size() > 0) {
			selected = list.get(0);
			disabledSearch = false;
		} else {
			selected = new CrmDoctorException();
			disabledSearch = true;
		}

		disabledNew = false;
	}

	public void editAction(ActionEvent event) {
		listBranchSelected = new LinkedList<String>();
		if (selected.getCrmBranch() == null) {
			for (SelectItem brc : listCrmBranch) {
				String id = brc.getValue().toString();
				listBranchSelected.add(id);
			}
		} else {
			listBranchSelected.add(selected.getCrmBranch().getId().toString());
		}
	}

	public void removeAction() {
		if (selected != null) {
			tableService.remove("CrmDoctorException", selected.getId());
			list = tableService.getListDoctorExceptionByDoctor(idDoctor);
			model = new DoctorExceptionDataModel(list);
			if (list.size() > 0) {
				selected = list.get(0);
			}
			String message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		}
	}

	public void handleDoctorChange() {
		list = new LinkedList<CrmDoctorException>();
		model = new DoctorExceptionDataModel(list);
		disabledSearch = true;
		selectedDoctor = mapDoctor.get(idDoctor);

		if (idDoctor.intValue() != -1) {
			disabled = false;
		} else {
			disabled = true;
		}
		disabledNew = true;
	}

}
