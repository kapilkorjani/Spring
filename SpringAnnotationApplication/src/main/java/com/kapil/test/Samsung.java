package com.kapil.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Samsung {

	@Autowired
	@Qualifier("snapdragon")
	private Processor cpu;
	
	
	public Processor getCpu() {
		return cpu;
	}


	public void setCpu(Processor cpu) {
		this.cpu = cpu;
	}


	public void config() {
		System.out.println("Samsung phone");
		cpu.display();
	}
}
