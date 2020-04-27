package com.app.gh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan({"com.app"})
@EntityScan(basePackages = {
"com.app.gh.persistence.model"})
@ImportResource({	
	"classpath*:applicationContext-persistence.xml",
	"classpath*:applicationContext-service.xml",
	"classpath*:applicationContext-generic-endpoint.xml",
	"classpath*:applicationContext-generic-service.xml"})
@EnableAutoConfiguration
public class AppStart extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AppStart.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AppStart.class, args);
	}
}
