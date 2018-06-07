package servlet;

import java.io.IOException;

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
import model.entity.ChangeLogBean;
import model.entity.UserBean;

/**
 * Servlet implementation class EmployeeDeleteServlet
 *
 * @author okawa
 */
@WebServlet("/EmployeeDeleteServlet")
public class EmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDeleteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String empCode = request.getParameter("target");
		EmployeeDAO delDao = null;
		String url = null;

		HttpSession session = request.getSession();

		try {
			LicenseDAO lDao = new LicenseDAO();
			lDao.deleteGetLicense(empCode);

			delDao = new EmployeeDAO();

			delDao.deleteEmployee(empCode);

			ChangeLogDAO chlDAO = new ChangeLogDAO();
			ChangeLogBean changeLog = new ChangeLogBean();
			UserBean user = (UserBean)session.getAttribute("user");

			changeLog.setUserId(user.getUserId());
			changeLog.setOperation("削除");
			changeLog.setEmpCode(empCode);

			chlDAO.insert(changeLog);
			url = "employeeDeleteComp.jsp";
		}catch(Exception e) {
			url = "employeeDeleteError.jsp";
		}

		session.setAttribute("empCode", empCode);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
