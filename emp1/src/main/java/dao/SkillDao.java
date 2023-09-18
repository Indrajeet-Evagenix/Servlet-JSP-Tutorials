package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.SkillMaster;

public class SkillDao {

	private Connection conn;

	public SkillDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public List<SkillMaster> listOfSkills() {
		List<SkillMaster> list = new ArrayList<SkillMaster>();
		SkillMaster skill = null;

		try {
			String sql = "select * from SkillMaster_Indra";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				skill = new SkillMaster();
				skill.setSkilMasterId((byte) rs.getInt(1));
				skill.setName(rs.getString(2));

				list.add(skill);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	

	public SkillMaster getSkillMasterById(int id) {
		SkillMaster skillMaster = null;

		try {
			String sql = "select * from SkillMaster_Indra where skillMasterId=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				skillMaster = new SkillMaster();
				skillMaster.setSkilMasterId((byte) rs.getInt(1));
				skillMaster.setName(rs.getString(2));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return skillMaster;

	}

}
