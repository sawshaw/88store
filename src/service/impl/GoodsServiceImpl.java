package service.impl;

import java.sql.SQLException;
import java.util.List;

import service.GoodsService;
import dao.GoodsDao;
import dao.impl.GoodsDaoImpl;
import entity.Goods;

public class GoodsServiceImpl implements GoodsService {
	GoodsDao dao = new GoodsDaoImpl();

	@Override
	public List<Goods> queryAll() throws SQLException {
		return dao.queryAll();
	}

	@Override
	public List<Goods> queryByName(String goods_name) throws SQLException {
		return dao.queryByName(goods_name);
	}

	@Override
	public void addGoods(Goods goods) throws SQLException {
		dao.addGoods(goods);
	}

	@Override
	public void delete(int id) throws SQLException {
		dao.delete(id);
	}

	@Override
	public Goods queryGoodsById(int id) throws SQLException {
		return dao.queryGoodsById(id);
	}

	@Override
	public void updateGoods(Goods goods) throws SQLException {
		dao.updateGoods(goods);
	}

	@Override
	public List<Goods> queryGoodsByCategoryId(int category_id) throws SQLException {
		return dao.queryByCategoryId(category_id);
	}

}
