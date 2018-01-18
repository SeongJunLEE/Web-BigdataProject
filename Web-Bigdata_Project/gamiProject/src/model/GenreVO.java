package model;

public class GenreVO {
	int g_id;
	String g_name;
	
	public GenreVO() {
		
	}
	
	public GenreVO(int g_id, String g_name) {
		super();
		this.g_id = g_id;
		this.g_name = g_name;
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	@Override
	public String toString() {
		return "GenreVO [g_id=" + g_id + ", g_name=" + g_name + "]";
	}
	
	
	
}
