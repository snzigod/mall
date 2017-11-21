package com.sn.smart.mall.wx.rest;

import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sn.smart.mall.wx.vo.DemoVo;

@Path("demo")
@Produces(MediaType.APPLICATION_JSON)
public class DemoRest {

	@GET
	@Path("getPathParam/{name}")
	public String getPath(@PathParam("name") String name) {
		return "hello, " + name + "!";
	}

	@GET
	@Path("getQueryParam")
	public String getQueryParam(@QueryParam("name") String name) {
		return "hello, " + name + "!";
	}

	@GET
	@Path("getBeanParam")
	public String getBeanParam(@BeanParam DemoVo demo) {
		return "My name is " + demo.getName() + ", I'm " + demo.getSex() + ", " + demo.getAge() + ", "
				+ demo.getRemark();
	}

	@POST
	@Path("postFormParam")
	public String postFormParam(@FormParam("name") String name) {
		return "hello, " + name + "!";
	}

	@POST
	@Path("postQueryParam")
	public String postQueryParam(@QueryParam("name") String name) {
		return "hello, " + name + "!";
	}

	@POST
	@Path("postBeanParam")
	public String postBeanParam(@BeanParam DemoVo demo) {
		return "My name is " + demo.getName() + ", I'm " + demo.getSex() + ", " + demo.getAge() + ", "
				+ demo.getRemark();
	}
}
