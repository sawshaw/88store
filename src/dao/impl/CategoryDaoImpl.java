package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import dao.CategoryDao;
import entity.Category;

public class CategoryDaoImpl implements CategoryDao {
	DBUtil util = new DBUtil();
	ResultSet rs = null;

	@Override
	public List<Category> queryAll() throws SQLException {
		List<Category> categorys = new ArrayList<Category>();
		String sql = new String("select * from T_Category");
		rs = util.query(sql);
		while (rs.next()) {
			Category category = new Category();
			category.setCategory_id(rs.getInt("category_id"));
			category.setCategory_name(rs.getString("category_name"));
			categorys.add(category);
		}
		return categorys;
	}

	@Override
	public void addCategory(Category category) throws SQLException {
		String sql = "INSERT INTO T_Category(category_name) VALUES(?)";
		util.update(sql,category.getCategory_name());
	}

}
