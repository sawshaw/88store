package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import dao.GoodsDao;
import entity.Goods;

public class GoodsDaoImpl implements GoodsDao {
	DBUtil util = new DBUtil();
	ResultSet rs = null;

	/*
	 * 查询所有商品
	 */
	@Override
	public List<Goods> queryAll() throws SQLException {
		List<Goods> goodss = new ArrayList<Goods>();
		String sql = new String("select * from T_Goods g  LEFT JOIN T_Category c on g.category_id=c.category_id");
		rs = util.query(sql);
		while (rs.next()) {
			Goods goods = new Goods();
			goods.setGoods_id(rs.getInt("goods_id"));
			goods.setGoods_name(rs.getString("goods_name"));
			goods.setGoods_num(rs.getInt("goods_num"));
			goods.setGoods_price(rs.getFloat("goods_price"));
			goods.setCategory_name(rs.getString("category_name"));
			goods.setGoods_image(rs.getString("goods_image"));
			goods.setGoods_desc(rs.getString("goods_desc"));
			goodss.add(goods);
		}
		return goodss;
	}

	/*
	 * 根据商品名字查询商品
	 */
	@Override
	public List<Goods> queryByName(String goods_name) throws SQLException {
		List<Goods> goodss = new ArrayList<Goods>();
		String sql = "select * from T_Goods g  LEFT JOIN T_Category c on g.category_id=c.category_id where g.goods_name like ? ";
		rs = util.query(sql, "%" + goods_name + "%");
		while (rs.next()) {
			Goods goods = new Goods();
			goods.setGoods_id(rs.getInt("goods_id"));
			goods.setGoods_name(rs.getString("goods_name"));
			goods.setGoods_num(rs.getInt("goods_num"));
			goods.setGoods_price(rs.getFloat("goods_price"));
			goods.setCategory_name(rs.getString("category_name"));
			goods.setGoods_image(rs.getString("goods_image"));
			goods.setGoods_desc(rs.getString("goods_desc"));
			goodss.add(goods);
		}
		return goodss;
	}

	/*
	 * 新增一件商品
	 */
	@Override
	public void addGoods(Goods goods) throws SQLException {
		String sql = "INSERT INTO T_Goods(goods_name,goods_num,goods_price,goods_image,goods_desc,category_id) VALUES(?,?,?,?,?,?)";
		util.update(sql, goods.getGoods_name(), goods.getGoods_num(), goods.getGoods_price(), goods.getGoods_image(), goods.getGoods_desc(), goods.getCategory_id());
	}

	/*
	 * 删除一件商品
	 */
	@Override
	public void delete(int id) throws SQLException {
		String sql = "delete from T_Goods where goods_id=?";
		util.update(sql, id);
	}

	/*
	 * 根据商品id查询商品信息
	 */
	@Override
	public Goods queryGoodsById(int id) throws SQLException {
		Goods goods = new Goods();
		String sql = "select * from T_Goods where goods_id=?";
		rs = util.query(sql, id);
		while (rs.next()) {
			goods.setGoods_id(rs.getInt("goods_id"));
			goods.setGoods_name(rs.getString("goods_name"));
			goods.setGoods_num(rs.getInt("goods_num"));
			goods.setGoods_price(rs.getFloat("goods_price"));
			goods.setCategory_id(rs.getInt("category_id"));
			goods.setGoods_image(rs.getString("goods_image"));
			goods.setGoods_desc(rs.getString("goods_desc"));
		}
		// util.closeAll();关闭连接
		return goods;
	}

	/*
	 * 更新商品
	 */
	@Override
	public void updateGoods(Goods goods) throws SQLException {
		String sql = "UPDATE T_Goods set goods_name=?,goods_num=?,goods_price=?,goods_image=?,goods_desc=?,category_id=? where goods_id=?";
		util.update(sql, goods.getGoods_name(), goods.getGoods_num(), goods.getGoods_price(), goods.getGoods_image(), goods.getGoods_desc(), goods.getCategory_id(), goods.getGoods_id());
	}

	/* 
	 *根据分类id查询所有商品
	 */
	@Override
	public List<Goods> queryByCategoryId(int category_id) throws SQLException {
		List<Goods> goodss = new ArrayList<Goods>();
		String sql = "select * from T_Goods where category_id=?";
		rs = util.query(sql, category_id);
		while(rs.next()) {
			Goods goods = new Goods();
			goods.setGoods_id(rs.getInt("goods_id"));
			goods.setGoods_name(rs.getString("goods_name"));
			goods.setGoods_num(rs.getInt("goods_num"));
			goods.setGoods_price(rs.getFloat("goods_price"));
			goods.setGoods_image(rs.getString("goods_image"));
			goods.setGoods_desc(rs.getString("goods_desc"));
			goodss.add(goods);
		}
		return goodss;
	}

	/**
	 * 重用
	 * 
	 * @param goods
	 * @throws SQLException
	 */
	public void set(Goods goods) throws SQLException {
		goods.setGoods_id(rs.getInt("goods_id"));
		goods.setGoods_name(rs.getString("goods_name"));
		goods.setGoods_num(rs.getInt("goods_num"));
		goods.setGoods_price(rs.getFloat("goods_price"));
		goods.setCategory_name(rs.getString("category_name"));
	}

}
