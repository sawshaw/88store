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
 * 用户id查询用户信息
 * 
 * @author sawyer 2015-2-19
 */
@WebServlet(urlPatterns = "/queryByUserId")
public class UserQueryUserByUserIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService service = new UserServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		User user;
		try {
			user = service.queryUserById(user_id);
			if (user != null) {
				response.getWriter().print(user.getUser_name() + "," + user.getUser_phone() + "," + user.getUser_email() + "," + user.getUser_adress());
			} else {
				response.getWriter().print("false");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
