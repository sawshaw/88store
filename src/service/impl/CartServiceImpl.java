package service.impl;

import java.util.List;

import service.CartService;
import dao.CartDao;
import dao.impl.CartDaoImpl;
import entity.Cart;
import entity.User;

public class CartServiceImpl implements CartService {
	CartDao dao= new CartDaoImpl();

	@Override
	public void inserCart(Cart cart) throws Exception {
		dao.insetCart(cart);
	}

	@Override
	public int queryCarNum(User user) throws Exception {
		return dao.queryCarNum(user);
	}

	@Override
	public List<Cart> queryAllCart(User user) throws Exception {
		return dao.queryAllCart(user);
	}

	@Override
	public void update(int cart_id,int order_num) throws Exception {
		dao.update(cart_id,order_num);
	}

	@Override
	public void deleteCart(int user_id, int cart_id) throws Exception {
		dao.deleteCart(user_id, cart_id);
	}

}
