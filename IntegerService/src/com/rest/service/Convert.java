package com.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Convert")
public class Convert {
	
	@GET
	@Path("/double/{a}")
	@Produces(MediaType.TEXT_PLAIN)
	public int ToDouble(@PathParam("a") int a){
		return a+a;
	}

}
