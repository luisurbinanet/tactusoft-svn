package co.com.tactusoft.crm.view.beans;

import java.io.Serializable;
import java.util.List;

public class ResultSearchAppointment implements Serializable {

	private static final long serialVersionUID = 1L;
	private String message;
	private List<Candidate> listCandidate;

	public ResultSearchAppointment() {

	}

	public ResultSearchAppointment(String message, List<Candidate> listCandidate) {
		this.message = message;
		this.listCandidate = listCandidate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Candidate> getListCandidate() {
		return listCandidate;
	}

	public void setListCandidate(List<Candidate> listCandidate) {
		this.listCandidate = listCandidate;
	}

}
