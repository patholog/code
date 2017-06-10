package com.founder.util;

import java.math.BigDecimal;

/**
 * @author yxm
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DealNumber
{
	public static void main(String[] args)
	{
//		System.out.println(DealNumber.getLongValueDot("123,456,789,000.51111"));
//		String val = "103384628992";
//		long iVal = DealNumber.getLongValue(val);
		//System.out.println("ok, val=" + formatNumber1Bit("86.5"));
		System.out.println(getBigDecimal("123.45678"));
		System.out.println(decimal_div("105.5","10"));
	}
	/**
	 *  判断是不是偶数
	 * @param n 要判断的数字
	 * @return true 表示是偶数， false 表示奇数
	 */
	public static boolean isEven(int n)
	{
		boolean bEven = false;
		
		int nEven = n%2;
		if(nEven == 0)
		{
			bEven = true;
		}
		else
		{
			bEven = false;
		}
		
		return bEven;
	}
	 
	/**
	 * Format from "123,322,344" to "123322344"
	 * @param money
	 * @return
	 */
	public static String formatMoneyToDB(String money)
	{
		if (money == null || money.equals("") || "0".equals(money)) return money;
		String remain = money;
		String result = "";
		while (remain.indexOf(",")!= -1)
		{
			int index = remain.indexOf(",");
			result += remain.substring(0, index);
			remain = remain.substring(index + 1, remain.length());
		}
		if (remain != null || !remain.equals(""))
		{
			result += remain;
		}
		return result;
	}
	/**
	 * Format from "123322344" to "123,322,344"
	 * @param money
	 * @return
	 */
	public static String formatMoneyToClient(String money)
	{
		String result = "";
		if (money == null || money.equals("") || "0".equals(money)) return money;
		
		int count = (int) Math.ceil(money.length()/3.0);
		if (count == 1) return money;
		
		boolean isNegative = false;
//		if(Integer.parseInt(money) < 0)
		if(Long.parseLong(money) < 0)
		{
			isNegative = true;
			money = money.substring(1, money.length());
		}
		count = (int) Math.ceil(money.length()/3.0);
		
		int j = 1;
		for (int i=1; i<count;i++,j++)
		{
			result = "," + money.substring(money.length()-3*i, money.length()-3*(i-1)) + result;
		}
		result = money.substring(0, money.length()-3*(j-1)) + result;
		
		if (isNegative)
		{
			result = "-" + result;
		}
		
		return result;
	}
	/**
	 * 返回字符串对应的整数值，如果为空，返回0。
	 * @param num
	 * @return
	 * @throws NumberFormatException
	 */
	public static int getIntValue(String num) throws NumberFormatException
	{		
		if (num == null) return 0;
		int result = 0;
		num = num.trim();
		if (!num.equals(""))
		{
			if (num.indexOf(".") >= 0)
			{
				float f = Float.parseFloat(num);
				result = Math.round(f);
			} else if (num.indexOf(",") >= 0)
			{
				result = Integer.parseInt(formatMoneyToDB(num));
			} else 
			{
				result = Integer.parseInt(num);
			}
		}
		
		return result;
	}
	
	public static long getLongValue(String num) throws NumberFormatException
	{
		if (num == null) return 0;
		long result = 0;
		num = num.trim();
		if (!num.equals(""))
		{
			try
			{
				result = Long.parseLong(num);
			} catch (NumberFormatException e)
			{
				num = formatMoneyToDB(num);
				result = Long.parseLong(num);
			}
		}
		
		return result;
	}
	
	public static long getLongValueDot(String num) throws NumberFormatException
	{
		if (num == null) return 0;
		long result = 0;
		long correct = 0;
		num = num.trim();
		if (!num.equals(""))
		{
			String i_num = null;
			String f_num = null;
			if (num.indexOf(".") >= 0 )
			{
				i_num = num.substring(0, num.lastIndexOf("."));
				f_num = num.substring(num.lastIndexOf(".") + 1, num.length() );
				if ( f_num.length() > 0 )
				{
					correct = Math.round(Double.parseDouble("0." + f_num));
				}
				result = getLongValue(i_num) + correct;
			}
			else
			{
				result = getLongValue(num);
			}
			
		}
		return result;
	}
	
	public static float getFloatValue(String num) throws NumberFormatException
	{
		if (num == null) return 0;
		float result = 0;
		num = num.trim();
		if (!num.equals(""))
		{
			result = Float.parseFloat(num);
		}
		
		return result;
	}
	
	public static float getSpaceDs(String num) throws Exception
	{
		float ff = getFloatValue(num);
		float ds = Math.round(ff) / 1000.0f;
		return ds;
	}
	
	/**
	 * 将数字字符串格式化为指定位数的小数 
	 * @param num 数字字符串
	 * @param dotBits 小数位数 1，2，3...
	 * @return
	 * @throws NumberFormatException
	 */
	public static String formatFloat(String num, int dotBits) throws NumberFormatException
	{
		if (num == null || num.equals(""))	return "0";
		float f = Float.parseFloat(num);
		String flag = f >= 0 ? "" : "-";
		int n = 1;
		for (int i = 0; i < dotBits; i++)
		{
			n *= 10;
		}
		f = f * n;
		
		int temp = Math.abs(Math.round(f));
		int n1 = temp / n;
		int n2 = temp % n;
		
		String s2 = "" + n2;
		while (s2.length() < dotBits)
		{
			s2 = "0" + s2;
		}
		
		return flag + n1 + "." + s2;		
	}
	/**
	 * 返回一个指定小数位数的百分数
	 * @param number
	 * @param nDecimal
	 * @return
	 * @throws NumberFormatException
	 */
	public static String getPercentNumber(String number, int nDecimal) throws NumberFormatException
	{
		String result = "";
		if (number == null || number.equals("") 
			|| "0".equals(number) || "0.0".equals(number)) 
		{
			return result;
		}
		if (nDecimal < 0 || nDecimal > 8)
		{
			return result;
		}
		double num = Double.parseDouble(number);
		for (int i = 0; i < nDecimal + 2; i++)
		{
			num = num * 10;
		}
		String str = "" + (int) num;
		int len = str.length();
		if (nDecimal == 0)
		{
			result = str + "%";
		} else if (nDecimal < len)
		{
			result = str.substring(0, len - nDecimal) + "." + str.substring(len - nDecimal, len) + "%";
		}
		return result;
	}
	
	private static boolean hasValue(String str)
	{
		return str != null && !"".equals(str);
	}
	
	public static String formatNumber1Bit(float num)
	{
		String result = "";
		String flag = num >= 0 ? "" : "-";
		int temp = Math.abs((int) (num * 10));
		int a = temp / 10;
		int b = temp % 10;
		//System.out.println("num=" + num + ", temp=" + temp + ", a=" + a + ", b=" + b);
		result = flag + a + "." + b;
		return result;
	}
	
	public static String formatNumber1Bit(String value)
	{
		String result = "";
		if (hasValue(value))
		{
			float num = Float.parseFloat(value);
			result = formatNumber1Bit(num);
		}
		return result;
	}
	
	/**
	 * ５９，６４两张预算帐票上传前数据准备专用。
	 * 将给定的数字金额字符串，转换成数字后乘以1000后round，返回转换后的字符串
	 * @param money_str
	 * @return 字符串，值等于数字后乘以1000。
	 */
	public static String getBigDecimal(String money_str) 
	{
		if (money_str == null || "".equals(money_str))
			return "";
		else if ("0".equals(money_str))
			return "0";
		
		BigDecimal number = new BigDecimal(money_str);
		return ""+Math.round(number.movePointRight(3).doubleValue());
		//return number.movePointRight(3).toString();
	}
	/**
	 * ５９，６４两张预算帐票上传前数据准备专用。
	 * 将给定的数字金额字符串，转换成数字后round,乘以1000，返回转换后的字符串
	 * @param money_str
	 * @return 字符串，值等于数字后乘以1000。
	 */
	public static String getBigDecimalRound1000(String money_str) 
	{
		if (money_str == null || "".equals(money_str))
			return "";
		else if ("0".equals(money_str))
			return "0";
		
		BigDecimal number = new BigDecimal(money_str);
		return ""+Math.round(number.doubleValue())*1000;
		//return number.movePointRight(3).toString();
	}
	
	/**
	 * ５９，６４两张预算帐票上传前数据准备专用。
	 * 获得分子除以分母的值。格式为不包含小数点，小数点以下四舍五入。
	 * @param divisor 分子
	 * @param dividend 分母
	 * @return 字符串，值 = 分子/分母。
	 */
	public static String decimal_div(String divisor, String dividend)
	{
		if (divisor == null || "".equals(divisor) || dividend == null || "".equals(dividend) || "0".equals(dividend))
			return "";
		else if ("0".equals(divisor))
			return "0";
		
		BigDecimal A = new BigDecimal(divisor);
		return A.divide(new BigDecimal(dividend),0, BigDecimal.ROUND_HALF_UP).toString();
	}
}
