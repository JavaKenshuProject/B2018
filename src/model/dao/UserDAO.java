package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

/**
 * ログイン、ログアウトと、システムを利用できるユーザの登録
 * @author akiya
 * 
 */
public class UserDAO {

	/**
	 * ログイン
	 * 引数をもとにユーザマスタから該当するレコードを抽出し
	 * 対応するBeanオブジェクトを返す
	 * @param userId
	 * @param password
	 * @return 認証曳航したユーザのBeanオブジェクト
	 * @throws Exception
	 */

	public UserBean login(String userId, String password) throws Exception{
		UserBean ub = null;

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"SELECT * FROM m_user Where userId = ? and password = ?")){


			pstmt.setString(1, userId);
			pstmt.setString(2, password);

			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				if(ub == null) {
					ub = new UserBean();
				}
				ub.setUserId(res.getString("user_id"));
				ub.setPassword(res.getString("password"));
				ub.setSectionCode(res.getString("section_code"));

			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ub;
	}
	/**
	 * 引数で指定した情報をユーザマスタに登録（挿入）する
	 * @param userId
	 * @param password
	 * @param sectionCode
	 * @throws Exception
	 */
	public void userRegistration(String userId,String password,String sectionCode)throws Exception{


		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO m_user VALUES(?,?,?)")){

			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			pstmt.setString(3, sectionCode);

			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
}
