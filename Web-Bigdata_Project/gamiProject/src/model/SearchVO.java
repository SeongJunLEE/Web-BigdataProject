package model;

import java.sql.Date;

public class SearchVO {
	long search_id;
	String search_contents;
	Date search_date;
	String c_id;
	
	public SearchVO() {
		
	}

	public SearchVO(long search_id, String search_contents, Date search_date, String c_id) {
		super();
		this.search_id = search_id;
		this.search_contents = search_contents;
		this.search_date = search_date;
		this.c_id = c_id;
	}

	public long getSearch_id() {
		return search_id;
	}

	public void setSearch_id(long search_id) {
		this.search_id = search_id;
	}

	public String getSearch_contents() {
		return search_contents;
	}

	public void setSearch_contents(String search_contents) {
		this.search_contents = search_contents;
	}

	public Date getSearch_date() {
		return search_date;
	}

	public void setSearch_date(Date search_date) {
		this.search_date = search_date;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	@Override
	public String toString() {
		return "SearchVO [search_id=" + search_id + ", search_contents=" + search_contents + ", search_date="
				+ search_date + ", c_id=" + c_id + "]";
	}
}
