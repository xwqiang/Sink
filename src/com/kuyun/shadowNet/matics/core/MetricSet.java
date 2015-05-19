package com.kuyun.shadowNet.matics.core;

import java.io.Serializable;

public interface MetricSet extends Serializable{
	public String name();
	public String tags();
	public MetricSet name(String name);
	public MetricSet tags(String tags);
}
