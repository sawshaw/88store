package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
	public static final String URL = "jdbc:mysql://localhost:3306/store";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String NAME = "root";
	public static final String PWD = "root";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * 加载驱动
	 * @return
	 */
	public Connection getCon() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, NAME, PWD);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	/**
	 * 增删改
	 * @param sql
	 * @param obj
	 * @return
	 */
	public int update(String sql, Object... obj) {
		int result = 0;
		con = getCon();
		try {
			ps = con.prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i + 1, obj[i]);
				}
			}
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}

		return result;
	}

	/**
	 * 查询
	 * @param sql
	 * @param obj
	 * @return
	 */
	public ResultSet query(String sql, Object... obj) {
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i + 1, obj[i]);
				}
			}
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 关闭连接
	 */
	public void closeAll() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
