package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;
import service.impl.GoodsServiceImpl;
import entity.Goods;

/**
 * 查询所有商品 2015-3-6
 */
@WebServlet(urlPatterns = "/queryAllGoods")
public class GoodsQueryAllGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GoodsService service = new GoodsServiceImpl();

	public GoodsQueryAllGoodsServlet() {
		super();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			Goods goods = new Goods();
			List<Goods> list = service.queryAll();
			request.getSession().setAttribute("goods_list", list);
			if (request.getParameter("query_name") != null) {
				String goodsName = new String(request.getParameter("query_name").getBytes("ISO8859-1"), "utf-8");
				list = service.queryByName(goodsName);
				goods.setGoods_name(goodsName);
				request.getSession().setAttribute("goods_list", list);
			}
			request.getRequestDispatcher("back/goods_manage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doGet(request, response);
	}
}
