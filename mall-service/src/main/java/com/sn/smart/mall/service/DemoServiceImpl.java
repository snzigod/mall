package com.sn.smart.mall.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.sn.smart.mall.api.DemoService;
import com.sn.smart.mall.dto.DemoDto;

@Service(version = "0.0.1")
public class DemoServiceImpl implements DemoService {

	public String sayHello(String name) {
		return "hello, " + name + "!";
	}

	public String sayHello(DemoDto dto) {
		return "hello, " + dto.getName() + "!";	
	}

}
