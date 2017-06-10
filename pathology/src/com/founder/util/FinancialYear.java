package com.founder.util;

import java.util.Calendar;

public class FinancialYear {

	/**judge the date is in or after current financilal year
	 * 
	 * @param date. e.g. "2006/01" or "2006/1"
	 * return true, if the date is in or after current financilal year; 
	 * else, return false. 
	 */
	public static boolean valicateDay(String date)
	{
		boolean result = true;
		
//		get financial year
		Calendar current = Calendar.getInstance();
		int year = current.get(Calendar.YEAR);
		int month = current.get(Calendar.MONTH);
		if (month <= 3)
		{
			year--;
		}
		
		String[] strs = date.split("/");
		if ( Integer.parseInt(strs[0]) < year )
		{
			result = false;
		}else if (Integer.parseInt(strs[0]) == year) 
		{
			if ( Integer.parseInt(strs[1]) < 4 )
			{
				return false;
			}
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FinancialYear.valicateDay("2006/4"));
	}

}
