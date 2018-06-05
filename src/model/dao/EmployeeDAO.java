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
	public List<EmployeeBean> select(String name, Byte sex, String section, String initial, String sortColumn, String order){
		List<EmployeeBean> empList = null;
		//SQL文作成
		String sql = "SELECT me.emp_code,me.l_name,me.f_name,me.l_kana_name,me.f_kana_name,me.sex,me.birth_day,me.emp_date,ms.section_name"
				+ "FROM m_employee me JOIN m_section ms ON me.section_code = ms.section_code"
				+ "WHERE (l_name LIKE ? OR f_name LIKE ? OR l_kana_name LIKE ? OR f_kana_name LIKE ?)"
				+ "AND l_kana_name LIKE ? AND section LIKE ?";
		if(sex != 0) {
			sql += " AND sex = ?";
		}
		sql += "ORDER BY "+ sortColumn;
		sql += " " + order;

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, "%"+name+"%");	//苗字に含むか
			pstmt.setString(2, "%"+name+"%");	//名前に含むか
			pstmt.setString(3, "%"+name+"%");	//苗字フリガナに含むか
			pstmt.setString(4, "%"+name+"%");	//名前フリガナに含むか
			pstmt.setString(5, initial+"%");	//頭文字
			pstmt.setString(6, "%"+section+"%");	//部署
			if(sex != 0) {
				pstmt.setByte(7, sex);
			}

			try(ResultSet res = pstmt.executeQuery()){
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
			}catch(Exception e) {
				throw e;
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		return empList;
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
				pstmt.setString(index, emp.getfName());
				index++;
			}
			if(emp.getlKanaName() != null) {
				pstmt.setString(index, emp.getlKanaName());
				index++;
			}
			if(emp.getfKanaName() != null) {
				pstmt.setString(index, emp.getfKanaName());
				index++;
			}
			if(emp.getSex() != -1) {
				pstmt.setByte(index, emp.getSex());
				index++;
			}
			if(emp.getSectionCode() != null) {
				pstmt.setString(index, emp.getSectionCode());
				index++;
			}
			pstmt.setString(index, emp.getEmpCode());

			pstmt.executeUpdate();
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
		String sql = "INSERT INTO m_employee (emp_code, l_name, f_name, l_kana_name, f_kana_name, sex, birth_day, section_code, emp_date) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, emp.getEmpCode());
			pstmt.setString(2, emp.getlName());
			pstmt.setString(3, emp.getfName());
			pstmt.setString(4, emp.getlKanaName());
			pstmt.setString(5, emp.getfKanaName());
			pstmt.setByte(6, emp.getSex());
			pstmt.setDate(7, emp.getBirthDay());
			pstmt.setString(8, emp.getSectionCode());
			pstmt.setDate(9, emp.getEmpDate());

			pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
