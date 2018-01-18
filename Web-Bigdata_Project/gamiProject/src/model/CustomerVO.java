package model;

import java.sql.Date;

public class CustomerVO {
	String c_id;
	String c_password;
	String c_name;
	char gender;
	Date birth;
	String c_phone;
	Date join_date;
	public CustomerVO() {
		
	}

	public CustomerVO(String c_id, String c_password, String c_name, char gender, Date birth, String c_phone,
		 Date join_date) {
		super();
		this.c_id = c_id;
		this.c_password = c_password;
		this.c_name = c_name;
		this.gender = gender;
		this.birth = birth;
		this.c_phone = c_phone;
		this.join_date = join_date;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_password() {
		return c_password;
	}

	public void setC_password(String c_password) {
		this.c_password = c_password;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getC_phone() {
		return c_phone;
	}

	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}


	@Override
	public String toString() {
		return "CustomerVO [c_id=" + c_id + ", c_password=" + c_password + ", c_name=" + c_name + ", gender=" + gender
				+ ", birth=" + birth + ", c_phone=" + c_phone + ", join_date=" + join_date
				+ "]";
	}
	
	
}