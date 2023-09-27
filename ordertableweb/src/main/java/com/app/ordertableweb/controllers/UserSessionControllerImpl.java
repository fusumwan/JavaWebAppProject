package com.app.ordertableweb.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.app.ordertableweb.domain.services.session.SessionManager;
import com.app.ordertableweb.domain.utils.JsonUtil;
import com.app.ordertableweb.domain.utils.web.WebRequestUtil;
import com.app.ordertableweb.domain.models.data.*;
import com.app.ordertableweb.domain.models.*;

@Controller
@RequestMapping("/usersession")
public class UserSessionControllerImpl implements UserSessionController {
	
	@GetMapping(value = "/get_usersession", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> get_usersession(HttpServletRequest request) {
		Account account=null;
        // Retrieve or create session
        String sessionId = request.getSession().getId();
        Session session = SessionManager.getInstance().getSession(sessionId);
        if (session==null) {
        	session=SessionManager.getInstance().createSession(sessionId);
        	session.setAttribute("Account", new Account());
        	session.setAttribute("PageSession", new PageSession());        	
        }else {
        	account=(Account) session.getAttribute("Account");
        }
        // Convert session to JSON using JsonUtil.ToJson(session)
        String json = JsonUtil.ToJson(account); // Implement this method
        System.out.println(json);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(json, headers, HttpStatus.OK);
    }
	
	@PostMapping(value = "/set_usersession", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> set_usersession(HttpServletRequest request, @RequestBody Account accountsessionobject) {
	    Account account = null;
	    // Retrieve or create session
	    String sessionId = request.getSession().getId();
	    Session session = SessionManager.getInstance().getSession(sessionId);
	    
	    if (session == null) {
	        session = SessionManager.getInstance().createSession(sessionId);
	    }

	    session.setAttribute("Account", accountsessionobject);
	    session.setAttribute("PageSession", new PageSession());
	    account = accountsessionobject;

	    // Convert session to JSON using JsonUtil.ToJson(session)
	    String json = JsonUtil.ToJson(account); // Implement this method
	    System.out.println(json);
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    return new ResponseEntity<>(json, headers, HttpStatus.OK);
	}
	
    @GetMapping(value = "/get_pagesession", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> get_pagesession(HttpServletRequest request) {
    	PageSession pagesession=null;
        // Retrieve or create session
        String sessionId = request.getSession().getId();
        Session session = SessionManager.getInstance().getSession(sessionId);
        if (session==null) {
        	session=SessionManager.getInstance().createSession(sessionId);
        	session.setAttribute("Account", new Account());
        	session.setAttribute("PageSession", new PageSession());        	
        }else {
        	pagesession=(PageSession) session.getAttribute("PageSession");
        }
        // Convert session to JSON using JsonUtil.ToJson(session)
        String json = JsonUtil.ToJson(pagesession); // Implement this method
        System.out.println(json);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(json, headers, HttpStatus.OK);
    }
    
	@PostMapping(value = "/set_pagesession", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> set_pagesession(HttpServletRequest request,@RequestBody PageSession pagesessionobject) {
		PageSession pagesession=pagesessionobject;
        // Retrieve or create session
        String sessionId = request.getSession().getId();
        Session session = SessionManager.getInstance().getSession(sessionId);
        if (session==null) {
        	session=SessionManager.getInstance().createSession(sessionId);
        	session.setAttribute("Account", new Account());
        	session.setAttribute("PageSession", pagesession);        	
        }else {
        	//pagesession=(PageSession) session.getAttribute("PageSession");
        	
        	session.setAttribute("PageSession", pagesession);
        }
        // Convert session to JSON using JsonUtil.ToJson(session)
        String json = JsonUtil.ToJson(pagesession); // Implement this method
        System.out.println(json);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(json, headers, HttpStatus.OK);
    }
}
