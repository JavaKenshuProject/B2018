package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDAO;
import model.entity.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub

		String url = null;
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("ACTION");

		if("ログイン".equals(action)) {
			String userId = request.getParameter("user_id");
			String password = request.getParameter("password");

			try {
				UserDAO dao = new UserDAO();
				UserBean user = dao.login(userId,password);

				if(user != null) {
					url = "menu.jsp";
					HttpSession session = request.getSession();
					session.setAttribute("user",user);
				}else {
					url = "loginError.jsp";
				}
			}catch(Exception e) {
				e.printStackTrace();
				url = "loginError.jsp";
			}
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request,response);
		}
	}
}


