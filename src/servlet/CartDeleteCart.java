package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CartService;
import service.impl.CartServiceImpl;
import entity.Cart;
import entity.User;

/**
 * 删除购物车
 * 
 * @author sawyer 2015-3-26
 */
@WebServlet(urlPatterns = "/deleteCart")
public class CartDeleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartService service = new CartServiceImpl();
	Cart cart = new Cart();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cart_id=Integer.parseInt(request.getParameter("cart_id"));
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		try {
			service.deleteCart(user.getUser_id(),cart_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write("ok");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
