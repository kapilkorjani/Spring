package com.kapil.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

		public static void main(String[] args) {
			ApplicationContext ap = new ClassPathXmlApplicationContext("spring.xml");
			
			Test t = (Test) ap.getBean("test");
			t.hello();
		
			
			Car c = (Car) ap.getBean("car");
			System.out.println(c);
		}


}
