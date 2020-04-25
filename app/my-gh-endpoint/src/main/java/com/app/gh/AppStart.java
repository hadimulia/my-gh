package com.app.gh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
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
public class AppStart {

	public static void main(String[] args) {
		SpringApplication.run(AppStart.class, args);
	}
}
