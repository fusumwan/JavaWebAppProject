package com.app.ordertableweb.controllers;

import java.util.logging.Logger;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.ordertableweb.domain.utils.JsonUtil;

@Controller
public class LoginController {
	// set up a logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());
	
    @GetMapping("/login")
    public String showlogin() {
        return "login";
    }
    
    @GetMapping("/login-content")
    public String showlogincontent() {
        return "login-content";
    }
}
