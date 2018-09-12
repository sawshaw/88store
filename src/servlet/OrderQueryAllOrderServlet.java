package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;
import service.impl.OrderServiceImpl;
import entity.OrderDetail;

/**
 * 
 * 查询订单
 * 
 * @author sawyer 2015-2-8
 */
@WebServlet(urlPatterns = "/queryAllOrder")
public class OrderQueryAllOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderService service = new OrderServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			OrderDetail order = new OrderDetail();
			List<OrderDetail> list = service.queryAllOrder();
			request.getSession().setAttribute("order_list", list);
			if (request.getParameter("query_name") != null) {
				String userName = new String(request.getParameter("query_name").getBytes("ISO8859-1"), "utf-8");
				System.out.println("userName:"+userName);
				order.setUser_name(userName);
				list = service.queryByName(order);
				for(OrderDetail i:list){
					System.out.println("goods_name:"+i.getGoods_name());
				}
				request.getSession().setAttribute("order_list", list);
			}
			request.getRequestDispatcher("back/order_manage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
