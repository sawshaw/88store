package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;

import service.UserService;
import service.impl.UserServiceImpl;

/**
 * 新增用户
 * 
 * @author sawyer 2015-2-8
 */
@WebServlet(urlPatterns = "/addUser")
public class UserAddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService service = new UserServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		String user_name = request.getParameter("user_name");
		String user_pwd = request.getParameter("user_pwd");
		String user_phone = request.getParameter("user_phone");
		String user_email = request.getParameter("user_email");
		String user_adress = request.getParameter("user_adress");
		user.setUser_name(user_name);
		user.setUser_pwd(user_pwd);
		if (user_phone != null) {
			user.setUser_phone(user_phone);
		}
		if (user_email != null) {
			user.setUser_email(user_email);
		}
		if (user_adress != null) {
			user.setUser_adress(user_adress);
		}
		try {
			service.addUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("queryAllUser");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
