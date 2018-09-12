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
 * 查询用户购物车数量
 * 
 * @author sawyer 2015-3-26
 */
@WebServlet(urlPatterns = "/queryCartNum")
public class CartQueryCartNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartService service = new CartServiceImpl();
	Cart cart = new Cart();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cart_num = 0;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		try {
			cart_num = service.queryCarNum(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write(cart_num+","+cart_num);
		System.out.println("cart_num:"+cart_num);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
