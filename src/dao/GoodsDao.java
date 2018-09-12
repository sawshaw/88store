package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Goods;

public interface GoodsDao {
	public List<Goods> queryAll() throws SQLException;
	
	public List<Goods> queryByName(String goods_name) throws SQLException;
	
	public void addGoods(Goods goods) throws SQLException;
	
	public void delete(int id) throws SQLException;
	
	public Goods queryGoodsById(int id) throws SQLException;
	
	public void updateGoods(Goods goods) throws SQLException;
	
	public List<Goods> queryByCategoryId(int category_id) throws SQLException;

}
