package com.app.ordertableweb.controllers;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.app.ordertableweb.domain.utils.web.WebRequestUtil;

public interface AccountController {
	
	public ResponseEntity<String> create(MultipartHttpServletRequest request);
	public ResponseEntity<String> get(MultipartHttpServletRequest request);
	public ResponseEntity<String> retrieve();
	public ResponseEntity<String> update(MultipartHttpServletRequest request);
	public ResponseEntity<String> delete(MultipartHttpServletRequest request);
	public ResponseEntity<String> filter(@RequestBody WebRequestUtil.FilterRequestData requestData);
	public ResponseEntity<String> getByAccountUsernamePassword(@RequestParam("username_00") String username_00,@RequestParam("password_01") String password_01);
	public ResponseEntity<String> getByAccountUsername(@RequestParam("username_01") String username_01);
	public ResponseEntity<String> getByAccount();
}