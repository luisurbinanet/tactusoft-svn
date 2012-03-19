package co.com.tactusoft.medical.view.backing;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medical.controller.bo.SecurityBo;
import co.com.tactusoft.medical.model.entities.MedRole;
import co.com.tactusoft.medical.model.entities.MedUser;
import co.com.tactusoft.medical.util.Constant;
import co.com.tactusoft.medical.util.FacesUtil;
import co.com.tactusoft.medical.view.datamodel.UserDataModel;

@Named
@Scope("view")
public class UserBacking {

	@Inject
	private SecurityBo service;

	private List<MedUser> list;
	private MedUser selected;
	private UserDataModel model;

	private List<SelectItem> listRole;
	private Map<BigDecimal, MedRole> mapRole;

	private MedUser currentUser;
	private String password;

	public UserBacking() {
		model = null;
		listRole = new LinkedList<SelectItem>();
		mapRole = new HashMap<BigDecimal, MedRole>();
		selected = new MedUser();
		selected.setMedRole(new MedRole());
	}

	public void init() {
		list = service.getListMedUser();
		model = new UserDataModel(list);
	}

	public List<MedUser> getList() {
		return list;
	}

	public void setList(List<MedUser> list) {
		this.list = list;
	}

	public MedUser getSelected() {
		return selected;
	}

	public void setSelected(MedUser selected) {
		this.selected = selected;
	}

	public UserDataModel getModel() {
		if (model == null) {
			list = service.getListMedUser();
			model = new UserDataModel(list);
		}
		return model;
	}

	public void setModel(UserDataModel model) {
		this.model = model;
	}

	public List<SelectItem> getListRole() {
		if (listRole.size() == 0) {
			List<MedRole> list = service.getListMedRole();
			for (MedRole row : list) {
				SelectItem item = new SelectItem(row.getId(), row.getName());
				listRole.add(item);

				mapRole.put(row.getId(), row);
			}
		}
		return listRole;
	}

	public void setListRole(List<SelectItem> listRole) {
		this.listRole = listRole;
	}

	public MedUser getCurrentUser() {
		currentUser = FacesUtil.getCurrentUser();
		return currentUser;
	}

	public void setCurrentUser(MedUser currentUser) {
		this.currentUser = currentUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void newAction() {
		selected = new MedUser();
		selected.setMedRole(new MedRole());
	}

	public void refreshAction() {

	}

	public void saveAction() {
		String message = null;
		String action = FacesUtil.getParam("action");

		if (action.equals("CHANGE_PASSWORD")) {
			currentUser.setPassword(FacesUtil.getMD5(password));
			selected = currentUser;
		} else {
			selected.setUsername(selected.getUsername().toLowerCase());
			selected.setMedRole(mapRole.get(selected.getMedRole().getId()));
		}

		if (selected.getId() == null) {
			selected.setId(service.getId("MedUser"));
			selected.setPassword(FacesUtil.getMD5("123"));
			selected.setState(Constant.STATE_ACTIVE);
			message = FacesUtil.getMessage("msg_record_ok_3");
		} else {
			message = FacesUtil.getMessage("msg_record_ok_2");
		}

		service.save(selected);
		list = service.getListMedUser();
		model = new UserDataModel(list);

		FacesUtil.addInfo(message);
	}

}
