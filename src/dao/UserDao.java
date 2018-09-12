package dao;

import java.sql.SQLException;
import java.util.List;

import entity.User;

public interface UserDao {
	public User login(String name, String pwd) throws SQLException;

	public int loginCheck(String name) throws SQLException;

	public void reister(User user);

	public int modifypwd(String name, String newPwd);

	public List<User> queryAll(int startRow, int size) throws SQLException;

	public int countAll() throws SQLException;

	public List<User> queryAll(User user) throws SQLException;

	public List<User> queryByName(String user_name) throws SQLException;

	public int delete(int id) throws SQLException;

	public User queryUserById(int id) throws SQLException;

	public int updateUser(User user) throws SQLException;

	public int addUser(User user) throws SQLException;
}
