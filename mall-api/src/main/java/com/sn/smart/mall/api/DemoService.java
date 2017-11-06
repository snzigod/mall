package com.sn.smart.mall.api;

import com.sn.smart.mall.dto.DemoDto;

public interface DemoService {

	String sayHello(String name);
	
	String sayHello(DemoDto dto);

}
