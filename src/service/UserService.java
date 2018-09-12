package service;

import java.sql.SQLException;
import java.util.List;

import entity.User;

public interface UserService {
	public User login(String name, String pwd) throws SQLException;

	public boolean loginCheck(String name) throws SQLException;

	public void register(User user);

	public boolean modifypwd(String name, String newPwd);

	public List<User> queryAll(int startRow, int size) throws SQLException;

	public int countAll() throws SQLException;

	public List<User> queryAll(User user) throws SQLException;

	public List<User> queryByName(String user_name) throws SQLException;

	public boolean delete(int id) throws SQLException;

	public User queryUserById(int id) throws SQLException;

	public boolean updateUser(User user) throws SQLException;

	public boolean addUser(User user) throws SQLException;
}
