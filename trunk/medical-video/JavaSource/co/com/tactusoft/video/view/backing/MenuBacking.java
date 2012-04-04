package co.com.tactusoft.video.view.backing;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.video.util.Constant;
import co.com.tactusoft.video.util.FacesUtil;
import co.com.tactusoft.video.view.datamodel.MenuDataModel;

@Named
@Scope("session")
public class MenuBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<MenuDataModel> listMenu;

	public MenuBacking() {

	}

	public void init(String role) {
		listMenu = getMenu(role);
	}

	public List<MenuDataModel> getListMenu() {
		if (listMenu == null) {
			String role = FacesUtil.getCurrentRole();
			init(role);
		}
		return listMenu;
	}

	public void setListMenu(List<MenuDataModel> listMenu) {
		this.listMenu = listMenu;
	}

	private List<MenuDataModel> getMenu(String role) {
		List<MenuDataModel> listMenu = new LinkedList<MenuDataModel>();
		MenuDataModel menuDataModel;
		MenuDataModel menuChild;
		List<MenuDataModel> listChilds;

		menuDataModel = new MenuDataModel();
		menuDataModel.setId(1);
		menuDataModel.setName(FacesUtil.getMessage("title_video"));
		menuDataModel.setPage("/pages/view/video");
		listMenu.add(menuDataModel);

		if (role != null) {
			menuDataModel = new MenuDataModel();
			menuDataModel.setId(3);
			menuDataModel.setName(FacesUtil.getMessage("title_config"));

			listChilds = new LinkedList<MenuDataModel>();

			menuChild = new MenuDataModel();
			menuChild.setId(4);
			menuChild.setName(FacesUtil.getMessage("title_config_video"));
			menuChild.setPage("/pages/admin/topic");
			listChilds.add(menuChild);

			if (role.equals(Constant.ROLE_SUPER_ADMIN)) {
				menuChild = new MenuDataModel();
				menuChild.setId(6);
				menuChild.setName(FacesUtil.getMessage("title_config_user"));
				menuChild.setPage("/pages/admin/user");
				listChilds.add(menuChild);
			}

			menuChild = new MenuDataModel();
			menuChild.setId(7);
			menuChild.setName(FacesUtil.getMessage("title_config_password"));
			menuChild.setPage("/pages/admin/change_password");
			listChilds.add(menuChild);

			menuDataModel.setChilds(listChilds);
			listMenu.add(menuDataModel);
		}

		return listMenu;
	}

	public String actionPage() {
		String page = FacesUtil.getParam("page");
		if (page != null) {
			page = page + "?faces-redirect=true";
		}
		return page;
	}

}
