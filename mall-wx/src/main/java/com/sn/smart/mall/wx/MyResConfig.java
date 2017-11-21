package com.sn.smart.mall.wx;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class MyResConfig extends ResourceConfig {

	public MyResConfig() {
		packages("com.sn.smart.mall.wx");
	}

}
