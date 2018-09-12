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

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import entity.Goods;

/**
 * 
 * 商品更新
 * 
 * @author sawyer 2015-2-8
 */
@WebServlet(urlPatterns = "/updateGoods")
public class GoodsUpdateGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GoodsService service = new GoodsServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Goods goods = new Goods();
		// 初始化下载对象
		SmartUpload su = new SmartUpload();
		try {
			// 初始化上传对象
			su.initialize(getServletConfig(), request, response);
			// 设置单文件最大容量
			su.setMaxFileSize(10 * 1024 * 1024);
			// 设置所有文件最大容量
			su.setTotalMaxFileSize(100 * 1024 * 1024);
			// 设置上传文件类型
			su.setAllowedFilesList("jpg,bmp,gif,png");
			// 设置禁止上传的文件类型
			su.setDeniedFilesList("jsp,js,html,css,rar,txt");
			int goods_id = 0;
			// 上传文件
			su.upload();
			goods_id = Integer.parseInt(su.getRequest().getParameter("goods_id"));
			/***************************************/
			// 定义服务器路径
			String path = "upload\\";
			// 获取数据库图片的名称
			String queryPath = service.queryGoodsById(goods_id).getGoods_image();
			System.out.println("queryPath:" + queryPath);
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
			/***************************************/
			// 获取单个上传文件
			com.jspsmart.upload.File tempFile = null;
			tempFile = su.getFiles().getFile(0);
			// 文件路径
			String filePath = null;
			// 文件名(需插入到数据库中作为字段内容)
			String fileReName = null;
			if (!tempFile.isMissing()) {
				// 获取文件的长度
				long SlaveSize = tempFile.getSize();
				// 文件重命名
				fileReName = System.currentTimeMillis() + SlaveSize + "." + tempFile.getFileExt();
				filePath = "upload\\";
				filePath += fileReName;
				// 保存文件
				tempFile.saveAs(filePath, SmartUpload.SAVE_VIRTUAL);
				String goods_name = su.getRequest().getParameter("goods_name");
				int goods_num = Integer.parseInt(su.getRequest().getParameter("goods_num"));
				float goods_price = Float.parseFloat(su.getRequest().getParameter("goods_price"));
				int category_id = Integer.parseInt(su.getRequest().getParameter("category"));
				String goods_desc = su.getRequest().getParameter("goods_desc");
				System.out.println("上传图片成功");
				goods.setGoods_id(goods_id);
				goods.setGoods_name(goods_name);
				goods.setGoods_num(goods_num);
				goods.setGoods_price(goods_price);
				goods.setCategory_id(category_id);
				goods.setGoods_desc(goods_desc);
				goods.setGoods_image(fileReName);
				service.updateGoods(goods);// 更新数据库记录
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		response.sendRedirect("queryAllGoods");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
