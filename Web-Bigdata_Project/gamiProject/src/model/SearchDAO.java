package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class SearchDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;
	String search_insert="insert into search values(?,?,sysdate,?)";
	String search_count="select count(*) from search";
	
	
	public int searchInsert(SearchVO search) {
		int result = 0;
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(search_insert);
			st.setLong(1, search.search_id);
			st.setString(2, search.search_contents);
			st.setString(3, search.c_id);
			result = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, st, rs);
		}
		return result;
	}
	
	public long searchCount() {
		long count = 0;
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(search_count);
			rs = st.executeQuery();
			if(rs.next()) {
				count = rs.getLong("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, st, rs);
		}
		return count;
	}
}
