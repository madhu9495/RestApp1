package com.rest.convert;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Tolower")
public class ToLower {
	
	@GET
	@Path("/convert/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAge(@PathParam("name") String name) {
		return name.toLowerCase();
	}

}
