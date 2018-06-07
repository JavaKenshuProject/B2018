package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		//五十音表
		Map<String, String> kanaMap = new HashMap<>();
		kanaMap.put("", ".*");
		kanaMap.put("ア", "^(ア|イ|ウ|エ|オ)+");
		kanaMap.put("カ", "^(カ|キ|ク|ケ|コ|ガ|ギ|グ|ゲ|ゴ)+");
		kanaMap.put("サ", "^(サ|シ|ス|セ|ソ|ザ|ジ|ズ|ゼ|ゾ)+");
		kanaMap.put("タ", "^(タ|チ|ツ|テ|ト|ダ|ヂ|ヅ|デ|ド)+");
		kanaMap.put("ナ", "^(ナ|ニ|ヌ|ネ|ノ)+");
		kanaMap.put("ハ", "^(ハ|ヒ|フ|ヘ|ホ|バ|ビ|ブ|ベ|ボ|パ|ピ|プ|ペ|ポ)+");
		kanaMap.put("マ", "^(マ|ミ|ム|メ|モ)+");
		kanaMap.put("ヤ", "^(ヤ|ユ|ヨ)+");
		kanaMap.put("ラ", "^(ラ|リ|ル|レ|ロ)+");
		kanaMap.put("ワ", "^(ワ|ヲ|ン)+");
		//SQL文作成
		String sql = "SELECT me.emp_code,me.l_name,me.f_name,me.l_kana_name,me.f_kana_name,me.sex,me.birth_day,me.emp_date,ms.section_name,tgl.license_code"
				+ " FROM (m_employee me JOIN m_section ms ON me.section_code = ms.section_code) LEFT OUTER JOIN t_get_license tgl ON me.emp_code = tgl.emp_code"
				+ " WHERE (me.l_name LIKE ? OR me.f_name LIKE ? OR me.l_kana_name LIKE ? OR me.f_kana_name LIKE ?)"
				+ " AND me.l_kana_name REGEXP ? AND ms.section_name LIKE ?";
		if(sex >= 0) {
			sql += " AND sex = ?";
		}
		sql += " ORDER BY me."+ sortColumn;
		sql += " " + order;
		sql += " ,me.emp_code,tgl.license_code ASC";

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, "%"+name+"%");	//苗字に含むか
			pstmt.setString(2, "%"+name+"%");	//名前に含むか
			pstmt.setString(3, "%"+name+"%");	//苗字フリガナに含むか
			pstmt.setString(4, "%"+name+"%");	//名前フリガナに含むか
			pstmt.setString(5, kanaMap.get(initial));	//頭文字
			pstmt.setString(6, "%"+section+"%");	//部署
			if(sex >= 0) {
				pstmt.setByte(7, sex);
			}
			try(ResultSet res = pstmt.executeQuery()){
				boolean next = res.next();
				while(next) {
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

					List<String> licenseCodeList = new ArrayList<>();
					while(true) {
						if(res.getString("license_code") != null) {
							licenseCodeList.add(res.getString("license_code"));
						}
						next = res.next();
						//従業員コードが同じ かつ まだ次がある
						if(next && res.getString("emp_code").equals(emp.getEmpCode())) {

						}else {
							break;
						}
					}
					emp.setLicenseList(licenseCodeList);
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

		String sql = "SELECT me.emp_code,me.l_name,me.f_name,me.l_kana_name,me.f_kana_name,me.sex,me.birth_day,me.emp_date,ms.section_name,tgl.license_code"
				+ " FROM (m_employee me JOIN m_section ms ON me.section_code = ms.section_code) LEFT OUTER JOIN t_get_license tgl ON me.emp_code = tgl.emp_code"
				+ " ORDER BY me.emp_code ASC, tgl.license_code ASC";

		try(Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)){
			boolean next = res.next();
			while(next) {
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

				List<String> licenseCodeList = new ArrayList<>();
				while(true) {
					if(res.getString("license_code") != null) {
						licenseCodeList.add(res.getString("license_code"));
					}
					next = res.next();
					//従業員コードが同じ かつ まだ次がある
					if(next && res.getString("emp_code").equals(emp.getEmpCode())) {

					}else {
						break;
					}
				}
				emp.setLicenseList(licenseCodeList);
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
			sql += " l_name = ? ,";
		}
		if(emp.getfName() != null) {
			sql += " f_name = ? ,";
		}
		if(emp.getlKanaName() != null) {
			sql += " l_kana_name = ? ,";
		}
		if(emp.getfKanaName() != null) {
			sql += " f_kana_name = ? ,";
		}
		if(emp.getSex() != -1) {
			sql += " sex = ? ,";
		}
		if(emp.getSectionCode() != null) {
			sql += " section_code = ? ,";
		}
		sql = sql.substring(0, sql.length()-2);
		sql += " WHERE emp_code = ?";

		System.out.println(sql);

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
