package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;
import dao.AdminDao;
import entity.Admin;

public class AdminDaoImpl implements AdminDao {
	DBUtil util = new DBUtil();

	/*
	 * 登录验证
	 */
	@Override
	public Admin login(String name, String pwd) throws SQLException {
		ResultSet rs = null;
		Admin admin = null;
		String sql = "SELECT * FROM T_Admin WHERE admin_name=? and admin_pwd=?";
		rs = util.query(sql, name, pwd);
		if (rs.next()) {
			String admin_name = rs.getString(2);//查询出的第一个是admin_id
			String admin_pwd = rs.getString(3);
			admin = new Admin(admin_name, admin_pwd);
		}
		return admin;
	}

	/*
	 * 账号验证
	 */
	@Override
	public int loginCheck(String name) throws SQLException {
		ResultSet rs = null;
		int re = 0;
		String sql = "SELECT  * FROM T_Admin WHERE admin_name=?";
		rs = util.query(sql, name);
		if (rs.next()) {
			re = 1;
		}
		return re;
	}

	/*
	 * 更改管理员密码
	 */
	@Override
	public int modifypwd(String name, String newPwd) {
		String sql = "UPDATE T_Admin SET admin_pwd=? WHERE admin_name=?";
		return util.update(sql, newPwd, name);
	}

}
