package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmDepartment;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.model.entities.CrmUser;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.UserDataModel;

@Named
@Scope("view")
public class UserBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tablesService;

	private List<CrmUser> list;
	private UserDataModel model;
	private CrmUser selected;

	private List<SelectItem> listProfile;
	private Map<BigDecimal, CrmProfile> mapProfile;

	private List<SelectItem> listDepartment;
	private Map<BigDecimal, CrmDepartment> mapDepartment;

	private DualListModel<CrmBranch> listBranch;

	private String password;

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

			if (listDepartment.size() > 0) {
				// selected =
			}
		}
		return listDepartment;
	}

	public void setListDepartment(List<SelectItem> listDepartment) {
		this.listDepartment = listDepartment;
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

	public void newAction() {
		listBranch = new DualListModel<CrmBranch>();
		generateListAction(null);

		selected = new CrmUser();
		selected.setState(Constant.STATE_ACTIVE);
		selected.setCrmProfile(new CrmProfile());
		selected.setCrmDepartment(new CrmDepartment());
	}

	public void saveAction() {
		String message = null;

		if (listBranch.getTarget().size() > 0) {
			
			selected.setUsername(selected.getUsername().toLowerCase());
			selected.setCrmProfile(mapProfile.get(selected.getCrmProfile()
					.getId()));
			selected.setCrmDepartment(mapDepartment.get(selected
					.getCrmDepartment().getId()));

			int result = tablesService.saveUser(selected);

			if (result == 0) {
				tablesService.saveUserBranch(selected, listBranch.getTarget());
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
		} else {
			message = FacesUtil.getMessage("usr_msg_error_branch");
			FacesUtil.addError(message);
		}
	}

	public void generateListAction(ActionEvent event) {
		List<CrmBranch> listTarget = new LinkedList<CrmBranch>();
		List<CrmBranch> listSource = new LinkedList<CrmBranch>();

		if (selected != null) {
			listTarget = tablesService.getListBranchByUser(selected.getId());

			for (CrmBranch row : FacesUtil.getCurrentUserData()
					.getListBranchAll()) {
				boolean exits = false;
				for (CrmBranch avb : listTarget) {
					if (avb.getId().intValue() == row.getId().intValue()) {
						exits = true;
						break;
					}
				}

				if (!exits) {
					listSource.add(row);
				}
			}
		} else {
			if (tablesService != null) {
				listSource = tablesService.getListBranchActive();
			}
		}

		listBranch = new DualListModel<CrmBranch>(listSource, listTarget);
	}

	public void updatePasswordAction() {
		String message = null;
		selected = FacesUtil.getCurrentUser();
		selected.setPassword(FacesUtil.getMD5(this.password));
		int result = tablesService.saveUser(selected);

		if (result == 0) {
			model = new UserDataModel(list);
			message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		}
	}

}
