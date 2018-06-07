package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ChangeLogDAO;
import model.dao.EmployeeDAO;
import model.dao.LicenseDAO;
import model.dao.SectionDAO;
import model.entity.ChangeLogBean;
import model.entity.EmployeeBean;
import model.entity.LicenseBean;
import model.entity.SectionBean;
import model.entity.UserBean;

/**
 * 従業員情報登録サーブレット
 *
 * @author iwase
 *
 */
@WebServlet("/EmployeeRegistrationServlet")
public class EmployeeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * superクラスのコンストラクタ呼び出し
	 */
	public EmployeeRegistrationServlet() {
		super();
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("ACTION");
		String url = null;

		HttpSession session = request.getSession();


		if("従業員情報登録".equals(action)) {

			try {
				SectionDAO secDAO = new SectionDAO();
				List<SectionBean> sectionlist = secDAO.getSectionList();

				LicenseDAO licDAO = new LicenseDAO();
				List<LicenseBean> licenselist = licDAO.getLicenseList();

				session.setAttribute("sectionlist", sectionlist);
				session.setAttribute("licenselist", licenselist);

				url = "employeeRegistration.jsp";
			}catch(Exception e) {
				url = "employeeListError.jsp";
			}

		} else if("登録".equals(action)) {

			String empCode = request.getParameter("emp_code");
			String lName = request.getParameter("l_name");
			String fName = request.getParameter("f_name");
			String lKanaName = request.getParameter("l_kana_name");
			String fKanaName = request.getParameter("f_kana_name");
			byte sex = Byte.parseByte(request.getParameter("sex"));
			Date birthDay= Date.valueOf(request.getParameter("birth_day"));
			String sectionCode = request.getParameter("section_code");
			Date empDate = Date.valueOf(request.getParameter("emp_date"));
			List<String> licenseList = Arrays.asList(request.getParameterValues("license_code"));


			//従業員情報の登録
			EmployeeBean eb = new EmployeeBean();

			eb.setEmpCode(empCode);
			eb.setlName(lName);
			eb.setfName(fName);
			eb.setlKanaName(lKanaName);
			eb.setfKanaName(fKanaName);
			eb.setSex(sex);
			eb.setBirthDay(birthDay);
			eb.setSectionCode(sectionCode);
			eb.setEmpDate(empDate);
			eb.setLicenseList(licenseList);


			//保有資格情報の登録

			try{

				EmployeeDAO empDAO = new EmployeeDAO();
				empDAO.registerEmployee(eb);

				LicenseDAO licDAO = new LicenseDAO();

				for(String code:licenseList) {
					licDAO.licenseRegistration(empCode, code);
				}

				ChangeLogDAO chlDAO = new ChangeLogDAO();
				ChangeLogBean changeLog = new ChangeLogBean();
				UserBean user = (UserBean)session.getAttribute("user");

				changeLog.setUserId(user.getUserId());
				changeLog.setOperation("登録");
				changeLog.setEmpCode(empCode);

				chlDAO.insert(changeLog);

				url = "employeeRegistrationComp.jsp";

			} catch (ClassNotFoundException | SQLException e) {
				url = "employeeRegistrationError.jsp";
			}


		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
