package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.LicenseBean;


/**
 * @author Namioka
 *
 */
public class LicenseDAO {

	/**
	 * 資格をすべてリストに入れて従業員登録処理の際にセレクトで表示する
	 * @return list
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<LicenseBean> getLicenseList() throws ClassNotFoundException, SQLException{
		List<LicenseBean> list =null;

		try(Connection con = ConnectionManager.getConnection();
				Statement stmt= con.createStatement();
				ResultSet res=stmt.executeQuery("select license_code,license_name from m_license");){



			while(res.next()) {
				if(list==null) {
					list = new ArrayList<LicenseBean>();
				}
				LicenseBean license = new LicenseBean();
				license.setLicenseCode(res.getString("license_code"));
				license.setLicenseName(res.getString("license_name"));

				list.add(license);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return list;


	}

	/**
	 * クライアントが入力した資格をクライアントの保有資格に追加する
	 * @param empCode
	 * @param licenseCode
	 * @param licenseDate
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void licenseRegistration(String empCode,String licenseCode,Date licenseDate) throws SQLException, ClassNotFoundException {

		try(Connection con =ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO t_get_license(emp_code,license_code,get_license_date) VALUES (?,?,?)")){

			pstmt.setString(1, empCode);
			pstmt.setString(2, licenseCode);
			pstmt.setDate(3, licenseDate);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

	}

	/**
	 * licenseDateが入力されなかった場合の処理メソッド
	 * @param empCode
	 * @param licenseCode
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void licenseRegistration(String empCode,String licenseCode) throws SQLException, ClassNotFoundException {

		try(Connection con =ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO t_get_license(emp_code,license_code) VALUES (?,?)")){

			pstmt.setString(1, empCode);
			pstmt.setString(2, licenseCode);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

	}

	/**
	 * クライアントが入力した資格を新たに追加する
	 * @param licenseCode
	 * @param licenseName
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void licenseAdd(String licenseCode,String licenseName) throws ClassNotFoundException, SQLException {

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt=con.prepareStatement(
						"INSERT INTO m_license (license_code,license_name) VALUES (?,?)")){

			pstmt.setString(1, licenseCode);
			pstmt.setString(2, licenseName);

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 従業員コードが持つ資格を削除する
	 *
	 * @param empCode 従業員コード
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void getLicenseDelete(String empCode) throws SQLException, ClassNotFoundException {
		try(Connection con =ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"DELETE FROM t_get_license WHERE emp_code = ?")){

			pstmt.setString(1, empCode);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}
	}

}
