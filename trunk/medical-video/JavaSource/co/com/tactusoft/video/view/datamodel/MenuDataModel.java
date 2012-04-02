package co.com.tactusoft.video.view.datamodel;

import java.io.Serializable;
import java.util.List;

public class MenuDataModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer parent;
	private String page;
	private List<MenuDataModel> childs;

	public MenuDataModel() {

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

	public List<MenuDataModel> getChilds() {
		return childs;
	}

	public void setChilds(List<MenuDataModel> childs) {
		this.childs = childs;
	}

}
