package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private String order_id;
	/* 订单总额 */
	private float order_price;
	/* 下单时间 */
	private Timestamp order_time;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public float getOrder_price() {
		return order_price;
	}

	public void setOrder_price(float order_price) {
		this.order_price = order_price;
	}

	public Timestamp getOrder_time() {
		return order_time;
	}

	public void setOrder_time(Timestamp order_time) {
		this.order_time = order_time;
	}

}
