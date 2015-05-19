package com.kuyun.shadowNet.matics.sink;

import java.util.Collection;

import com.kuyun.shadowNet.matics.core.Metric;






public class ConsoleSink extends AbstractSink{

	@Override
	public void snapShot(Collection<Metric> metrics) {
		for(Metric m : metrics){
			System.out.println("name:" + m.name() + " value:" + m.value() + " tag:" + m.tags() + " group:" + m.group().getGroupName());
		}
	}
}
