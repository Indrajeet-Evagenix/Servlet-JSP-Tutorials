package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entity.Employee;
import entity.SkillMaster;

public class EmployeeSkillMasterDao {

	private Connection conn;

	public EmployeeSkillMasterDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addSkills(int empId, byte skillId) {
		boolean f = false;

		try {
			String sql = "insert into EmployeeSkill_Indra(employeeId,skillMasterId) values(?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empId);
			ps.setInt(2, skillId);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean deleteSkillByEmployeeId(int empId) {
		boolean f = false;

		try {
			String sql = "delete from EmployeeSkill_Indra where employeeId=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, empId);

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Integer> getSkillIdbyEmployeeId(int empId) {
		List<Integer> list = new ArrayList<Integer>();

		try {
			String sql = "select * from EmployeeSkill_Indra where employeeId=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				list.add(rs.getInt(2));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
