package com.sn.smart.mall.wx.vo;

import javax.ws.rs.QueryParam;

public class DemoVo {

	@QueryParam("name")
	private String name;

	@QueryParam("sex")
	private Short sex;

	@QueryParam("age")
	private Integer age;

	@QueryParam("remark")
	private String remark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getSex() {
		return sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
