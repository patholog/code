package com.pathology.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {

	static private Properties pro = new Properties();
	static{
		
		String properterPath = "/properties.properties";
		InputStream is = Property.class.getResourceAsStream(properterPath);
		try{
			pro.load(is);
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}
	public static String getProperty(String key){
		return pro.getProperty(key);
	}
}

