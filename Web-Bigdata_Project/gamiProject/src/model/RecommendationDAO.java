package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class RecommendationDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;
	
	String selectAllSql="select * from recommendation";
	String selectIdSql= selectAllSql + " where m_id = ? ";
	
	public RecommendationVO selectIdSql(String m_id){
		RecommendationVO recommendation = null;
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(selectIdSql);
			st.setString(1, m_id);
			rs = st.executeQuery();
			if(rs.next()){
				recommendation=makeRecommendation(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbclose(conn, st, rs);
		}
		
		return recommendation;
	}
	
	private RecommendationVO makeRecommendation(ResultSet rs) throws SQLException {
		int m_id = rs.getInt("m_id");
		int r1_id = rs.getInt("r1_id");
		int r2_id = rs.getInt("r2_id");
		int r3_id = rs.getInt("r3_id");
		RecommendationVO recommendation = new RecommendationVO(m_id, r1_id, r2_id, r3_id);
		return recommendation;
	}
}
