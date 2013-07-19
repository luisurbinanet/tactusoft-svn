package co.com.tactusoft.crm.controller.bo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

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

	public FileWriter getListPatient(BigDecimal idBranch, String startDate,
			String endDate) {
		FileWriter outFile = null;
		try {
			outFile = new FileWriter("/opt/rips/rips_paciente.txt");
			PrintWriter out = new PrintWriter(outFile);

			String sql = "FROM VwRipsPatient o WHERE o.appointmentDate BETWEEN '"
					+ startDate
					+ "' AND '"
					+ endDate
					+ "' AND o.idBranch = "
					+ idBranch;
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
		return outFile;
	}
	
	public FileWriter getListAppointment(BigDecimal idBranch, String startDate,
			String endDate) {
		FileWriter outFile = null;
		try {
			outFile = new FileWriter("/opt/rips/rips_consultas.txt");
			PrintWriter out = new PrintWriter(outFile);

			String sql = "FROM VwRipsAppointment o WHERE o.id.appointmentDate BETWEEN '"
					+ startDate
					+ "' AND '"
					+ endDate
					+ "' AND o.id.idBranch = "
					+ idBranch;
			List<VwRipsAppointment> list = dao.find(sql);

			for (VwRipsAppointment row : list) {
				StringBuilder result = new StringBuilder();
				result.append(row.getId().getIdBill());
				result.append(SEPARATOR);
				result.append(row.getId().getClinic());
				result.append(SEPARATOR);
				result.append(row.getId().getDocType());
				result.append(SEPARATOR);
				result.append(row.getId().getDoc());
				result.append(SEPARATOR);
				result.append(FacesUtil.formatDate(row.getId().getAppointmentDate(),"dd/MM/yyyy"));
				result.append(SEPARATOR);
				result.append(row.getId().getAppointmentType());
				result.append(SEPARATOR);
				result.append(row.getId().getAutorization());
				result.append(SEPARATOR);
				result.append(row.getId().getAppointmentCode());
				result.append(SEPARATOR);
				result.append(row.getId().getAppointmentTarget());
				result.append(SEPARATOR);
				result.append(row.getId().getAppointmentExternal());
				result.append(SEPARATOR);
				result.append(row.getId().getDiagnosis1());
				result.append(SEPARATOR);
				result.append(row.getId().getDiagnosis2());
				result.append(SEPARATOR);
				result.append(row.getId().getDiagnosis3());
				result.append(SEPARATOR);
				result.append(row.getId().getDiagnosis4());
				result.append(SEPARATOR);
				result.append(row.getId().getDiagnosisType());
				result.append(SEPARATOR);
				result.append(row.getId().getAmount());
				result.append(SEPARATOR);
				result.append(row.getId().getQuote());
				result.append(SEPARATOR);
				result.append(row.getId().getTotal());
				out.println(result.toString());
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outFile;
	}
	
	public FileWriter getListProcedure(BigDecimal idBranch, String startDate,
			String endDate) {
		FileWriter outFile = null;
		try {
			outFile = new FileWriter("/opt/rips/rips_procedimientos.txt");
			PrintWriter out = new PrintWriter(outFile);

			String sql = "FROM VwRipsProcedure o WHERE o.id.appointmentDate BETWEEN '"
					+ startDate
					+ "' AND '"
					+ endDate
					+ "' AND o.id.idBranch = "
					+ idBranch;
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
				result.append(FacesUtil.formatDate(row.getId().getAppointmentDate(),"dd/MM/yyyy"));
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
		return outFile;
	}
	
	public FileWriter getListMedication(BigDecimal idBranch, String startDate,
			String endDate) {
		FileWriter outFile = null;
		try {
			outFile = new FileWriter("/opt/rips/rips_medicamentos.txt");
			PrintWriter out = new PrintWriter(outFile);

			String sql = "FROM VwRipsMedication o WHERE o.id.appointmentDate BETWEEN '"
					+ startDate
					+ "' AND '"
					+ endDate
					+ "' AND o.id.idBranch = "
					+ idBranch;
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
				result.append(FacesUtil.formatDate(row.getId().getAppointmentDate(),"dd/MM/yyyy"));
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
				result.append(row.getId().getUnit() );
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
		return outFile;
	}
	
	public FileWriter getListTransaction(BigDecimal idBranch, String startDate,
			String endDate) {
		FileWriter outFile = null;
		try {
			outFile = new FileWriter("/opt/rips/rips_transacciones.txt");
			PrintWriter out = new PrintWriter(outFile);

			String sql = "FROM VwRipsTransaction o WHERE o.id.appointmentDate BETWEEN '"
					+ startDate
					+ "' AND '"
					+ endDate
					+ "' AND o.id.idBranch = "
					+ idBranch;
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
				result.append(FacesUtil.formatDate(row.getId().getDateBill(),"dd/MM/yyyy"));
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
		return outFile;
	}
	
	/**
	 * 
	 * @param listaFiles
	 * @param outFilename
	 * @return
	 */
	public boolean crearZip(File[] listaFiles, String outFilename) {
		boolean resultado = false;
		byte[] buf = new byte[1024];
		try {
			// Create the ZIP file
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ZipOutputStream out = new ZipOutputStream(baos);
			// Compress the files
			for (int i = 0; i < listaFiles.length; i++) {
				FileInputStream in = new FileInputStream(listaFiles[i]);
				String strFile = (listaFiles[i]).getName();
				// Add ZIP entry to output stream.
				out.putNextEntry(new ZipEntry(strFile));
				// Transfer bytes from the file to the ZIP file
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				// Complete the entry
				out.closeEntry();
				in.close();
			}
			// Complete the ZIP file
			out.close();

			// store pdf file
			String nameFile = null; 
			/*reporte = VariablesSesion.getCarpetaAcrhivosReportes() + "Reporte"
					+ mpcCapa.getNombre() + FacesUtils.formatDate() + ".zip";*/
			FileOutputStream fileOut = new FileOutputStream(nameFile);
			baos.writeTo(fileOut);
			fileOut.close();

			// Export the File
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Object response = facesContext.getExternalContext().getResponse();

			if (response instanceof HttpServletResponse) {
				HttpServletResponse hsr = (HttpServletResponse) response;
				hsr.setContentType("application/zip");
				hsr.setHeader("Content-disposition", "attachment; filename="
						+ nameFile + ".zip");
				hsr.setContentLength(baos.size());
				ServletOutputStream output = hsr.getOutputStream();
				baos.writeTo(output);
				output.flush();
				facesContext.responseComplete();
			}

			resultado = true;
		} catch (IOException e) {
			e.printStackTrace();
			resultado = false;
		}
		return resultado;
	}

}
