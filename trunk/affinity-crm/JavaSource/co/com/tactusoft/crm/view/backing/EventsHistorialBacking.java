package co.com.tactusoft.crm.view.backing;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmCampaignDetail;
import co.com.tactusoft.crm.model.entities.CrmMedication;
import co.com.tactusoft.crm.model.entities.VwAppointment;
import co.com.tactusoft.crm.util.Constant;

@Named
@Scope("view")
public class EventsHistorialBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private List<VwAppointment> listAppointment;
	private List<CrmMedication> listMedication;
	private List<CrmMedication> listTherapy;
	private List<CrmMedication> listLabExam;
	private List<CrmCampaignDetail> listCapaign;

	public EventsHistorialBacking() {
		newAction();
	}

	public List<VwAppointment> getListAppointment() {
		return listAppointment;
	}

	public void setListAppointment(List<VwAppointment> listAppointment) {
		this.listAppointment = listAppointment;
	}

	public List<CrmMedication> getListMedication() {
		return listMedication;
	}

	public void setListMedication(List<CrmMedication> listMedication) {
		this.listMedication = listMedication;
	}

	public List<CrmMedication> getListTherapy() {
		return listTherapy;
	}

	public void setListTherapy(List<CrmMedication> listTherapy) {
		this.listTherapy = listTherapy;
	}

	public List<CrmMedication> getListLabExam() {
		return listLabExam;
	}

	public void setListLabExam(List<CrmMedication> listLabExam) {
		this.listLabExam = listLabExam;
	}

	public List<CrmCampaignDetail> getListCapaign() {
		return listCapaign;
	}

	public void setListCapaign(List<CrmCampaignDetail> listCapaign) {
		this.listCapaign = listCapaign;
	}

	public void newAction() {
		optionSearchPatient = 1;
		docPatient = "";
		namePatient = "";
	}

	public void searchAction() {
		listAppointment = processService
				.getListByAppointmentByPatient(selectedPatient.getId());

		listMedication = new ArrayList<CrmMedication>();
		listTherapy = new ArrayList<CrmMedication>();
		listLabExam = new ArrayList<CrmMedication>();

		List<CrmMedication> listAllMedication = processService
				.getListMedicationByPatient(selectedPatient.getId());

		for (CrmMedication row : listAllMedication) {
			if (row.getMaterialType().equals(Constant.MATERIAL_TYPE_MEDICINE)
					|| row.getMaterialType().equals(
							Constant.MATERIAL_TYPE_OTHER_MEDICINE)) {
				listMedication.add(row);
			} else if (row.getMaterialType().equals(
					Constant.MATERIAL_TYPE_THERAPY)) {
				listTherapy.add(row);
			} else if (row.getMaterialType().equals(
					Constant.MATERIAL_TYPE_EXAMS)) {
				listLabExam.add(row);
			}
		}
	}

}
