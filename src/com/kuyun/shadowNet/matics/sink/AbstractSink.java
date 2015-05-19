package com.kuyun.shadowNet.matics.sink;

import java.util.Collection;

import com.kuyun.shadowNet.matics.core.Metric;
import com.kuyun.shadowNet.matics.core.MetricRegistry;



public abstract class AbstractSink implements ISink{
	protected SinkTimer timer = new SinkTimer(this);
	protected MetricRegistry registry;
	private boolean started;
	@Override
	public void forRegistry(MetricRegistry registry){
//		registry.sink(this);
		this.registry = registry;
	}
	public abstract void snapShot(Collection<Metric> metrics);
	public void start(){
		timer.scheduleAtFixedRate();
		started = true;
	}
	public boolean isStarted(){
		return started;
	}
	
}
