package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author user
 *
 */
public class ConnectionManager {
	private final static String URL = "jdbc:mysql://localhost:3306/emp_sys_db?useSSL=false";
	private final static String USER = "newver";
	private final static String PASSWORD = "ride";

	/**
	 * DBの接続
	 *
	 * @return コネクション
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		//JDBCドライバクラスの初期化処理
		Class.forName("com.mysql.jdbc.Driver");

		//コネクション取得
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
