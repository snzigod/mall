package com.sn.smart.mall.web.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sn.smart.mall.api.DemoService;

@Service
public class DemoBiz {
	
	@Autowired
	private DemoService demoService;
	
	public String sayHello(String name) {
		return demoService.sayHello(name);
	}

}
