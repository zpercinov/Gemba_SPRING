package com.hemofarm.Gemba_SPRING;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GembaSpringApplication extends SpringBootServletInitializer  {

  @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GembaSpringApplication.class);
    }
    
    
    public static void main(String[] args) {
		SpringApplication.run(GembaSpringApplication.class, args);
	}

}
