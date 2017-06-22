package com.pathology.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class UploadExcelInfo
{
	private HSSFWorkbook excel;
	private List sheets;

	/**
	 * 得到的结果集为:第一层:sheet的list;第二层:row的list;第三层:cell的list.
	 * 全部依靠位置来取得.全部的index从0开始.
	 * @param is
	 * @return
	 * @throws Exception
	 */
	public List getExcelInfo(InputStream is) throws Exception
	{
		// 将指定输入流转换为HSSFWorkbook对象.
		POIFSFileSystem pfs = new POIFSFileSystem(is);
		excel = new HSSFWorkbook(pfs);
		is.close();
		is = null;
		
		sheets = new ArrayList();
		for (int i = 0; i< excel.getNumberOfSheets(); i++)
		{
			
			List rows = getSheetInfo(excel.getSheetAt(i));
			sheets.add(i, rows);
		}
		
		return sheets;
	}
	
	/**
	 * 得到的结果集为:第一层:sheet的list;第二层:row的list;第三层:cell的list.
	 * 全部依靠位置来取得.全部的index从0开始.
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public List getExcelInfo(String fileName) throws Exception
	{
		// 将指定文件转换为HSSFWorkbook对象.
		InputStream is = new FileInputStream(new File(fileName));			
		return getExcelInfo(is);
	}
	
	/**
	 * 将每个sheet中,每个row,每个cell的内容都使用List记录.
	 * @param sheet
	 * @return
	 */
	private List getSheetInfo(HSSFSheet sheet) throws Exception
    {
	    List rows = new ArrayList();
	    HSSFRow hrow = null;
	    HSSFCell cell = null;
	    
	    int lastColNum = 0;
	    String value = null;
	    int type = 0;
	    double d_value;
	    
	    for (int i = 0; i<= sheet.getLastRowNum(); i++)
	    {
	    	List row = new ArrayList();
			hrow = sheet.getRow(i);
			if (hrow == null)
			{
				// 该行未定义任何内容
				for (int j=0; j<=lastColNum; j++)
				{
					row.add(j, "");
				}
			}
			else
			{
				// 该行存在
				lastColNum = hrow.getLastCellNum();
				String strExcelLine = null;
				for (short j=0; j<=lastColNum; j++)
				{
					cell = hrow.getCell(j);
					if (cell == null)
						row.add(j, "");
					else
					{
						type = cell.getCellType();
						if (type == 0)
						{
							//CELL_TYPE_NUMERIC
							d_value = cell.getNumericCellValue();
							strExcelLine = String.valueOf(d_value);
							  if (null != strExcelLine &&
									  strExcelLine.indexOf(".") != -1 && 
									  strExcelLine.indexOf("E") != -1) 
							  {
			                      DecimalFormat df = new DecimalFormat();
			                      strExcelLine = df.parse(strExcelLine).toString();
							  }
							  
							  if (null != strExcelLine &&
									  strExcelLine.endsWith(".0")) {
			                        int size = strExcelLine.length();
			                        strExcelLine = strExcelLine.substring(0, size - 2);
			                    }
							  
							//row.add(j, ""+cell.getNumericCellValue());
							row.add(j, strExcelLine);
						}
						else if (type == 2)
						{
							//CELL_TYPE_FORMULA
							try
							{
								d_value = cell.getNumericCellValue();
								value = String.valueOf(d_value);
								if ("NaN".equals(value))
									value = "";
							}catch (Exception e)
							{
								value = "";
							}
								
							row.add(j, value);
						}
						else if (type == 3 || type == 5)
						{
							//3:CELL_TYPE_BLANK  5:CELL_TYPE_ERROR
							value = "";
							row.add(j, value);
						}
						else 
						{
							value = cell.getStringCellValue();
							if (value == null)
								value = "";
							row.add(j, value);
						}
					}
					
				}
			}
			
			rows.add(i, row);
	    }
	    return rows;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		UploadExcelInfo einfo = new UploadExcelInfo();
		try
		{
			List rs = einfo.getExcelInfo("d:\\celltest.xls");
			//System.out.println(rs.get(0).toString());
			System.out.print(rs.toString());
			
		}
		catch (Exception e)
		{
			System.out.print(e.toString());
		}

	}

}
