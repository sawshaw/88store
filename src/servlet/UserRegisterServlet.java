package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;

import service.UserService;
import service.impl.UserServiceImpl;

/**
 * 用户注册
 * 
 * @author sawyer 2015-2-8
 */
@WebServlet(urlPatterns = "/userRegister")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService service = new UserServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		String user_name = request.getParameter("userName");
		String user_pwd = request.getParameter("passWord");
		String user_email = request.getParameter("email");
		user.setUser_name(user_name);
		user.setUser_pwd(user_pwd);
		user.setUser_email(user_email);
		service.register(user);
		response.sendRedirect("index.jsp");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
