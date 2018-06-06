package servlet;

import java.io.IOException;
import java.sql.SQLException;

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

/**
 * Servlet implementation class EmployeeChangeServlet
 */
/**
 * @author user Namioka
 *
 */
@WebServlet("/EmployeeChangeServlet")
public class EmployeeChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeChangeServlet() {
		super();
		// TODO Auto-generated constructor stub
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
		HttpSession session = request.getSession();
		String url = null;

		String action =request.getParameter("ACTION");
		String empCode = request.getParameter("target");

		if(action.equals("従業員情報変更")) {
			//sectionDAOをインスタンス化してsectioncodeを持ってくる
			//選択した従業員の情報も持ってくる
			try{
				SectionDAO scDao = new SectionDAO();
				session.setAttribute("scList",scDao.getSectionList());

				EmployeeDAO empDao = new EmployeeDAO();
				session.setAttribute("employee", empDao.select(empCode));

				url = "employeeChange.jsp";

			}catch(Exception e){
				url = "employeeListError.jsp";
			}

		}else if(action.equals("変更")) {


			//変更画面でクライアントが入力した情報を取ってくる

			String LName=request.getParameter("l_name");
			String FName=request.getParameter("f_name");
			String LKanaName=request.getParameter("l_kana_name");
			String FKanaName=request.getParameter("f_kana_name");
			byte Sex =Byte.parseByte(request.getParameter("sex"));
			String SectionCode =request.getParameter("section_code");


			//EmployeeBeanをインスタンス化して値を渡す
			EmployeeBean bean = new EmployeeBean();
			bean.setlName(LName);
			bean.setfName(FName);
			bean.setlKanaName(LKanaName);
			bean.setfKanaName(FKanaName);
			bean.setSex(Sex);
			bean.setSectionCode(SectionCode);

			//Sessionを生成し値が入ったbeanを格納する
			session.setAttribute("bean", bean);

			response.setContentType("text/html; charset=UTF-8");

			//tryの中でエラーが出たらエラー表示画面へ遷移するようにする
			try {
				EmployeeDAO empdao = new EmployeeDAO();
				empdao.update(bean);
				url ="employeeChangeComp.jsp";

			} catch (ClassNotFoundException | SQLException e) {

				url = "employeeChangeError.jsp";

			}
		}


		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);



	}

}
