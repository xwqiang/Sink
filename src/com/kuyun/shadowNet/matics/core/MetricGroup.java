package com.kuyun.shadowNet.matics.core;

import java.util.ArrayList;
import java.util.List;


public class MetricGroup {
	public static final MetricGroup DEFAULT_GROUP = new MetricGroup("default-group");
	private List<Metric> groupList = new ArrayList<Metric>();
	private Timer timer;
	private String groupName;
	
	public MetricGroup(String groupName){
		this.groupName = groupName;
		this.timer = Timer.DEFAULT_TIMER;
	}
	public void timer(Timer timer){
		this.timer = timer;
	}
	public void addMetric(Metric metric){
		metric.group(this);
		groupList.add(metric);
	}
	public Timer getTimer() {
		return timer;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public List<Metric> group(){
		return this.groupList;
	}
	
}
