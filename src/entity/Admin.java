package entity;

import java.io.Serializable;

public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;
	// 管理员id
	private int admin_id;
	// 管理员名字
	private String admin_name;
	// 管理员密码
	private String admin_pwd;

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String adminName) {
		admin_name = adminName;
	}

	public String getAdmin_pwd() {
		return admin_pwd;
	}

	public void setAdmin_pwd(String adminPwd) {
		admin_pwd = adminPwd;
	}

	public Admin() {
		super();
	}

	public Admin(String adminName, String adminPwd) {
		this.admin_name = adminName;
		this.admin_pwd = adminPwd;
	}

}
