package com.kapil.test;

import org.springframework.stereotype.Component;

@Component
public class Snapdragon implements Processor{

	@Override
	public void display() {
		
		System.out.println("running Snapdragon processor");
		
	}

	
}
