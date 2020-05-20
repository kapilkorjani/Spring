package com.kapil.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

	@Autowired
	private Tyre tyre;


	public Tyre getTyre() {
		return tyre;
	}

	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}

	@Override
	public String toString() {
		return "Car [tyre=" + tyre + "]";
	}
	
	
	
}
