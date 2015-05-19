package com.kuyun.shadowNet.matics.core;


public class Counter extends Metric{
	private static final long serialVersionUID = 1L;
	private long count = 0;
	protected String name ;
	protected String tags;
	public void inc(){
		inc(1);
	}
	public void inc(long num){
		count += num;
	}
	public void dec(long num){
		inc(-num);
	}
	public void dec(){
		inc(-1);
	}
	public String name() {
		return name;
	}
	public String tags() {
		return tags;
	}
	public Counter name(String name) {
		this.name = name;
		return this;
	}
	public Counter tags(String tags) {
		this.tags = tags;
		return this;
	}
	public long count(){
		return count;
	}
	@Override
	public String value() {
		return Long.toString(count);
	}
	
}