package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import service.OrderService;
import service.impl.OrderServiceImpl;
import entity.Order;
import entity.User;

/**
 * 
 * 查询订单
 * 
 * @author sawyer 2015-2-8
 */
@WebServlet(urlPatterns = "/userQueryOrder")
public class OrderUserQueryOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderService service = new OrderServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int user_id = user.getUser_id();
		try {
			List<Order> list = service.userQueryOrder(user_id);
			JSONArray orderList = JSONArray.fromObject(list);
			response.getWriter().println(orderList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
