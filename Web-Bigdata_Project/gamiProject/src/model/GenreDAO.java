package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class GenreDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;
	
	String selectAllSql="select * from genre";
	String selectIdSql="select g_name from genre where g_id = ? ";
	
	public String selectIdSql(int g_id){
		String g_name = null;
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(selectIdSql);
			st.setInt(1, g_id);
			rs = st.executeQuery();
			if(rs.next()){
				g_name=rs.getString("g_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbclose(conn, st, rs);
		}
		
		return g_name;
	}
}
