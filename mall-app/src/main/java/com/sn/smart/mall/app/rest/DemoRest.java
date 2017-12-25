package com.sn.smart.mall.app.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sn.smart.mall.app.biz.DemoBiz;
import com.sn.smart.mall.app.vo.DemoVo;

@Path("/demo")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class DemoRest {

	@Autowired
	private DemoBiz demoBiz;

	@GET
	@Path("/getPathParam/{name}")
	public String getPathParam(@PathParam("name") String name) {
		return demoBiz.sayHello(name);
	}

	@GET
	@Path("/getQueryParam")
	public String getQueryParam(@QueryParam("name") String name) {
		return demoBiz.sayHello(name);
	}

	@GET
	@Path("/getBeanParam")
	public String getBeanParam(DemoVo vo) {
		return demoBiz.sayHello(vo);
	}

	@POST
	@Path("/postFormParam")
	public String doPostForm(@FormParam("name") String name) {
		return demoBiz.sayHello(name);
	}

	@POST
	@Path("/postQueryParam")
	public String postQueryParam(@QueryParam("name") String name) {
		return demoBiz.sayHello(name);
	}

	@GET
	@Path("/postBeanParam")
	public String postBeanParam(DemoVo vo) {
		return demoBiz.sayHello(vo);
	}

}
