package co.com.tactusoft.crm.controller.bo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.VwRipsAppointment;
import co.com.tactusoft.crm.model.entities.VwRipsMedication;
import co.com.tactusoft.crm.model.entities.VwRipsPatient;
import co.com.tactusoft.crm.model.entities.VwRipsProcedure;
import co.com.tactusoft.crm.model.entities.VwRipsTransaction;
import co.com.tactusoft.crm.util.FacesUtil;

@Named
public class RIPSBo implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SEPARATOR = ",";

	@Inject
	private CustomHibernateDao dao;

	public File getListPatient(String path, String fileName,
			BigDecimal idBranch, String startDate, String endDate,
			String typeHistory) {
		File file = new File(path + "/rips_paciente" + fileName + ".txt");
		try {
			FileWriter outFile = null;
			outFile = new FileWriter(file);
			PrintWriter out = new PrintWriter(outFile);

			String sql = "FROM VwRipsPatient o WHERE o.appointmentDate BETWEEN '"
					+ startDate
					+ "' AND '"
					+ endDate
					+ "' AND o.idBranch = "
					+ idBranch + " AND typeHistory = '" + typeHistory + "'";
			List<VwRipsPatient> list = dao.find(sql);

			for (VwRipsPatient row : list) {
				StringBuilder result = new StringBuilder();
				result.append(row.getBranch());
				result.append(SEPARATOR);
				result.append(row.getDocType());
				result.append(SEPARATOR);
				result.append(row.getDoc());
				result.append(SEPARATOR);
				result.append(row.getMembership());
				result.append(SEPARATOR);
				result.append(row.getSurnames());
				result.append(SEPARATOR);
				result.append(row.getSurnames2());
				result.append(SEPARATOR);
				result.append(row.getFirstnames());
				result.append(SEPARATOR);
				result.append(row.getFirstnames2());
				result.append(SEPARATOR);
				result.append(row.getAge());
				result.append(SEPARATOR);
				result.append(row.getSizeUnit());
				result.append(SEPARATOR);
				result.append(row.getRegion());
				result.append(SEPARATOR);
				result.append(row.getCity());
				result.append(SEPARATOR);
				result.append(row.getTypeHousing());
				out.println(result.toString());
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public File getListAppointment(String path, String fileName,
			BigDecimal idBranch, String startDate, String endDate) {
		File file = new File(path + "/rips_consultas" + fileName + ".txt");
		try {
			FileWriter outFile = new FileWriter(file);
			PrintWriter out = new PrintWriter(outFile);

			String sql = "FROM VwRipsAppointment o WHERE o.id.appointmentDate BETWEEN '"
					+ startDate
					+ "' AND '"
					+ endDate
					+ "' AND o.id.idBranch = " + idBranch;
			List<VwRipsAppointment> list = dao.find(sql);

			for (VwRipsAppointment row : list) {
				try {
					StringBuilder result = new StringBuilder();
					if (row != null) {
						result.append(row.getIdBill());
						result.append(SEPARATOR);
						result.append(row.getClinic());
						result.append(SEPARATOR);
						result.append(row.getDocType());
						result.append(SEPARATOR);
						result.append(row.getDoc());
						result.append(SEPARATOR);
						result.append(FacesUtil.formatDate(
								row.getAppointmentDate(), "dd/MM/yyyy"));
						result.append(SEPARATOR);
						result.append(row.getAppointmentType());
						result.append(SEPARATOR);
						result.append(row.getAutorization());
						result.append(SEPARATOR);
						result.append(row.getAppointmentCode());
						result.append(SEPARATOR);
						result.append(row.getAppointmentTarget());
						result.append(SEPARATOR);
						result.append(row.getAppointmentExternal());
						result.append(SEPARATOR);
						result.append(row.getDiagnosis1());
						result.append(SEPARATOR);
						result.append(row.getDiagnosis2());
						result.append(SEPARATOR);
						result.append(row.getDiagnosis3());
						result.append(SEPARATOR);
						result.append(row.getDiagnosis4());
						result.append(SEPARATOR);
						result.append(row.getDiagnosisType());
						result.append(SEPARATOR);
						result.append(row.getAmount());
						result.append(SEPARATOR);
						result.append(row.getQuote());
						result.append(SEPARATOR);
						result.append(row.getTotal());
						out.println(result.toString());
					}
				} catch (Exception ex) {
					System.out.println("");
				}
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public File getListProcedure(String path, String fileName,
			BigDecimal idBranch, String startDate, String endDate) {
		File file = new File(path + "/rips_procedimientos" + fileName + ".txt");
		try {
			FileWriter outFile = new FileWriter(path + "/rips_procedimientos"
					+ fileName + ".txt");
			PrintWriter out = new PrintWriter(outFile);

			String sql = "FROM VwRipsProcedure o WHERE o.id.appointmentDate BETWEEN '"
					+ startDate
					+ "' AND '"
					+ endDate
					+ "' AND o.id.idBranch = " + idBranch;
			List<VwRipsProcedure> list = dao.find(sql);

			for (VwRipsProcedure row : list) {
				StringBuilder result = new StringBuilder();
				result.append(row.getId().getIdBill());
				result.append(SEPARATOR);
				result.append(row.getId().getClinic());
				result.append(SEPARATOR);
				result.append(row.getId().getDocType());
				result.append(SEPARATOR);
				result.append(row.getId().getDoc());
				result.append(SEPARATOR);
				result.append(FacesUtil.formatDate(row.getId()
						.getAppointmentDate(), "dd/MM/yyyy"));
				result.append(SEPARATOR);
				result.append(row.getId().getAutorization());
				result.append(SEPARATOR);
				result.append(row.getId().getProcedureType());
				result.append(SEPARATOR);
				result.append(row.getId().getProcedureCode());
				result.append(SEPARATOR);
				result.append(row.getId().getProcedureScope());
				result.append(SEPARATOR);
				result.append(row.getId().getProcedureTarget());
				result.append(SEPARATOR);
				result.append(row.getId().getPersonal());
				result.append(SEPARATOR);
				result.append(row.getId().getDiagnosis1());
				result.append(SEPARATOR);
				result.append(row.getId().getDiagnosis2());
				result.append(SEPARATOR);
				result.append(row.getId().getComplication());
				result.append(SEPARATOR);
				result.append(row.getId().getSurgical());
				result.append(SEPARATOR);
				result.append(row.getId().getAmount());
				out.println(result.toString());
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public File getListMedication(String path, String fileName,
			BigDecimal idBranch, String startDate, String endDate) {
		File file = new File(path + "/rips_medicamentos" + fileName + ".txt");
		try {
			FileWriter outFile = new FileWriter(file);
			PrintWriter out = new PrintWriter(outFile);

			String sql = "FROM VwRipsMedication o WHERE o.id.appointmentDate BETWEEN '"
					+ startDate
					+ "' AND '"
					+ endDate
					+ "' AND o.id.idBranch = " + idBranch;
			List<VwRipsMedication> list = dao.find(sql);

			for (VwRipsMedication row : list) {
				StringBuilder result = new StringBuilder();
				result.append(row.getId().getIdBill());
				result.append(SEPARATOR);
				result.append(row.getId().getClinic());
				result.append(SEPARATOR);
				result.append(row.getId().getDocType());
				result.append(SEPARATOR);
				result.append(row.getId().getDoc());
				result.append(SEPARATOR);
				result.append(FacesUtil.formatDate(row.getId()
						.getAppointmentDate(), "dd/MM/yyyy"));
				result.append(SEPARATOR);
				result.append(row.getId().getAutorization());
				result.append(SEPARATOR);
				result.append(row.getId().getMedicationCode());
				result.append(SEPARATOR);
				result.append(row.getId().getMedicationType());
				result.append(SEPARATOR);
				result.append(row.getId().getMedicationName());
				result.append(SEPARATOR);
				result.append(row.getId().getMedicationForm());
				result.append(SEPARATOR);
				result.append(row.getId().getMedicationConcentration());
				result.append(SEPARATOR);
				result.append(row.getId().getMedicationSize());
				result.append(SEPARATOR);
				result.append(row.getId().getUnit());
				result.append(SEPARATOR);
				result.append(row.getId().getAmount());
				result.append(SEPARATOR);
				result.append(row.getId().getTotal());
				out.println(result.toString());
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public File getListTransaction(String path, String fileName,
			BigDecimal idBranch, String startDate, String endDate) {
		File file = new File(path + "/rips_transacciones" + fileName + ".txt");
		try {
			FileWriter outFile = new FileWriter(file);
			PrintWriter out = new PrintWriter(outFile);

			String sql = "FROM VwRipsTransaction o WHERE o.id.appointmentDate BETWEEN '"
					+ startDate
					+ "' AND '"
					+ endDate
					+ "' AND o.id.idBranch = " + idBranch;
			List<VwRipsTransaction> list = dao.find(sql);

			for (VwRipsTransaction row : list) {
				StringBuilder result = new StringBuilder();
				result.append(row.getId().getClinic());
				result.append(SEPARATOR);
				result.append(row.getId().getDocType());
				result.append(SEPARATOR);
				result.append(row.getId().getDoc());
				result.append(SEPARATOR);
				result.append(row.getId().getIdBill());
				result.append(SEPARATOR);
				result.append(FacesUtil.formatDate(row.getId().getDateBill(),
						"dd/MM/yyyy"));
				result.append(SEPARATOR);
				result.append(row.getId().getStartDate());
				result.append(SEPARATOR);
				result.append(row.getId().getEndDate());
				result.append(SEPARATOR);
				result.append(row.getId().getEpsCode());
				result.append(SEPARATOR);
				result.append(row.getId().getEpsName());
				result.append(SEPARATOR);
				result.append(row.getId().getContract());
				result.append(SEPARATOR);
				result.append(row.getId().getBenefitPlan());
				result.append(SEPARATOR);
				result.append(row.getId().getPolicy());
				result.append(SEPARATOR);
				result.append(row.getId().getCopayment());
				result.append(SEPARATOR);
				result.append(row.getId().getCommission());
				result.append(SEPARATOR);
				result.append(row.getId().getDiscount());
				result.append(SEPARATOR);
				result.append(row.getId().getAmount());
				out.println(result.toString());
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

}
