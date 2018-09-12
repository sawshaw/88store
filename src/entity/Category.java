package entity;

import java.io.Serializable;

public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	// 商品类别id
	private int category_id;
	// 商品类别名字
	private String category_name;

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

}
