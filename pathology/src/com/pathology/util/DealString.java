package com.pathology.util;

/*
 * Created on 2006-08-12
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wlm
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DealString
{
	private static  byte[] special_byte0 = {(byte)0x81, (byte) 0x60};
	private static  byte[] special_byte1 = {(byte)0x81, (byte)0x61};
	private static  byte[] special_byte2 = {(byte) 0x81, (byte)0x7C};
	private static  byte[] special_byte3 = {(byte) 0x81, (byte) 0x91};
	private static  byte[] special_byte4 = {(byte) 0x81, (byte) 0x92};
	private static  byte[] special_byte5 = {(byte) 0x81, (byte) 0xCA};

	private static Object[] special_byte = {special_byte0, special_byte1, special_byte2, special_byte3, special_byte4, special_byte5};
	private static String[] special_str = new String[6];
	
	public final static String ENCODING_MS932 = "MS932";
	public final static String ENCODING_SJIS  = "SHIFT_JIS";
	public final static byte HALF_BLANK = 0x20;
	
	static
	{
		try
		{
			special_str[0] = new String(special_byte0, ENCODING_SJIS);
			special_str[1] = new String(special_byte1, ENCODING_SJIS);
			special_str[2] = new String(special_byte2, ENCODING_SJIS);
			special_str[3] = new String(special_byte3, ENCODING_SJIS);
			special_str[4] = new String(special_byte4, ENCODING_SJIS);
			special_str[5] = new String(special_byte5, ENCODING_SJIS);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] arg)
	{
		System.out.println(DealString.IntToMoneyString(123456));
	}
	
	/**
	 * 去掉字符串的首尾全角半角空格 
	 * @param text
	 * @return
	 */
	public static String trimBoth(String text)
	{
		if(text == null)
			return null;
		
		return text.replaceAll("(^[　| ]*|[　| ]*$)", "");
	}

	/**
	 * 传入字符串的第一个字母大写
	 * @param str
	 * @return String
	 */
	public static String upperFirstLetter(String str)
	{
		if (str == null) return str;
		return str.substring(0,1).toUpperCase() + str.substring(1, str.length()); 
	}
	
	/**
	 * 
	 * @param str xxx,xxx,xxx
	 * @return Collection - String
	 */
	public static List simpleStringToList(String str)
	{
		List list = new ArrayList();
		StringTokenizer st = new StringTokenizer(str, ",");
		while (st.hasMoreTokens())
		{
			list.add( st.nextToken());
		}
		return list;
	}
	/**
	 * @param str "xx|xx,xx|xx" or "x,x" or ...
	 * @return Collection - Collection - String
	 */
	public static List stringToList(String str)
	{
		List result = new ArrayList();
		List colRecord = null;
		StringTokenizer stFirst = new StringTokenizer(str, ",");
		StringTokenizer stSecond = null;
		String record = null;
		String column = null;
		while (stFirst.hasMoreTokens())
		{
			colRecord = new ArrayList();
			record = stFirst.nextToken();
			stSecond = new StringTokenizer(record, "|");
			while (stSecond.hasMoreTokens())
			{
				column = stSecond.nextToken();
				colRecord.add(column);
			}
			result.add(colRecord);
		}
		
		Iterator it = result.iterator();
		while (it.hasNext())
		{
			colRecord = (List)it.next();
			Iterator iter = colRecord.iterator();
			while (iter.hasNext())
				System.out.print(iter.next().toString()+" ");
			System.out.println();
		}
		return result;
	}
	/**
	 * 
	 * @param str xxx,xxx,xxx
	 * @return String[]
	 */
	public static String[] stringToArray(String str)
	{
		if (str == null || str.equals("")) return null;
		return stringToArray(str, ",");
	}
	
	/**
	 * 
	 * @param str xxx,xxx,xxx
	 * @return String[]
	 */
