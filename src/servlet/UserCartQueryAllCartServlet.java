package servlet;

import java.io.IOException;
import java.util.List;

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
 * 
 * 更新购物车数量
 * 
 * @author sawyer 2015-2-8
 */
@WebServlet(urlPatterns = "/user/queryAllCart")
public class UserCartQueryAllCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartService service = new CartServiceImpl();
	Cart cart = new Cart();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		try {
			List<Cart> list = service.queryAllCart(user);
			request.getSession().setAttribute("cart_list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
