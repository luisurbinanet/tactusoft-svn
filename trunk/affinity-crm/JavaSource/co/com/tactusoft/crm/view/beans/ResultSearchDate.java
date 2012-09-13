package co.com.tactusoft.crm.view.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ResultSearchDate implements Serializable {

	private static final long serialVersionUID = 1L;
	private String message;
	private List<Date> listDate;

	public ResultSearchDate() {

	}

	public ResultSearchDate(String message, List<Date> listDate) {
		this.message = message;
		this.listDate = listDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Date> getListDate() {
		return listDate;
	}

	public void setListDate(List<Date> listDate) {
		this.listDate = listDate;
	}

}
