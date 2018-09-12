package dao;

import java.util.List;

import entity.Cart;
import entity.User;

public interface CartDao {

	public void insetCart(Cart cart) throws Exception;

	public int queryCarNum(User user) throws Exception;

	public List<Cart> queryAllCart(User user) throws Exception;

	public void update(int cart_id,int order_num) throws Exception;
	
	public void deleteCart(int user_id,int cart_id) throws Exception;

}
