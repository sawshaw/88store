package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;
import service.impl.AdminServiceImpl;

/**
 * 管理员账号存在验证
 * 
 * @author sawyer 2015-2-8
 */
@WebServlet(urlPatterns = "/adminLoginCheck")
public class AdminLoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService service = new AdminServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String admin_name = request.getParameter("admin_name");
		boolean result = false;
		try {
			result = service.loginCheck(admin_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == false) {
			response.getWriter().print("false");
		} else {
			response.getWriter().print("true");
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
