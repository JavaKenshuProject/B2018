package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.LicenseDAO;
import model.entity.LicenseBean;

/**
 * Servlet implementation class LicenseRegistrationServlet
 */
@WebServlet("/LicenseRegistrationServlet")
public class LicenseRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LicenseRegistrationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String empCode=request.getParameter("emp_code");
		String licenseName=request.getParameter("license_name");
		Date licenseDate=Date.valueOf(request.getParameter("get_license_date"));

		LicenseBean bean = new LicenseBean();
		bean.setEmpCode(empCode);
		bean.setLicenseName(licenseName);
		bean.setGetLicenseDate(licenseDate);

		HttpSession session = request.getSession();
		session.setAttribute("licensebean", bean);

		response.setContentType("text/html; charset=UTF-8");

		LicenseDAO dao =new LicenseDAO();

		if(licenseDate==null) {
			dao.licenseRegistration(empCode, licenseName);
		}else {
			dao.licenseRegistration(empCode, licenseName, licenseDate);
		}


		String url =null;

		url = "licenceRegistrationComp.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);


	}

}
