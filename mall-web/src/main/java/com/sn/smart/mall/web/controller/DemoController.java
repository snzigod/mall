package com.sn.smart.mall.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sn.smart.mall.web.biz.DemoBiz;

@Controller
@RequestMapping("/church")
public class DemoController {
	
	@Autowired
	private DemoBiz demoBiz;
	
	@ResponseBody
	@RequestMapping(value = "/sayHello",method = RequestMethod.GET)
	public String sayHello() {
		return demoBiz.sayHello();
	}

}
