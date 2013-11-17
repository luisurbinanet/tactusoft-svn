package co.com.tactusoft.crm.view.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import co.com.tactusoft.crm.model.entities.VwMedicationSold;

public class AppointmentMedicationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idAppointment;
	private String appointmentDesc;
	private List<VwMedicationSold> listMedication;
	private List<VwMedicationSold> listTherapy;
	private List<VwMedicationSold> listLabExam;

	public AppointmentMedicationBean() {

	}

	public BigDecimal getIdAppointment() {
		return idAppointment;
	}

	public void setIdAppointment(BigDecimal idAppointment) {
		this.idAppointment = idAppointment;
	}

	public String getAppointmentDesc() {
		return appointmentDesc;
	}

	public void setAppointmentDesc(String appointmentDesc) {
		this.appointmentDesc = appointmentDesc;
	}

	public List<VwMedicationSold> getListMedication() {
		return listMedication;
	}

	public void setListMedication(List<VwMedicationSold> listMedication) {
		this.listMedication = listMedication;
	}

	public List<VwMedicationSold> getListTherapy() {
		return listTherapy;
	}

	public void setListTherapy(List<VwMedicationSold> listTherapy) {
		this.listTherapy = listTherapy;
	}

	public List<VwMedicationSold> getListLabExam() {
		return listLabExam;
	}

	public void setListLabExam(List<VwMedicationSold> listLabExam) {
		this.listLabExam = listLabExam;
	}

}
