package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Category;

import service.CategoryService;
import service.impl.CategoryServiceImpl;

/**
 * 新增分类
 * 
 * @author sawyer 2015-2-8
 */
@WebServlet(urlPatterns = "/newCategory")
public class CategoryAddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService service = new CategoryServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category category = new Category();
		String category_name = request.getParameter("category_name");
		category.setCategory_name(category_name);
		try {
			service.addCategory(category);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("queryAllGoods");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
