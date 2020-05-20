package com.kapil.test;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class MediaTech implements Processor {

	@Override
	public void display() {
		System.out.println("Running Media tech processor");

	}

}
