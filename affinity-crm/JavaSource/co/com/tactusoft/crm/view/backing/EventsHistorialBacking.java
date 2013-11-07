package co.com.tactusoft.crm.view.backing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmCampaignDetail;
import co.com.tactusoft.crm.model.entities.CrmRecall;
import co.com.tactusoft.crm.model.entities.VwAppointment;
import co.com.tactusoft.crm.model.entities.VwMedicationSold;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;

@Named
@Scope("view")
public class EventsHistorialBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private List<VwAppointment> listAppointment;
	private List<VwMedicationSold> listMedication;
	private List<VwMedicationSold> listTherapy;
	private List<VwMedicationSold> listLabExam;
	private List<CrmCampaignDetail> listCampaign;
	private CrmCampaignDetail crmCampaignDetail;

	private Map<Integer, CrmRecall> mapRecall;
	private CampaignBacking campaignBacking;

	public EventsHistorialBacking() {
		newAction();
	}

	@PostConstruct
	public void init() {
		List<CrmRecall> listRecall = tablesService.getAllListRecall();
		mapRecall = new HashMap<Integer, CrmRecall>();
		for (CrmRecall row : listRecall) {
			mapRecall.put(row.getId(), row);
		}
	}

	public List<VwAppointment> getListAppointment() {
		return listAppointment;
	}

	public void setListAppointment(List<VwAppointment> listAppointment) {
		this.listAppointment = listAppointment;
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

	public List<CrmCampaignDetail> getListCampaign() {
		return listCampaign;
	}

	public void setListCampaign(List<CrmCampaignDetail> listCampaign) {
		this.listCampaign = listCampaign;
	}

	public CrmCampaignDetail getCrmCampaignDetail() {
		return crmCampaignDetail;
	}

	public void setCrmCampaignDetail(CrmCampaignDetail crmCampaignDetail) {
		this.crmCampaignDetail = crmCampaignDetail;
	}

	public void newAction() {
		optionSearchPatient = 1;
		docPatient = "";
		namePatient = "";
	}

	public void searchAction() {
		listAppointment = processService
				.getListByAppointmentAllByPatient(selectedPatient.getId());

		listMedication = new ArrayList<VwMedicationSold>();
		listTherapy = new ArrayList<VwMedicationSold>();
		listLabExam = new ArrayList<VwMedicationSold>();

		List<VwMedicationSold> listAllMedication = processService
				.getListMedicationSoldByPatient(selectedPatient.getId());

		for (VwMedicationSold row : listAllMedication) {
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

		searchCamapignDetail();
	}

	public void searchCamapignDetail() {
		crmCampaignDetail = new CrmCampaignDetail();
		listCampaign = tablesService
				.getListCampaignDetailByPatient(selectedPatient.getId());
		if (listCampaign.size() > 0) {
			crmCampaignDetail = listCampaign.get(0);
		}
	}

	public String getDescRecall(Integer idRecall) {
		String result = null;
		if (idRecall == 0) {
			result = "Pendiente";
		} else if (idRecall == 999) {
			result = "No Atendido";
		} else {
			result = mapRecall.get(idRecall).getDescription();
		}
		return result;
	}

	public void updateCall() {
		campaignBacking = FacesUtil.findBean("campaignBacking");
		campaignBacking.setSelected(this.crmCampaignDetail.getCrmCampaign());
		campaignBacking.generateDetail();
	}

	@Override
	public void searchPatientAction() {
		super.searchPatientAction();
		searchAction();
	}

	public void saveCampaingAction() {
		campaignBacking.saveAction();
		searchCamapignDetail();
	}

}
