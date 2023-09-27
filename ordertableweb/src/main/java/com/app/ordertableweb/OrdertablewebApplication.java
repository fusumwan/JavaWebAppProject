package com.app.ordertableweb;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
http://localhost:8080/ordertableweb/
*/

@SpringBootApplication
public class OrdertablewebApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrdertablewebApplication.class, args);
	}
	@PostConstruct
	public void changeTimezone() {
	  TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
