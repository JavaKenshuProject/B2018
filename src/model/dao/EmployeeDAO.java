package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	public List<EmployeeBean> select(String name, Byte sex, String section, String initial, String sortColumn){
		List<EmployeeBean> empList = null;
		//SQL文作成


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
		List<EmployeeBean> empList = null;

		String sql = "SELECT eme.emp_code,eme.l_name,eme.f_name,eme.l_kana_name,eme.f_kana_name,eme.sex,eme.birth_day,eme.emp_date,ems.section_name"
				+ "FROM emp_sys_db.m_employee eme JOIN emp_sys_db.m_section ems ON eme.section_code = ems.section_code";

		try(Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)){

			while(res.next()) {
				if(empList == null) {
					empList = new ArrayList<>();
				}
				EmployeeBean emp = new EmployeeBean();
				emp.setEmpCode(res.getString("emp_code"));
				emp.setlName(res.getString("l_name"));
				emp.setfName(res.getString("f_name"));
				emp.setlKataName(res.getString("l_kana_name"));
				emp.setfKataName(res.getString("f_kana_name"));
				emp.setSex(res.getByte("sex"));
				emp.setBirthDay(res.getDate("birth_day"));
				emp.setSectionName(res.getString("section_name"));
				emp.setEmpDate(res.getDate("emp_date"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return empList;
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
