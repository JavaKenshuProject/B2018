package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.EmployeeDAO;
import model.dao.LicenseDAO;
import model.entity.EmployeeBean;
import model.entity.LicenseBean;

/**
 * Servlet implementation class LicenseRegistrationServlet
 */
/**
 * @author user Namioka
 *
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
		String url =null;
		String action = request.getParameter("ACTION");

		HttpSession session = request.getSession();
		//入力された内容を取り出す


		if("保有資格追加".equals(action)) {
			LicenseDAO lcDAO = new LicenseDAO();
			EmployeeDAO empDAO = new EmployeeDAO();

			try {
				List<LicenseBean> lclist = lcDAO.getLicenseList();
				session.setAttribute("lclist", lclist);

				List<EmployeeBean> emplist = empDAO.selectAllEmployee();
				session.setAttribute("emplist", emplist);

				url = "licenseRegistration.jsp";
			} catch (ClassNotFoundException | SQLException e) {
				url="employeeListError.jsp";
			}
			session.removeAttribute("licensebean");

		}else if("追加".equals(action)){

			String empCode=request.getParameter("emp_code");
			String licenseName=request.getParameter("license_name");
			Date licenseDate;
			if("".equals(request.getParameter("get_license_date"))) {
				licenseDate = null;
			}else {
				licenseDate=Date.valueOf(request.getParameter("get_license_date"));
			}


			//LicenseBeanを生成し、値を受け渡す
			LicenseBean bean = new LicenseBean();
			bean.setEmpCode(empCode);
			bean.setLicenseName(licenseName);
			bean.setGetLicenseDate(licenseDate);

			//Sessionを生成し、値が入ったbeanを格納する
			session.setAttribute("licensebean", bean);

			response.setContentType("text/html; charset=UTF-8");


			//もし取得日が入力されなかったらif文内の処理、入力されたらelse内の処理をする
			try {
				LicenseDAO dao =new LicenseDAO();

				if(licenseDate==null) {
					dao.registerGetLicense(empCode, licenseName);
					url = "licenseRegistrationComp.jsp";

				}else {
					dao.registerGetLicense(empCode, licenseName, licenseDate);
					url = "licenseRegistrationComp.jsp";
				}


			} catch (ClassNotFoundException | SQLException e) {
				url = "licenseRegistrationError.jsp";

			}
		}else{
			LicenseDAO lcDAO = new LicenseDAO();
			try {
				List<LicenseBean> lclist = lcDAO.getLicenseList();
				session.setAttribute("lclist", lclist);

				url = "licenseRegistration.jsp";
			} catch (ClassNotFoundException | SQLException e) {
				url="employeeListError.jsp";
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);


	}

}
