package com.example.UserFeedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserFeedback.entities.Feedback;
import com.example.UserFeedback.services.FeedbackService;

@RestController
public class AddFeedbackController {
	@Autowired
	FeedbackService feedbackService;

	
	
	@PostMapping("/feedback")
	public String addUserFeedback(@RequestParam("user") String user, @RequestParam("rating") int rating, @RequestParam("comments") String comments) {
	Feedback f = new Feedback(user, rating, comments);
	
	boolean data = feedbackService.addFeedback(f);
	
	if(data) {
		return "Feedback added succesfully!";
	}
	else {
		return "Unable to add the feedback";
	}
		
	}

}
