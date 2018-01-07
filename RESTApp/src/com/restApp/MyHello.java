package com.restApp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

@Path("/helloWorld")
public class MyHello {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{name}")
	public String Hello(@Context HttpHeaders httpheaders, @PathParam("name") String name) {

		return "Hello World , My name is " +name;
	}
}
