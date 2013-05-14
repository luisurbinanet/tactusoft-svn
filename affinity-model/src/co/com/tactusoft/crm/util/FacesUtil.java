package co.com.tactusoft.crm.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FacesUtil {
	
	public static boolean isEmptyOrBlank(String str) {
		return str == null || str.trim().isEmpty();
	}
	
	public static String formatDate(Date date, String format) {
		String stringDate = null;
		DateFormat formatter;
		formatter = new SimpleDateFormat(format);
		stringDate = formatter.format(date);
		return stringDate;
	}

}
