package model;

public class DirectorVO {
	int d_id;
	String d_name;
	int d_like;
	
	public DirectorVO() {
		
	}

	public DirectorVO(int d_id, String d_name, int d_like) {
		super();
		this.d_id = d_id;
		this.d_name = d_name;
		this.d_like = d_like;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public int getD_like() {
		return d_like;
	}

	public void setD_like(int d_like) {
		this.d_like = d_like;
	}

	@Override
	public String toString() {
		return "DirectorVO [d_id=" + d_id + ", d_name=" + d_name + ", d_like=" + d_like + "]";
	}
	
}
