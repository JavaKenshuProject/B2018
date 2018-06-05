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

import model.dao.EmployeeDAO;
import model.entity.EmployeeBean;

/**
 * Servlet implementation class EmployeeListServlet
 */
@WebServlet("/EmployeeListServlet")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeListServlet() {
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

		String action = request.getParameter("ACTION");
		EmployeeDAO dao = null;
		List<EmployeeBean> empList = null;

		if("従業員一覧".equals(action)) {
			dao = new EmployeeDAO();
			empList = dao.selectAll();
		}else if("絞り込み".equals(action)){
			String initial = request.getParameter("initial");
			String sectionName = request.getParameter("section_name");
			byte sex = Byte.valueOf(request.getParameter("sex"));
			String sort = request.getParameter("sort");
			String order = request.getParameter("order");
			String name = request.getParameter("name");

			dao = new EmployeeDAO();
			empList = dao.select(name, sex, sectionName, initial, sort, order);
		}

		HttpSession session = request.getSession();
		session.setAttribute("empList", empList);

		RequestDispatcher rd = request.getRequestDispatcher("employeeList.jsp");
		rd.forward(request, response);
	}

}
