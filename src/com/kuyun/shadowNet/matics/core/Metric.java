package com.kuyun.shadowNet.matics.core;

import java.io.Serializable;


public abstract class  Metric implements Serializable{
	private static final long serialVersionUID = 1L;
	private MetricGroup group = MetricGroup.DEFAULT_GROUP;
	public MetricGroup group(){
		return this.group;
	}
	public void group(MetricGroup group){
		group.addMetric(this);
		this.group = group;
	}
	public abstract String name();
	public abstract String tags();
	public abstract String value();
	public abstract Metric name(String name);
	public abstract Metric tags(String tags);
}
