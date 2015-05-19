package com.kuyun.shadowNet.jvm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Context {
	public static Map<String,Object> context = new ConcurrentHashMap<String,Object>();
	public static void put(String key,Object value){
		context.put(key, value);
	}
	public static Object get(String key){
		return context.get(key);
	}
	public static String getString(String key){
		return (String) get(key);
	}
	public static int getInt(String key){
		return (Integer) get(key);
	}
	public static long getLong(String key){
		return (Long) get(key);
	}
}
