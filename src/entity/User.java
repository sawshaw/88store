package entity;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	// 用户id
	private int user_id;
	//用户名
	private String user_name;
	//用户密码 
	private String user_pwd;
	// 用户电话
	private String user_phone;
	// 用户邮件
	private String user_email;
	//用户收货地址
	private String user_adress;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String userPwd) {
		user_pwd = userPwd;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String userPhone) {
		user_phone = userPhone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String userEmail) {
		user_email = userEmail;
	}

	public String getUser_adress() {
		return user_adress;
	}

	public void setUser_adress(String userAdress) {
		user_adress = userAdress;
	}

	public User() {
		super();
	}

	public User(int user_id,String user_name, String user_pwd) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
	}
}
