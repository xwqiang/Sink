package com.kuyun.shadowNet.matics.sink;

import com.kuyun.shadowNet.matics.core.MetricRegistry;



public interface ISink {
	public void start();
	public void forRegistry(MetricRegistry registry);
}
