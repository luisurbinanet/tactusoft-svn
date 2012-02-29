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
	private String page;
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

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public List<MenuModel> getChilds() {
		return childs;
	}

	public void setChilds(List<MenuModel> childs) {
		this.childs = childs;
	}

}
