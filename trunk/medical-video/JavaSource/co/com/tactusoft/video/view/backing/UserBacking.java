package co.com.tactusoft.video.view.backing;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.video.controller.bo.AdminBo;
import co.com.tactusoft.video.controller.bo.SecurityBo;
import co.com.tactusoft.video.model.entities.Role;
import co.com.tactusoft.video.model.entities.User;
import co.com.tactusoft.video.model.entities.VidUserPackage;
import co.com.tactusoft.video.model.entities.VidUserTopic;
import co.com.tactusoft.video.util.Constant;
import co.com.tactusoft.video.util.FacesUtil;
import co.com.tactusoft.video.view.datamodel.UserDataModel;
import co.com.tactusoft.video.view.datamodel.UserPackageDataModel;
import co.com.tactusoft.video.view.datamodel.UserTopicDataModel;

@Named
@Scope("view")
public class UserBacking {

	@Inject
	private SecurityBo service;

	@Inject
	private AdminBo serviceAdmin;

	private List<User> list;
	private User selected;
	private UserDataModel model;

	private List<SelectItem> listRole;
	private Map<BigDecimal, Role> mapRole;

	private User currentUser;
	private String password;

	private List<VidUserPackage> listPackage;
	private List<VidUserTopic> listTopic;

	private UserPackageDataModel modelPackage;
	private UserTopicDataModel modelTopic;

	public UserBacking() {
		model = null;
		listRole = new LinkedList<SelectItem>();
		mapRole = new HashMap<BigDecimal, Role>();
		selected = new User();
		selected.setRole(new Role());
	}

	public void init() {
		list = service.getListMedUser();
		model = new UserDataModel(list);
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public User getSelected() {
		return selected;
	}

	public void setSelected(User selected) {
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
			List<Role> list = service.getListMedRole();
			for (Role row : list) {
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

	public User getCurrentUser() {
		currentUser = FacesUtil.getCurrentUser();
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<VidUserPackage> getListPackage() {
		return listPackage;
	}

	public void setListPackage(List<VidUserPackage> listPackage) {
		this.listPackage = listPackage;
	}

	public List<VidUserTopic> getListTopic() {
		return listTopic;
	}

	public void setListTopic(List<VidUserTopic> listTopic) {
		this.listTopic = listTopic;
	}

	public UserPackageDataModel getModelPackage() {
		return modelPackage;
	}

	public void setModelPackage(UserPackageDataModel modelPackage) {
		this.modelPackage = modelPackage;
	}

	public UserTopicDataModel getModelTopic() {
		return modelTopic;
	}

	public void setModelTopic(UserTopicDataModel modelTopic) {
		this.modelTopic = modelTopic;
	}

	public void newAction() {
		selected = new User();
		selected.setRole(new Role());
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
			selected.setRole(mapRole.get(selected.getRole().getId()));
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

	public void onRowSelect(SelectEvent event) {
		BigDecimal idUser = ((User) event.getObject()).getId();
		listPackage = serviceAdmin.getListVidUserPackageByUser(idUser);
		modelPackage = new UserPackageDataModel(listPackage);
		listTopic = serviceAdmin.getListVidUserTopicByUser(idUser);
		modelTopic = new UserTopicDataModel(listTopic);
	}

}
