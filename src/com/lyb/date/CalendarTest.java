package com.lyb.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class CalendarTest {

	public static void main(String[] args) {
		String date = "2016-06-27 08:08:07";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		System.out.println("calendar class = "+calendar.getClass());
		try {
			calendar.setTime(dateFormat.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		calendar.set(Calendar.SECOND, 0);
		System.out.println(dateFormat.format(calendar.getTime()));
		System.out.println("日期工具转换："+DateFormatUtils.format(new Date(), "yyyy-MM-dd E a HH:mm:ss"));
		System.out.println(org.apache.commons.lang3.time.DateUtils.MILLIS_PER_HOUR);
		System.out.println(DateFormatUtils.ISO_DATE_FORMAT.format(new Date()));
		System.out.println(DateFormatUtils.ISO_DATETIME_FORMAT.format(new Date()));
	}
}
