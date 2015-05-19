package com.kuyun.shadowNet.matics.util;


public enum CommonMetric {
    GC("com.metric.gc", "gc的执行"), TIME("com.metric.time", "方法执行时间");
    
    
    
    
    private String name;
    private String desc;

    // 构造方法
    private CommonMetric(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
    
}