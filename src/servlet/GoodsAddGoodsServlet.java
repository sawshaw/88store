package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;
import service.impl.GoodsServiceImpl;

import com.jspsmart.upload.SmartUpload;

import entity.Goods;

/**
 * 增加商品 2015-3-6
 */
@WebServlet(urlPatterns = "/addGoods")
public class GoodsAddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GoodsService service = new GoodsServiceImpl();
	Goods goods = new Goods();

	public GoodsAddGoodsServlet() {
		super();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
			// 上传文件
			su.upload();
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
			}
			System.out.println("fileName:" + fileReName);
			System.out.println("-------------------------------------------------");
			System.out.println("表单项名称:" + tempFile.getFieldName());// 取HTML表单中对应于此上传文件的表单项的名字
			System.out.println("文件名：" + tempFile.getFileName());// 获取文件名(不包含路径)
			System.out.println("文件长度：" + tempFile.getSize());// 获取文件的长度(以字节记)
			System.out.println("文件扩展名:" + tempFile.getFileExt());// 获取文件扩展名
			System.out.println("文件全名：" + tempFile.getFilePathName());// 取文件全名（带目录）
			System.out.println("-------------------------------------------------");
			String goods_name = su.getRequest().getParameter("goods_name");
			int goods_num = Integer.parseInt(su.getRequest().getParameter("goods_num"));
			float goods_price = Float.parseFloat(su.getRequest().getParameter("goods_price"));
			int category_id = Integer.parseInt(su.getRequest().getParameter("category"));
			String goods_desc = su.getRequest().getParameter("goods_desc");
			System.out.println("goods_desc:"+goods_desc);
			goods.setGoods_name(goods_name);
			goods.setGoods_num(goods_num);
			goods.setGoods_price(goods_price);
			goods.setCategory_id(category_id);
			goods.setGoods_desc(goods_desc);
			goods.setGoods_image(fileReName);
			service.addGoods(goods);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("queryAllGoods");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doGet(request, response);
	}
}
