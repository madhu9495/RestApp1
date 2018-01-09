package com.calc.rest.Client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {
	
	static final String REST_URL = "http://localhost:8080/RESTCalculator";
	static final String ADD_PATH = "/calc/add";
	static final String SUB_PATH = "/calc/sub";

	public static void main(String[] args) {
		
		int a = 122;
		int b = 34;
		
		// Client class is from com.sun.jersey.api.client.Client and core jar is version 1.19
		Client restClient = Client.create();
		WebResource service = restClient.resource(REST_URL);
		WebResource addService = service.path(ADD_PATH).path(a + "/" + b);
		System.out.println("Add Response: " + getResponse(addService));
		System.out.println("Add Output as XML: " + getOutputAsXML(addService));
		System.out.println("---------------------------------------------------");
		
		WebResource subService = service.path(SUB_PATH).path(a + "/" + b);
		System.out.println("Sub Response: " + getResponse(subService));
		System.out.println("Sub Output as XML: " + getOutputAsXML(subService));
		System.out.println("---------------------------------------------------");

	}
	private static String getResponse(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();
	}
	
	private static String getOutputAsXML(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(String.class);
	}
	

}
