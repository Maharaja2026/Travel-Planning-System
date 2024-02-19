package com.spring.boot.TravelPlanningSystem.util;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class Config implements WebMvcConfigurer
{
	@Bean
	public OpenAPI swaggerDocOpenAPI()
	{
		Server devServer = new Server();
		devServer.setUrl("lohalhost:8080");
		devServer.setDescription("Development Server");
		
		Server testServer = new Server();
		testServer.setUrl("lohalhost:8081");
		testServer.setDescription("Test Server");
		
		Contact co = new Contact();
		co.setEmail("demo@gmail.com");
		co.setName("devName");
		co.setUrl("../https://github.com");
		
		License ls = new License();
		ls.setName("license");
		ls.setUrl("license providers");
		
		Info in = new Info();
		in.setContact(co);
		in.setLicense(ls);
		in.setDescription("TravelPlanningSystem: Dummy Project");
		
		in.setTermsOfService("https://pixabay.com/");
		in.setTitle("Travel Planning System");
		in.setVersion("2.0");
		
		OpenAPI op = new OpenAPI();
		op.info(in);
		op.servers(Arrays.asList(devServer,testServer));
		return op;
	}
	
}
