package com.calc.rest.Client;

import java.util.Scanner;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientApp {
	
	static final String REST_URL = "http://localhost:9090/CalcService/calc";
	static final String Add="/add";
	static final String sub="/sub";
	public static void main(String args[])  {
		System.out.print("Please enter two integer values: ");
        Scanner scanner = new Scanner(System.in);
        String a=scanner.next();
        String b=scanner.next();
        Client restClient = Client.create();
		WebResource service = restClient.resource(REST_URL);
		WebResource AddService = service.path(Add).path(a+"/"+b);
		WebResource SubService = service.path(sub).path(a+"/"+b);
		System.out.println("Response: " + getResponse(AddService));
		System.out.println("Output: " + getOutputAsXML(AddService));
		System.out.println("---------------------------------------------------");
		System.out.println("Response: " + getResponse(SubService));
		System.out.println("Output: " + getOutputAsXML(SubService));
		System.out.println("---------------------------------------------------");

}
	private static String getResponse(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();
	}
	
	private static String getOutputAsXML(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(String.class);
	}
}
