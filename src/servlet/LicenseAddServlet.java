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

import model.dao.LicenseDAO;
import model.entity.LicenseBean;

/**
 * Servlet implementation class LicenseAddServlet
 */
/**
 * @author user Namioka
 *
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

		request.setCharacterEncoding("UTF-8");
		String url =null;
		String action = request.getParameter("ACTION");

		if("新規資格追加".equals(action)) {

			url="licenseAdd.jsp";

		}else if("追加".equals(action)){

			//入力された値を取ってくる
			String licenseCode = request.getParameter("license_code");
			String licenseName = request.getParameter("license_name");

			//LicenseBeanをインスタンス化して値をセットして取り出す
			LicenseBean bean = new LicenseBean();
			bean.setLicenseCode(licenseCode);
			bean.setLicenseName(licenseName);


			//beanに入った値をsessionに入れて渡す
			HttpSession session =request.getSession();
			session.setAttribute("licenseaddbean",bean );

			response.setContentType("text/html; charset=UTF-8");

			//try内でエラーが出たらエラー画面へ遷移する
			try {
				LicenseDAO dao = new LicenseDAO();
				dao.licenseAdd(licenseCode, licenseName);

				url = "licenseAddComp.jsp";

			} catch (ClassNotFoundException | SQLException e) {
				url = "licenceAddError.jsp";

			}
		}


		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);


	}

}
