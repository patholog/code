package com.pathology.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author xu_dengfeng
 *
 */
public class PreparedSqlParser
{
	public static void main(String[] args)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("select * from tx1020 where (:user_id is null or user_id = :user_id) and (:user_name is null or user_name = :user_name)");
		
		new PreparedSqlParser().parse(sb.toString());
	}
	
	public List parse(String sql)
	{
		List names = new ArrayList();
		Pattern p = Pattern.compile("[:]+[\\w]+");
		Matcher m = p.matcher(sql);
		while(m.find())
		{
			names.add(m.group().substring(1, m.group().length()));
		}
		
		return names;
	}
}
