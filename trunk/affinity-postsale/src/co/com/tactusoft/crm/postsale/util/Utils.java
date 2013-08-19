package co.com.tactusoft.crm.postsale.util;

import java.text.DateFormat;
import java.text.ParseException;
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

	public static int getCurrentDay(Date currentDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		int currentDay = calendar.get(Calendar.DAY_OF_WEEK);
		return currentDay;
	}

	public static int getCurrentHour(Date currentDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
		return currentHour;
	}
	
	public static String lpad(String valueToPad, char filler, int size) {
		char[] array = new char[size];

		int len = size - valueToPad.length();

		for (int i = 0; i < len; i++)
			array[i] = filler;

		valueToPad.getChars(0, valueToPad.length(), array,
				size - valueToPad.length());

		return String.valueOf(array);
	}
	
	public static Date getDateWithoutTime(Date date) {
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();
		try {
			now = df1.parse(df1.format(date));
		} catch (ParseException e) {
			now = null;
		}
		return now;
	}
	
	public static Date stringTOSDate(String strDate, String format) {
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = formatoDelTexto.parse(strDate);
		} catch (ParseException ex) {
			date = null;
		}
		return date;
	}

}
