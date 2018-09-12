package dao;

import java.util.List;

import entity.Order;
import entity.OrderDetail;

public interface OrderDao {
	public void insertOrder(Order order) throws Exception;
	
	public void insertOrderDetail(OrderDetail order) throws Exception;
	
	public List<Order> userQueryOrder(int user_id) throws Exception;
	
	public List<OrderDetail> userQueryOrderDetail(OrderDetail order) throws Exception;
	
	public List<OrderDetail> queryAllOrder() throws Exception;
	
	public List<OrderDetail> queryByName(OrderDetail order) throws Exception;
}
