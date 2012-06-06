package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmDoctorException;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.DoctorExceptionDataModel;

@Named
@Scope("view")
public class DoctorExceptionBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tableService;

	private List<CrmDoctorException> list;
	private DoctorExceptionDataModel model;
	private CrmDoctorException selected;

	private List<SelectItem> listDoctor;
	private Map<BigDecimal, CrmDoctor> mapDoctor;
	private CrmDoctor selectedDoctor;
	private BigDecimal idDoctor;
	private Date selectedDate;
	private Date currentDate;

	public DoctorExceptionBacking() {
		newAction();
	}

	public List<CrmDoctorException> getList() {
		return list;
	}

	public void setList(List<CrmDoctorException> list) {
		this.list = list;
	}

	public DoctorExceptionDataModel getModel() {
		return model;
	}

	public void setModel(DoctorExceptionDataModel model) {
		this.model = model;
	}

	public CrmDoctorException getSelected() {
		return selected;
	}

	public void setSelected(CrmDoctorException selected) {
		if (selected != null) {
			this.selectedDate = selected.getStartHour();
		}
		this.selected = selected;
	}

	public List<SelectItem> getListDoctor() {
		listDoctor = new LinkedList<SelectItem>();
		mapDoctor = new HashMap<BigDecimal, CrmDoctor>();
		for (CrmDoctor row : tableService.getListDoctorActive()) {
			mapDoctor.put(row.getId(), row);
			listDoctor.add(new SelectItem(row.getId(), row.getFirstName() + " "
					+ row.getFirstSurname()));
		}
		return listDoctor;
	}

	public void setListDoctor(List<SelectItem> listDoctor) {
		this.listDoctor = listDoctor;
	}

	public CrmDoctor getSelectedDoctor() {
		return selectedDoctor;
	}

	public void setSelectedDoctor(CrmDoctor selectedDoctor) {
		this.selectedDoctor = selectedDoctor;
	}

	public BigDecimal getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(BigDecimal idDoctor) {
		this.idDoctor = idDoctor;
	}

	public Date getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public void newAction() {
		selected = new CrmDoctorException();
		selectedDate = new Date();
		currentDate = new Date();
	}

	public void saveAction() {
		String message = null;

		if (selected.getId() == null) {
			selected.setCrmDoctor(selectedDoctor);
		}

		Date startHourCompleted = FacesUtil.addHourToDate(selectedDate,
				selected.getStartHour());

		Date endHourCompleted = FacesUtil.addHourToDate(selectedDate,
				selected.getEndHour());

		selected.setStartHour(startHourCompleted);
		selected.setEndHour(endHourCompleted);

		int result = tableService.saveDoctorException(selected);
		if (result == 0) {
			list = tableService.getListDoctorExceptionByDoctor(idDoctor);
			model = new DoctorExceptionDataModel(list);
			message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		} else if (result == -1) {
			String paramValue = FacesUtil.getMessage("hol_date");
			message = FacesUtil.getMessage("msg_record_unique_exception",
					paramValue);
			FacesUtil.addError(message);
		}
	}

	public void searchAction() {
		selectedDoctor = mapDoctor.get(idDoctor);
		list = tableService.getListDoctorExceptionByDoctor(idDoctor);
		model = new DoctorExceptionDataModel(list);
	}

	public void removeAction() {
		if (selected != null) {
			tableService.remove(selected);
			list = tableService.getListDoctorExceptionByDoctor(idDoctor);
			model = new DoctorExceptionDataModel(list);
			String message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		}
	}

}