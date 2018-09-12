package service.impl;

import java.sql.SQLException;
import java.util.List;

import service.CategoryService;
import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import entity.Category;

public class CategoryServiceImpl implements CategoryService{
	CategoryDao dao=new CategoryDaoImpl();
	@Override
	public List<Category> queryAll() throws SQLException {
		return dao.queryAll();
	}
	@Override
	public void addCategory(Category category) throws SQLException {
		dao.addCategory(category);
	}

}
