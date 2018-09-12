package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;
import service.impl.GoodsServiceImpl;
import entity.Goods;

/**
 * 用户端分类id查询分类商品
 * 
 * @author sawyer 2015-2-19
 */
@WebServlet(urlPatterns = "/queryByCategoryId")
public class GoodsQueryCategoryByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GoodsService service = new GoodsServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		System.out.println("id:"+categoryId);
		try {
			List<Goods> list = service.queryGoodsByCategoryId(categoryId);
			request.getSession().setAttribute("goods_list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
