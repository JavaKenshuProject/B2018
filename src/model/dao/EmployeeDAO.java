package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.entity.EmployeeBean;

/**
 * 従業員のDAO
 *
 * @author okawa
 *
 */
public class EmployeeDAO {
	/**
	 * 絞り込みをかけた従業員リスト
	 *
	 * @return
	 */
	public List<EmployeeBean> select(){


		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("")){

		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 全従業員リスト
	 *
	 * @return
	 */
	public List<EmployeeBean> selectAll(){
		try(Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("")){

		}catch(SQLException e) {

		}catch(ClassNotFoundException e) {

		}
		return null;
	}

	/**
	 * 従業員の削除
	 *
	 * @param empCode 従業員コード
	 */
	public void delete(String empCode) {
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM m_employee WHERE emp_code = ?")){

			pstmt.setString(1, empCode);

			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 従業員情報の変更
	 *
	 * @param emp 従業員情報
	 */
	public void update(EmployeeBean emp) {
		//SQL文生成
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("")){

		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 従業員の登録
	 *
	 * @param emp 従業員情報
	 */
	public void register(EmployeeBean emp) {
		//SQL文生成
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("")){

		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
