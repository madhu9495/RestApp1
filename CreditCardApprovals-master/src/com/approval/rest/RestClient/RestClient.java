package com.approval.rest.RestClient;

import java.util.Scanner;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class RestClient {
	
	static final String REST_URL = "http://localhost:8080/CreditCardApprovals";
	static final String Validate_Path = "/CreditApproval/validate";
	
public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter credit card number");
		String num = s.nextLine();
		Client restClient = Client.create();
		WebResource service = restClient.resource(REST_URL);
		WebResource validateService = service.path(Validate_Path).path(num);
		System.out.println("Response: " + getResponse(validateService));
		System.out.println("Output: " + getOutputAsXML(validateService));
		System.out.println("---------------------------------------------------");
		s.close();
}

private static String getResponse(WebResource service) {
	return service.accept(MediaType.TEXT_PLAIN).get(ClientResponse.class).toString();
}

private static String getOutputAsXML(WebResource service) {
	return service.accept(MediaType.TEXT_PLAIN).get(String.class);
}
}
