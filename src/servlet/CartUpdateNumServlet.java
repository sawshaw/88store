package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CartService;
import service.impl.CartServiceImpl;
import entity.Cart;

/**
 * 
 * 购物车更新数量
 * 
 * @author sawyer 2015-2-8
 */
@WebServlet(urlPatterns = "/cartUpdateNum")
public class CartUpdateNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartService service = new CartServiceImpl();
	Cart cart = new Cart();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cart_id=Integer.parseInt(request.getParameter("cart_id"));
		int order_num=Integer.parseInt(request.getParameter("order_num"));
		try {
			service.update(cart_id,order_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().println("ok");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
