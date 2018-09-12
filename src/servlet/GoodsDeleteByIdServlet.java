package servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;
import service.impl.GoodsServiceImpl;

/**
 * 
 * 商品删除
 * 
 * @author sawyer 2015-2-8
 */
@WebServlet(urlPatterns = "/deleteGoodsById")
public class GoodsDeleteByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GoodsService service = new GoodsServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		// 定义服务器路径
		String path = "upload\\";
		System.out.println(path);
		try {
			// 获取数据库图片的名称
			String queryPath = service.queryGoodsById(id).getGoods_image();
			System.out.println(queryPath);
			// 获取文件的绝对路径(物理路径)
			String resource = this.getServletContext().getRealPath("/");
			resource = resource + path + queryPath;
			System.out.println("resource:" + resource);
			// 新建一个文件对象
			File file = new File(resource);
			if (file.exists() && file.isFile()) {
				if (file.delete()) {
					System.out.println("图片文件删除成功");
				} else {
					System.out.println("图片文件删除失败");
				}
			} else {
				System.out.println("图片文件不存在");
			}
			// 删除数据库记录
			service.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
