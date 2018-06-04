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
	 */
	public List<ChangeLogBean> selectAll(){
		List<ChangeLogBean> changeLogList = null;
		String sql = "select etcl.update_date,etcl.user_id,etcl.operation,ems.section_name,etcl.emp_code"
				+ "from (emp_sys_db.t_change_log etcl JOIN emp_sys_db.m_user emu ON etcl.user_id = emu.user_id)"
				+ "JOIN emp_sys_db.m_section ems ON emu.section_code = ems.section_code";

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
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return changeLogList;
	}

	/**
	 * DBに変更ログを挿入する
	 *
	 * @param changeLog 変更ログ
	 */
	public void insert(ChangeLogBean changeLog) {
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO t_change_log (user_id, operation, emp_code) VALUES (?, ?, ?)")){

			pstmt.setString(1, changeLog.getUserId());
			pstmt.setString(2, changeLog.getOperation());
			pstmt.setString(3, changeLog.getEmpCode());

			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
