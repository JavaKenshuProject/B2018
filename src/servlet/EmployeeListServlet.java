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
import model.dao.SectionDAO;
import model.entity.EmployeeBean;
import model.entity.SectionBean;

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
		EmployeeDAO eDao = null;
		List<EmployeeBean> empList = null;
		String url = null;
		HttpSession session = request.getSession();

		try {
			//部署一覧を取得
			SectionDAO sDao = new SectionDAO();
			List<SectionBean> sectionList = sDao.getSectionList();
			session.setAttribute("sectionList", sectionList);

			if("従業員一覧".equals(action)) {
				eDao = new EmployeeDAO();
				empList = eDao.selectAll();
			}else if("絞り込み".equals(action)){
				String initial = request.getParameter("initial");
				String sectionName = request.getParameter("section_name");
				byte sex = Byte.valueOf(request.getParameter("sex"));
				String sort = request.getParameter("sort");
				String order = request.getParameter("order");
				String name = request.getParameter("name");

				eDao = new EmployeeDAO();
				empList = eDao.select(name, sex, sectionName, initial, sort, order);
			}
			url = "employeeList.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			url = "employeeListError.jsp";
		}
		session.setAttribute("empList", empList);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
