package service.impl;

import java.sql.SQLException;
import java.util.List;

import service.UserService;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;

public class UserServiceImpl implements UserService {
	UserDao dao = new UserDaoImpl();

	@Override
	public User login(String name, String pwd) throws SQLException {
		return dao.login(name, pwd);
	}

	@Override
	public boolean loginCheck(String name) throws SQLException {
		return dao.loginCheck(name) > 0;
	}

	@Override
	public void register(User user) {
		dao.reister(user);
	}

	@Override
	public boolean modifypwd(String name, String newPwd) {
		return dao.modifypwd(name, newPwd) > 0;
	}

	@Override
	public List<User> queryAll(int startRow, int size) throws SQLException {
		return dao.queryAll(startRow, size);
	}

	@Override
	public int countAll() throws SQLException {
		return dao.countAll();
	}

	@Override
	public List<User> queryAll(User user) throws SQLException {
		return dao.queryAll(user);
	}

	@Override
	public List<User> queryByName(String user_name) throws SQLException {
		return dao.queryByName(user_name);
	}

	@Override
	public boolean delete(int id) throws SQLException {
		return dao.delete(id) > 0;
	}

	@Override
	public User queryUserById(int id) throws SQLException {
		return dao.queryUserById(id);
	}

	@Override
	public boolean updateUser(User user) throws SQLException {
		return dao.updateUser(user) > 0;
	}

	@Override
	public boolean addUser(User user) throws SQLException {
		return dao.addUser(user) > 0;
	}

}
