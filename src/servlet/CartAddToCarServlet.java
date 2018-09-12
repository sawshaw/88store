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
 * 
 * 加入购物车
 * 
 * @author sawyer 2015-2-8
 */
@WebServlet(urlPatterns = "/addToCart")
public class CartAddToCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartService service=new CartServiceImpl();
	Cart cart=new Cart();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
	
		if(user!=null){
			System.out.println("user_name:"+user.getUser_name());
			System.out.println("user_id:"+user.getUser_id());
			System.out.println("user_pwd:"+user.getUser_pwd());
			int goods_id=Integer.parseInt(request.getParameter("goods_id"));
			cart.setGoods_id(goods_id);
			cart.setUser_id(user.getUser_id());
			if(request.getParameter("order_num")!=null){
				int order_num=Integer.parseInt(request.getParameter("order_num"));
				cart.setOrder_num(order_num);
			}else{
				
				cart.setOrder_num(1);
			}
			try {
				service.inserCart(cart);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.getWriter().print("true");
		}else{
			response.getWriter().print("false");
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