//	public static String[] stringToArray(String str, String token)
//	{
//		if (str == null || str.equals("")) return null;
//		
//		List list = new ArrayList();
//		StringTokenizer st = new StringTokenizer(str, token);
//		while (st.hasMoreTokens())
//		{
//			list.add( st.nextToken());
//		}
//				
//		return (String[])list.toArray(new String[list.size()]);
//	}
	public static String[] stringToArray(String str, String token)
	{
		if (str == null || str.equals("")) return null;
		
		List list = new ArrayList();
		int len = token.length();
		int p0 = 0;
		int p = str.indexOf(token);
		while (p >= 0)
		{
			list.add(str.substring(p0, p));
			p0 = p + len;
			p = str.indexOf(token, p0);
			//System.out.println("p0=" + p0 + ", p=" + p);
		}
		list.add(str.substring(p0));
		
		//System.out.println("array:" + list.toString());		
		return (String[])list.toArray(new String[list.size()]);
	}
	
	/**
	 * 以指定字符将字符串左填充为固定长度的字符串
	 * @param src 需要填充的字符串
	 * @param len 填充完之后的字符长度
	 * @param fillChar 填充的字符
	 * @return 填充之后生成的字符串
	 */
	public static String leftFill(String src, int len, char fillChar)
	{
		if(src == null || len < src.length())
			return src;
		
		String result = src;
		for(int i = src.length(); i < len; i++)
		{
			result = String.valueOf(fillChar) + result;
		}
		
		return result;
	}
	
	/**
	 * 以指定字符将字符串右填充为固定长度的字符串
	 * @param src 需要填充的字符串
	 * @param len 填充完之后的字符长度
	 * @param fillChar 填充的字符
	 * @return 填充之后生成的字符串
	 */
	public static String rightFill(String src, int len, char fillChar)
	{
		if(src == null || len < src.length())
			return src;
		
		String result = src;
		for(int i = src.length(); i < len; i++)
		{
			result += String.valueOf(fillChar);
		}
		
		return result;
	}	
	
	/**
	 * 用新的字符串替换源字符串中的旧字符串
	 * @param source
	 * @param oldString
	 * @param newString
	 * @return String 替换后的字符串
	 */
	public static String replace(String source, String oldString, String newString)
	{
		return replaceAll(source, oldString, newString);
	}

	/**
	 * 以指定字符集的方式截取指定长度的字符串。如果我们要截取长度为20的子字符串，如果源字符串为
	 * 双字节汉字，那么只会截取10个汉字， 如果源字符串为单字节字符，那么会截取20个字符。
	 * @param src 源字符串
	 * @param index 开始位置
	 * @param len 长度
	 * @param charset 字符集 （如果是日文，请指定为"MS932"）
	 * @return 截取的字符串
	 */
	public static String subString(String src, int index, int len, String charset)
	{
		if(src == null)
		{
			return src;
		}
		
		String result = "";
		try
		{
			int subTotal = 0;

			for(int i = 0; i <src.length(); i++)
			{
				String subStr = src.substring(index, index + 1);
				subTotal += subStr.getBytes(charset).length;
				result += subStr;
				
				if(subTotal >= len)
				{
					if(index < src.length())
					{
						result += "...";
					}
					break;
				}
				
				index++;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return result;
	}
	
	/**
	 * @param source
	 * @param from
	 * @param to
	 * @return
	 */
	public static String replaceAll(String source, String from, String to)
	{		
		if (source == null || source.equals("")) return source;
		String remain = source;
		String result = "";
		while (remain.indexOf(from) != -1)
		{
			
			result += remain.substring(0, remain.indexOf(from)) + to;
			remain = remain.substring( remain.indexOf(from) + from.length(), remain.length());
		}
		if (remain != null && !remain.equals(""))
			result += remain;
		return result;
	}
	
	public static String convertStringEnc(String strSource, String strEncoding) 
		throws UnsupportedEncodingException
	{
		String	strResult = new String(strSource.getBytes("ISO-8859-1"), strEncoding);
		return strResult;
	}		
	/**
	 * 
	 * @param src
	 * @param ch
	 * @return
	 */
	public static int firstIndexOf(String src, char ch)
	{
		int result = -1;
		if (src == null)
		{
			return result;
		}
		
		return src.indexOf(ch);
	}
	/**
	 *  
	 * @param src
	 * @param ch
	 * @return
	 */
	public static int lastIndexOf(String src, char ch)
	{
		int result = -1;
		if (src == null)
		{
			return result;
		}
		
		for (int i = src.length() - 1; i >= 0; i--)
		{
			if (src.charAt(i) == ch)
			{
				return i;
			}
		}
		return result;
	}
	/**
	 * 
	 * @param arr
	 * @return
	 */
	public static String arrayToString(String[] arr)
	{
		String result = "";
		if (arr == null)
		{
			return result;
		}
		
		for (int i = 0; i < arr.length; i++)
		{
			if (i == 0)
			{
				result = arr[i];
			} else {
				result += "," + arr[i];
			}
		}
		
		return result;
	}
	/**
	 * 
	 * @param code
	 * @return
	 */
	public static String formatPostalCode(String code)
	{
		String result = code;
		if (code == null)
		{
			result = "";
		}
		
		if (result.length() >= 7)
		{
			int p = result.indexOf("-");
			if (p < 0)
			{
				result = result.substring(0, 3) + "-" + result.substring(3, 7);
			}
		}
		
		return result;
	}
	
	/**
	 * 删除字符串数组中的重复字符中，可能会改变数组的长度，元素的顺序不变 
	 * @param oldArray
	 * @return
	 */
	public static String[] getDistinctArray(String[] oldArray)
	{
		int cnt = 0;
		for (int i = 0; i < oldArray.length; i++)
		{
			if (oldArray[i] == null)
			{
				continue;
			}
			if (oldArray[i].equals(""))
			{
				oldArray[i] = null;
				continue;
			}
			cnt++;
			for (int j = i + 1; j< oldArray.length; j++)
			{
				if (oldArray[j] == null)
				{
					continue;
				}
				if (oldArray[j].equals(""))
				{
					oldArray[j] = null;
					continue;
				}
				if (oldArray[i].equals(oldArray[j]))
				{
					oldArray[j] = null;
				}
			}
		}
		
		String[] newArray = new String[cnt];
		if (cnt > 0)
		{
			int index = 0;
			for (int i = 0; i < oldArray.length; i++)
			{
				if (oldArray[i] != null)
				{
					newArray[index++] = oldArray[i];
					//System.out.println("i=" + oldArray[i]);
				}
			}
		}
		return newArray;
	}
	/**
	 * 将字符串数组的元素替换为Map中的值 
	 * @param oldArray
	 * @param map
	 * @return
	 */
	public static String[] replaceArray(String[] oldArray, Map map)
	{
		String[] result = new String[oldArray.length];
		for (int i = 0; i < result.length; i++)
		{
			String key = oldArray[i];
			String value = (String) map.get(key);
			result[i] = value == null ? key : value;
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public static String simpleListToString(List list)
	{
		String result = "";
		if (list != null)
		{
			for (int i = 0; i < list.size(); i++)
			{
				if (i == 0)
				{
					result = (String) list.get(i);
				} else {
					result += "," + (String) list.get(i);
				}
			}
		}
		
		return result;
	}

	
	/**
	 * 将字符串中的 "：column" 提取出来去掉"："变为小写，放入List中
	 * 将字符串中的 "#column" 提取出来去掉"#"变为小写，放入List中
	 * @param sql
	 * @return List
	 */
	public static List parseToList(String sql)
	{
		List names = new ArrayList();
		Pattern p = Pattern.compile("[:]+[\\w]+");
		Matcher m = p.matcher(sql);
		while(m.find())
		{
			String key = m.group().substring(1, m.group().length());
			names.add(key.toLowerCase());
		}
		p = Pattern.compile("[#]+[\\w]+");
		m = p.matcher(sql);
		while(m.find())
		{
			String key = m.group().substring(1, m.group().length());
			names.add(key.toLowerCase());
		}
		return names;
	}
	
	/**
	 * Add by  Guo Jie 2006-10-12
	 * 将新字符串添加到旧字符串后面(中间以" 、"分隔),如果旧字符串为空,则返回新字符串
	 * @param oldStr 旧字符串
	 * @param newStr 新字符串
	 * @return 
	 */
	public static String addString(String oldStr, String newStr)
	{
		StringBuffer result = null;
		if (oldStr == null || oldStr.equals(""))
		{
			result = new StringBuffer(newStr);
		}else
		{
			result = new StringBuffer(oldStr);
			result.append("、");
			result.append(newStr);
		}
		return result.toString();
	}
	
	
	/**
	 * Add by  Guo Jie 2006-10-13
	 * 判断字符串是否包含在List中。只要List中有一个与要比较的字符串相同就返回true,否则返回false。
	 * @param allStr 
	 * @param findStr
	 * @return
	 */
	public static boolean strIsHaveInList(List allStr, String findStr)
	{
		boolean isContain = false;
		if (allStr == null)
		{
			return isContain;
		}
		for (int i = 0; i < allStr.size(); i++)
		{
			String tmpStr = allStr.get(i).toString();
			if (tmpStr.equals(findStr))
			{
				isContain = true;
				break;
			}
		}
		return isContain;
	}
	
	/**
	 * Add By  Guo Jie 2006-10-17
	 * 判断字符串是否包含另一个字符串
	 * @param source 源字符串
	 * @param target  要查找的字符串
	 * @return
	 */
	public static boolean contains(String source, String target)
	{
		return source.indexOf(target) > -1;
	}
	
	/**
	 * 将","分割的钱字符串，转换为int型
	 * @param moneyString
	 * @return
	 */
	public static int moneyStringToInt(String moneyString)
	{
		if (moneyString == null || moneyString.trim() == "") return 0;
		String money = moneyString.replaceAll(",", "");
		return Integer.parseInt(money);
	}
	
	public static String IntToMoneyString(int money)
	{
		String result = "";
		String sign = money < 0 ? "-" : "";
		String strMoney = Math.abs(money) + "";
		int pos = strMoney.length();
		while(pos > 0)
		{			
			int begin = pos - 3 > 0 ? pos - 3 : 0;
			if (result != "")
				result = strMoney.substring(begin, pos) + "," + result;
			else
				result = strMoney.substring(begin, pos) + result;
			pos -= 3; 
		}
		return sign + result;
	}
	
	public static byte[] truncateMS932Bytes(String value, int width, int type) throws Exception
    {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		ByteArrayOutputStream temp_baos = new ByteArrayOutputStream();
		
		if(value == null) value = "";
		int str_len = value.length();
		int baos_len = 0;
		int temp_len = 0;
		String temp_str = "";
		boolean flag = false;
		// 对每一个字符进行检查
		for (int i =0; i< str_len; i++)
		{
			if (temp_baos.size() >= width)
				break;
			
			// flag: 标示是否是特殊字符
			flag = false;
			temp_str = value.substring(i, i+1);
			
			for (int j =0; j<special_str.length; j++)
			{
				if (temp_str.equals(special_str[j]) && (!flag))
				{
					// 超长跳出
					if (temp_baos.size() >= width)
						break;
					
					// 写byte
					temp_baos.write((byte[])special_byte[j]);
					flag = true;
					break;
				}
			}
			// 不是特殊字符
			if (!flag)
			{
				// 超长跳出
				if (temp_baos.size() >= width)
					break;
				// 
				baos_len = temp_baos.size();
				byte[] b = temp_str.getBytes(ENCODING_MS932);
				if ((width-baos_len) > b.length )
					temp_len = b.length;
				else
					temp_len = width - baos_len;
				temp_baos.write(b, 0, temp_len);
			}
		}
		
		if (temp_baos.size() < width)
		{
			// 需要加空格
			if (type == 0)
			{
				// 前面补充空格
				result.write(getBlank(width - temp_baos.size()));
				result.write(temp_baos.toByteArray());
			}
			else
			{
				// 后面补充空格
				result.write(temp_baos.toByteArray());
				result.write(getBlank(width - temp_baos.size()));
			}
		}
		else result.write(temp_baos.toByteArray());
		
		return result.toByteArray();
    }
	
	/**
	 * 得到指定数量的空格
	 * @param number
	 * @return StringBuffer
	 */
	private static byte[] getBlank(int number)
	{
		byte[] result = new byte[number];
		for (int i = 0 ; i< number; i++)
		{
			result[i] = HALF_BLANK;
		}
		return result;
	}
}