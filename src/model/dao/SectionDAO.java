package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.SectionBean;


/**
 * 所属DAO
 *
 * @author iwase
 *
 */
public class SectionDAO {

	/**
	 * @return 所属情報リスト
	 */

	public List<SectionBean> getSectionList() {

		List<SectionBean> sectionList = null;

		try(Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
					ResultSet res = stmt.executeQuery("SELECT * FROM m_section")) {

			while(res.next()) {
				if(sectionList == null) {
					sectionList = new ArrayList<SectionBean>();
				}
				SectionBean section = new SectionBean();
				section.setSectionCode(res.getString("section_code"));
				section.setSectionName(res.getString("section_name"));

				sectionList.add(section);
			}

		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return sectionList;
	}

}

