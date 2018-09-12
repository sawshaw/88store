package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Admin;

/**
 * 管理员账号存在性
 * 
 * @author sawyer 2015-2-8
 */
@WebServlet(urlPatterns = "/adminPwdCheck")
public class AdminPwdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPwd = request.getParameter("oldPwd");
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if (oldPwd.equals(admin.getAdmin_pwd())) {
			response.getWriter().print("true");
		} else {
			response.getWriter().print("false");
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
