package co.com.tactusoft.crm.controller.bo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

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

}
