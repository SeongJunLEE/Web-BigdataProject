package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class StaffDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;
	String staff_search ="select * from staff where s_id = ? and s_password = ?";
	
	public int staffSearch(String s_id, String s_password) {
		result = 0;
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(staff_search);
			st.setString(1, s_id);
			st.setString(2, s_password);
			rs = st.executeQuery();
			if(rs.next()) result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, st, rs);
		}
		return result;
	}
}
