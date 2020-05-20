package com.kapil;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.kapil.*"})
public class SpringMvcConfig{

	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
//		vr.setPrefix("/WEB-INF/");
		vr.setSuffix(".jsp");
		
		return vr;
	}
}
