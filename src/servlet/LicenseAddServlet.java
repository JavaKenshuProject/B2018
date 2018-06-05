package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.LicenseDAO;
import model.entity.LicenseBean;

/**
 * Servlet implementation class LicenseAddServlet
 */
@WebServlet("/LicenseAddServlet")
public class LicenseAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LicenseAddServlet() {
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

		//入力された値を取ってくる
		request.setCharacterEncoding("UTF-8");
		String licenseCode = request.getParameter("license_code");
		String licenseName = request.getParameter("license_name");

		//LicenseBeanをインスタンス化して値をセットして取り出す
		LicenseBean bean = new LicenseBean();
		bean.setLicenseCode(licenseCode);
		bean.setLicenseName(licenseName);


		//値をsessionに入れて渡す
		HttpSession session =request.getSession();
		session.setAttribute("licenseaddbean",bean );


		response.setContentType("text/html; charset=UTF-8");


		LicenseDAO dao = new LicenseDAO();
		dao.licenseAdd(licenseCode, licenseName);

		String url =null;

		url = "licenseAddComp.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);


	}

}
