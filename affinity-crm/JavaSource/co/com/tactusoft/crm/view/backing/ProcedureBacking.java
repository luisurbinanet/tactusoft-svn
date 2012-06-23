package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.model.DualListModel;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmProcedure;
import co.com.tactusoft.crm.model.entities.CrmProcedureDetail;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.ProcedureDataModel;
import co.com.tactusoft.crm.view.datamodel.ProcedureDetailDataModel;

@Named
@Scope("view")
public class ProcedureBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private List<CrmProcedure> list;
	private ProcedureDataModel model;
	private CrmProcedure selected;

	private ProcedureDetailDataModel modelProcedureDetail;
	private CrmProcedureDetail[] selectedProcedureDetail;
	private List<CrmProcedureDetail> listProcedureDetail;

	private String name;
	private Integer timeDoctor;
	private Integer timeNurses;
	private Integer timeStretchers;

	private DualListModel<CrmBranch> listModelBranch;

	public ProcedureBacking() {
		newAction();
	}

	public List<CrmProcedure> getList() {
		return list;
	}

	public void setList(List<CrmProcedure> list) {
		this.list = list;
	}

	public ProcedureDataModel getModel() {
		if (model == null) {
			list = tablesService.getListProcedure();
			model = new ProcedureDataModel(list);

			if (list.size() > 0) {
				selected = list.get(0);
			}
		}
		return model;
	}

	public void setModel(ProcedureDataModel model) {
		this.model = model;
	}

	public CrmProcedure getSelected() {
		return selected;
	}

	public void setSelected(CrmProcedure selected) {
		this.selected = selected;
	}

	public ProcedureDetailDataModel getModelProcedureDetail() {
		return modelProcedureDetail;
	}

	public void setModelProcedureDetail(
			ProcedureDetailDataModel modelProcedureDetail) {
		this.modelProcedureDetail = modelProcedureDetail;
	}

	public CrmProcedureDetail[] getSelectedProcedureDetail() {
		return selectedProcedureDetail;
	}

	public void setSelectedProcedureDetail(
			CrmProcedureDetail selectedProcedureDetail[]) {
		this.selectedProcedureDetail = selectedProcedureDetail;
	}

	public List<CrmProcedureDetail> getListProcedureDetail() {
		return listProcedureDetail;
	}

	public void setListProcedureDetail(
			List<CrmProcedureDetail> listProcedureDetail) {
		this.listProcedureDetail = listProcedureDetail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTimeDoctor() {
		return timeDoctor;
	}

	public void setTimeDoctor(Integer timeDoctor) {
		this.timeDoctor = timeDoctor;
	}

	public Integer getTimeNurses() {
		return timeNurses;
	}

	public void setTimeNurses(Integer timeNurses) {
		this.timeNurses = timeNurses;
	}

	public Integer getTimeStretchers() {
		return timeStretchers;
	}

	public void setTimeStretchers(Integer timeStretchers) {
		this.timeStretchers = timeStretchers;
	}

	public void newAction() {
		selected = new CrmProcedure();
		selected.setState(Constant.STATE_ACTIVE);

		listProcedureDetail = new LinkedList<CrmProcedureDetail>();
		modelProcedureDetail = new ProcedureDetailDataModel(listProcedureDetail);

		this.name = "";
		this.timeDoctor = 0;
		this.timeNurses = 0;
		this.timeStretchers = 0;

		listModelBranch = new DualListModel<CrmBranch>();
	}

	public void saveAction() {
		String message = null;

		if (listModelBranch.getTarget().size() == 0) {
			message = FacesUtil.getMessage("prc_msg_error_branch");
			FacesUtil.addError(message);
		}

		if (listProcedureDetail.size() == 0) {
			message = FacesUtil.getMessage("prc_msg_error_detail");
			FacesUtil.addError(message);
		}

		if (message == null) {
			int result = tablesService.saveProcedure(selected);
			if (result == 0) {
				tablesService
						.saveProcedureDetail(selected, listProcedureDetail);

				tablesService.saveProcedureBranch(selected,
						listModelBranch.getTarget());

				list = tablesService.getListProcedure();
				model = new ProcedureDataModel(list);
				message = FacesUtil.getMessage("msg_record_ok");
				FacesUtil.addInfo(message);
			} else if (result == -1) {
				String paramValue = FacesUtil.getMessage("prc_name");
				message = FacesUtil.getMessage("msg_record_unique_exception",
						paramValue);
				FacesUtil.addError(message);
			}
		}
	}

	public void addProcedureDetailAction() {
		String message = null;
		try {
			if (FacesUtil.isEmptyOrBlank(this.name)) {
				String field = FacesUtil.getMessage("prc_name");
				message = FacesUtil.getMessage("glb_required", field);
				FacesUtil.addError(message);
			}

			if (timeDoctor < 0 || timeNurses < 0 || timeStretchers < 0) {
				message = FacesUtil.getMessage("prc_msg_error_times");
				FacesUtil.addError(message);
			}

			if (timeDoctor <= 0 && timeNurses <= 0 && timeStretchers <= 0) {
				message = FacesUtil.getMessage("prc_msg_error_times");
				FacesUtil.addError(message);
			}

			if ((timeDoctor % 5 != 0) || (timeNurses % 5 != 0)
					|| (timeStretchers % 5 != 0)) {
				message = FacesUtil.getMessage("prc_msg_error_multiplo");
				FacesUtil.addError(message);
			}

			if (message == null) {
				listProcedureDetail.add(new CrmProcedureDetail(new BigDecimal(
						-1), selected, this.name, timeDoctor, timeNurses,
						timeStretchers, Constant.STATE_ACTIVE, null));
				modelProcedureDetail = new ProcedureDetailDataModel(
						listProcedureDetail);

				this.name = "";
				this.timeDoctor = 0;
				this.timeNurses = 0;
				this.timeStretchers = 0;
			}
		} catch (NumberFormatException e) {
			message = FacesUtil.getMessage("prc_msg_error_times");
			FacesUtil.addError(message);
		}
	}

	public void generateListAction(ActionEvent event) {
		listProcedureDetail = tablesService
				.getListProcedureDetailByProcedure(selected.getId());
		modelProcedureDetail = new ProcedureDetailDataModel(listProcedureDetail);

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

	public DualListModel<CrmBranch> getListModelBranch() {
		return listModelBranch;
	}

	public void setListModelBranch(DualListModel<CrmBranch> listModelBranch) {
		this.listModelBranch = listModelBranch;
	}

}
