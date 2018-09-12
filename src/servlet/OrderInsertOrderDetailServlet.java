package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.OrderService;
import service.impl.OrderServiceImpl;
import entity.OrderDetail;
import entity.User;

/**
 * 插入订单详情
 * 
 * @author sawyer 2015-3-26
 */
@WebServlet(urlPatterns = "/insertOrderDetail")
public class OrderInsertOrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderService service = new OrderServiceImpl();
	OrderDetail order = new OrderDetail();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float goods_price = Float.parseFloat(request.getParameter("goods_price"));
		String order_id = request.getParameter("order_id");
		String goods_name=request.getParameter("goods_name");
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String user_id = String.valueOf(user.getUser_id());
		order_id = order_id + user_id;
		order.setOrder_id(order_id);
		order.setGoods_price(goods_price);
		order.setGoods_name(goods_name);
		order.setOrder_num(order_num);
		order.setUser_id(user.getUser_id());
		try {
			service.insertOrderDetail(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write("ok");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
