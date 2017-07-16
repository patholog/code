package com.pathology.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

/**
 * String通用操作工具
 */
public class StringUtil {

	/**
	 * 分隔符
	 */
	public static final String SEPARATOR = "-"; // -分隔符

	/**
	 * 判断字符串为空
	 */
	public static boolean isBlank(String str) {
		return str == null || str.length() <= 0 || "null".equals(str);
	}

	/**
	 * 判断数组是否为空
	 */
	public static boolean isBlank(Object[] os) {
		return os == null || os.length == 0;
	}

	/**
	 * 判断集合是否为空
	 */
	public static boolean isBlank(Collection<?> cs) {
		return cs == null || cs.isEmpty();
	}

	/**
	 * 判断字符串去空格后为空
	 */
	public static boolean isBlankWithTrim(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * 判断字符串不为空
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}

	/**
	 * 判断数组不为空
	 */
	public static boolean isNotBlank(Object[] os) {
		return !isBlank(os);
	}

	/**
	 * 判断集合不为空
	 */
	public static boolean isNotBlank(Collection<?> cs) {
		return !isBlank(cs);
	}

	/**
	 * 判断字符串去空格后不为空
	 */
	public static boolean isNotBlankWithTrim(String str) {
		return !isBlankWithTrim(str);
	}
	
	/**
	 * 字符串去空格
	 */
	public static String trim(String str) {
		return isBlankWithTrim(str) ? null : str.trim();
	}

	/**
	 * 首字母大写
	 */
	public static String firstUpperStr(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * 首字母小写
	 */
	public static String firstLowerStr(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	/**
	 * 根据字符数组，拼接成一个字符
	 * @param strArray
	 * @param separator
	 * @return
	 */
	public static String getStrByStrArray(String[] strArray, String separator) {
		String returnStr = "";
		for (int i = 0; strArray != null && i < strArray.length; i++) {
			if (isNotBlank(strArray[i]))
				returnStr += strArray[i];
			if (i != strArray.length - 1)
				returnStr += isBlank(separator) ? SEPARATOR : separator;
		}
		return returnStr;
	}

	/**
	 * 根据字符数组，拼接成一个字符
	 * @param strArray
	 * @param separator
	 * @return
	 */
	public static String getStrByStrArray(List<?> strArray, String separator) {
		String returnStr = "";
		Object obj = null;
		for (int i = 0; strArray != null && i < strArray.size(); i++) {
			obj = strArray.get(i);
			if (obj instanceof String && isNotBlank((String) obj))
				returnStr += (String) obj;
			else if (obj instanceof Integer && (Integer) obj != null)
				returnStr += (Integer) obj + "";
			if (i != strArray.size() - 1)
				returnStr += isBlank(separator) ? SEPARATOR : separator;
		}
		return returnStr;
	}
	
	/**
	 * String转Integer类型
	 * 
	 * @param str
	 * @return
	 */
	public static Integer stringToInteger(String str) {
		return StringUtil.isBlank(str) ? null : Integer.valueOf(str);
	}
	
	/**
	 * String转Long类型
	 * 
	 * @param str
	 * @return
	 */
	public static Long stringToLong(String str) {
		return StringUtil.isBlank(str) ? null : Long.parseLong(str);
	}
	
	/**
	 * String转Timestamp类型
	 * 
	 * @param str
	 * @return
	 */
	public static Timestamp stringToTimestamp(String str) {
		return StringUtil.isBlank(str) ? null : DateUtil.dateToTimestamp(DateUtil.strToDate(str, DateUtil.FULL_PATTERN));
	}

	/**
	 * 在字符串中(字符串以,为分隔的连续数字串)找到最大的数值
	 * 
	 * @param str
	 *            如:1,2,6,4,5
	 * @return 返回6
	 */
	public static Integer getBigNumberByString(String str) {
		if (StringUtil.isBlank(str))
			return -1;
		String[] numberStrs = getNumberStrsByString(str);
		return Integer.parseInt(numberStrs[numberStrs.length - 1]);
	}

	/**
	 * 在字符串中(字符串以,为分隔的连续数字串)找到最大的数值
	 * 
	 * @param str
	 *            如:2,1,6,4,5
	 * @return 返回1
	 */
	public static Integer getSmallNumberByString(String str) {
		if (StringUtil.isBlank(str))
			return -1;
		String[] numberStrs = getNumberStrsByString(str);
		return Integer.parseInt(numberStrs[0]);
	}

	/**
	 * 给定字符串进行冒泡排序
	 */
	private static String[] getNumberStrsByString(String str) {
		String temp = "";
		String[] numberStrs = str.split(",");
		for (int i = 0; numberStrs != null && i < numberStrs.length; i++) {
			for (int j = i + 1; j < numberStrs.length; j++) {
				if (Integer.parseInt(numberStrs[i]) > Integer.parseInt(numberStrs[j])) {
					temp = numberStrs[i];
					numberStrs[i] = numberStrs[j];
					numberStrs[j] = temp;
				}
			}
		}
		return numberStrs;
	}

	/**
	 * 将字符串有某种编码转变成另一种编码
	 * 
	 * @param string
	 *            编码的字符串
	 * @param originCharset
	 *            原始编码格式
	 * @param targetCharset
	 *            目标编码格式
	 * @return String 编码后的字符串
	 */
	public static String encodeString(String string, Charset originCharset, Charset targetCharset) {
		return string = new String(string.getBytes(originCharset), targetCharset);
	}

	/**
	 * URL编码
	 * 
	 * @param string
	 *            编码字符串
	 * @param charset
	 *            编码格式
	 * @return String
	 */
	@SuppressWarnings("deprecation")
	public static String encodeUrl(String string, String charset) {
		if (null != charset && !charset.isEmpty()) {
			try {
				return URLEncoder.encode(string, charset);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return URLEncoder.encode(string);
	}

	/**
	 * URL编码
	 * 
	 * @param string
	 *            解码字符串
	 * @param charset
	 *            解码格式
	 * @return String
	 */
	@SuppressWarnings("deprecation")
	public static String decodeUrl(String string, String charset) {
		if (null != charset && !charset.isEmpty()) {
			try {
				return URLDecoder.decode(string, charset);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return URLDecoder.decode(string);
	}

	/**
	 * 判断字符串是否是空的 方法摘自commons.lang
	 * 
	 * <pre>
	 * StringUtils.isEmpty(null)      = true
	 * StringUtils.isEmpty("")        = true
	 * StringUtils.isEmpty(" ")       = false
	 * StringUtils.isEmpty("bob")     = false
	 * StringUtils.isEmpty("  bob  ") = false
	 * </pre>
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	/**
	 * <p>
	 * 判断字符串是否是""," ",null,注意和isEmpty的区别
	 * </p>
	 * 方法摘自commons.lang
	 * 
	 * <pre>
	 * StringUtils.isBlank(null)      = true
	 * StringUtils.isBlank("")        = true
	 * StringUtils.isBlank(" ")       = true
	 * StringUtils.isBlank("bob")     = false
	 * StringUtils.isBlank("  bob  ") = false
	 * </pre>
	 */
	public static boolean isWhitespaceBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 判断字符串是否全是数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNum(String str) {
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	
	public static boolean areNotEmpty(String... values) {
		boolean result = true;
		if (values == null || values.length == 0) {
			result = false;
		} else {
			for (String value : values) {
				result &= !isEmpty(value);
			}
		}
		return result;
	}
}
