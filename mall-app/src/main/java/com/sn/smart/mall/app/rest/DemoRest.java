package com.sn.smart.mall.app.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sn.smart.mall.app.biz.DemoBiz;

@Path("/demo")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class DemoRest {

	@Autowired
	private DemoBiz demoBiz;

	@GET
	@Path("/sayHello")
	public String sayHello() {
		return demoBiz.sayHello();
	}

}
