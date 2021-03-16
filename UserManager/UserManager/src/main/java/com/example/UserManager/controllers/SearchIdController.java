package com.example.UserManager.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.UserManager.entities.User;
import com.example.UserManager.services.UserService;

@Controller
public class SearchIdController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/findid", method = RequestMethod.POST)
	public String showUsers(ModelMap model, @RequestParam int id) {

		User u = userService.GetUserById(id);
		List<User> us = new ArrayList<>();

		us.add(u);

		model.addAttribute("users", us);

		return "users";
	}

}
