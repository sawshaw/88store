package entity;

import java.io.Serializable;

public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private int order_detail_id;
	/* 订单号 */
	private String order_id;
	/* 单件商品的价格 */
	private float goods_price;
	/* 商品名称 */
	private String goods_name;
	private int user_id;
	/* 用户订购数量 */
	private int order_num;
	/* 外表 */
	/* 用户名 */
	private String user_name;

	public int getOrder_detail_id() {
		return order_detail_id;
	}

	public void setOrder_detail_id(int order_detail_id) {
		this.order_detail_id = order_detail_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public float getGoods_price() {
		return goods_price;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public void setGoods_price(float goods_price) {
		this.goods_price = goods_price;
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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
