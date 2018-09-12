package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import service.CategoryService;
import service.impl.CategoryServiceImpl;
import entity.Category;

/**
 * 查询所有商品分类2015-3-6
 */
@WebServlet(urlPatterns = "/queryAllCategory")
public class CategoryQueryAllCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService service = new CategoryServiceImpl();

	public CategoryQueryAllCategoryServlet() {
		super();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			List<Category> list = service.queryAll();
			request.getSession().setAttribute("category_list", list);
			JSONArray categorry_list = JSONArray.fromObject(list);//转换成json字符串
			response.getWriter().println(categorry_list);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doGet(request, response);
	}
}
