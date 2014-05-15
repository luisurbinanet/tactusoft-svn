package co.com.tactusoft.filter;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jasperReportsServlet")
public class JasperReportsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BigDecimal idPatient = new BigDecimal(request.getParameter("idPatient"));
		String type = request.getParameter("type");
		Integer gender = new Integer(request.getParameter("gender"));

		System.out.println(idPatient + type + gender);
	}

}
