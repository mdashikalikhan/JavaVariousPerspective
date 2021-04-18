package com.reflection.entity;

import java.io.Serializable;

public class Entity3 extends Entity1 implements Serializable {

	String details;

	public Entity3(String name, String address, String details) {
		super(name, address);
		this.details = details;
	}

	
	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	@Override
	public String toString() {
		return "Entity3 [name=" + getName() + ", address=" + getAddress() + ", details=" + details + "]";
	}
	
	
	
}
