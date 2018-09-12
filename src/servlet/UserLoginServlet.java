package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.impl.UserServiceImpl;
import entity.User;

/**
 * 用户登录
 * 
 * @author sawyer 2015-2-8
 */
@WebServlet(urlPatterns = "/userLogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService service = new UserServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userName");
		String pwd = request.getParameter("passWord");
		User user = null;
		try {
			user = service.login(name, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user != null) {
			request.getSession().setAttribute("user", user);
			request.getSession().setMaxInactiveInterval(30 * 60);
		} 
		response.sendRedirect("index.jsp");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
