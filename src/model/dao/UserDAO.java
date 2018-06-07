package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

/**
 * ユーザーのDAO
 * @author akiya
 *
 */
public class UserDAO {

	/**
	 * ログイン
	 * 引数をもとにユーザマスタから該当するレコードを抽出し、対応するBeanオブジェクトを返す
	 * @param userId　ユーザID
	 * @param password　パスワード
	 * @return 認証成功したユーザのBeanオブジェクト
	 * @throws SQLException 
	 */

	public UserBean login(String userId, String password) throws SQLException, ClassNotFoundException{
		UserBean user = null;
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"SELECT * FROM m_user WHERE user_id = ? AND password = ?")){


			pstmt.setString(1, userId);
			pstmt.setString(2, password);

			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				if(user == null) {
					user = new UserBean();
				}
				user.setUserId(res.getString("user_id"));
				user.setPassword(res.getString("password"));
				user.setSectionCode(res.getString("section_code"));

			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return user;
	}
	/**
	 * 引数で指定した情報をユーザマスタに登録（挿入）する
	 * @param userId　ユーザID
	 * @param password　パスワード
	 * @param sectionCode
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void registerUser(String userId,String password,String sectionCode)throws SQLException, ClassNotFoundException{


		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO m_user (user_id,password,section_code) VALUES(?,?,?)")){

			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			pstmt.setString(3, sectionCode);

			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}

	}
}
