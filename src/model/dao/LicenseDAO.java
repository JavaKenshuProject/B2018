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

	//資格をすべてリストに入れて従業員登録処理の際にセレクトで表示する
	/**
	 * @return list
	 */
	public List<LicenseBean> getLicenseList(){
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

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;


	}

	//クライアントが入力した資格をクライアントの保有資格に追加する
	/**
	 * @param empCode
	 * @param licenseCode
	 * @param licenseDate
	 */
	public void licenseRegistration(String empCode,String licenseCode,Date licenseDate) {

		try(Connection con =ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO t_get_license(emp_code,license_code,get_license_date) VALUES (?,?,?)")){

			pstmt.setString(1, empCode);
			pstmt.setString(2, licenseCode);
			pstmt.setDate(3, licenseDate);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

	}

	/**
	 * @param empCode
	 * @param licenseCode
	 */
	public void licenseRegistration(String empCode,String licenseCode) {

		try(Connection con =ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO t_get_license(emp_code,license_code,get_license_date) VALUES (?,?,?)")){

			pstmt.setString(1, empCode);
			pstmt.setString(2, licenseCode);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

	}



	//クライアントが入力した資格を新たに追加する
	/**
	 * @param licenseCode
	 * @param licenseName
	 */
	public void LicenseAddServlet(String licenseCode,String licenseName) {

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt=con.prepareStatement(
						"INSERT INTO m_license (license_code,license_name) VALUES (?,?)")){

			pstmt.setString(1, licenseCode);
			pstmt.setString(2, licenseName);

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
