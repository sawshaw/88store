package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import dao.UserDao;
import entity.User;

public class UserDaoImpl implements UserDao {
	DBUtil util = new DBUtil();
	ResultSet rs = null;

	/*
	 * 用户登录
	 */
	@Override
	public User login(String name, String pwd) throws SQLException {
		User user = null;
		String sql = "SELECT * FROM T_User WHERE user_name=? and user_pwd=?";
		rs = util.query(sql, name, pwd);
		while(rs.next()) {
			int user_id = rs.getInt(1);
			String user_name = rs.getString(2);
			String user_pwd = rs.getString(3);
			user = new User(user_id,user_name, user_pwd);
		}
		return user;
	}

	/*
	 * 用户账号验证
	 */
	@Override
	public int loginCheck(String name) throws SQLException {
		int re = 0;
		String sql = "SELECT  * FROM T_User WHERE user_name=?";
		rs = util.query(sql, name);
		while(rs.next()) {
			re = 1;
		}
		return re;
	}

	/*
	 * 用户注册
	 */
	@Override
	public void reister(User user) {
		String sql = "INSERT INTO T_User(user_name,user_pwd,user_email) VALUES(?,?,?)";
		util.update(sql, user.getUser_name(), user.getUser_pwd(), user.getUser_email());
	}

	/*
	 * 更改用户密码
	 */
	@Override
	public int modifypwd(String name, String newPwd) {
		String sql = "UPDATE T_User SET user_pwd=? WHERE user_name=?";
		return util.update(sql, newPwd, name);
	}

	/*
	 * 真分页查询用户
	 */
	@Override
	public List<User> queryAll(int startRow, int size) throws SQLException {
		List<User> users = new ArrayList<User>();
		String sql = "select * from T_User limit ?,?";
		rs = util.query(sql, startRow, size);
		while (rs.next()) {
			User user = new User();
			user.setUser_id(rs.getInt("user_id"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_pwd(rs.getString("user_pwd"));
			user.setUser_email(rs.getString("user_email"));
			user.setUser_phone(rs.getString("user_phone"));
			user.setUser_adress(rs.getString("user_adress"));
			users.add(user);
		}
		return users;
	}

	/*
	 * 计算用户总数量
	 */
	@Override
	public int countAll() throws SQLException {
		int count = 0;
		String sql = "select count(*) from T_User";
		rs = util.query(sql);
		while (rs.next()) {
			count = rs.getInt(1);
		}

		return count;
	}

	/*
	 * 假分页查询所有
	 */
	@Override
	public List<User> queryAll(User u) throws SQLException {
		List<User> users = new ArrayList<User>();
		String sql = new String("select * from T_User");
		rs = util.query(sql);
		while (rs.next()) {
			User user = new User();
			user.setUser_id(rs.getInt("user_id"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_pwd(rs.getString("user_pwd"));
			user.setUser_email(rs.getString("user_email"));
			user.setUser_phone(rs.getString("user_phone"));
			user.setUser_adress(rs.getString("user_adress"));
			users.add(user);
		}
		return users;
	}

	/*
	 * 根据用户名查询用户信息
	 */
	@Override
	public List<User> queryByName(String user_name) throws SQLException {
		List<User> users = new ArrayList<User>();
		String sql = "select * from T_User where user_name like ?";
		rs = util.query(sql, "%" + user_name + "%");
		while (rs.next()) {
			User user = new User();
			user.setUser_id(rs.getInt("user_id"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_pwd(rs.getString("user_pwd"));
			user.setUser_email(rs.getString("user_email"));
			user.setUser_phone(rs.getString("user_phone"));
			user.setUser_adress(rs.getString("user_adress"));
			users.add(user);
		}
		return users;
	}

	/*
	 * 删除用户信息
	 */
	@Override
	public int delete(int id) throws SQLException {
		String sql = "delete from T_User where user_id=?";
		return util.update(sql, id);
	}

	/*
	 * 根据用户id查询用户信息
	 */
	@Override
	public User queryUserById(int id) throws SQLException {
		User user = new User();
		String sql = "select * from T_User where user_id=?";
		rs = util.query(sql, id);
		while (rs.next()) {
			user.setUser_id(rs.getInt("user_id"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_pwd(rs.getString("user_pwd"));
			user.setUser_email(rs.getString("user_email"));
			user.setUser_phone(rs.getString("user_phone"));
			user.setUser_adress(rs.getString("user_adress"));
		}
		return user;
	}

	/*
	 * 更新用户信息
	 */
	@Override
	public int updateUser(User user) throws SQLException {
		String sql = "update T_User set user_name=?,user_phone=?,user_email=?,user_adress=? where user_id=?";
		return util.update(sql, user.getUser_name(), user.getUser_phone(), user.getUser_email(), user.getUser_adress(), user.getUser_id());

	}

	/*
	 * 增加用户
	 */
	@Override
	public int addUser(User user) throws SQLException {
		String sql = "INSERT INTO T_User(user_name,user_pwd,user_phone,user_email,user_adress) VALUES(?,?,?,?,?)";
		return util.update(sql, user.getUser_name(), user.getUser_pwd(), user.getUser_phone(), user.getUser_email(), user.getUser_adress());
	}
}
