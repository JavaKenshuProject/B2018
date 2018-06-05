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

import model.dao.ChangeLogDAO;
import model.entity.ChangeLogBean;

/**
 * Servlet implementation class ChangeLogServlet
 *
 * @author okawa
 */
@WebServlet("/ChangeLogServlet")
public class ChangeLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public ChangeLogServlet() {
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

		ChangeLogDAO dao = new ChangeLogDAO();
		List<ChangeLogBean> changeLogList = dao.selectAll();

		HttpSession session = request.getSession();
		session.setAttribute("changeLogList", changeLogList);

		RequestDispatcher rd = request.getRequestDispatcher("changeLog.jsp");
		rd.forward(request, response);
	}

}
