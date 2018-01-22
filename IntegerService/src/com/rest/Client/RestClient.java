package com.rest.Client;

import java.util.Scanner;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {
	
	static final String REST_URL = "http://localhost:9090/IntegerService/Convert/double";
	
	public static void main(String args[])  {
		System.out.print("Please enter any integer: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
       
        Client restClient = Client.create();
		WebResource service = restClient.resource(REST_URL);
		WebResource convert = service.path(input);
		System.out.println("Response: " + getResponse(convert));
		System.out.println("Output Double of "+ input +" is : " + getOutput(convert));
		System.out.println("---------------------------------------------------");
        scanner.close();
        }
        
	
	private static String getResponse(WebResource service) {
		return service.accept(MediaType.TEXT_PLAIN).get(ClientResponse.class).toString();
	}
	
	private static String getOutput(WebResource service) {
		return service.accept(MediaType.TEXT_PLAIN).get(String.class);
	}
}
