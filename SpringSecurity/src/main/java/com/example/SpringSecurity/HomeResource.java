package com.example.SpringSecurity;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class HomeResource {
	

	    @GetMapping("/")
	    public String home() {
	        return "home";
	    }

	    @GetMapping("/user")
	    public String user() {
	        return ("hello");
	    }
	    
	    
	    @GetMapping("/logout")
	    public String logout() {
	    	return "logout";
	    }
	    
	}

