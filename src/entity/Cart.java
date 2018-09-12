package entity;

import java.io.Serializable;

public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	private int cart_id;
	private int goods_id;
	private int user_id;
	/* 订购某件商品的数量 */
	private int order_num;
	/* 非表字段 */
	// 商品名字
	private String goods_name;
	// 商品数量
	private int goods_num;
	// 商品单价
	private float goods_price;
	// 商品图片
	private String goods_image;
	// 商品详细说明
	private String goods_desc;
	// 分类id
	private int category_id;
	// 总额
	private double totalPrice;

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Cart() {
		super();
	}

	public Cart(int cart_id, int goods_id, int user_id) {
		this.cart_id = cart_id;
		this.goods_id = goods_id;
		this.user_id = user_id;
	}

}
