package com.learning.java_testing.bean;

public class ComparableBean {

	private int id;
	
	private String name;
	
	//no need of hashcode
	
	//equals is enough as of now

	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof ComparableBean)) {
			return false;	
		}
		return ((ComparableBean)obj).id == this.id ? true :false;
	}

	@Override
	public String toString() {
		return "ComparableBean [id=" + id + ", name=" + name + "]";
	}

	public ComparableBean(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
