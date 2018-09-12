package servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.OrderService;
import service.impl.OrderServiceImpl;
import entity.Order;
import entity.User;

/**
 * 插入订单
 * 
 * @author sawyer 2015-3-26
 */
@WebServlet(urlPatterns = "/insertOrder")
public class OrderInsertOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderService service = new OrderServiceImpl();
	Order order = new Order();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Timestamp order_time=Timestamp.valueOf(request.getParameter("order_time"));
		String order_id=request.getParameter("order_id");
		float order_price=Float.parseFloat(request.getParameter("order_price"));
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String user_id=String.valueOf(user.getUser_id());
		order_id=order_id+user_id;
		order.setOrder_id(order_id);
		order.setOrder_price(order_price);
		order.setOrder_time(order_time);
		try {
			service.insertOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write("ok");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
