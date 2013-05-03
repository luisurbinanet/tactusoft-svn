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
import co.com.tactusoft.crm.model.entities.VwRipsPatient;

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
			outFile = new FileWriter("C:/Temp/rips_paciente.txt");
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
