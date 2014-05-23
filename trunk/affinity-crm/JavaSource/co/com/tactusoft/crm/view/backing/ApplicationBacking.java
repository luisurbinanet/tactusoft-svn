package co.com.tactusoft.crm.view.backing;

import java.util.Date;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.tactusoft.webservice.client.beans.WSBean;

@Named
@Scope("application")
public class ApplicationBacking {

	private Date currentDate;
	private List<WSBean> listBranchs;
	private List<WSBean> listGroupSellers;
	private List<WSBean> listMaterials;
	private List<WSBean> listDocTypes;

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public List<WSBean> getListBranchs() {
		return listBranchs;
	}

	public void setListBranchs(List<WSBean> listBranchs) {
		this.listBranchs = listBranchs;
	}

	public List<WSBean> getListGroupSellers() {
		return listGroupSellers;
	}

	public void setListGroupSellers(List<WSBean> listGroupSellers) {
		this.listGroupSellers = listGroupSellers;
	}

	public List<WSBean> getListMaterials() {
		return listMaterials;
	}

	public void setListMaterials(List<WSBean> listMaterials) {
		this.listMaterials = listMaterials;
	}

	public List<WSBean> getListDocTypes() {
		return listDocTypes;
	}

	public void setListDocTypes(List<WSBean> listDocTypes) {
		this.listDocTypes = listDocTypes;
	}

}
