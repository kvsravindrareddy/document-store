package com.sasi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This is Swagger API custom configuration class which provides the ResFul
 * WebService API documentation
 * 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	/**
	 * This method is used generate the API documentation using Swagger 2 API
	 * 
	 * @return Docket
	 */
	@Bean
	public Docket apiDoc() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.sasi.controller"))
				.paths(PathSelectors.ant("/student/*")).build();
	}
}