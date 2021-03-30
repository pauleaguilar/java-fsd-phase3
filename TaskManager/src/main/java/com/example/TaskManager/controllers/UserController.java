package com.example.TaskManager.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.TaskManager.entities.User;
import com.example.TaskManager.services.UserService;
@Controller
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/login")
	public String showLogin(ModelMap map) {
		return "login";
	}

	@PostMapping("/login")
	public String submitLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
		
		logger.info("Passing these parameters username " + username);
		logger.info("Passing these parameters username " + password);
		User u = userService.GetUserByName(username);
		logger.info("Passing these parameters username " + u.getName());
		logger.info("Passing these parameters username " + u.getPassword());
		boolean data = userService.authenticate(username, password, u);

		if (data) {
			return "login-success";
		} else {
			return "login_failed";
		}

	}
	
	@GetMapping("/register")
	public String showRegister(ModelMap map) {
		return "register";
	}
	
	@PostMapping("/register")
	public String submitRegister(@RequestParam("email") String email , @RequestParam("username") String username, @RequestParam("password")String password) {
		User u = new User(email, username, password);
		userService.UpdateUser(u);
		return "register-success";
	}
	
}
