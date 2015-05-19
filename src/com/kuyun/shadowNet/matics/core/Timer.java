package com.kuyun.shadowNet.matics.core;

import java.util.concurrent.TimeUnit;

import com.kuyun.shadowNet.matics.util.PropertyHelper;

public class Timer{
	public final static Timer DEFAULT_TIMER =  new Timer(
			TimeUnit.SECONDS,
			PropertyHelper.getLong("timer.intervalMillis") == null ? 4000 :  PropertyHelper.getLong("timer.intervalMillis"),
			PropertyHelper.getLong("timer.startMillis") == null ? 0 :  PropertyHelper.getLong("timer.startMillis")
		);
	
	
	public TimeUnit timeUnit ;
	public long intervalMillis ;
	public long startMillis ;
	
	public Timer(TimeUnit timeUnit,long intervalMillis,long startMillis){
		this.timeUnit = timeUnit;
		this.intervalMillis = intervalMillis;
		this.startMillis = startMillis;
	}
}
