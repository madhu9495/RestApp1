package com.calc.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/calc")
public class CalcREST {
 
 @GET
 @Path("/add/{a}/{b}")
 @Produces(MediaType.TEXT_XML)
 public String add(@PathParam("a") double a, @PathParam("b") double b) {
  return "<?xml version=\"1.0\"?>" + "<result>" + (a+b) + "</result>";
 }
 
 @GET
 @Path("/sub/{a}/{b}")
 @Produces(MediaType.TEXT_XML)
 public String sub(@PathParam("a") double a, @PathParam("b") double b) {
  return "<?xml version=\"1.0\"?>" + "<result>" + (a-b) + "</result>";
 }
}