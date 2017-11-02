package com.sn.smart.mall.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.sn.smart.mall.api.DemoService;

@Service(version = "0.0.1")
public class DemoServiceImpl implements DemoService {

	public String sayHello() {
		return "hello, world!";
	}

}
