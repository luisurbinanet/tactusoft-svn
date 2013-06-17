package co.com.tactusoft.crm.view.backing;

import java.util.LinkedList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DualListModel;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmProcedureDetail;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.ProcedureDetailDataModel;

@Named
@Scope("view")
public class ProcedureBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private List<CrmProcedureDetail> list;
	private ProcedureDetailDataModel model;
	private CrmProcedureDetail selected;

	private DualListModel<CrmBranch> listModelBranch;

	public ProcedureBacking() {
		newAction(null);
	}

	public List<CrmProcedureDetail> getList() {
		return list;
	}

	public void setList(List<CrmProcedureDetail> list) {
		this.list = list;
	}

	public ProcedureDetailDataModel getModel() {
		if (model == null) {
			list = tablesService.getListProcedureDetail();
			model = new ProcedureDetailDataModel(list);

			if (list.size() > 0) {
				selected = list.get(0);
			}
		}
		return model;
	}

	public void setModel(ProcedureDetailDataModel model) {
		this.model = model;
	}

	public CrmProcedureDetail getSelected() {
		return selected;
	}

	public void setSelected(CrmProcedureDetail selected) {
		this.selected = selected;
	}

	public DualListModel<CrmBranch> getListModelBranch() {
		return listModelBranch;
	}

	public void setListModelBranch(DualListModel<CrmBranch> listModelBranch) {
		this.listModelBranch = listModelBranch;
	}

	public void newAction(ActionEvent event) {
		selected = new CrmProcedureDetail();
		selected.setState(Constant.STATE_ACTIVE);
		selected.setTimeDoctor(0);
		selected.setTimeNurses(0);
		selected.setTimeStretchers(0);

		List<CrmBranch> listSourceBranch = FacesUtil.getCurrentUserData()
				.getListBranchAll();

		listModelBranch = new DualListModel<CrmBranch>();
		listModelBranch.setSource(listSourceBranch);
	}

	public void viewAction(ActionEvent event) {
		List<CrmBranch> listTargetBranch = new LinkedList<CrmBranch>();
		List<CrmBranch> listSourceBranch = new LinkedList<CrmBranch>();

		if (selected != null && selected.getId() != null) {
			listTargetBranch = tablesService.getListBranchByProcedure(selected
					.getId());
			for (CrmBranch row : FacesUtil.getCurrentUserData()
					.getListBranchAll()) {
				boolean exits = false;
				for (CrmBranch avb : listTargetBranch) {
					if (avb.getId().intValue() == row.getId().intValue()) {
						exits = true;
						break;
					}
				}

				if (!exits) {
					listSourceBranch.add(row);
				}
			}
		} else {
			if (tablesService != null) {
				listSourceBranch = tablesService.getListBranchActive();
			}
		}

		listModelBranch = new DualListModel<CrmBranch>(listSourceBranch,
				listTargetBranch);
	}

	public void saveAction() {
		String message = null;
		boolean validate = true;
		RequestContext context = RequestContext.getCurrentInstance();

		if (FacesUtil.isEmptyOrBlank(selected.getName())) {
			String field = FacesUtil.getMessage("prc_name");
			message = FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
			validate = false;
		}

		if (selected.getTimeDoctor() < 0 || selected.getTimeNurses() < 0
				|| selected.getTimeStretchers() < 0) {
			message = FacesUtil.getMessage("prc_msg_error_times");
			FacesUtil.addError(message);
			validate = false;
		}

		if (selected.getTimeDoctor() <= 0 && selected.getTimeNurses() <= 0
				&& selected.getTimeStretchers() <= 0) {
			message = FacesUtil.getMessage("prc_msg_error_times");
			FacesUtil.addError(message);
			validate = false;
		}

		if ((selected.getTimeDoctor() % 5 != 0)
				|| (selected.getTimeNurses() % 5 != 0)
				|| (selected.getTimeStretchers() % 5 != 0)) {
			message = FacesUtil.getMessage("prc_msg_error_multiplo");
			FacesUtil.addError(message);
			validate = false;
		}

		if (selected.isNoRepeat() && selected.getNoRepeatDays() == 0) {
			message = FacesUtil.getMessage("prc_msg_error_repeat");
			FacesUtil.addError(message);
			validate = false;
		}

		if (listModelBranch.getTarget().size() == 0) {
			message = FacesUtil.getMessage("prc_msg_error_branch");
			FacesUtil.addError(message);
			validate = false;
		}

		if (validate) {
			selected.setName(selected.getName().toUpperCase());
			int result = tablesService.saveProcedureDetail(selected);
			if (result == 0) {
				tablesService.saveProcedureBranch(selected,
						listModelBranch.getTarget());

				list = tablesService.getListProcedureDetail();
				model = new ProcedureDetailDataModel(list);
				message = FacesUtil.getMessage("msg_record_ok");
				FacesUtil.addInfo(message);
			} else {
				String paramValue = FacesUtil.getMessage("prc_name");
				message = FacesUtil.getMessage("msg_record_unique_exception",
						paramValue);
				FacesUtil.addError(message);
			}
		}

		context.addCallbackParam("validate", validate);
	}

}
