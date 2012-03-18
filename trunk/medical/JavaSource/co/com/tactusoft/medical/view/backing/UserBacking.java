package co.com.tactusoft.medical.view.backing;

import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medical.model.entities.MedUser;
import co.com.tactusoft.medical.view.datamodel.UserDataModel;

@Named
@Scope("session")
public class UserBacking {

	private List<MedUser> list;
	private MedUser selected;
	private UserDataModel model;

	public UserBacking() {

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
		return model;
	}

	public void setModel(UserDataModel model) {
		this.model = model;
	}

}
