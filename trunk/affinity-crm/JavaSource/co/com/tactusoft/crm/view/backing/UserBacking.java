package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.primefaces.model.DualListModel;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmDepartment;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.model.entities.CrmRole;
import co.com.tactusoft.crm.model.entities.CrmUser;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.UserDataModel;

@Named
@Scope("view")
public class UserBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private List<CrmUser> list;
	private UserDataModel model;
	private CrmUser selected;

	private List<SelectItem> listProfile;
	private Map<BigDecimal, CrmProfile> mapProfile;

	private List<SelectItem> listDepartment;
	private Map<BigDecimal, CrmDepartment> mapDepartment;

	private DualListModel<CrmRole> listRole;
	private DualListModel<CrmBranch> listBranch;

	private String password;
	private CrmDoctor crmDoctor;
	private Boolean doctor;

	public UserBacking() {
		newAction();
	}

	public List<CrmUser> getList() {
		return list;
	}

	public void setList(List<CrmUser> list) {
		this.list = list;
	}

	public UserDataModel getModel() {
		if (model == null) {
			list = tablesService.getListUser();
			model = new UserDataModel(list);

			if (list.size() > 0) {
				this.setSelected(list.get(0));
			}
		}
		return model;
	}

	public void setModel(UserDataModel model) {
		this.model = model;
	}

	public CrmUser getSelected() {
		return selected;
	}

	public void setSelected(CrmUser selected) {
		this.selected = selected;
		password = this.selected.getPassword();
	}

	public List<SelectItem> getListProfile() {
		if (listProfile == null) {
			mapProfile = new HashMap<BigDecimal, CrmProfile>();
			listProfile = new LinkedList<SelectItem>();
			for (CrmProfile row : tablesService.getListProfileActive()) {
				listProfile.add(new SelectItem(row.getId(), row.getCode()));
				mapProfile.put(row.getId(), row);
			}
		}
		return listProfile;
	}

	public void setListProfile(List<SelectItem> listProfile) {
		this.listProfile = listProfile;
	}

	public List<SelectItem> getListDepartment() {
		if (listDepartment == null) {
			mapDepartment = new HashMap<BigDecimal, CrmDepartment>();
			listDepartment = new LinkedList<SelectItem>();
			for (CrmDepartment row : tablesService.getListDepartmentActive()) {
				listDepartment.add(new SelectItem(row.getId(), row.getName()));
				mapDepartment.put(row.getId(), row);
			}
		}
		return listDepartment;
	}

	public void setListDepartment(List<SelectItem> listDepartment) {
		this.listDepartment = listDepartment;
	}

	public DualListModel<CrmRole> getListRole() {
		return listRole;
	}

	public void setListRole(DualListModel<CrmRole> listRole) {
		this.listRole = listRole;
	}

	public DualListModel<CrmBranch> getListBranch() {
		return listBranch;
	}

	public void setListBranch(DualListModel<CrmBranch> listBranch) {
		this.listBranch = listBranch;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getDoctor() {
		return doctor;
	}

	public void setDoctor(Boolean doctor) {
		this.doctor = doctor;
	}

	public void newAction() {
		selected = new CrmUser();
		selected.setState(Constant.STATE_ACTIVE);
		selected.setCrmProfile(new CrmProfile());
		selected.setCrmDepartment(new CrmDepartment());

		listBranch = new DualListModel<CrmBranch>();
		listRole = new DualListModel<CrmRole>();
		generateListAction(null);

		doctor = false;
		idSpeciality = Constant.DEFAULT_VALUE;
	}

	public void saveAction() {
		String message = null;
		boolean validatePassword = true;

		if (FacesUtil.isEmptyOrBlank(selected.getPassword())
				&& selected.getId() == null) {
			String field = FacesUtil.getMessage("usr_password");
			message = FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		} else {
			if (FacesUtil.isEmptyOrBlank(selected.getPassword())
					&& selected.getId() != null) {
				selected.setPassword(password);
				validatePassword = false;
			}
		}

		if (listBranch.getTarget().size() == 0) {
			message = FacesUtil.getMessage("usr_msg_error_branch");
			FacesUtil.addError(message);
		}

		if (listRole.getTarget().size() == 0) {
			message = FacesUtil.getMessage("usr_msg_error_role");
			FacesUtil.addError(message);
		}

		if (doctor && idSpeciality.intValue() == -1) {
			message = FacesUtil.getMessage("usr_msg_error_speciality");
			FacesUtil.addError(message);
		}

		if (message == null) {
			selected.setUsername(selected.getUsername().toLowerCase());
			if (validatePassword) {
				selected.setPassword(FacesUtil.getMD5(selected.getPassword()));
			}

			selected.setCrmProfile(mapProfile.get(selected.getCrmProfile()
					.getId()));
			selected.setCrmDepartment(mapDepartment.get(selected
					.getCrmDepartment().getId()));

			if (selected.getId() == null && doctor) {
				crmDoctor = new CrmDoctor();
				crmDoctor.setCode(selected.getDoc());
				crmDoctor.setNames(selected.getSurnames().toUpperCase() + " "
						+ selected.getNames().toUpperCase());
				crmDoctor.setCrmSpeciality(mapCrmSpeciality.get(idSpeciality));
				crmDoctor.setState(Constant.STATE_ACTIVE);
			} else if (crmDoctor != null) {
				crmDoctor.setCode(selected.getDoc());
				crmDoctor.setNames(selected.getSurnames().toUpperCase() + " "
						+ selected.getNames().toUpperCase());
				crmDoctor.setCrmSpeciality(mapCrmSpeciality.get(idSpeciality));
				crmDoctor.setState(doctor ? Constant.STATE_ACTIVE
						: Constant.STATE_INACTIVE);
			}

			int result = tablesService.saveUser(selected, crmDoctor);

			if (result == 0) {
				tablesService.saveUserBranch(selected, listBranch.getTarget());
				tablesService.saveUserRole(selected, listRole.getTarget());
				list = tablesService.getListUser();
				model = new UserDataModel(list);
				message = FacesUtil.getMessage("msg_record_ok");
				FacesUtil.addInfo(message);
			} else if (result == -1) {
				String paramValue = FacesUtil.getMessage("usr_username");
				message = FacesUtil.getMessage("msg_record_unique_exception",
						paramValue);
				FacesUtil.addError(message);
			}
		}
	}

	public void generateListAction(ActionEvent event) {
		List<CrmBranch> listTargetBranch = new LinkedList<CrmBranch>();
		List<CrmBranch> listSourceBranch = new LinkedList<CrmBranch>();
		List<CrmRole> listTargetRole = new LinkedList<CrmRole>();
		List<CrmRole> listSourceRole = new LinkedList<CrmRole>();

		if (selected != null && selected.getId() != null) {

			List<CrmDoctor> listDoctor = tablesService.getDoctorByUser(selected
					.getId());
			if (listDoctor.size() > 0) {
				crmDoctor = listDoctor.get(0);
				idSpeciality = crmDoctor.getCrmSpeciality().getId();
				if (crmDoctor.getState() == Constant.STATE_ACTIVE) {
					doctor = true;
				} else {
					doctor = false;
				}
			} else {
				crmDoctor = null;
				doctor = false;
			}

			listTargetBranch = tablesService.getListBranchByUser(selected
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

			listTargetRole = securityService.getListCrmRoleByUser(selected
					.getId());
			for (CrmRole row : FacesUtil.getCurrentUserData().getListRoleAll()) {
				boolean exits = false;
				for (CrmRole avb : listTargetRole) {
					if (avb.getId().intValue() == row.getId().intValue()) {
						exits = true;
						break;
					}
				}

				if (!exits) {
					listSourceRole.add(row);
				}
			}
		} else {
			if (tablesService != null) {
				listSourceBranch = tablesService.getListBranchActive();
				listSourceRole = tablesService.getListRoleActive();
			}
		}

		listBranch = new DualListModel<CrmBranch>(listSourceBranch,
				listTargetBranch);
		listRole = new DualListModel<CrmRole>(listSourceRole, listTargetRole);
	}

	public void updatePasswordAction() {
		String message = null;
		selected = FacesUtil.getCurrentUser();
		selected.setPassword(FacesUtil.getMD5(this.password));
		int result = tablesService.saveUser(selected, null);

		if (result == 0) {
			model = new UserDataModel(list);
			message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		}
	}

}
