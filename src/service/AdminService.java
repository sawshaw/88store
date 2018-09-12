package service;

import java.sql.SQLException;

import entity.Admin;

public interface AdminService {
	public Admin login(String name, String pwd) throws SQLException;

	public boolean loginCheck(String name) throws SQLException;

	public boolean modifypwd(String name, String newPwd);
}
