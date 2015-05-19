package com.kuyun.shadowNet.matics.core;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

import com.kuyun.shadowNet.matics.sink.ISink;

@SuppressWarnings("unchecked")
public class MetricRegistry {
	private ConcurrentHashMap<String, Metric> metric_map ;
	private ISink sinker ;
//	private static List<ISink> sink_list;
	public MetricRegistry(){
		metric_map = new ConcurrentHashMap<String, Metric>();
//		sink_list = new CopyOnWriteArrayList<ISink>();
	}
	public Metric get(String name){
		return metric_map.get(name) ;
	}
	public <T extends Metric> T get(String name,Class<T> clz){
		Metric  m = get(name) ;
		if(m != null){
			return (T)m;
		}else{
			return null;
		}
	}
	public Metric regist(String name,Metric metric){
		final Metric existing = metric_map.putIfAbsent(name, metric);
		if((existing == null)){
			System.out.println("A metric added.");
		}else{
			System.out.println("A metric named " + name + " already exsting.");
			return existing;
		}
		return metric;
	}
	public Metric regist(Metric metric){
		return regist(metric.name(),metric);
	}
	public void regist(MetricGroup group){
		if(group.group() != null && group.group().size() > 0){
			for(Metric metric : group.group()){
				regist(metric.name(),metric);
			}
		}
	}
	
	public Collection<Metric> getMetrics(){
		return Collections.unmodifiableMap(metric_map).values();
	}
//	public static List<ISink> getSinkList(){
//		return sink_list;
//	}
	public static Counter newCounter(String name,String tags){
		Counter c = new Counter();
		c.name(name);
		c.tags(tags);
		return c;
	}
	public static Gauges newGauges(){
		return new Gauges();
	}
	public ISink sink(){
		return this.sinker;
	}
	public void sink(ISink sinker){
		this.sinker = sinker;
	}
}
