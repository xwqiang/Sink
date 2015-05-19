package com.kuyun.shadowNet.matics;

import java.util.concurrent.TimeUnit;

import com.kuyun.shadowNet.matics.core.Counter;
import com.kuyun.shadowNet.matics.core.MetricGroup;
import com.kuyun.shadowNet.matics.core.MetricRegistry;
import com.kuyun.shadowNet.matics.core.Timer;
import com.kuyun.shadowNet.matics.sink.ConsoleSink;



public class Test {

	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		MetricRegistry registry = new MetricRegistry();
		Counter m = MetricRegistry.newCounter("test_counter",null);
		MetricGroup group = new MetricGroup("test-group");
		group.timer(new Timer(TimeUnit.SECONDS,3,0));
		m.group(group);
		
		m.tags("abc.dd");
		m.inc();
		registry.regist("test counter", m);
		ConsoleSink sink = new ConsoleSink();
		sink.forRegistry(registry);
		sink.start();
		while(true){
			Counter mm = registry.get("test counter",Counter.class);
			mm.inc();
			Thread.sleep(1000);
		}
//		
//		BasicMetrics m1 = new BasicMetrics();
//		m1.name("ab22c").value("2322");
//		registry.regist("te22st", m1);
//		MatricsUtil.regist("abc", "dfdsaf");
//		MatricsUtil.regist("e3abc", "dfdsaf");
//		MatricsUtil.regist("a33434bc", "dfdsaf");
	}
}
