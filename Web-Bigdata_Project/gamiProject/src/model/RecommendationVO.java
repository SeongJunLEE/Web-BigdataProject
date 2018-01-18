package model;

public class RecommendationVO {
	int m_id;
	int r1_id;
	int r2_id;
	int r3_id;
	
	public RecommendationVO() {
		
	}

	public RecommendationVO(int m_id, int r1_id, int r2_id, int r3_id) {
		super();
		this.m_id = m_id;
		this.r1_id = r1_id;
		this.r2_id = r2_id;
		this.r3_id = r3_id;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public int getR1_id() {
		return r1_id;
	}

	public void setR1_id(int r1_id) {
		this.r1_id = r1_id;
	}

	public int getR2_id() {
		return r2_id;
	}

	public void setR2_id(int r2_id) {
		this.r2_id = r2_id;
	}

	public int getR3_id() {
		return r3_id;
	}

	public void setR3_id(int r3_id) {
		this.r3_id = r3_id;
	}

	@Override
	public String toString() {
		return "RecommendationVO [m_id=" + m_id + ", r1_id=" + r1_id + ", r2_id=" + r2_id + ", r3_id=" + r3_id + "]";
	}
	
}
