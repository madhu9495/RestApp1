package com.rest.age;

import java.time.LocalDate;
import java.time.Period;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Age")
public class AgeCalculator {

	@GET
	@Path("/calculate/{a}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAge(@PathParam("a") String a) {
		LocalDate dob = LocalDate.parse(a);
		
		LocalDate curDate = LocalDate.now();
        Period p=Period.between(dob, curDate);
        return p.getYears()+" years "+p.getMonths()+" months "+p.getDays()+" days";
		
	}
	
	
}
