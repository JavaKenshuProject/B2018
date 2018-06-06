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
	 * @return 絞り込み従業員リスト
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<EmployeeBean> select(String name, Byte sex, String section, String initial, String sortColumn, String order) throws SQLException, ClassNotFoundException{
		List<EmployeeBean> empList = null;
		//SQL文作成
		String sql = "SELECT me.emp_code,me.l_name,me.f_name,me.l_kana_name,me.f_kana_name,me.sex,me.birth_day,me.emp_date,ms.section_name"
				+ " FROM m_employee me JOIN m_section ms ON me.section_code = ms.section_code"
				+ " WHERE (me.l_name LIKE ? OR me.f_name LIKE ? OR me.l_kana_name LIKE ? OR me.f_kana_name LIKE ?)"
				+ " AND me.l_kana_name LIKE ? AND ms.section_name LIKE ?";
		if(sex >= 0) {
			sql += " AND sex = ?";
		}
		sql += " ORDER BY me."+ sortColumn;
		sql += " " + order;

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, "%"+name+"%");	//苗字に含むか
			pstmt.setString(2, "%"+name+"%");	//名前に含むか
			pstmt.setString(3, "%"+name+"%");	//苗字フリガナに含むか
			pstmt.setString(4, "%"+name+"%");	//名前フリガナに含むか
			pstmt.setString(5, initial+"%");	//頭文字
			pstmt.setString(6, "%"+section+"%");	//部署
			if(sex >= 0) {
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
				e.printStackTrace();
				throw e;
			}

		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}

		return empList;
	}

	/**
	 * ある従業員コードの従業員情報取得
	 *
	 * @param empCode 従業員コード
	 * @return 従業員情報
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public EmployeeBean select(String empCode) throws SQLException, ClassNotFoundException{
		EmployeeBean employee = null;

		String sql = "SELECT me.emp_code,me.l_name,me.f_name,me.l_kana_name,me.f_kana_name,me.sex,me.birth_day,me.emp_date,ms.section_name"
				+ " FROM m_employee me JOIN m_section ms ON me.section_code = ms.section_code WHERE me.emp_code = ?";

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, empCode);

			try(ResultSet res = pstmt.executeQuery()){
				if(res.next()) {
					employee = new EmployeeBean();
					employee.setEmpCode(res.getString("emp_code"));
					employee.setlName(res.getString("l_name"));
					employee.setfName(res.getString("f_name"));
					employee.setlKanaName(res.getString("l_kana_name"));
					employee.setfKanaName(res.getString("f_kana_name"));
					employee.setSex(res.getByte("sex"));
					employee.setBirthDay(res.getDate("birth_day"));
					employee.setSectionName(res.getString("section_name"));
					employee.setEmpDate(res.getDate("emp_date"));
				}
			}catch(Exception e) {
				throw e;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return employee;
	}

	/**
	 * 全従業員リスト
	 *
	 * @return 全従業員リスト
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<EmployeeBean> selectAll() throws SQLException, ClassNotFoundException{
		List<EmployeeBean> empList = null;

		String sql = "SELECT me.emp_code,me.l_name,me.f_name,me.l_kana_name,me.f_kana_name,me.sex,me.birth_day,me.emp_date,ms.section_name"
				+ " FROM m_employee me JOIN m_section ms ON me.section_code = ms.section_code";

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
			throw e;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return empList;
	}

	/**
	 * 従業員の削除
	 *
	 * @param empCode 従業員コード
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void delete(String empCode) throws SQLException, ClassNotFoundException {
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM m_employee WHERE emp_code = ?")){

			pstmt.setString(1, empCode);

			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 従業員情報の変更
	 *
	 * @param emp 従業員情報
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void update(EmployeeBean emp) throws SQLException, ClassNotFoundException {
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
			throw e;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 従業員の登録
	 *
	 * @param emp 従業員情報
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void register(EmployeeBean emp) throws SQLException, ClassNotFoundException {
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
			throw e;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
