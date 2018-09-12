package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;
import service.impl.GoodsServiceImpl;
import entity.Goods;

/**
 * 用户id查询用户信息
 * 
 * @author sawyer 2015-2-19
 */
@WebServlet(urlPatterns = "/queryByGoodsId")
public class GoodsQueryGoodsByGoodsIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GoodsService service = new GoodsServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int goods_id = Integer.parseInt(request.getParameter("goods_id"));
		Goods goods;
			try {
				goods = service.queryGoodsById(goods_id);
			if (goods != null) {
				response.getWriter().print(goods.getGoods_name() + "," + goods.getGoods_num() + "," + goods.getGoods_price() + "," + goods.getCategory_id()+ "," + goods.getGoods_desc()+","+goods.getGoods_image());
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
