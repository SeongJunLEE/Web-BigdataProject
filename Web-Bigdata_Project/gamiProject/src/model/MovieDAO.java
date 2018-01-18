package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class MovieDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;
	
	String selectAllSql="select * from movie";
	String selectIdSql = selectAllSql + " where m_id = ?";
	String selectNameSql= selectAllSql + " where m_name like ? and ROWNUM <= 20 order by m_ratings desc";
	
	public List<MovieVO> selectAllSql(){
		List<MovieVO> movielist = new ArrayList<MovieVO>();
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(selectAllSql);
			rs = st.executeQuery();
			while(rs.next()){
				MovieVO movie = makeMovie(rs);
				movielist.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbclose(conn, st, rs);
		}
		
		return movielist;
	}
	
	public MovieVO selectIdSql(String m_id){
		MovieVO movie = null;
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(selectIdSql);
			st.setString(1, m_id);
			rs = st.executeQuery();
			if(rs.next()){
				movie = makeMovie(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbclose(conn, st, rs);
		}
		
		return movie;
	}
	
	public MovieVO selectIdSql(int m_id){
		MovieVO movie = null;
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(selectIdSql);
			st.setInt(1, m_id);
			rs = st.executeQuery();
			if(rs.next()){
				movie = makeMovie(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbclose(conn, st, rs);
		}
		
		return movie;
	}
	
	public List<MovieVO> selectNameSql(String m_name){
		List<MovieVO> movielist = new ArrayList<>();
		MovieVO movie = null;
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(selectNameSql);
			st.setString(1, "%"+m_name+"%");
			rs = st.executeQuery();
			while(rs.next()){
				movie = makeMovie(rs);
				movielist.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbclose(conn, st, rs);
		}
		
		return movielist;
	}
	
	
	
	private MovieVO makeMovie(ResultSet rs) throws SQLException {
		int m_id = rs.getInt("m_id");
		String m_name = rs.getString("m_name");
		int m_time = rs.getInt("m_time");
		int m_budget = rs.getInt("m_budget");
		int m_date = rs.getInt("m_date");
		int m_like = rs.getInt("m_like");
		float m_ratings = rs.getFloat("m_ratings");
		float m_pred_ratings = rs.getFloat("m_pred_ratings");
		int m_ratecount = rs.getInt("m_ratecount");
		int d_id = rs.getInt("d_id");
		int a1_id = rs.getInt("a1_id");
		int a2_id = rs.getInt("a2_id");
		int a3_id = rs.getInt("a3_id");
		int g_id = rs.getInt("g_id");
		MovieVO movie = new MovieVO(m_id, m_name, m_time, m_budget, m_date, m_like, m_ratings, m_pred_ratings, m_ratecount, d_id, a1_id, a2_id, a3_id, g_id);
		return movie;
	}
}
