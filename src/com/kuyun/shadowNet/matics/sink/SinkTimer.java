//package com.kuyun.shadowNet.matics.sink;
//
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//import com.kuyun.shadowNet.matics.util.PropertyHelper;
//
//
//public class SinkTimer implements Runnable {
//	private AbstractSink sink ;
//	private Timer timer = new Timer();
//	private static ScheduledExecutorService  exec = Executors.newScheduledThreadPool(10);
//
//	public SinkTimer(AbstractSink sink){
//		this.sink = sink;
//	}
//	private class Timer{
//		public TimeUnit timeUnit = TimeUnit.MILLISECONDS;
//		public long intervalMillis = PropertyHelper.getLong("timer.intervalMillis") == null ? 4000 :  PropertyHelper.getLong("timer.intervalMillis");
//		public long startMillis = PropertyHelper.getLong("timer.startMillis") == null ? 0 :  PropertyHelper.getLong("timer.startMillis");
//	}
//	@Override
//	public void run() {
//		sink.snapShot(sink.registry.getMetrics());
//	}
//	public void scheduleAtFixedRate() {
//		exec.scheduleAtFixedRate(this,timer.startMillis,timer.intervalMillis,timer.timeUnit);
//	}
//}
