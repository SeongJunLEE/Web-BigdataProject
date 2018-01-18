package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class DirectorDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;
	
	String selectAllSql="select * from director";
	String selectIdSql = selectAllSql + " where d_id = ? ";
	
	public DirectorVO selectIdSql(int d_id){
		DirectorVO director = null;
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(selectIdSql);
			st.setInt(1, d_id);
			rs = st.executeQuery();
			if(rs.next()){
				director= makeDirector(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbclose(conn, st, rs);
		}
		
		return director;
	}
	
	private DirectorVO makeDirector(ResultSet rs) throws SQLException {
		
		int d_id= rs.getInt("d_id");
		String d_name = rs.getString("d_name");
		int d_like = rs.getInt("d_like");
		
		DirectorVO director = new DirectorVO(d_id, d_name, d_like);
		return director;
	}
}
