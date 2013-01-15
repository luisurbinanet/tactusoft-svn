package co.com.tactusoft.crm.postsale.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
	
	public static String formatDate(Date date, String format) {
		String stringDate = null;
		DateFormat formatter;
		formatter = new SimpleDateFormat(format);
		stringDate = formatter.format(date);
		return stringDate;
	}
	
	public static Date addDaysToDate(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}
	
	
	public static int getCurrentDay(Date currentDate){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		int currentDay = calendar.get(Calendar.DAY_OF_WEEK);
		return currentDay;
	}

}
