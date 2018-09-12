package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AdminService;
import service.impl.AdminServiceImpl;
import entity.Admin;

/**
 * 更改管理员密码
 * 
 * @author sawyer 2015-2-19
 */
@WebServlet(urlPatterns = "/modifyAdminPwd")
public class AdminModifyAdminPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService service = new AdminServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		String name = admin.getAdmin_name();
		String newPwd = request.getParameter("newPwd");
		System.out.println("newPwd:"+newPwd);
		boolean result = false;
		result = service.modifypwd(name, newPwd);
		if (result == false) {
			response.getWriter().print("false");
		} else {
			session.removeAttribute("admin");
			response.getWriter().print("true");
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
