package com.rest.RestClient;

import java.util.Scanner;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {
	static final String REST_URL = "http://localhost:8080/StringConvert/Tolower/convert";
	
public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter name :");
		String name = s.nextLine();
		Client restClient = Client.create();
		WebResource service = restClient.resource(REST_URL);
		WebResource Service = service.path(name);
		System.out.println("Response: " + getResponse(Service));
		System.out.println("Output: " + getOutput(Service));
		System.out.println("---------------------------------------------------");
		s.close();
}

private static String getResponse(WebResource service) {
	return service.accept(MediaType.TEXT_PLAIN).get(ClientResponse.class).toString();
}

private static String getOutput(WebResource service) {
	return service.accept(MediaType.TEXT_PLAIN).get(String.class);
}
}

