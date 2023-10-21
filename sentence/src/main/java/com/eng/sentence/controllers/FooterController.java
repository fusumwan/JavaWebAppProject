
package com.eng.sentence.controllers;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FooterController {
    // set up a logger for diagnostics
    private Logger logger = Logger.getLogger(getClass().getName());
    
    @GetMapping("/footer")
    public String showFooter() {

        return "footer";
    }
}
