package com.kapil.test;
import org.springframework.stereotype.Component;

@Component
public class Test {
	
	
	private String name;
	private int age;
	
	
	public Test(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Test() {
		System.out.println("Test");
	}

	public void hello() {
		System.out.println("Hello   " + name + " Age is : "+ age);
	}

}
