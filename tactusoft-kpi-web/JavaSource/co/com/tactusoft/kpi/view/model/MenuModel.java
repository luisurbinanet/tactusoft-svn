package co.com.tactusoft.kpi.view.model;

import java.io.Serializable;
import java.util.List;

public class MenuModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer parent;
	private String action;
	private List<MenuModel> childs;

	public MenuModel() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<MenuModel> getChilds() {
		return childs;
	}

	public void setChilds(List<MenuModel> childs) {
		this.childs = childs;
	}

}
