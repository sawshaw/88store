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
@WebServlet(urlPatterns = "/queryGoods")
public class GoodsQueryGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GoodsService service = new GoodsServiceImpl();

	public GoodsQueryGoodsServlet() {
		super();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			Goods goods = new Goods();
			List<Goods> list = service.queryAll();
			request.getSession().setAttribute("goods_list", list);
			if (request.getParameter("query_name") != null) {
				String goodsName = request.getParameter("query_name");
				System.out.println("goodsName:"+goodsName);
				list = service.queryByName(goodsName);
				goods.setGoods_name(goodsName);
				request.getSession().setAttribute("goods_list", list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doGet(request, response);
	}
}
