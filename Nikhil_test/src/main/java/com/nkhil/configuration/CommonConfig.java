package com.nkhil.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class CommonConfig {
	
	static final String CONTROLLER_PATH = "com.nkhil.controller";

	 @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PATH))              
	          .paths(PathSelectors.any())                          
	          .build();                                           
	    }
	 
	 @Bean
	 public ObjectMapper objectMapper() {
		 final JavaTimeModule module = new JavaTimeModule();
		 return new ObjectMapper()
				 .setSerializationInclusion(JsonInclude.Include.NON_NULL)
			      .registerModule(module);
	 }
}
