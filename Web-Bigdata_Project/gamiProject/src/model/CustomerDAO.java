package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class CustomerDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;
	
	
	String selectAllSql="select * from customer";
	String selectIdSql= selectAllSql + " where c_id = ? ";
	String insertSql = "insert into "+"customer(c_id, c_password, c_name, gender, birth, c_phone, join_date)"+ "values(?,?,?,?,?,?,sysdate) ";
	String deleteSql = "delete customer " + " where c_id = ? ";
	String updateSql = "update customer "+ "set c_password=?, c_phone=?"
			+ " where c_id=?";
	String customer_search ="select * from customer where c_id = ? and c_password = ?";
	
	public List<CustomerVO> selectAllSql(){
		List<CustomerVO> customerlist = new ArrayList<CustomerVO>();
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(selectAllSql);
			rs = st.executeQuery();
			while(rs.next()){
				CustomerVO customer = makeCustomer(rs);
				customerlist.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbclose(conn, st, rs);
		}
		
		return customerlist;
	}
	
	public CustomerVO selectIdSql(String c_id){
		CustomerVO customer = null;
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(selectIdSql);
			st.setString(1, c_id);
			rs = st.executeQuery();
			if(rs.next()){
				customer=makeCustomer(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbclose(conn, st, rs);
		}
		
		return customer;
	}
	
	public int insertSql(CustomerVO customer){
		int result = 0;
		conn = DBUtil.getConnect();
		try{
			st = conn.prepareStatement(insertSql);
			st.setString(1, customer.getC_id());
			st.setString(2, customer.getC_password());
			st.setString(3, customer.getC_name());
			char gender = customer.getGender();
			st.setString(4, String.valueOf(gender));
			st.setDate(5, customer.getBirth());
			st.setString(6, customer.getC_phone());
			result = st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.dbclose(conn, st, rs);
		}
		return result;
	}
	

	
	public int deleteSql(String c_id){
		int result = 0;
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(deleteSql);
			st.setString(1, c_id);
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbclose(conn, st, rs);
		}
		return result;
	}
	
	public int updateSql(CustomerVO customer){
		int result = 0;
		conn = DBUtil.getConnect();
		try{
			
			st = conn.prepareStatement(updateSql);

			st.setString(1, customer.getC_password());
			st.setString(2, customer.getC_phone());
			st.setString(3, customer.getC_id());
			result = st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.dbclose(conn, st, rs);
		}
		return result;
	}
	
	public int customerSearch(String c_id, String c_password) {
		result = 0;
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(customer_search);
			st.setString(1, c_id);
			st.setString(2, c_password);
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
	
	private CustomerVO makeCustomer(ResultSet rs) throws SQLException {
		
		String c_id= rs.getString("c_id");
		String c_password = rs.getString("c_password");
		String c_name = rs.getString("c_name");
		char gender = rs.getString("gender").charAt(0);
		Date birth= rs.getDate("birth");
		String c_phone = rs.getString("c_phone");
		Date join_date= rs.getDate("join_date");
		
		CustomerVO customer = new CustomerVO(c_id, c_password, c_name, gender, birth, c_phone, join_date);
		
		return customer;
	}
}
