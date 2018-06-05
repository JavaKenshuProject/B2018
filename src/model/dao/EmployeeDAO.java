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

		String sql = "SELECT me.emp_code,me.l_name,me.f_name,me.l_kana_name,me.f_kana_name,me.sex,me.birth_day,me.emp_date,ms.section_name"
				+ "FROM m_employee me JOIN m_section ms ON me.section_code = ms.section_code";

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
				emp.setlKanaName(res.getString("l_kana_name"));
				emp.setfKanaName(res.getString("f_kana_name"));
				emp.setSex(res.getByte("sex"));
				emp.setBirthDay(res.getDate("birth_day"));
				emp.setSectionName(res.getString("section_name"));
				emp.setEmpDate(res.getDate("emp_date"));

				empList.add(emp);
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
		String sql = "UPDATE m_employee SET";
		if(emp.getlName() != null) {
			sql += " l_name = ?";
		}
		if(emp.getfName() != null) {
			sql += " f_name = ?";
		}
		if(emp.getlKanaName() != null) {
			sql += " l_kana_name = ?";
		}
		if(emp.getfKanaName() != null) {
			sql += " f_kana_name = ?";
		}
		if(emp.getSex() != -1) {
			sql += " sex = ?";
		}
		if(emp.getSectionCode() != null) {
			sql += " section_code = ?";
		}
		sql += " WHERE emp_code = ?";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			int index = 1;

			if(emp.getlName() != null) {
				pstmt.setString(index, emp.getlName());
				index++;
			}
			if(emp.getfName() != null) {
				sql += " f_name = ?";
			}
			if(emp.getlKanaName() != null) {
				sql += " l_kana_name = ?";
			}
			if(emp.getfKanaName() != null) {
				sql += " f_kana_name = ?";
			}
			if(emp.getSex() != -1) {
				sql += " sex = ?";
			}
			if(emp.getSectionCode() != null) {
				sql += " section_code = ?";
			}
			pstmt.setString(index, emp.getEmpCode());
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
