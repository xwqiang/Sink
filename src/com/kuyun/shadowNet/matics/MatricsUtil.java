//package com.kuyun.shadowNet.matics;
//
//import com.kuyun.shadowNet.matics.core.BasicMetrics;
//import com.kuyun.shadowNet.matics.core.MetricRegistry;
//import com.kuyun.shadowNet.matics.sink.AbstractSink;
//import com.kuyun.shadowNet.matics.util.PropertyHelper;
//
//public class MatricsUtil {
//	private static AbstractSink sink = null;
//	private static MetricRegistry registry = new MetricRegistry();
//	public static void regist(String name,String value) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
//		initInNeed();
//		BasicMetrics m = new BasicMetrics();
//		m.name(name).value(value);
//		registry.regist(name, m);
//		sink.forRegistry(registry);
//		start();
//	}
//	public static void start() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
//		initInNeed();
//		if(!sink.isStarted()){
//			sink.start();
//		}
//	}
//	
//	
//	
//	private static void initInNeed() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
//		if(sink == null){
//			sink = (AbstractSink) Class.forName(PropertyHelper.get("sink.class.name")).newInstance();
//		}
//	}
//}
