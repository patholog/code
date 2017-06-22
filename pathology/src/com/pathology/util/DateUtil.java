/*
 * Created on 2005-3-19
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.pathology.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author xu_dengfeng
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DateUtil
{
	/**
	 * 将给出的日期加上相应的偏移量，并返回结果日期格式化后的字符串 
	 * @param origin 要计算的原始日期字符 
	 * @param pattern 原始日期的格式化字符串，可以接受的格式与SimpleDateFormat相同
	 * @param field 要移动的字段，可以接受的值为Calendar中定义的YEAR/MONTH/DAY_OF_YEAR
	 * @param amount 要移动的偏移量，如果是正数，则移动后的日期在原始日期之后，否则在原始日期之前
	 * @return String 移动后的日期格式化后的字符串，格式与原始日期的格式一致 
	 * @throws Exception
	 */
	public static String roll(String origin, String pattern, int field,
	        int amount) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(pattern);
		Date date = sdf.parse(origin);

		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(field, amount);

		return sdf.format(gc.getTime());
	}

	/**
	 * 将给出的日期加上相应的偏移量，并返回结果日期格式化后的字符串 
	 * @param origin 要计算的原始日期字符串，格式为：yyyy/MM 
	 * @param field 要移动的字段，可以接受的值为Calendar中定义的YEAR/MONTH/DAY_OF_YEAR
	 * @param amount 要移动的偏移量，如果是正数，则移动后的日期在原始日期之后，否则在原始日期之前
	 * @return String 移动后的日期格式化后的字符串，格式与原始日期的格式一致 
	 * @throws Exception
	 */
	public static String roll(String origin, int field, int amount)
	        throws Exception
	{
		return roll(origin, "yyyy/MM", field, amount);
	}

	/**
	 * 将给出的日期加上指定的年，并返回结果日期格式化后的字符串 
	 * @param origin 要计算的原始日期字符 
	 * @param pattern 原始日期的格式化字符串，可以接受的格式与SimpleDateFormat相同
	 * @param amount 要移动的偏移量，如果是正数，则移动后的日期在原始日期之后，否则在原始日期之前 
	 * @return String 移动后的日期格式化后的字符串，格式与原始日期的格式一致 
	 * @throws Exception
	 */
	public static String rollYear(String origin, String pattern, int amount)
	        throws Exception
	{
		return roll(origin, pattern, GregorianCalendar.YEAR, amount);
	}

	/**
	 * 将给出的日期加上指定的月份，并返回结果日期格式化后的字符串 
	 * @param origin 要计算的原始日期字符串 format:yyyy/MM
	 * @param amount 要移动的偏移量，如果是正数，则移动后的日期在原始日期之后，否则在原始日期之前 
	 * @return String 移动后的日期格式化后的字符串，格式与原始日期的格式一致 
	 * @throws Exception
	 */
	public static String rollMonth(String origin, int amount) throws Exception
	{
		return roll(origin, "yyyy/MM", GregorianCalendar.MONTH, amount);
	}

	/**
	 * 将给出的日期加上指定的月份，并返回结果日期格式化后的字符串 
	 * @param origin 要计算的原始日期字符 
	 * @param pattern 原始日期的格式化字符串，可以接受的格式与SimpleDateFormat相同
	 * @param amount 要移动的偏移量，如果是正数，则移动后的日期在原始日期之后，否则在原始日期之前 
	 * @return String 移动后的日期格式化后的字符串，格式与原始日期的格式一致 
	 * @throws Exception
	 */
	public static String rollMonth(String origin, String pattern, int amount)
	        throws Exception
	{
		return roll(origin, pattern, GregorianCalendar.MONTH, amount);
	}

	/**
	 * 将给出的日期加上指定的天，并返回结果日期格式化后的字符串 
	 * @param origin 要计算的原始日期字符 format:yyyy/MM/dd
	 * @param amount 要移动的偏移量，如果是正数，则移动后的日期在原始日期之后，否则在原始日期之前
	 * @return String 移动后的日期格式化后的字符串，格式与原始日期的格式一致
	 * @throws Exception
	 */
	public static String rollDay(String origin, int amount) throws Exception
	{
		return roll(origin, "yyyy/MM/dd", GregorianCalendar.DAY_OF_MONTH,
		        amount);
	}

	/**
	 * 将给出的日期加上指定的天，并返回结果日期格式化后的字符串
	 * @param origin 要计算的原始日期字符
	 * @param pattern 原始日期的格式化字符串，可以接受的格式与SimpleDateFormat相同
	 * @param amount 要移动的偏移量，如果是正数，则移动后的日期在原始日期之后，否则在原始日期之前
	 * @return String 移动后的日期格式化后的字符串，格式与原始日期的格式一致
	 * @throws Exception
	 */
	public static String rollDay(String origin, String pattern, int amount)
	        throws Exception
	{
		return roll(origin, pattern, GregorianCalendar.DAY_OF_MONTH, amount);
	}

	/**
	 * 将给出的日期移动到指定的月份，并返回结果日期格式化后的字符串
	 * @param origin 要计算的原始日期字符
	 * @param pattern 原始日期的格式化字符串，可以接受的格式与SimpleDateFormat相同
	 * @param month 移动后的月份
	 * @return String 移动后的日期格式化后的字符串，格式与原始日期的格式一致
	 * @throws Exception
	 */
	public static String rollToMonth(String origin, String pattern, int month)
	        throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(pattern);
		Date date = sdf.parse(origin);

		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.set(GregorianCalendar.MONTH, month - 1);

		return sdf.format(gc.getTime());
	}

	/**
	 * 将给出的日期移动到指定的日，并返回结果日期格式化后的字符串
	 * @param origin 要计算的原始日期字符
	 * @param pattern 原始日期的格式化字符串，可以接受的格式与SimpleDateFormat相同
	 * @param day 移动后的日
	 * @return String 移动后的日期格式化后的字符串，格式与原始日期的格式一致
	 * @throws Exception
	 */
	public static String rollToDay(String origin, String pattern, int day)
	        throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(pattern);
		Date date = sdf.parse(origin);

		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.set(GregorianCalendar.DAY_OF_MONTH, day);

		return sdf.format(gc.getTime());
	}

	public static String getDateOfWeek(String origin, String pattern,
	        int firstday) throws Exception
	{
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(pattern);
		Date date = sdf.parse(origin);
		gc.setTime(date);

		int day = gc.get(Calendar.DAY_OF_WEEK);
		int diff = firstday - day;
		if (diff > 0)
			diff -= 7;

		gc.add(Calendar.DAY_OF_MONTH, diff);
		return sdf.format(gc.getTime());
	}

	/**
	 * 比较两个日期字符串的大小 
	 * @param date1
	 * @param date2
	 * @param dateFormat return date1 - date2
	 * @return
	 */
	public static long compareDate(String date1, String date2, String dateFormat)
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern(dateFormat);
			Date d1 = sdf.parse(date1);
			Date d2 = sdf.parse(date2);
			return (d1.getTime() - d2.getTime());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return Long.MIN_VALUE;
	}

	public static String getMinDate(String date1, String date2,
	        String dateFormat)
	{
		if (date1 == null || "".equals(date1))
			return date2;
		if (date2 == null || "".equals(date2))
			return date1;
		return compareDate(date1, date2, dateFormat) < 0 ? date1 : date2;
	}

	public static String getMaxDate(String date1, String date2,
	        String dateFormat)
	{
		if (date1 == null || "".equals(date1))
			return date2;
		if (date2 == null || "".equals(date2))
			return date1;
		return compareDate(date1, date2, dateFormat) > 0 ? date1 : date2;
	}

	/**
	 * 
	 * @param date1
	 * @param date2
	 * @param dateFormat
	 * @return
	 */
	public static int compareMonth(String date1, String date2, int interval)
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern("yyyy/MM");
			Date d1 = sdf.parse(date1);
			Date d2 = sdf.parse(date2);

			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(d1);
			gc.add(GregorianCalendar.MONTH, interval);
			long amount = gc.getTime().getTime() - d2.getTime();
			if (amount > 0)
				return 1;
			else if (amount < 0)
				return -1;
			else
				return 0;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * 
	 * @param begin YYYY/MM
	 * @param end YYYY/MM
	 * @return
	 */
	public static int countMonths(String begin, String end)
	{
		int beginYear = Integer.parseInt(begin.substring(0, 4));
		int endYear = Integer.parseInt(end.substring(0, 4));
		int beginMonth = Integer.parseInt(begin.substring(5, 7));
		int endMonth = Integer.parseInt(end.substring(5, 7));
		int months = (endYear - beginYear) * 12 + (endMonth - beginMonth) + 1;

		return months;
	}

	/**
	 * 
	 * @param date1
	 * @param date2
	 * @param days
	 * @return date1 + days < date2
	 */
	public static boolean compareDate(Date date1, Date date2, int days)
	{
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date1);
		gc.add(Calendar.DAY_OF_YEAR, days);
		//System.out.println("date1:" + gc.getTime().getTime() + ", date2:" + date2.getTime() + ", > " + (gc.getTime().getTime() > date2.getTime()));
		return gc.getTime().getTime() < date2.getTime();
	}

	/**
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static int getWeek(int year, int month, int day)
	{
		int week;
		GregorianCalendar gc = new GregorianCalendar(year, month - 1, day);
		week = gc.get(Calendar.DAY_OF_WEEK) - 1;
		return week;
	}

	/**
	 * 返回指定的日期是星期（日~六） 
	 * @param date format:yyyy/MM/dd
	 * @return
	 */
	public static int getWeek(String date)
	{
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8, 10));

		return getWeek(year, month, day);
	}
	
	/**
	 * 返回指定的日期是星期几。日~六对应：日月火水木金土
	 * @param date format:yyyy/MM/dd
	 * @return
	 */
	public static String getWeekName(String date)
	{
		String weekName = "";
		int week = getWeek(date);
		if (week == 1)
			weekName = "月";
		else if (week == 2)
			weekName = "火";
		else if (week == 3)
			weekName = "水";
		else if (week == 4)
			weekName = "木";
		else if (week == 5)
			weekName = "金";
		else if (week == 6)
			weekName = "土";
		else 
			weekName = "日";
		
		return weekName;
	}

	/**
	 * 是否是有效的年份 
	 * @param year 0 ~ 9999
	 * @return
	 */
	public static boolean isValidYear(int year)
	{
		return year >= 0 && year <= 9999;
	}

	/**
	 * 是否是有效的月份
	 * @param month 1 ~ 12
	 * @return
	 */
	public static boolean isValidMonth(int month)
	{
		return month >= 1 && month <= 12;
	}

	/**
	 * 返回指定的年份是否是润年 
	 * @param year 0 ~ 9999
	 * @return
	 */
	public static boolean isLeapYear(int year)
	{
		return isValidYear(year)
		        && (year % 100 == 0 || (year % 4 == 0 && year % 10 != 0));
	}

	/**
	 * 返回指定月份的天数 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getMonthDays(int year, int month)
	{
		int days = 30;
		switch (month)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			case 2:
				days = isLeapYear(year) ? 29 : 28;
				break;
		}

		return days;
	}

	/**
	 * 返回指定月份的天数 
	 * @param aMonth format yyyy/MM
	 * @return
	 */
	public static int getMonthDays(String aMonth)
	{
		int year = Integer.parseInt(aMonth.substring(0, 4));
		int month = Integer.parseInt(aMonth.substring(5, 7));

		return getMonthDays(year, month);
	}

	/**
	 * 
	 * @param date yyyy/MM/dd
	 * @return
	 */
	public static String getMonthFirstDay(String date) throws Exception
	{
		return date.substring(0, 7) + "/01";
	}

	/**
	 * 
	 * @param date
	 * @return yyyy/MM/dd
	 * @throws Exception
	 */
	public static String getMonthLastDay(String date) throws Exception
	{
		String month = date.substring(0, 7);
		int days = getMonthDays(month);
		return month + "/" + days;
	}
	
	/**
	 * 
	 * @param date yyyy/MM/dd
	 * @return
	 */
	public static String getNextMonthFirstDay(String date) throws Exception
	{
		String month = rollMonth(date.substring(0, 7), 1);
		return month + "/01";
	}

	/**
	 * 
	 * @param date
	 * @return yyyy/MM/dd
	 * @throws Exception
	 */
	public static String getNextMonthLastDay(String date) throws Exception
	{
		String month = rollMonth(date.substring(0, 7), 1);
		int days = getMonthDays(month);
		return month + "/" + days;
	}

	/**
	 * 
	 * 取得List中所有日期中最小的日期,仅判断到:yyyy/MM/dd
	 * @param all_date
	 * @return
	 */
	public static String getMinDateFromList(List all_date)
	{
		String dateFormat = "yyyy/MM/dd";
		String min_date = "";

		if (all_date.size() == 0)
			return null;

		min_date = (String)all_date.get(0);

		for (int i = 0; i < all_date.size(); i++)
		{
			String date = (String)all_date.get(i);

			if (!date.equals("") && date != null)
			{
				if (min_date == null || min_date.equals(""))
				{
					min_date = date;
				}
				else
				{
					if (compareDate(min_date, date, dateFormat) > 0)
					{
						min_date = date;
					}
				}
			}
		}
		return min_date;
	}
	
	/**
	 * 取得List中所有日期中最大的日期,仅判断到:yyyy/MM/dd
	 * @param all_date
	 * @return
	 */
	public static String getMaxDateFromList(List all_date)
	{
		String dateFormat = "yyyy/MM/dd";
		String max_date = "";

		if (all_date.size() == 0)
			return null;

		max_date = (String)all_date.get(0);

		for (int i = 0; i < all_date.size(); i++)
		{
			String date = (String)all_date.get(i);

			if (!date.equals("") && date != null)
			{
				if (max_date == null || max_date.equals(""))
				{
					max_date = date;
				}
				else
				{
					if (compareDate(max_date, date, dateFormat) < 0)
					{
						max_date = date;
					}
				}
			}
		}
		return max_date;
	}
}
