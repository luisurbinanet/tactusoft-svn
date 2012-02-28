package co.com.tactusoft.kpi.view.backing;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import co.com.tactusoft.kpi.util.Constant;
import co.com.tactusoft.kpi.util.FacesUtil;
import co.com.tactusoft.kpi.view.model.MenuModel;

@Controller
@Scope("session")
public class MenuBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<MenuModel> listParents;

	public MenuBacking() {
		this.init();
	}

	public void init() {
		Map<Integer, MenuModel> mapMenu = new HashMap<Integer, MenuModel>();

		MenuModel menuModel;

		for (String role : FacesUtil.getCurrentRoles()) {
			if (role.equals(Constant.ROLE_SUPER_ADMIN)) {
				menuModel = getMenuAdministration();
				mapMenu.put(menuModel.getId(), menuModel);

				menuModel = getMenuProcess();
				mapMenu.put(menuModel.getId(), menuModel);

				menuModel = getMenuReports();
				mapMenu.put(menuModel.getId(), menuModel);

			} else if (role.equals(Constant.ROLE_ADMIN)) {
				menuModel = getMenuProcess();
				mapMenu.put(menuModel.getId(), menuModel);

				menuModel = getMenuReports();
				mapMenu.put(menuModel.getId(), menuModel);
			} else if (role.equals(Constant.ROLE_USER)) {
				menuModel = getMenuReports();
				mapMenu.put(menuModel.getId(), menuModel);
			}
		}

		listParents = new LinkedList<MenuModel>();
		for (MenuModel row : mapMenu.values()) {
			listParents.add(row);
		}

	}

	public List<MenuModel> getListParents() {
		return listParents;
	}

	public void setListParents(List<MenuModel> listParents) {
		this.listParents = listParents;
	}

	private MenuModel getMenuAdministration() {
		MenuModel menuModel;
		MenuModel menuChild;
		List<MenuModel> listChilds;

		menuModel = new MenuModel();
		menuModel.setId(1);
		menuModel.setName(FacesUtil.getMessage("menu_administration"));

		listChilds = new LinkedList<MenuModel>();

		menuChild = new MenuModel();
		menuChild.setId(2);
		menuChild.setName(FacesUtil.getMessage("menu_admin_company"));
		listChilds.add(menuChild);

		menuChild = new MenuModel();
		menuChild.setId(3);
		menuChild.setName(FacesUtil.getMessage("menu_admin_user"));
		listChilds.add(menuChild);

		menuChild = new MenuModel();
		menuChild.setId(4);
		menuChild.setName(FacesUtil.getMessage("menu_admin_role"));
		listChilds.add(menuChild);

		menuChild = new MenuModel();
		menuChild.setId(5);
		menuChild.setName(FacesUtil.getMessage("menu_admin_delay"));
		listChilds.add(menuChild);

		menuChild = new MenuModel();
		menuChild.setId(6);
		menuChild.setName(FacesUtil.getMessage("menu_admin_header"));
		listChilds.add(menuChild);

		menuModel.setChilds(listChilds);

		return menuModel;
	}

	private MenuModel getMenuProcess() {
		MenuModel menuModel;
		MenuModel menuChild;
		List<MenuModel> listChilds;

		menuModel = new MenuModel();
		menuModel.setId(7);
		menuModel.setName(FacesUtil.getMessage("menu_process"));

		listChilds = new LinkedList<MenuModel>();
		menuChild = new MenuModel();
		menuChild.setId(8);
		menuChild.setName(FacesUtil.getMessage("menu_process_week"));
		listChilds.add(menuChild);

		menuChild = new MenuModel();
		menuChild.setId(9);
		menuChild.setName(FacesUtil.getMessage("menu_schedule_days"));
		listChilds.add(menuChild);

		menuChild = new MenuModel();
		menuChild.setId(10);
		menuChild.setName(FacesUtil.getMessage("menu_registry_days"));
		listChilds.add(menuChild);

		menuModel.setChilds(listChilds);

		return menuModel;
	}

	private MenuModel getMenuReports() {
		MenuModel menuModel;
		MenuModel menuChild;
		List<MenuModel> listChilds;

		menuModel = new MenuModel();
		menuModel.setId(11);
		menuModel.setName(FacesUtil.getMessage("menu_reports"));

		listChilds = new LinkedList<MenuModel>();
		menuChild = new MenuModel();
		menuChild.setId(12);
		menuChild.setName(FacesUtil.getMessage("menu_reports_daily"));
		listChilds.add(menuChild);

		menuModel.setChilds(listChilds);

		return menuModel;
	}

}
