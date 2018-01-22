package com.approval.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/CreditApproval")
public class ApprovalRest {
	
	@GET
	@Path("/validate/{num}")
	@Produces(MediaType.TEXT_PLAIN)
	public String Validate(@PathParam("num") double num) {
		int lastnumber= (int) (num%10);
		if(lastnumber%2==0) {
			return "Valid";
		}
		return "Invalid";
	}

}
