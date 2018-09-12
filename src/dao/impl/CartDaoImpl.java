package dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import dao.CartDao;
import entity.Cart;
import entity.User;

public class CartDaoImpl implements CartDao {
	DBUtil util = new DBUtil();
	ResultSet rs = null;

	/*
	 * 保存购物车(如果不存在则插入,如果存在则更新)
	 */
	@Override
	public void insetCart(Cart cart) throws Exception {
		String sql = "INSERT INTO T_Cart(goods_id,order_num,user_id) VALUES(?,?,?) ON DUPLICATE KEY UPDATE order_num=order_num+?";
		util.update(sql, cart.getGoods_id(),cart.getOrder_num(), cart.getUser_id(),cart.getOrder_num());
	}

	/*
	 * 计算购物车的总数
	 */
	@Override
	public int queryCarNum(User user) throws Exception {
		int count = 0;
		String sql = "SELECT  count(*) FROM T_Cart WHERE user_id=?";
		rs = util.query(sql, user.getUser_id());
		while (rs.next()) {
			count = rs.getInt(1);
		}
		System.out.println("count:"+count);
		return count;
	}

	/* 
	 * 查询购物车的商品
	 */
	@Override
	public List<Cart> queryAllCart(User user) throws Exception {
		List<Cart> carts = new ArrayList<Cart>();
		String sql="select * from T_Cart c  LEFT JOIN T_Goods g on g.goods_id=c.goods_id where user_id=?";
		rs = util.query(sql,user.getUser_id());
		while (rs.next()) {
			Cart cart = new Cart();
			cart.setGoods_id(rs.getInt("goods_id"));
			cart.setGoods_name(rs.getString("goods_name"));
			cart.setGoods_num(rs.getInt("goods_num"));
			cart.setGoods_price(rs.getFloat("goods_price"));
			cart.setGoods_image(rs.getString("goods_image"));
			cart.setGoods_desc(rs.getString("goods_desc"));
			cart.setUser_id(rs.getInt("user_id"));
			cart.setCart_id(rs.getInt("cart_id"));
			cart.setOrder_num(rs.getInt("order_num"));
			cart.setTotalPrice(rs.getInt("order_num")*rs.getFloat("goods_price"));
			carts.add(cart);
		}
		return carts;
	}

	/* 
	 * 更新购物车商品数量
	 */
	@Override
	public void update(int cart_id,int order_num) throws Exception {
		String sql="update T_Cart set order_num=? where cart_id=?";
		util.update(sql, order_num,cart_id);
	}

	/* 
	 *删除购物车
	 */
	@Override
	public void deleteCart(int user_id, int cart_id) throws Exception {
		String sql="delete from T_Cart where user_id=? and cart_id=?";
		util.update(sql, user_id,cart_id);
	}

}
