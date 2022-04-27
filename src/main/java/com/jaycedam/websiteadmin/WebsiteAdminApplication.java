package com.jaycedam.websiteadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WebsiteAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsiteAdminApplication.class, args);
	}

}
