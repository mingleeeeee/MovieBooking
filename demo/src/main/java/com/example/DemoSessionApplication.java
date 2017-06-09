package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

public class DemoSessionApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			  SpringApplication.run(DemoSessionApplication.class, args);
	}

	@EnableJdbcHttpSession 
	public class HttpSessionConfig {
	}
	

}
