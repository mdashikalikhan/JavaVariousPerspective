package com.reflection.entity;

import java.io.Serializable;

public class Entity1 implements Serializable {

	private String name;
	private String address;
	
	public Entity1(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Entity1 [name=" + name + ", address=" + address + "]";
	}
	
	
	
}
