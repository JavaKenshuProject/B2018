package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.EmployeeDAO;
import model.dao.LicenseDAO;
import model.dao.SectionDAO;
import model.entity.EmployeeBean;
import model.entity.LicenseBean;
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
			if(session.getAttribute("secionList") == null) {
				//部署一覧を取得
				SectionDAO sDao = new SectionDAO();
				List<SectionBean> sectionList = sDao.getSectionList();
				session.setAttribute("sectionList", sectionList);
			}
			if(session.getAttribute("licenseList") == null) {
				//資格一覧を取得
				LicenseDAO lDao = new LicenseDAO();
				List<LicenseBean> licenseList = lDao.getLicenseList();
				//マップで保存
				Map<String,String> licenseMap = new HashMap<>();
				for(LicenseBean license: licenseList) {
					licenseMap.put(license.getLicenseCode(), license.getLicenseName());
				}
				session.setAttribute("licenseMap", licenseMap);
			}


			if("従業員一覧".equals(action)) {
				eDao = new EmployeeDAO();
				empList = eDao.selectAll();
				session.removeAttribute("initial");
				session.removeAttribute("section_name");
				session.removeAttribute("sex");
				session.removeAttribute("sort");
				session.removeAttribute("order");
				session.removeAttribute("name");
			}else if("絞り込み".equals(action)){
				String initial = request.getParameter("initial");
				String sectionName = request.getParameter("section_name");
				byte sex = Byte.parseByte(request.getParameter("sex"));
				String sort = request.getParameter("sort");
				String order = request.getParameter("order");
				String name = request.getParameter("name");

				session.setAttribute("initial",initial);
				session.setAttribute("section_name",sectionName);
				session.setAttribute("sex",String.valueOf(sex));
				session.setAttribute("sort",sort);
				session.setAttribute("order",order);
				session.setAttribute("name",name);
				eDao = new EmployeeDAO();
				empList = eDao.select(name, sex, sectionName, initial, sort, order);
			}else {
				eDao = new EmployeeDAO();
				empList = eDao.selectAll();
				session.removeAttribute("initial");
				session.removeAttribute("section_name");
				session.removeAttribute("sex");
				session.removeAttribute("sort");
				session.removeAttribute("order");
				session.removeAttribute("name");
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
