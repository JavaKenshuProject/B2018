package model.entity;

import java.io.Serializable;

/**
 * 所属Bean
 *
 * @author iwase
 *
 */
public class SectionBean implements Serializable {

	private String sectionCode;
	private String sectionName;

	/**
	 * @param sectionCode 所属コード
	 */
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	/**
	 * @return sectionCode 所属コード
	 */
	public String getSectionCode() {
		return this.sectionCode;
	}

	/**
	 * @param sectionName 所属部署名
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	/**
	 * @return sectionName 所属部署名
	 */
	public String getSectionName() {
		return this.sectionName;
	}

}
