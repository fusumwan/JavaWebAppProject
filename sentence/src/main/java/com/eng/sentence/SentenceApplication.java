package com.eng.sentence;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
http://localhost:8080/sentence/
*/
@SpringBootApplication
public class SentenceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SentenceApplication.class, args);
	}
	@PostConstruct
	public void changeTimezone() {
	  TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
