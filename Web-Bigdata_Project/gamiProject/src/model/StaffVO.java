package model;

public class StaffVO {
	String s_id;
	String s_password;
	String s_name;
	
	public StaffVO() {
		
	}

	public StaffVO(String s_id, String s_password, String s_name) {
		super();
		this.s_id = s_id;
		this.s_password = s_password;
		this.s_name = s_name;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getS_password() {
		return s_password;
	}

	public void setS_password(String s_password) {
		this.s_password = s_password;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	@Override
	public String toString() {
		return "StaffVO [s_id=" + s_id + ", s_password=" + s_password + ", s_name=" + s_name + "]";
	}
}


