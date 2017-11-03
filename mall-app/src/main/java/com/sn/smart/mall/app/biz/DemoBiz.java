package com.sn.smart.mall.app.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sn.smart.mall.api.DemoService;

@Service
public class DemoBiz {
	
	@Autowired
	private DemoService demoService;

	public String sayHello() {
		return demoService.sayHello();
	}

}
