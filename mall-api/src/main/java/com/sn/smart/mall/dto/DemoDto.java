package com.sn.smart.mall.dto;

import java.io.Serializable;

public class DemoDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4809827862245701013L;

	private String id;
	
	private String name;
	
	private Integer age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
