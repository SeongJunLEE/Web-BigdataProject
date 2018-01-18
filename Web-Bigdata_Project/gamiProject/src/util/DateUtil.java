package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	public static java.sql.Date toSqlDate(String dt) {
		// String->java.util.Date->java.sql.Date
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date hire_date = null;
		try {
			java.util.Date hire = sd.parse(dt);
			hire_date = new java.sql.Date(hire.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return hire_date;
	}
}
