/*
 * Created on 2005-1-11
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.pathology.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author wlm
 * 
 * TODO To change the template for this generated type comment go to Window - Preferences - Java - Code Style - Code
 * Templates
 */
public class DealFile
{
	private static Logger	   log	              = Logger.getLogger(DealFile.class.getName());
	public static final String	CHARSET_UTF8	  = "UTF-8";
	public static final String	CHARSET_SHIFT_JIS	= "shift_jis";

	/**
	 * 载入属性文件，返回Map对象
	 * 
	 * @param fileName
	 *            文件名包含地址
	 * @return Map
	 */
	public static Map loadProperties(String fileName, String encoding)
	{
		Map result = null;
		try
		{
			result = new HashMap(1000);
			FileInputStream inStream = new FileInputStream(fileName);
			Properties prop = new Properties();
			prop.load(inStream);
			inStream.close();

			/*
			 * If the method had specialed encoding, so should convert encoding here.
			 */
			if (encoding != null)
			{
				List col = (List) prop.keySet();
				Iterator iter = col.iterator();
				while (iter.hasNext())
				{
					Object strKey = iter.next();
					String tmp = (String) prop.get(strKey);
					tmp = DealString.convertStringEnc(tmp, encoding);
					result.put(strKey, tmp);
					System.out.println(strKey.toString() + " = " + tmp);
				}
			}
			else
			{
				result = prop;
			}
		}
		catch (Exception e)
		{
			log.warning(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 检查目录是否存在，如果不存在，那么创建目录。
	 * 
	 * @param filePath
	 *            文件目录
	 * @throws IOException
	 *             文件访问异常
	 */
	public static void createFilePath(String filePath) throws IOException
	{
		if (filePath == null || filePath.trim().equals(""))
			throw new IOException("File path name is null.");

		File f = new File(filePath);

		if (!f.exists())
		{
			f.mkdirs();
		}
	}

	public static String loadString(File file) throws Exception
	{
		return loadString(file, CHARSET_UTF8);
	}

	/**
	 * 根据指定的编码将文件载入为字符串
	 * 
	 * @param file
	 * @param encoding
	 *            UTF-8,
	 * @return
	 * @throws Exception
	 */
	public static String loadString(File file, String encoding) throws Exception
	{
		InputStream is = new FileInputStream(file);
		return loadString(is, encoding);
	}

	/**
	 * 根据指定的编码将文件载入为字符串
	 * 
	 * @param is
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public static String loadString(InputStream is, String encoding) throws Exception
	{
		if(is == null)
			return null;
		
		final int BUF_SIZE = 2048;
		char[] charBuffer = new char[BUF_SIZE];
		StringBuffer buffer = new StringBuffer();

		int read = 0;
		InputStreamReader reader = null;
		try
		{
			reader = new InputStreamReader(new BufferedInputStream(is), encoding);
			while (true)
			{
				read = reader.read(charBuffer, 0, BUF_SIZE);
				if (read <= 0)
					break;
				buffer.append(charBuffer, 0, read);
			}
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (reader != null)
					reader.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		return buffer.toString();
	}

	/**
	 * 将字符串内容写入指定的文件中
	 * 
	 * @param file
	 *            文件路径及名称
	 * @param content
	 *            写入的内容
	 * @param encoding
	 *            文件编码
	 */
	public static void writeFile(File file, String content, String encoding)
	{
		OutputStreamWriter osw = null;
		try
		{
			osw = new OutputStreamWriter(new FileOutputStream(file), encoding);
			osw.write(content);
			osw.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				if (osw != null)
					osw.close();
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 将文件读取为字节数组
	 * 
	 * @param filePath
	 * @return byte[]
	 * @throws Exception
	 */
	public static byte[] readFileToBytes(String filePath) throws Exception
	{
		FileInputStream fis = new FileInputStream(filePath);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		int len = 0;
		while ((len = fis.read(data, 0, 1024)) != -1)
		{
			baos.write(data, 0, len);
		}
		return baos.toByteArray();
	}

	public static void main(String[] args)
	{
		try
		{
			String fileName = "D:\\testpath\\kkk\\kk.txt";
			createFilePath(fileName);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}

	}

}
