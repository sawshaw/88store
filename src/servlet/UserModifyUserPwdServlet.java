package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;
import service.impl.UserServiceImpl;
import entity.User;

/**
 * 更改用户信息
 * 
 * @author sawyer 2015-2-19
 */
@WebServlet(urlPatterns = "/modifyUserPwd")
public class UserModifyUserPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService service = new UserServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String name = user.getUser_name();
		String newPwd = request.getParameter("newPwd");
		boolean result = false;
		result = service.modifypwd(name, newPwd);
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
