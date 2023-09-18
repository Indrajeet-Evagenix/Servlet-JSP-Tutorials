package entity;

public class SkillMaster {

	private byte skilMasterId;
	private String name;

	public byte getSkilMasterId() {
		return skilMasterId;
	}

	public void setSkilMasterId(byte skilMasterId) {
		this.skilMasterId = skilMasterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SkillMaster [skilMasterId=" + skilMasterId + ", name=" + name + "]";
	}

	public SkillMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SkillMaster(String name) {
		super();
		this.name = name;
	}

	public SkillMaster(byte skilMasterId, String name) {
		super();
		this.skilMasterId = skilMasterId;
		this.name = name;
	}

}
