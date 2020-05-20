package com.kapil.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		
		
		ApplicationContext ap = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Samsung s = (Samsung)ap.getBean(Samsung.class);
		s.config();

	}

}
