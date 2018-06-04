package model.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 従業員情報のBean
 *
 * @author okawa
 *
 */
public class EmployeeBean implements Serializable {
	private String empCode;
	private String lName;
	private String fName;
	private String lKataName;
	private String fKataName;
	private byte sex;
	private Date birthDay;
	private String sectionName;
	private Date empDate;
	List<LicenseBean> licenseList;

	/**
	 * @return empCode 従業員コード
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
	 * @return lName 苗字
	 */
	public String getlName() {
		return lName;
	}
	/**
	 * @param lName セットする lName
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	/**
	 * @return fName 名前
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * @param fName セットする fName
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * @return lKataName 苗字(フリガナ)
	 */
	public String getlKataName() {
		return lKataName;
	}
	/**
	 * @param lKataName セットする lKataName
	 */
	public void setlKataName(String lKataName) {
		this.lKataName = lKataName;
	}
	/**
	 * @return fKataName 名前(フリガナ)
	 */
	public String getfKataName() {
		return fKataName;
	}
	/**
	 * @param fKataName セットする fKataName
	 */
	public void setfKataName(String fKataName) {
		this.fKataName = fKataName;
	}
	/**
	 * @return sex 性別
	 */
	public byte getSex() {
		return sex;
	}
	/**
	 * @param sex セットする sex
	 */
	public void setSex(byte sex) {
		this.sex = sex;
	}
	/**
	 * @return birthDay 誕生日
	 */
	public Date getBirthDay() {
		return birthDay;
	}
	/**
	 * @param birthDay セットする birthDay
	 */
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	/**
	 * @return sectionName 部署名
	 */
	public String getSectionName() {
		return sectionName;
	}
	/**
	 * @param sectionName セットする sectionName
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	/**
	 * @return empDate 入社日
	 */
	public Date getEmpDate() {
		return empDate;
	}
	/**
	 * @param empDate セットする empDate
	 */
	public void setEmpDate(Date empDate) {
		this.empDate = empDate;
	}
	/**
	 * @return licenseList 取得資格リスト
	 */
	public List<LicenseBean> getLicenseList() {
		return licenseList;
	}
	/**
	 * @param licenseList セットする licenseList
	 */
	public void setLicenseList(List<LicenseBean> licenseList) {
		this.licenseList = licenseList;
	}
}
