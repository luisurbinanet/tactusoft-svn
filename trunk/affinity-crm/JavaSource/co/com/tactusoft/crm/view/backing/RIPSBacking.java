package co.com.tactusoft.crm.view.backing;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.RIPSBo;
import co.com.tactusoft.crm.util.FacesUtil;

@Named("RIPSBacking")
@Scope("view")
public class RIPSBacking extends BaseBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private RIPSBo RIPSService;

	private Date startDate;
	private Date endDate;

	private Map<String, String> options;
	private List<String> selectedOptions;

	public RIPSBacking() {
		options = new HashMap<String, String>();
		options.put("Archivo de Usuarios", "RIPS1");
		options.put("Archivo de Consulta", "RIPS2");
		options.put("Archivo de Procedimientos", "RIPS3");
		options.put("Archivo de Medicamentos", "RIPS4");
		options.put("Archivo de Transacciones", "RIPS5");
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

	public void generateAction() {
		if (selectedOptions.size() > 0) {

			String fileName = FacesUtil.formatDate(new Date(),
					"yyyyMMddHHmmssS");
			String path = "c:/Temp/";

			String startDateString = FacesUtil.formatDate(this.startDate,
					"yyyy-MM-dd") + " 00:00:00";
			String endDateString = FacesUtil.formatDate(this.endDate,
					"yyyy-MM-dd") + " 23:59:59";

			File[] files = new File[selectedOptions.size()];
			int index = 0;

			for (String option : selectedOptions) {
				if (option.equals("RIPS1")) {
					files[index] = this.RIPSService.getListPatient(path,
							fileName, idBranch, startDateString, endDateString);
					index++;
				} else if (option.equals("RIPS2")) {
					files[index] = this.RIPSService.getListAppointment(path,
							fileName, idBranch, startDateString, endDateString);
					index++;
				} else if (option.equals("RIPS3")) {
					files[index] = this.RIPSService.getListProcedure(path,
							fileName, idBranch, startDateString, endDateString);
					index++;
				} else if (option.equals("RIPS4")) {
					files[index] = this.RIPSService.getListMedication(path,
							fileName, idBranch, startDateString, endDateString);
					index++;
				} else if (option.equals("RIPS5")) {
					files[index] = this.RIPSService.getListTransaction(path,
							fileName, idBranch, startDateString, endDateString);
					index++;
				}
			}

			FacesUtil.createZip(files, path, "/rips" + fileName + ".zip");

			FacesUtil.addInfo("Archivo generado " + fileName + ".zip"
					+ " exitosamente");
		}
	}
}
