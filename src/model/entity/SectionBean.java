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
	/**
	 * @return sectionName
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


}
