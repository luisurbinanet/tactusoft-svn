package co.com.tactusoft.medical.view.backing;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medical.util.Constant;
import co.com.tactusoft.medical.util.FacesUtil;
import co.com.tactusoft.medical.view.datamodel.MenuDataModel;

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
		Map<Integer, MenuDataModel> mapMenu = new HashMap<Integer, MenuDataModel>();

		MenuDataModel MenuDataModel;

		if (role.equals(Constant.ROLE_SUPER_ADMIN)) {
			MenuDataModel = getMenuAdministration();
			mapMenu.put(MenuDataModel.getId(), MenuDataModel);

			MenuDataModel = getMenuProcess();
			mapMenu.put(MenuDataModel.getId(), MenuDataModel);

			MenuDataModel = getMenuReports();
			mapMenu.put(MenuDataModel.getId(), MenuDataModel);

		} else if (role.equals(Constant.ROLE_ADMIN)) {
			MenuDataModel = getMenuProcess();
			mapMenu.put(MenuDataModel.getId(), MenuDataModel);

			MenuDataModel = getMenuReports();
			mapMenu.put(MenuDataModel.getId(), MenuDataModel);
		} else if (role.equals(Constant.ROLE_USER)) {
			MenuDataModel = getMenuReports();
			mapMenu.put(MenuDataModel.getId(), MenuDataModel);
		}

		listMenu = new LinkedList<MenuDataModel>();
		for (MenuDataModel row : mapMenu.values()) {
			listMenu.add(row);
		}
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

	private MenuDataModel getMenuAdministration() {
		MenuDataModel MenuDataModel;
		MenuDataModel menuChild;
		List<MenuDataModel> listChilds;

		MenuDataModel = new MenuDataModel();
		MenuDataModel.setId(1);
		MenuDataModel.setName(FacesUtil.getMessage("menu_administration"));

		listChilds = new LinkedList<MenuDataModel>();

		menuChild = new MenuDataModel();
		menuChild.setId(2);
		menuChild.setName(FacesUtil.getMessage("menu_admin_company"));
		menuChild.setPage("/pages/admin/company");
		listChilds.add(menuChild);

		menuChild = new MenuDataModel();
		menuChild.setId(3);
		menuChild.setName(FacesUtil.getMessage("menu_admin_user"));
		listChilds.add(menuChild);

		menuChild = new MenuDataModel();
		menuChild.setId(4);
		menuChild.setName(FacesUtil.getMessage("menu_admin_role"));
		listChilds.add(menuChild);

		menuChild = new MenuDataModel();
		menuChild.setId(5);
		menuChild.setName(FacesUtil.getMessage("menu_admin_delay"));
		menuChild.setPage("/pages/admin/delay");
		listChilds.add(menuChild);

		menuChild = new MenuDataModel();
		menuChild.setId(6);
		menuChild.setName(FacesUtil.getMessage("menu_admin_header"));
		menuChild.setPage("/pages/admin/kpi");
		listChilds.add(menuChild);

		MenuDataModel.setChilds(listChilds);

		return MenuDataModel;
	}

	private MenuDataModel getMenuProcess() {
		MenuDataModel MenuDataModel;
		MenuDataModel menuChild;
		List<MenuDataModel> listChilds;

		MenuDataModel = new MenuDataModel();
		MenuDataModel.setId(7);
		MenuDataModel.setName(FacesUtil.getMessage("menu_process"));

		listChilds = new LinkedList<MenuDataModel>();
		menuChild = new MenuDataModel();
		menuChild.setId(8);
		menuChild.setName(FacesUtil.getMessage("menu_process_week"));
		menuChild.setPage("/pages/process/week");
		listChilds.add(menuChild);

		menuChild = new MenuDataModel();
		menuChild.setId(9);
		menuChild.setName(FacesUtil.getMessage("menu_schedule_days"));
		menuChild.setPage("/pages/process/daily");
		listChilds.add(menuChild);

		menuChild = new MenuDataModel();
		menuChild.setId(10);
		menuChild.setName(FacesUtil.getMessage("menu_registry_days"));
		menuChild.setPage("/pages/process/registryDay");
		listChilds.add(menuChild);

		MenuDataModel.setChilds(listChilds);

		return MenuDataModel;
	}

	private MenuDataModel getMenuReports() {
		MenuDataModel MenuDataModel;
		MenuDataModel menuChild;
		List<MenuDataModel> listChilds;

		MenuDataModel = new MenuDataModel();
		MenuDataModel.setId(11);
		MenuDataModel.setName(FacesUtil.getMessage("menu_reports"));

		listChilds = new LinkedList<MenuDataModel>();
		menuChild = new MenuDataModel();
		menuChild.setId(12);
		menuChild.setName(FacesUtil.getMessage("menu_reports_daily"));
		menuChild.setPage("/pages/reports/reportDaily");
		listChilds.add(menuChild);

		MenuDataModel.setChilds(listChilds);

		return MenuDataModel;
	}

	public String actionPage() {
		String page = FacesUtil.getParam("page");
		if (page != null) {
			page = page + "?faces-redirect=true";
		}
		return page;
	}

}
