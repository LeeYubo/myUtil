package com.lyb.date;

import java.awt.SystemColor;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DateUtils {
	
	public static void timeAll(){
		/*
		yyyy：年
		MM：月
		dd：日 
		hh：1~12小时制(1-12)
		HH：24小时制(0-23)
		mm：分
		ss：秒 
		S：毫秒 
		E：星期几
		D：一年中的第几天
		F：一月中的第几个星期(会把这个月总共过的天数除以7)
		w：一年中的第几个星期
		W：一月中的第几星期(会根据实际情况来算)
		a：上下午标识
		k：和HH差不多，表示一天24小时制(1-24)。
		K：和hh差不多，表示一天12小时制(0-11)。
		z：表示时区
		*/
		
		//日期中的小时，HH表示24小时制，hh表示12小时制
		//月份“MM”必须大写，分钟“mm”必须小写
		//“yyyy-MM-dd HH:mm:ss”格式中的双字母，当为一位时，会自动在前面补“0”，
		//“yyyy”得出2016，yy得出16，其它类似，如月“MM”得出06，“M”得出6，
		
		String type1 = "z yyyy-MM-dd a HH:mm:ss.S";
		String type2 = "yyyy/MM/dd hh:mm:ss";
		String type3 = "yyyy/MM/dd";
		String type4 = "yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒";
		String type5 = "E";
		System.out.println(new SimpleDateFormat(type1).format(new Date()));
		System.out.println(new SimpleDateFormat(type2).format(new Date()));
		System.out.println(new SimpleDateFormat(type3).format(new Date()));
		System.out.println(new SimpleDateFormat(type4).format(new Date()));
		System.out.println(new SimpleDateFormat(type5).format(new Date()));
	}
	
	/**
	 * 方法名称：获取当前日期
	 * 方法说明：格式：yyyy-MM-dd
	 * 		     例子：2016-06-27
	 * @return
	 * @autho Yubo Lee
	 * @time 2016年6月27日 下午3:20:45
	 */
	public static String getCurrentDateString(){
		String result = "";
		DateFormat format =new SimpleDateFormat("yyyy-MM-dd");
		result = format.format(new Date());
		return result;
	}
	
	/**
	 * 方法名称：获取当前时间
	 * 方法说明：格式：yyyy-MM-dd HH:mm:ss
	 * 		     例子：2016-06-27 15:20:38
	 * @return
	 * @autho Yubo Lee
	 * @time 2016年6月27日 下午3:20:45
	 */
	public static String getCurrentTimeString(){
		String result = "";
		DateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = format.format(new Date());
		return result;
	}
	
	/**
	 * 方法名称：获取当前时间，带毫秒
	 * 方法说明：格式：yyyy-MM-dd HH:mm:ss.SSS
	 * 		     例子：2016-06-27 15:22:54.388
	 * @return
	 * @autho Yubo Lee
	 * @time 2016年6月27日 下午3:20:45
	 */
	public static String getCurrentTimeStringWithMill(){
		String result = "";
		DateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		result = format.format(new Date());
		return result;
	}
	
	/**
	 * <p>方法名称：比较时间是否在当前时间内</p>
	 * <p>方法说明：</p>
	 * @param date
	 * @return
	 * @autho Yubo Lee
	 * @time 2016年6月27日 下午4:01:31
	 */
	public static boolean checkTimeBetween(Date date){
		boolean result = false;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(dateFormat.format(new Date()));
		System.out.println(dateFormat.format(date));
		if(dateFormat.format(new Date()).equals(dateFormat.format(date))){
			result = true;
		}
		return result;
	}
	
	/**
	 * <p>方法名称：比较两个日期的大小</p>
	 * <p>方法说明：</p>
	 * @return -1：time1 小于 time2
	 * 			0：time1 等于 time2
	 * 			1：time1 大于 time2
	 * @autho Yubo Lee
	 * @time 2016年6月27日 下午4:35:28
	 */
	public static Integer compareDate(String time1, String time2){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			if(dateFormat.parse(time1).getTime() < dateFormat.parse(time2).getTime()){
				System.out.println("时间1小于时间2");
				return -1;
			}
			if(dateFormat.parse(time1).getTime() == dateFormat.parse(time2).getTime()){
				System.out.println("时间1等于时间2");
				return 0;
			}
			if(dateFormat.parse(time1).getTime() > dateFormat.parse(time2).getTime()){
				System.out.println("时间1大于时间2");
				return 1;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * <p>方法名称：获取时间差</p>
	 * <p>方法说明：获取两个时间的时间差，结果为毫秒</p>
	 * @param startTime
	 * @param stopTime
	 * @return
	 * @autho Yubo Lee
	 * @time 2016年6月27日 下午4:48:16
	 */
	public static long GetTimeDiff(String startTime, String stopTime){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long startTimeStamp = 0;
		long stopTimeStamp = 0;
		try {
			startTimeStamp = dateFormat.parse(startTime).getTime();
			stopTimeStamp = dateFormat.parse(stopTime).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (stopTimeStamp - startTimeStamp);
	}
	
	
	public static String changeTime(Long time){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date date = new Date(time);
		return simpleDateFormat.format(date);
	}
	
	
	public static void main1(String[] args) {
		System.out.println("获取当前日期："+DateUtils.getCurrentDateString());
		System.out.println("获取当前时间："+DateUtils.getCurrentTimeString());
		System.out.println("获取当前时间（带毫秒）："+DateUtils.getCurrentTimeStringWithMill());
		
		//比较时间是否在当前时间内		
		String date = "2016-06-27 08:08:07";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			System.out.println("时间是否在当前时间内："+DateUtils.checkTimeBetween(dateFormat.parse(date)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//系统时间戳也可以直接format为自己想要的格式
		System.out.println(dateFormat.format(System.currentTimeMillis()));
		
		//比较日期大小		
		System.out.println(DateUtils.compareDate("2015-08-06 13:37:01", "2015-08-06 13:37:00"));
		
		//获取时间差
		System.out.println(DateUtils.GetTimeDiff("2015-08-06 13:37:01", "2015-08-06 13:37:02"));
	}
	
	
	public static void main(String[] args) {
		Long startTime = 1500601174518L;
		Long endtime = 1500601174526L;
		System.out.println(changeTime(startTime));
		System.out.println(changeTime(endtime));
	}
}
