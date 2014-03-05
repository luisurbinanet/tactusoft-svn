package co.com.tactusoft.crm.view.backing;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.RIPSBo;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;

@Named("RIPSBacking")
@Scope("view")
public class RIPSBacking extends BaseBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private RIPSBo RIPSService;

	private Date startDate;
	private Date endDate;

	private String typeHistory;
	private Map<String, String> options;
	private List<String> selectedOptions;

	private File[] files;
	private String fileName;
	private String path;

	public RIPSBacking() {
		options = new HashMap<String, String>();
		options.put("Archivo de Usuarios", "RIPS1");
		options.put("Archivo de Consulta", "RIPS2");
		options.put("Archivo de Procedimientos", "RIPS3");
		options.put("Archivo de Medicamentos", "RIPS4");
		options.put("Archivo de Transacciones", "RIPS5");
		typeHistory = Constant.MEDICAL_HISTORY_TYPE;
	}

	@PostConstruct
	public void init() {
		path = FacesUtil.getParameterTextValue("RUTA_ARCHIVOS_TEMPORALES")
				+ "/rips/";
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getTypeHistory() {
		return typeHistory;
	}

	public void setTypeHistory(String typeHistory) {
		this.typeHistory = typeHistory;
	}

	public Map<String, String> getOptions() {
		return options;
	}

	public void setOptions(Map<String, String> options) {
		this.options = options;
	}

	public List<String> getSelectedOptions() {
		return selectedOptions;
	}

	public void setSelectedOptions(List<String> selectedOptions) {
		this.selectedOptions = selectedOptions;
	}

	public boolean isDisabledExport() {
		return (files == null || files.length == 0) ? true : false;
	}

	public void handleHistoryTypeChange() {
		options = new HashMap<String, String>();
		options.put("Archivo de Usuarios", "RIPS1");
		options.put("Archivo de Consulta", "RIPS2");
		options.put("Archivo de Procedimientos", "RIPS3");
		options.put("Archivo de Transacciones", "RIPS5");
		if (typeHistory.equals(Constant.MEDICAL_HISTORY_TYPE)) {
			options.put("Archivo de Medicamentos", "RIPS4");
		}
	}

	public void generateAction() {
		if (selectedOptions.size() > 0) {

			fileName = FacesUtil.formatDate(new Date(), "yyyyMMddHHmmssS");
			//path = "E:/CRM/rips/";

			String startDateString = FacesUtil.formatDate(this.startDate,
					"yyyy-MM-dd") + " 00:00:00";
			String endDateString = FacesUtil.formatDate(this.endDate,
					"yyyy-MM-dd") + " 23:59:59";

			files = new File[selectedOptions.size()];
			int index = 0;

			for (String option : selectedOptions) {
				if (option.equals("RIPS1")) {
					files[index] = this.RIPSService.getListPatient(path,
							fileName, idBranch, startDateString, endDateString,
							typeHistory);
					index++;
				} else if (option.equals("RIPS2")) {
					files[index] = this.RIPSService.getListAppointment(path,
							fileName, idBranch, startDateString, endDateString,
							typeHistory);
					index++;
				} else if (option.equals("RIPS3")) {
					files[index] = this.RIPSService.getListProcedure(path,
							fileName, idBranch, startDateString, endDateString,
							typeHistory);
					index++;
				} else if (option.equals("RIPS4")) {
					files[index] = this.RIPSService.getListMedication(path,
							fileName, idBranch, startDateString, endDateString);
					index++;
				} else if (option.equals("RIPS5")) {
					files[index] = this.RIPSService.getListTransaction(path,
							fileName, idBranch, startDateString, endDateString,
							typeHistory);
					index++;
				}
			}

			FacesUtil.addInfo("Archivo generados exitosamente");
		}
	}

	public void exportAction() {
		if (files != null && files.length > 0) {
			FacesUtil.createZip(files, path, "/rips" + fileName + ".zip");
		}
	}
}
