package com.kuyun.shadowNet.matics.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 
 * 加载configure.properties配置文件类
 * 
 */
public class PropertyHelper {
	private static Properties prop = new Properties();;
	private static InputStream inputStream;
	private static long last_time = 0L;
	private static final long time = 5 * 1000L;
	private static void reload(){
		try {
			inputStream = PropertyHelper.class.getResourceAsStream("/configure.properties");
			prop.load(inputStream);
			last_time = System.currentTimeMillis();
		} catch (Exception ex) {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
	}
	public static String get(String key) {
		if(System.currentTimeMillis() - last_time > time){
			reload();
		}
		String value =  prop.getProperty(key);
		return value;
	}
	public static Integer getInt(String key){
		String value = get(key);
		if(value == null || value.trim().equals("") || !key.matches("\\d")){
			return null;
		}
		return Integer.parseInt(value);
	}
	public static Long getLong(String key){
		String value = get(key);
		if(value == null || value.trim().equals("") || !value.matches("\\d")){
			return null;
		}
		return Long.parseLong(value);
	}
	public static void main(String[] a) throws InterruptedException{
	}
}
