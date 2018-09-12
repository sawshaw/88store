package dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import dao.OrderDao;
import entity.Order;
import entity.OrderDetail;

public class OrderDaoImpl implements OrderDao {

	DBUtil util = new DBUtil();
	ResultSet rs = null;

	/*
	 * 插入订单表
	 */
	@Override
	public void insertOrder(Order order) throws Exception {
		String sql = "insert into T_Order(order_id,order_price,order_time) values(?,?,?)";
		util.update(sql, order.getOrder_id(), order.getOrder_price(), order.getOrder_time());
	}

	/*
	 * 插入订单详情表
	 */
	@Override
	public void insertOrderDetail(OrderDetail order) throws Exception {
		String sql = "insert into T_OrderDetail(order_id,goods_price,user_id,order_num,goods_name) values(?,?,?,?,?)";
		util.update(sql, order.getOrder_id(), order.getGoods_price(), order.getUser_id(), order.getOrder_num(),order.getGoods_name());
	}

	/*
	 * 查询用户订单
	 */
	@Override
	public List<Order> userQueryOrder(int user_id) throws Exception {
		List<Order> orders = new ArrayList<Order>();
		String sql = "select distinct o.order_id,o.order_price,o.order_time from T_Order o left join T_OrderDetail d on o.order_id=d.order_id where user_id=?";
		rs = util.query(sql, user_id);
		while (rs.next()) {
			Order order = new Order();
			order.setOrder_id(rs.getString("order_id"));
			order.setOrder_price(rs.getFloat("order_price"));
			order.setOrder_time(rs.getTimestamp("order_time"));
			orders.add(order);
		}
		return orders;
	}

	/* 
	 *查询用户订单详情
	 */
	@Override
	public List<OrderDetail> userQueryOrderDetail(OrderDetail order) throws Exception {
		List<OrderDetail> orders = new ArrayList<OrderDetail>();
		String sql = "select * from T_OrderDetail where user_id=? and order_id=?";
		rs = util.query(sql, order.getUser_id(),order.getOrder_id());
		while (rs.next()) {
			OrderDetail orde = new OrderDetail();
			orde.setGoods_price(rs.getFloat("goods_price"));
			orde.setGoods_name(rs.getString("goods_name"));
			orde.setOrder_num(rs.getInt("order_num"));
			orders.add(orde);
		}
		return orders;
	}

	@Override
	public List<OrderDetail> queryAllOrder() throws Exception {
		List<OrderDetail> orders = new ArrayList<OrderDetail>();
		String sql="select * from t_orderdetail d LEFT JOIN t_order F on d.order_id=F.order_id  left JOIN t_user u on d.user_id=u.user_id";
		rs = util.query(sql);
		while (rs.next()) {
			OrderDetail orde = new OrderDetail();
			orde.setOrder_id(rs.getString("order_id"));
			orde.setGoods_price(rs.getFloat("goods_price"));
			orde.setGoods_name(rs.getString("goods_name"));
			orde.setOrder_num(rs.getInt("order_num"));
			orde.setUser_name(rs.getString("user_name"));
			orders.add(orde);
		}
		return orders;
	}

	@Override
	public List<OrderDetail> queryByName(OrderDetail order) throws Exception {
		System.out.println("user_XX:"+order.getUser_name());
		List<OrderDetail> orders = new ArrayList<OrderDetail>();
		String sql="select * from t_orderdetail d LEFT JOIN t_order F on d.order_id=F.order_id  left JOIN t_user u on d.user_id=u.user_id where user_name like ?";
		rs=util.query(sql,"%" + order.getUser_name() + "%");
		while (rs.next()) {
			OrderDetail orde = new OrderDetail();
			orde.setOrder_id(rs.getString("order_id"));
			orde.setGoods_price(rs.getFloat("goods_price"));
			orde.setGoods_name(rs.getString("goods_name"));
			orde.setOrder_num(rs.getInt("order_num"));
			orde.setUser_name(rs.getString("user_name"));
			orders.add(orde);
		}
		return orders;
	}

}
