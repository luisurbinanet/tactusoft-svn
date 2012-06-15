package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.ProfileDataModel;

@Named
@Scope("view")
public class ProfileBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tablesService;

	private List<CrmProfile> list;
	private ProfileDataModel model;
	private CrmProfile selected;

	public ProfileBacking() {
		newAction();
	}

	public List<CrmProfile> getList() {
		return list;
	}

	public void setList(List<CrmProfile> list) {
		this.list = list;
	}

	public ProfileDataModel getModel() {
		if (model == null) {
			list = tablesService.getListProfile();
			model = new ProfileDataModel(list);
			
			if (list.size() > 0) {
				selected = list.get(0);
			}
		}
		return model;
	}

	public void setModel(ProfileDataModel model) {
		this.model = model;
	}

	public CrmProfile getSelected() {
		return selected;
	}

	public void setSelected(CrmProfile selected) {
		this.selected = selected;
	}

	public void newAction() {
		selected = new CrmProfile();
		selected.setState(Constant.STATE_ACTIVE);
	}

	public void saveAction() {
		String message = null;

		int result = tablesService.saveProfile(selected);
		if (result == 0) {
			list = tablesService.getListProfile();
			model = new ProfileDataModel(list);
			message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		} else if (result == -1) {
			String paramValue = FacesUtil.getMessage("pro_code");
			message = FacesUtil.getMessage("msg_record_unique_exception", paramValue);
			FacesUtil.addError(message);

		}
	}

}
