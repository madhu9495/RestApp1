package com.rest.Client;

import java.util.Scanner;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {
	
	static final String REST_URL = "http://localhost:8080/AgeCalculatorRest";
	static final String GetAge = "/Age/calculate";
	
	public static void main(String args[])  {
		System.out.print("Please enter date of birth in YYYY-MM-DD: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if (input.matches("\\d{4}-\\d{2}-\\d{2}")) {
        Client restClient = Client.create();
		WebResource service = restClient.resource(REST_URL);
		WebResource Age = service.path(GetAge).path(input);
		System.out.println("Response: " + getResponse(Age));
		System.out.println("Output: " + getOutputAsXML(Age));
		System.out.println("---------------------------------------------------");
        scanner.close();
        }
        else {
        	System.out.println("Enter correct format");
        	

        }
	}
	private static String getResponse(WebResource service) {
		return service.accept(MediaType.TEXT_PLAIN).get(ClientResponse.class).toString();
	}
	
	private static String getOutputAsXML(WebResource service) {
		return service.accept(MediaType.TEXT_PLAIN).get(String.class);
	}
}
