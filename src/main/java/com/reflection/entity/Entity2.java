package com.reflection.entity;

import java.io.Serializable;

public class Entity2 implements Serializable {
	
	private String name;
	private String address;
	
	public Entity2(String name, String address) {
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
		return "Entity2 [name=" + name + ", address=" + address + "]";
	}
	
	
	
}
