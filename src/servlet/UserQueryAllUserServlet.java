package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.impl.UserServiceImpl;
import entity.User;

/**
 * 查询用户信息 2015-3-6
 */
@WebServlet(urlPatterns = "/queryAllUser")
public class UserQueryAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService service = new UserServiceImpl();

	public UserQueryAllUserServlet() {
		super();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			// int rowCount = service.countAll();
			// Page p1 = new
			// Page(10,Integer.parseInt(request.getParameter("num")),rowCount);
			// request.setAttribute("page", p1);
			// List<User> list = service.queryAll(p1.getStartRow(),
			// p1.getSize());
			User user = new User();
			List<User> list = service.queryAll(user);
			request.getSession().setAttribute("user_list", list);
			if (request.getParameter("query_name") != null) {
				String userName = new String(request.getParameter("query_name").getBytes("ISO8859-1"), "utf-8");
				//System.out.println("servlet:" + userName);
				//HttpSession session = request.getSession();
				//session.setAttribute("userName", userName);
				list = service.queryByName(userName);
				user.setUser_name(userName);
				request.getSession().setAttribute("user_list", list);
			}
			request.getRequestDispatcher("back/user_manage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doGet(request, response);
	}
}
