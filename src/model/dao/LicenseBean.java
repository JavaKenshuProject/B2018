package model.dao;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Namioka
 *
 */
public class LicenseBean implements Serializable {

	private String licenseName;	//資格名
	private String licenseCode;	//資格コード
	private String empCode;		//従業員コード
	private Date getLicenseDate;	//資格取得日

	/**
	 * @return licenseName
	 */
	public String getLicenseName() {
		return licenseName;
	}
	/**
	 * @param licenseName セットする licenseName
	 */
	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
	}
	/**
	 * @return licenseCode
	 */
	public String getLicenseCode() {
		return licenseCode;
	}
	/**
	 * @param licenseCode セットする licenseCode
	 */
	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}
	/**
	 * @return empCode
	 */
	public String getEmpCode() {
		return empCode;
	}
	/**
	 * @param empCode セットする empCode
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	/**
	 * @return getLicenseDate
	 */
	public Date getGetLicenseDate() {
		return getLicenseDate;
	}
	/**
	 * @param getLicenseDate セットする getLicenseDate
	 */
	public void setGetLicenseDate(Date getLicenseDate) {
		this.getLicenseDate = getLicenseDate;
	}


}
