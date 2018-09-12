package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Admin;

import service.AdminService;
import service.impl.AdminServiceImpl;

/**
 * 管理员登录
 * 
 * @author sawyer 2015-2-8
 */
@WebServlet(urlPatterns = "/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService service = new AdminServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("adminName");
		String pwd = request.getParameter("passWord");
		Admin admin = null;
		try {
			admin = service.login(name, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (admin != null) {
			request.getSession().setAttribute("admin", admin);
			request.getSession().setMaxInactiveInterval(30 * 60);
			response.sendRedirect("back/main.jsp");
		} else {
			response.sendRedirect("adminLogin.jsp");
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
