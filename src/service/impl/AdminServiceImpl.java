package service.impl;

import java.sql.SQLException;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import entity.Admin;
import service.AdminService;

public class AdminServiceImpl implements AdminService {
	AdminDao dao = new AdminDaoImpl();

	@Override
	public Admin login(String name, String pwd) throws SQLException {
		return dao.login(name, pwd);
	}

	@Override
	public boolean loginCheck(String name) throws SQLException {
		return dao.loginCheck(name) > 0;
	}

	@Override
	public boolean modifypwd(String name, String newPwd) {
		return dao.modifypwd(name, newPwd) > 0;
	}

}
