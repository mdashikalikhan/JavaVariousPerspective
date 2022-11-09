package com.json;

import com.fasterxml.jackson.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
public class JSONRead {
	
	private final static String resp =//"{\"Entries\":[{\"SerialNo\":1,\"StatusCode\":\"01\",\"StatusDesc\":\"Invalid Details\",\"ErrorMsg\":\"Debit not allowed for the account: 1612134020268\"},{\"SerialNo\":2,\"StatusCode\":\"01\",\"StatusDesc\":\"Invalid Details\",\"ErrorMsg\":\"Debit not allowed for the account: 1612134015276\"},{\"SerialNo\":3,\"StatusCode\":\"01\",\"StatusDesc\":\"Invalid Details\",\"ErrorMsg\":\"Insufficient Balance\"}]}"; 
			
			"{\"Entries\":[{\"SerialNo\":1,\"StatusCode\":\"01\",\"StatusDesc\":\"Invalid Details\",\"ErrorMsg\":\"Debit not allowed for the account: 1612134020268\"},{\"SerialNo\":2,\"StatusCode\":\"01\",\"StatusDesc\":\"Invalid Details\",\"ErrorMsg\":\"Debit not allowed for the account: 1612134015276\"}]}";
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(resp);
		System.out.println(node);
		
		node.get("Entries").forEach(obj->{
			System.out.println(obj.get("SerialNo"));
		});
	}
}
