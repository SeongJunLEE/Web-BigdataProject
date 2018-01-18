package model;

public class MovieVO {
	int m_id;
	String m_name;
	int m_time;
	int m_budget;
	int m_date;
	int m_like;
	float m_ratings;
	float m_pred_ratings;
	int m_ratecount;
	int d_id;
	int a1_id;
	int a2_id;
	int a3_id;
	int g_id;
	
	public MovieVO() {
	}

	public MovieVO(int m_id, String m_name, int m_time, int m_budget, int m_date, int m_like, float m_ratings,
			float m_pred_ratings, int m_ratecount, int d_id, int a1_id, int a2_id, int a3_id, int g_id) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_time = m_time;
		this.m_budget = m_budget;
		this.m_date = m_date;
		this.m_like = m_like;
		this.m_ratings = m_ratings;
		this.m_pred_ratings = m_pred_ratings;
		this.m_ratecount = m_ratecount;
		this.d_id = d_id;
		this.a1_id = a1_id;
		this.a2_id = a2_id;
		this.a3_id = a3_id;
		this.g_id = g_id;
	}


	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public int getM_time() {
		return m_time;
	}

	public void setM_time(int m_time) {
		this.m_time = m_time;
	}

	public int getM_budget() {
		return m_budget;
	}

	public void setM_budget(int m_budget) {
		this.m_budget = m_budget;
	}

	public int getM_date() {
		return m_date;
	}

	public void setM_date(int m_date) {
		this.m_date = m_date;
	}

	public int getM_like() {
		return m_like;
	}

	public void setM_like(int m_like) {
		this.m_like = m_like;
	}

	public float getM_ratings() {
		return m_ratings;
	}

	public void setM_ratings(float m_ratings) {
		this.m_ratings = m_ratings;
	}
	

	public float getM_pred_ratings() {
		return m_pred_ratings;
	}

	public void setM_pred_ratings(float m_pred_ratings) {
		this.m_pred_ratings = m_pred_ratings;
	}

	public int getM_ratecount() {
		return m_ratecount;
	}

	public void setM_ratecount(int m_ratecount) {
		this.m_ratecount = m_ratecount;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public int getA1_id() {
		return a1_id;
	}

	public void setA1_id(int a1_id) {
		this.a1_id = a1_id;
	}

	public int getA2_id() {
		return a2_id;
	}

	public void setA2_id(int a2_id) {
		this.a2_id = a2_id;
	}

	public int getA3_id() {
		return a3_id;
	}

	public void setA3_id(int a3_id) {
		this.a3_id = a3_id;
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	@Override
	public String toString() {
		return "MovieVO [m_id=" + m_id + ", m_name=" + m_name + ", m_time=" + m_time + ", m_budget=" + m_budget
				+ ", m_date=" + m_date + ", m_like=" + m_like + ", m_ratings=" + m_ratings + ", m_pred_ratings="
				+ m_pred_ratings + ", m_ratecount=" + m_ratecount + ", d_id=" + d_id + ", a1_id=" + a1_id + ", a2_id="
				+ a2_id + ", a3_id=" + a3_id + ", g_id=" + g_id + "]";
	}

	
}
