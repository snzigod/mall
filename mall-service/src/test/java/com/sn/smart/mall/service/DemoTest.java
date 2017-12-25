package com.sn.smart.mall.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sn.smart.mall.api.DemoService;
import com.sn.smart.mall.base.BaseTest;

public class DemoTest extends BaseTest {

	@Autowired
	private DemoService demoService;

	@Test
	public void sayHello() {
		System.out.println(demoService.sayHello("test"));
	}

}
