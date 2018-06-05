package model.entity;

import java.io.Serializable;
/**
 * ユーザーBean
 * 
 * @author akiya
 *
 */
public class UserBean implements Serializable {

	private String userId;
	private String password;
	private String sectionCode;
	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return sectionCode
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
}

