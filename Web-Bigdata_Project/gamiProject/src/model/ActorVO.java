package model;

public class ActorVO {
	int a_id;
	String a_name;
	int a_like;
	int a_rank;
	
	public ActorVO() {
		
	}
	
	public ActorVO(int a_id, String a_name, int a_like, int a_rank) {
		super();
		this.a_id = a_id;
		this.a_name = a_name;
		this.a_like = a_like;
		this.a_rank = a_rank;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public int getA_like() {
		return a_like;
	}

	public void setA_like(int a_like) {
		this.a_like = a_like;
	}

	public int getA_rank() {
		return a_rank;
	}

	public void setA_rank(int a_rank) {
		this.a_rank = a_rank;
	}

	@Override
	public String toString() {
		return "ActorDAO [a_id=" + a_id + ", a_name=" + a_name + ", a_like=" + a_like + ", a_rank=" + a_rank + "]";
	}
	
}
