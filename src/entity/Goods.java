package entity;

import java.io.Serializable;

public class Goods implements Serializable {
	private static final long serialVersionUID = 1L;
	// 商品id
	private int goods_id;
	// 商品名字
	private String goods_name;
	// 商品数量
	private int goods_num;
	// 商品单价
	private float goods_price;
	// 商品图片
	private String goods_image;
	//商品详细说明
	private String goods_desc;
	// 分类id
	private int category_id;
	// 商品类别名,非表字段
	private String category_name;

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public int getGoods_num() {
		return goods_num;
	}

	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}

	public float getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(float goods_price) {
		this.goods_price = goods_price;
	}

	public String getGoods_image() {
		return goods_image;
	}

	public void setGoods_image(String goods_image) {
		this.goods_image = goods_image;
	}
	
	
	public String getGoods_desc() {
		return goods_desc;
	}

	public void setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public Goods() {
		super();
	}

	public Goods(String goods_name, int goods_num, float goods_price, int category_id, String goods_image,String goods_desc) {
		this.goods_name = goods_name;
		this.goods_num = goods_num;
		this.goods_price = goods_price;
		this.category_id = category_id;
		this.goods_image = goods_image;
		this.goods_desc=goods_desc;
	}
}
