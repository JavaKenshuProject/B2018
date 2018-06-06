package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.SectionDAO;
import model.dao.UserDAO;
import model.entity.SectionBean;
import model.entity.UserBean;

/**
 * Servlet implementation class UserRegistrationServlet
 *
 */
@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistrationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("ACTION");
		String url = null;

		if("システム利用者追加".equals(action)) {
			HttpSession session = request.getSession();

			try {
				SectionDAO secDAO = new SectionDAO();
				List<SectionBean> sectionlist = secDAO.getSectionList();

				session.setAttribute("sectionlist", sectionlist);

				url = "userRegistration.jsp";

			}catch(Exception e) {
				url = "employeeListError.jsp";
			}


		}else if ("追加".equals(action)) {

			String userId = request.getParameter("user_id");
			String password = request.getParameter("password");
			String sectionCode = request.getParameter("section_code");

			UserBean ub = new UserBean();

			ub.setUserId(userId);
			ub.setPassword(password);
			ub.setSectionCode(sectionCode);

			try{
				UserDAO usDAO = new UserDAO();
				usDAO.userRegistration(userId, password, sectionCode);

				url = "userRegistrationComp.jsp";
			}catch(Exception e) {
				url = "userRegistrationError.jsp";
			}


		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);


	}

}
