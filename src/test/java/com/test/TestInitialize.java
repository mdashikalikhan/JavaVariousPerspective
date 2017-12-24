package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import com.google.common.collect.Maps;

public class TestInitialize {
	
	protected Map<String, Integer> salary = Maps.newHashMap();
	
	{
		salary.put("John", 10000);
		salary.put("Jane", 15000);
	}
	
	public String getValue(String key)
	{
		Properties props = new Properties();
		String value="";
		InputStream is = ClassLoader.getSystemResourceAsStream("TestParam.properties");
		try {
			props.load(is);
			value = props.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return value;
	}

}
