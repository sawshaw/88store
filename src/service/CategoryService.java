package service;

import java.sql.SQLException;
import java.util.List;

import entity.Category;

public interface CategoryService {
	public List<Category> queryAll() throws SQLException;
	
	public void addCategory(Category category) throws SQLException;

}
