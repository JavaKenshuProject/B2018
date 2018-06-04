package model.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 変更ログBean
 *
 * @author okawa
 *
 */
public class ChangeLogBean implements Serializable {
	private Timestamp updateDate;
	private String userId;
	private String section;
	private String operation;
	private String empCode;

	/**
	 * @return updateDate 編集日時
	 */
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param updateDate セットする updateDate
	 */
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * @return userId ユーザID
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
	 * @return section 部署名
	 */
	public String getSection() {
		return section;
	}
	/**
	 * @param section セットする section
	 */
	public void setSection(String section) {
		this.section = section;
	}
	/**
	 * @return operation 操作
	 */
	public String getOperation() {
		return operation;
	}
	/**
	 * @param operation セットする operation
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}
	/**
	 * @return empCode　従業員コード
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
}
