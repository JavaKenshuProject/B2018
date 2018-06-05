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
	private String lKanaName;
	private String fKanaName;
	private byte sex = -1;
	private Date birthDay;
	private String sectionName;
	private String sectionCode;
	private Date empDate;
	List<String> licenseList;

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
	 * @return lKanaName 苗字(フリガナ)
	 */
	public String getlKanaName() {
		return lKanaName;
	}
	/**
	 * @param lKanaName セットする lKanaName
	 */
	public void setlKanaName(String lKataName) {
		this.lKanaName = lKataName;
	}
	/**
	 * @return fKanaName 名前(フリガナ)
	 */
	public String getfKanaName() {
		return fKanaName;
	}
	/**
	 * @param fKanaName セットする fKanaName
	 */
	public void setfKanaName(String fKataName) {
		this.fKanaName = fKataName;
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
	 * @return sectionCode 部署コード
	 */
	public String getSectionCode() {
		return sectionCode;
	}
	/**
	 * @param sectionCode セットする sectionCode
	 */
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
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
	public List<String> getLicenseList() {
		return licenseList;
	}
	/**
	 * @param licenseList セットする licenseList
	 */
	public void setLicenseList(List<String> licenseList) {
		this.licenseList = licenseList;
	}
}
