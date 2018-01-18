package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class ActorDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;
	
	String selectAllSql="select * from actor";
	String selectIdSql = selectAllSql + " where a_id = ? ";
	
	public ActorVO selectIdSql(int a_id){
		ActorVO actor = null;
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(selectIdSql);
			st.setInt(1, a_id);
			rs = st.executeQuery();
			if(rs.next()){
				actor= makeActor(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbclose(conn, st, rs);
		}
		
		return actor;
	}
	
	private ActorVO makeActor(ResultSet rs) throws SQLException {
		
		int a_id= rs.getInt("a_id");
		String a_name = rs.getString("a_name");
		int a_like = rs.getInt("a_like");
		int a_rank = rs.getInt("a_rank");
		
		ActorVO actor = new ActorVO(a_id, a_name, a_like, a_rank);
		return actor;
	}
}
