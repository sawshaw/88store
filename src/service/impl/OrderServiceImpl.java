package service.impl;

import java.util.List;

import service.OrderService;
import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import entity.Order;
import entity.OrderDetail;

public class OrderServiceImpl implements OrderService {
	OrderDao dao = new OrderDaoImpl();

	@Override
	public void insertOrder(Order order) throws Exception {
			dao.insertOrder(order);
	}

	@Override
	public void insertOrderDetail(OrderDetail order) throws Exception {
		dao.insertOrderDetail(order);
	}

	@Override
	public List<Order> userQueryOrder(int user_id) throws Exception {
		return dao.userQueryOrder(user_id);
	}

	@Override
	public List<OrderDetail> userQueryOrderDetail(OrderDetail order) throws Exception {
		return dao.userQueryOrderDetail(order);
	}

	@Override
	public List<OrderDetail> queryAllOrder() throws Exception {
		return dao.queryAllOrder();
	}

	@Override
	public List<OrderDetail> queryByName(OrderDetail order) throws Exception {
		return dao.queryByName(order);
	}

}
