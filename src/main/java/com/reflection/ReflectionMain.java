package com.reflection;

import com.reflection.entity.Entity1;
import com.reflection.entity.Entity2;
import com.reflection.entity.Entity3;

public class ReflectionMain {
	
	public static void main(String[] args) {
		ArrayCheck check = new ArrayCheck();
		System.out.println(check.getArr1().length);
		Entity1 entity1 = new Entity1("Entity1", "Entity1 Address");
		Entity2 entity2 = new Entity2("Entity2", "Entity2 Address");
		Entity3 entity3 = new Entity3("Entity3", "Entity3 Address", "Entity3 Details");
		System.out.println(entity1);
		System.out.println(entity2);
		System.out.println(entity3);
		checkObject(entity3);
		System.out.println(entity1);
		System.out.println(entity2);
		System.out.println(entity3);
	}
	
	static void checkObject(Object obj) {
		if(obj instanceof Entity3) {
			((Entity3)obj).setAddress("Address Modified of Entity 3");
			((Entity3)obj).setDetails("Details Modified of Entity 3");
		} else if(obj instanceof Entity2) {
			((Entity2)obj).setName("Entity2 Name changed");
		} else if(obj instanceof Entity1) {
			((Entity1)obj).setAddress("Address changed Entity 1");
		}
		
		if(obj instanceof Entity1) {
			((Entity1)obj).setAddress("Address further modified Entity 1");
		}
	}
	
}
class ArrayCheck {
	private String arr1[]= {};

	public String[] getArr1() {
		return arr1;
	}

	public void setArr1(String[] arr1) {
		this.arr1 = arr1;
	}
	
}
