/*
 * Created on 2004-11-23
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.pathology.util;

import java.text.SimpleDateFormat;
import java.util.Date;

//import com.founder.message.MsgSource;

/**
 * @author wlm
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FormatDate
{
	public static final String NORMAL_DATE_FORMAT = "yyyy/MM/dd";
	public static final String FULL_DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
	public static final String FULL_DATE_FORMAT_2 = "yyyy-M-d HH:mm"; 
	public static final String REPORT_DATE_FORMAT = "yyyy/MM/dd HH:mm";
	public static final String REPORT_DATE_FORMAT2 = "M月d日";
	public static final String FULL_DATE_FORMAT_ORACLE = "yyyy/mm/dd hh24:mi:ss";	
	public static final int MONTH_lENGTH = 12;
	public static String JP_YEAR = "年";//MsgSource.getMessage("MSG0506");
	public static String JP_MONTH = "月";//MsgSource.getMessage("MSG0507");
	public static String JP_DAY = "日";//MsgSource.getMessage("MSG0508");
	
	/**
	 * 传入完整(yyyy/MM/dd hh:mm:ss)的日期，和需要格式化为部分日期的格式
	 * @param fullDateString
	 * @param format "yyyy/MM/dd hh:mm:ss"中的部分，注意区分大小写。
	 * @return 部分日期字符串。
	 */
	public static String getPartDateString(String fullDateString, String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(FULL_DATE_FORMAT);
		Date date = null;
		try
		{
			date = sdf.parse(fullDateString);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * 传入部分日期字符串，并指定部分日期的格式。
	 * @param partDateString 部分日期字符串
	 * @param format 部分日期的格式, 为"yyyy/MM/dd HH:mm:ss"中的一部分，注意区分大小写。
	 * @return 完整的日期字符串。"yyyy/MM/dd HH:mm:ss"
	 */
	public static String getFullDateString(String partDateString, String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		String result = "";
		try
		{
			date = sdf.parse(partDateString);
			sdf = new SimpleDateFormat(FULL_DATE_FORMAT);
			result = sdf.format(date);		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	/**
	 * 得到当前日期的字符串。"yyyy/MM/dd HH:mm:ss";
	 * @return
	 */
	public static String getCurrentDateString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat(FULL_DATE_FORMAT);
		return sdf.format(new Date());
	}
	
	/**
	 * 得到当前日期的字符串。
	 * @param format 指定需要当前日期的格式。"yyyy/MM/dd HH:mm:ss"取其中部分格式组合。
	 * @return
	 */
	public static String getCurrentDateString(String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
	
	/**
	 * 取到当前年偏移传入参数offset的年份
	 * @param offset 偏移量
	 * @return String  format is "yyyy"
	 */
	public static String getYear(int offset)
	{
		int result =Integer.parseInt(getCurrentDateString("yyyy")) ;
		 result += offset;
		return "" + result;
	}
	
	/**
	 * 取到当前月偏移传入参数offset的月份
	 * @param offset 偏移量
	 * @return String  format is "MM"
	 */
	public static String getMonth(int offset)
	{
		int result =Integer.parseInt(getCurrentDateString("MM")) ;
		result += offset;
		result = result % MONTH_lENGTH ;
		while (result < 0)
		{
			result = result + MONTH_lENGTH;
		}
		
		if (result == 0)
		{
			result = MONTH_lENGTH;
		}
		if (result < 10)
		{
			return "0" + result ;
		}
		else
		{
			return "" + result;
		}
	}
	
	/**
	 * 将传入的日期（date)按要求格式化
	 * @param date
	 * @param format "yyyy/MM/dd HH:mm:ss"取其中部分格式组合。 
	 * @return
	 */
	public static String getDateString(Date date, String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * 得到"yyyy年MM月"的格式。
	 * @param year_month YYYY/MM 或者YYYY-MM
	 * @return
	 */
	public static String getYearMonthFormat(String year_month)
	{
		if (year_month == null || year_month.equals(""))
			return "";
		
		if (year_month.length() <= 6)
			return year_month;
		
		if (year_month.charAt(5) == '0')
			return year_month.substring(0, 4) + JP_YEAR + year_month.substring(6) + JP_MONTH;
		else return year_month.substring(0, 4) + JP_YEAR + year_month.substring(5) + JP_MONTH;
	}
	
	/**
	 * 得到"yyyy年MM月"的格式。
	 * @param date YYYY/MM 或者YYYY-MM
	 * @return
	 */
	public static String getJPDateString(String date)
	{
		if (date == null || date.equals(""))
			return "";
		
		if (date.length() <= 9)
			return date;
		
		return date.substring(0, 4) + JP_YEAR + date.substring(5, 7) + JP_MONTH + date.substring(8, 10) + JP_DAY;
		
	}
	/**
	 * 得到"yyyy年MM月"的格式。
	 * @param date YYYY/MM 或者YYYY-MM
	 * @return
	 */
	public static String getJPMonthDayString()
	{
		String date=getCurrentDateString();		
		return date.substring(5, 7) + JP_MONTH + date.substring(8, 10) + JP_DAY;
		
	}
}
