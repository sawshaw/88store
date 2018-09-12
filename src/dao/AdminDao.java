package dao;

import java.sql.SQLException;

import entity.Admin;

public interface AdminDao {
	public Admin login(String name, String pwd) throws SQLException;

	public int loginCheck(String name) throws SQLException;

	public int modifypwd(String name, String newPwd);
}
