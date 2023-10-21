
package com.eng.sentence.controllers;

import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagementController {
	// set up a logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@GetMapping("/management")
	public String management() {
	    return "management";
	}
	
	@GetMapping("/management-content")
	public String managementcontent() {
	    return "management-content";
	}
}
