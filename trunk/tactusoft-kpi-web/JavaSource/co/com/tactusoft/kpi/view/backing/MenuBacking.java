package co.com.tactusoft.kpi.view.backing;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.kpi.util.Constant;
import co.com.tactusoft.kpi.util.FacesUtil;
import co.com.tactusoft.kpi.view.model.MenuModel;

@Named
@Scope("session")
public class MenuBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<MenuModel> listMenu;
	
	public MenuBacking() {
		
	}

	public void init(List<String> roles) {
		Map<Integer, MenuModel> mapMenu = new HashMap<Integer, MenuModel>();

		MenuModel menuModel;

		for (String role : roles) {
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

		listMenu = new LinkedList<MenuModel>();
		for (MenuModel row : mapMenu.values()) {
			listMenu.add(row);
		}
	}

	public List<MenuModel> getListMenu() {
		if(listMenu == null){
			List<String> roles= FacesUtil.getCurrentRoles();
			init(roles);
		}
		return listMenu;
	}

	public void setListMenu(List<MenuModel> listMenu) {
		this.listMenu = listMenu;
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
		menuChild.setPage("/pages/admin/company");
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
		menuChild.setPage("/pages/admin/delay");
		listChilds.add(menuChild);

		menuChild = new MenuModel();
		menuChild.setId(6);
		menuChild.setName(FacesUtil.getMessage("menu_admin_header"));
		menuChild.setPage("/pages/admin/kpi");
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
		menuChild.setPage("/pages/process/week");
		listChilds.add(menuChild);

		menuChild = new MenuModel();
		menuChild.setId(9);
		menuChild.setName(FacesUtil.getMessage("menu_schedule_days"));
		menuChild.setPage("/pages/process/daily");
		listChilds.add(menuChild);

		menuChild = new MenuModel();
		menuChild.setId(10);
		menuChild.setName(FacesUtil.getMessage("menu_registry_days"));
		menuChild.setPage("/pages/process/registryDay");
		listChilds.add(menuChild);
		
		menuChild = new MenuModel();
		menuChild.setId(11);
		menuChild.setName(FacesUtil.getMessage("title_registry_hours"));
		menuChild.setPage("/pages/process/registryHours");
		listChilds.add(menuChild);

		menuModel.setChilds(listChilds);

		return menuModel;
	}

	private MenuModel getMenuReports() {
		MenuModel menuModel;
		MenuModel menuChild;
		List<MenuModel> listChilds;

		menuModel = new MenuModel();
		menuModel.setId(12);
		menuModel.setName(FacesUtil.getMessage("menu_reports"));

		listChilds = new LinkedList<MenuModel>();
		menuChild = new MenuModel();
		menuChild.setId(13);
		menuChild.setName(FacesUtil.getMessage("menu_reports_daily"));
		menuChild.setPage("/pages/reports/reportDaily");
		listChilds.add(menuChild);

		menuModel.setChilds(listChilds);

		return menuModel;
	}

	public String actionPage() {
		String page = FacesUtil.getParam("page");
		if (page != null) {
			page = page + "?faces-redirect=true";
		}
		return page;
	}

}
