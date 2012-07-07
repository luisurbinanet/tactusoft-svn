package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmPage;
import co.com.tactusoft.crm.util.FacesUtil;

@Named
@Scope("session")
public class MenuBacking implements Serializable {

	private static final long serialVersionUID = 1L;
	private MenuModel model;
	private List<CrmPage> listPage;

	public MenuBacking() {
		model = new DefaultMenuModel();
		listPage = FacesUtil.getCurrentUserData().getListPage();

		for (CrmPage crmPage : listPage) {
			if (crmPage.getParent() == null) {
				Submenu submenu = new Submenu();
				submenu.setLabel(crmPage.getName());
				submenu.setIcon(crmPage.getIcon());
				for (CrmPage children : listPage) {
					if ((children.getParent() != null)
							&& (children.getParent().intValue() == crmPage
									.getId().intValue())) {
						MenuItem menuItem = new MenuItem();
						menuItem.setValue(children.getName());
						menuItem.setIcon(children.getIcon());
						menuItem.setUrl(children.getPage());
						menuItem.setOnstart("refreshBacking();");
						submenu.getChildren().add(menuItem);
					}
				}
				model.addSubmenu(submenu);
			}
		}

		String closeLabel = FacesUtil.getMessage("btn_close");

		MenuItem menuItem = new MenuItem();
		menuItem.setValue(closeLabel);
		menuItem.setIcon("ui-icon-close");
		menuItem.setActionExpression(FacesUtil
				.getMethodExpression("loginBacking.logout"));
		model.addMenuItem(menuItem);

	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	public void refreshBacking() {
		HistoryBacking historyBacking = FacesUtil.findBean("historyBacking");
		historyBacking.newAction(null);

		AppointmentBacking appointmentBacking = FacesUtil
				.findBean("appointmentBacking");
		appointmentBacking.newAction(null);
	}

	public String actionPage() {
		String page = FacesUtil.getParam("page");
		if (page != null) {
			page = page + "?faces-redirect=true";
		}
		return page;
	}

}
