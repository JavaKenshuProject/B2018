package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.ChangeLogBean;

/**
 * 変更ログのDAO
 *
 * @author okawa
 *
 */
public class ChangeLogDAO {

	/**
	 * 変更ログを全てもってくる
	 *
	 * @return 変更ログのリスト
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<ChangeLogBean> selectAll() throws SQLException, ClassNotFoundException{
		List<ChangeLogBean> changeLogList = null;
		String sql = "SELECT tcl.update_date,tcl.user_id,tcl.operation,ms.section_name,tcl.emp_code"
				+ " FROM (t_change_log tcl JOIN m_user mu ON tcl.user_id = mu.user_id)"
				+ " JOIN m_section ms ON mu.section_code = ms.section_code ORDER BY tcl.update_date DESC";

		try(Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
					ResultSet res = stmt.executeQuery(sql)){

			while(res.next()) {
				if(changeLogList == null) {
					changeLogList = new ArrayList<>();
				}

				ChangeLogBean clBean = new ChangeLogBean();
				clBean.setUpdateDate(res.getTimestamp("update_date"));
				clBean.setUserId(res.getString("user_id"));
				clBean.setSection(res.getString("section_name"));
				clBean.setOperation(res.getString("operation"));
				clBean.setEmpCode(res.getString("emp_code"));

				changeLogList.add(clBean);
			}

		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return changeLogList;
	}

	/**
	 * DBに変更ログを挿入する
	 *
	 * @param changeLog 変更ログ
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void insert(ChangeLogBean changeLog) throws SQLException, ClassNotFoundException {
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO t_change_log (user_id, operation, emp_code) VALUES (?, ?, ?)")){

			pstmt.setString(1, changeLog.getUserId());
			pstmt.setString(2, changeLog.getOperation());
			pstmt.setString(3, changeLog.getEmpCode());

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
